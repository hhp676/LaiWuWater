package com.hongguaninfo.hgdf.generator.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import oracle.jdbc.driver.OracleConnection;

import org.springframework.stereotype.Service;

import com.hongguaninfo.hgdf.core.utils.logging.Log;
import com.hongguaninfo.hgdf.core.utils.logging.LogFactory;
import com.hongguaninfo.hgdf.generator.core.Constants;
import com.hongguaninfo.hgdf.generator.core.base.BaseService;
import com.hongguaninfo.hgdf.generator.entity.Column;
import com.hongguaninfo.hgdf.generator.entity.ForeignKey;
import com.hongguaninfo.hgdf.generator.entity.GeneratorConfig;
import com.hongguaninfo.hgdf.generator.entity.MetaContext;
import com.hongguaninfo.hgdf.generator.entity.Table;
import com.mysql.jdbc.MySQLConnection;

/**
 * 
 * @author:henry
 */
@Service("MetaService")
public class MetaService extends BaseService {

	/**
     * 日志。
     */
    private static final Log LOG = LogFactory.getLog(MetaService.class);

    /**
     * 获取所有表。
     * @param genConfig 生成配置
     * @throws InstantiationException 实例化异常。
     * @throws IllegalAccessException 非法的访问级别。
     * @throws ClassNotFoundException 找不到类。
     * @throws SQLException sql异常。
     * @return 所有的表。
     */
    public MetaContext getTables(GeneratorConfig genConfig)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        LOG.debug("begin connect database....");
        Class.forName(genConfig.getJdbcDriverName());
        MetaContext context = new MetaContext();
        try (Connection conn = getConnection(genConfig)) {
            DatabaseMetaData dm = conn.getMetaData();
            if (genConfig.getJdbcDriverName().equals("oracle.jdbc.driver.OracleDriver")) {
            	((OracleConnection)conn).setRemarksReporting(true); 
            }
            getAllTableInfo(dm, genConfig.getJdbcSchema(), context);
        }
        //resolveFks(context);

//        context.getTables().forEach(t -> t.setBizTable(t.getCol("IS_DELETE_") != null));
        Set<Table> tables = context.getTables();
        if(tables!=null && tables.size()>0){
    		for(Table table:tables){
    			table.setBizTable((table.getCol("IS_DELETE_") != null));
    		}
    	}

