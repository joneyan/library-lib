package com.lib.utils;

import java.sql.Connection;
import java.util.Map;

/**
 * @Author YangXiaohui
 * @Description 获取数据源的字符串
 * @Date Created on 2017-12-29 15:44
 * @Modified By
 */
public interface GenerateDataOperationUtilIntf {
    /**
     * 获取jdbc数据库连接
     * @param dbhost 数据库地址
     * @param dbport 数据库端口
     * @param dbname 数据库名字
     * @param dbuser 数据库用户名
     * @param dbpass 数据库密码
     * @return Connection
     */
    public Connection getDBConnect(String dbhost, String dbport, String dbname, String dbuser, String dbpass);

    /**
     * 获取表的详细信息，比如驼峰转过得字段名,字段的注释
     * @param conn 数据库连接
     * @return
     */
    public Map<String,Map<String,Map<String,String>>> getTablesInfo(Connection conn);

    /**
     * 获取表对应的实体类的字符串
     * @param tableName         表名
     * @param tableAttribute    表的列类型和释义
     * @return
     */
    public String getTableModelBase(String tableName, Map<String, Map<String, String>> tableAttribute);
    public String getTableModelVO(String tableName);

    /**
     * 获取实体对应的mapper文件
     * @param tableName
     * @return
     */
    public String getTableMapperBase(String tableName, Map<String, Map<String, String>> tableAttribute);
    public String getTableMapperEXT(String tableName, Map<String, Map<String, String>> tableAttribute);

    /**
     * 获取对应service接口的字符串
     * @param tableName
     * @return
     */
    public String getTableServiceIntf(String tableName);

    /**
     * 获取对应service实现类的字符串
     * @param tableName
     * @return
     */
    public String getTableServiceImpl(String tableName);

    /**
     * 获取对应dao接口的字符串
     * @param tableName
     * @return
     */
    public String getTableDAOIntf(String tableName);

    /**
     * 获取对应dao实现类的字符串
     * @param tableName
     * @return
     */
    public String getTableDAOImpl(String tableName);

}