        return context;
    }
    
    /**
     * 解析外键中的主表信息。
     * 注意：原外键信息是按照主表解析。
     * @param context 上下文
     */
    private void resolveFks(MetaContext context) {
    	Set<Table> tables = context.getTables();
    	if(tables!=null && tables.size()>0){
    		for(Table table:tables){
    			List<ForeignKey> rawFks =table.getRawFks();
    			if(rawFks!=null && rawFks.size()>0){
    				for(ForeignKey fk:rawFks){
    					Table fkTable = context.getTable(fk.getFkTableName());
    					fk.setFkColumn(fkTable.getCol(fk.getFkColumnName()));
    					fkTable.getFks().add(fk);
    					fk.resolveFieldName();
    				}
    			}
    		}
    	}
    }

    /**
     * 获取数据库连接。
     * @param genConfig 生成配置。
     * @return 数据库连接。
     * @throws SQLException sql异常。
     */
    private Connection getConnection(GeneratorConfig genConfig) throws SQLException {
        Connection conn;
        if (genConfig.getJdbcDriverName().equals("com.mysql.jdbc.Driver")) {
            Properties props = new Properties();

            props.setProperty("user", genConfig.getJdbcUserName());
            props.setProperty("password", genConfig.getJdbcPassword());
            // 设置可以获取remarks信息
            props.setProperty("remarks", "true");
            // 设置可以获取tables remarks信息
            props.setProperty("useInformationSchema", "true");

            conn = DriverManager.getConnection(genConfig.getJdbcDriverUrl(), props);
        } else {
            conn = DriverManager.getConnection(genConfig.getJdbcDriverUrl(),
                    genConfig.getJdbcUserName(), genConfig.getJdbcPassword());
        }
        return conn;
    }
    /**
     * 获取表信息。
     * @param dm           dm
     * @param schema       schema
     * @param context      context
     * @throws SQLException sql exception
     */
    private void getAllTableInfo(DatabaseMetaData dm, String schema, MetaContext context)
            throws SQLException {
        LOG.debug("begin parse database....");
        ResultSet rs = dm.getTables(null, schema, null, new String[] {"TABLE"});
        int i=0;
        while (rs.next()) {
            Table tmd = getBaseInfoTable(rs);

            // 获取主键信息，仅保存主键对应的字段名，用于获取字段列表时判断字段是否为主键。
            getRawPks(dm, tmd);
            getCols(dm, tmd);
          //  getUniqueKeys(dm, tmd);
          //  getRawFks(dm, tmd);

            context.addTable(tmd);
        }
        LOG.debug("end parse database....");
    }
    
    /**
     * 获取基础信息。
     * @param rs  resultSet
     * @return Table
     * @throws SQLException sql exception
     */
    private Table getBaseInfoTable(ResultSet rs) throws SQLException {
        Table tmd = new Table();


        tmd.setTableName(rs.getString("TABLE_NAME"));
        tmd.setTableDesc(rs.getString("REMARKS"));
        tmd.setSchema(rs.getString("TABLE_SCHEM"));

        return tmd;
    }
    
    /**
     * 获取主键信息。
     * @param dm          dm
     * @param table       table
     * @throws SQLException sql exception
     */
    private void getRawPks(DatabaseMetaData dm, Table table)
            throws SQLException {
        Set<String> pks = new HashSet<>();
        ResultSet rsPK = dm.getPrimaryKeys(null, table.getSchema(), table.getTableName());

        while (rsPK.next()) {
            pks.add(rsPK.getString("COLUMN_NAME"));
        }

        table.setRawPks(pks);
    }

    /**
     * 获取表字段。
     * @param dm          dm
     * @param table       table
     * @throws SQLException sql exception
     */
    private void getCols(DatabaseMetaData dm, Table table)
            throws SQLException {
        ResultSet rsCol = dm.getColumns(null, table.getSchema(), table.getTableName(), null);
        while (rsCol.next()) {
            table.addCol(getColumn(rsCol));
        }
    }

    /**
     * 获取唯一约束信息。
     * @param dm      dm
     * @param table   table
     * @throws SQLException sql exception
     */
    private void getUniqueKeys(DatabaseMetaData dm, Table table)
            throws SQLException {
        ResultSet rsUniKeys = dm.getIndexInfo(null, table.getSchema(), table.getTableName(), true, true);
        while (rsUniKeys.next()) {
            String indexName = rsUniKeys.getString("INDEX_NAME");
            if (indexName == null || "PRIMARY".equals(indexName)) {
                continue;
            }
           // table.addUniqueKey(indexName, rsUniKeys.getString("COLUMN_NAME"));
        }
    }

    /**
     * 获取外键信息，对应主表仅保存表名，字段名信息。
     * @param dm           dm
     * @param table        table
     * @throws SQLException  sql exception
     */
    private void getRawFks(DatabaseMetaData dm, Table table)
            throws SQLException {
        ResultSet fks = dm.getExportedKeys(null, table.getSchema(), table.getTableName());
        List<ForeignKey> rawFks = new ArrayList<>();
        while (fks.next()) {
            if (!table.getTableName().equals(fks.getString("PKTABLE_NAME"))) {
                LOG.info("表信息不对应！");
                continue;
            }

            ForeignKey fk = new ForeignKey();

            fk.setPkColumn(table.getCol(fks.getString("PKCOLUMN_NAME")));
            fk.setFkTableName(fks.getString("FKTABLE_NAME"));
            fk.setFkColumnName(fks.getString("FKCOLUMN_NAME"));

            rawFks.add(fk);
        }
        table.setRawFks(rawFks);
    }
    /**
     * 读取当前数据，构建对应的Column实例。
     * @param rsCol 数据集
     * @return Column
     * @throws SQLException sql异常。
     */
    private Column getColumn(ResultSet rsCol) throws SQLException {
        Column col = new Column();

        col.setColName(rsCol.getString("COLUMN_NAME"));
        col.setColDesc(rsCol.getString("REMARKS"));
        col.setLength(rsCol.getString("COLUMN_SIZE"));
        col.setNullable(rsCol.getString("NULLABLE"));

        String colType = rsCol.getString("TYPE_NAME");
        String digits = rsCol.getString("DECIMAL_DIGITS");
        String ct = parseDataType(colType, digits);
        col.setColType(ct);
        col.setJavaType("TIMESTAMP".equals(colType) ? "Date" : ct);
        col.setFormatCode(parseFormatCode(colType, digits));
        return col;
    }
    
    /**
     * 将数据类型转换为java类型。
     * @param colType 列的数据库数据类型
     * @param digits  数据类型的长度
     * @return java类型。
     */
    private String parseDataType(String colType, String digits) {
        if ("VARCHAR".equals(colType) || "CHAR".equals(colType) || "VARCHAR2".equals(colType)) {
            return Constants.TYPE_STRING;
        }
        if ("TIMESTAMP".equals(colType)) {
            return Constants.TYPE_TIMESTAMP;
        }
        if ("INT".equals(colType) || "SMALLINT".equals(colType)
                || "TINYINT".equals(colType) || "INTEGER".equals(colType) || "NUMBER".equals(colType)) {
            return "0".equals(digits) ? Constants.TYPE_INTEGER : Constants.TYPE_FLOAT;
        }
        if ("DECIMAL".equals(colType)) {
            return Constants.TYPE_FLOAT;
        }
        if ("BIGINT".equals(colType)) {
            return Constants.TYPE_LONG;
        }
        if ("DATETIME".equals(colType) || "TIMESTAMP(6)".equals(colType) || "DATE".equals(colType)) {
            return "java.util.Date";
        }
        if ("BLOB".equals(colType)) {
            return "Object";
        }
        return "String";
    }
    /**
     * entity类toString方法需要的，字段对应String.format代码。
     * @param colType 字段类型
     * @param digits 字段长度
     * @return format代码
     */
    private String parseFormatCode(String colType, String digits) {
        if ("TIMESTAMP".equals(colType)) {
            return "tc";
        }
        if ("INT".equals(colType) || "SMALLINT".equals(colType) || "TINYINT".equals(colType)
                || "INTEGER".equals(colType) || "NUMBER".equals(colType)) {
            return "0".equals(digits) ? "d" : "g";
        }
        if ("BIGINT".equals(colType)) {
            return "d";
        }
        if ("DATETIME".equals(colType) || "TIMESTAMP(6)".equals(colType) || "DATE".equals(colType)) {
            return "tc";
        }
        return "s";
    }
    
}