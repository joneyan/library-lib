package com.lib.utils;

import com.lib.constant.GetDataConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author YangXiaohui
 * @Description
 * @Date Created on 2017-12-29 15:54
 * @Modified By
 */
public class GenerateDataOperationUtil implements GenerateDataOperationUtilIntf {
    @Override
    public Connection getDBConnect(String dbhost, String dbport, String dbname, String dbuser, String dbpass) {
        String url="jdbc:mysql://"+dbhost+":"+dbport+"/"+dbname+"??useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection conn = null;
        //获取连接
        try {
            //驱动注册
            Class.forName(GetDataConstant.DB_DRIVER);
            conn = DriverManager.getConnection(url, dbuser, dbpass);
        } catch (Exception e) {
            System.out.println("数据库连接失败！！！");
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public Map<String, Map<String, Map<String, String>>> getTablesInfo(Connection conn) {
        Map<String, Map<String, Map<String, String>>> resulMap = new HashMap<String, Map<String, Map<String, String>>>();
        String table = GetDataConstant.DB_TABLENAME;
        String[] tables = table.split(",");
        Statement stmt = null;
        //遍历表
        if(tables!=null&&tables.length>0){
            //获取每一张表
            for (int i=0;i<tables.length;i++){
                try {
                    stmt = conn.createStatement();
                    //获取表对象
                    //ResultSet resultSet = stmt.executeQuery("show full columns from " + tables[i]);
                    ResultSet resultSet = stmt.executeQuery("SELECT TABLE_NAME, COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '"+ GetDataConstant.DB_NAME +"' and TABLE_NAME = '" + tables[i]+"'");
                    //获取每个表的数据
                    resulMap.put(tables[i],this.getTableClonmnInfo(conn,resultSet,tables[i]));
                } catch (Exception e){
                    System.out.println(tables[i]+" ：表查询异常！！！");
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("没有找到有效的表对象！！！");
        }
        System.out.println(resulMap.toString());
        return resulMap;
    }

    /**
     * 获取表的数据
     * @param resultSet
     * @return
     * @throws Exception
     */
    private Map<String,Map<String,String>> getTableClonmnInfo(Connection conn,ResultSet resultSet,String table) throws Exception{
        Map<String,Map<String,String>> resultMap = new HashMap<String, Map<String, String>>();
        while(resultSet.next()){
            Map<String,String> item = new HashMap<String, String>();
            //字段类型
            item.put("type",sqlType2JavaType(resultSet.getString("DATA_TYPE")));
            //字段注释
            item.put("comment",resultSet.getString("COLUMN_COMMENT"));
            //字段名
            resultMap.put(resultSet.getString("COLUMN_NAME"),item);
            System.out.println(resultSet.getString("COLUMN_NAME"));
//            System.out.println(resultSet.getString("PK_NAME"));
            //字段类型
            //typeColumn.put(resultSet.getString("Field"),sqlType2JavaType(resultSet.getString("Type")));
            //字段注释
            //annotationColumn.put(resultSet.getString("Field"),resultSet.getString("Comment"));
        }
        System.out.println(resultMap.toString());
        return resultMap;
    }

    @Override
    public String getTableModelBase(String tableName, Map<String, Map<String,String>> tableAttribute) {
        StringBuffer resultStru = new StringBuffer();
        //转换表名成类名
        String className = Underline2Camel.toUpperCase4Index(Underline2Camel.camelName(tableName));
        resultStru.append("package com.lib.model;\r\n\r\n");
        resultStru.append("public class "+className+" {\r\n");
        //获取基本属性
        for (Map.Entry<String, Map<String,String>> entry : tableAttribute.entrySet()) {
            resultStru.append(this.getBeanAttribute(entry.getKey(),entry.getValue().get("type"),entry.getValue().get("comment")));
        }
        //获取getset方法
        for (Map.Entry<String, Map<String,String>> entry : tableAttribute.entrySet()) {
            //获取get方法
            resultStru.append(this.getBeanGetMethod(entry.getValue().get("type"),entry.getKey()));
            //获取set方法
            resultStru.append(this.getBeanSetMethod(entry.getValue().get("type"),entry.getKey()));
        }
        //结尾
        resultStru.append("}\r\n");
        System.out.println(resultStru.toString());
        return resultStru.toString();
    }

    @Override
    public String getTableModelVO(String tableName) {
        //获取javaBean名字
        String className = Underline2Camel.toUpperCase4Index(Underline2Camel.camelName(tableName));
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.lib.model.vo;\r\n\r\n");
        str.append("import com.lib.model."+className+";\r\n\r\n");
        str.append("public class "+className+"VO extends "+className+"{\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }

    @Override
    public String getTableMapperBase(String tableName, Map<String, Map<String, String>> tableAttribute) {
        String javaName = Underline2Camel.camelName(tableName);
        StringBuffer str=new StringBuffer();
        str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<!DOCTYPE mapper PUBLIC\r\n")
                .append("\"-//mybatis.org//DTD Mapper 3.0//EN\"\r\n")
                .append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n")
                .append("<mapper namespace=\""+javaName+"Dao\">\r\n")
                .append(getResultMapStr(javaName,tableAttribute))
                .append(getSqlInsertColumnList(javaName,tableAttribute))
                .append(getSqlInsertPropertyList(javaName,tableAttribute))
                .append(getSqlColumnList(javaName,tableAttribute))
                .append(getSqlUpdateSet(javaName,tableAttribute))
                .append(getSqlCondition(javaName,tableAttribute))
                .append(getSqlForceUpdateSet(javaName,tableAttribute))
                .append(getSqlIUDSXML(tableName,tableAttribute))
                .append("</mapper>");
        System.out.println(str.toString());
        return str.toString();
    }

    @Override
    public String getTableMapperEXT(String tableName, Map<String, Map<String, String>> tableAttribute) {
        String javaName = Underline2Camel.camelName(tableName);
        StringBuffer str=new StringBuffer();
        str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<!DOCTYPE mapper PUBLIC\r\n")
                .append("\"-//mybatis.org//DTD Mapper 3.0//EN\"\r\n")
                .append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n")
                .append("<mapper namespace=\""+javaName+"Dao_EXT\">\r\n")
                .append(getResultMapStr(javaName,tableAttribute))
                .append(getSqlInsertColumnList(javaName,tableAttribute))
                .append(getSqlInsertPropertyList(javaName,tableAttribute))
                .append(getSqlColumnList(javaName,tableAttribute))
                .append(getSqlUpdateSet(javaName,tableAttribute))
                .append(getSqlCondition(javaName,tableAttribute))
                .append(getSqlForceUpdateSet(javaName,tableAttribute))
                .append("</mapper>");
        System.out.println(str.toString());
        return str.toString();
    }

    @Override
    public String getTableServiceIntf(String tableName) {
        //获取javaBean名字
        String className = Underline2Camel.camelName(tableName);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.lib.service;\r\n\r\n");
        str.append("import com.lib.base.BO;\r\n");
        str.append("import com.lib.model."+className+";\r\n");
        str.append("import com.lib.model.vo."+className+"VO;\r\n\r\n");
        str.append("public interface "+className+"Service extends BO<"+className+", "+className+"VO, String>{\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }

    @Override
    public String getTableServiceImpl(String tableName) {
        //获取javaBean名字
        String className = Underline2Camel.camelName(tableName);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.lib.service.impl;\r\n\r\n");
        str.append("import com.lib.base.AbstractBO;\r\n");
        str.append("import com.lib.base.DAO;\r\n");
        str.append("import com.lib.dao."+className+"DAO;\r\n");
        str.append("import com.lib.model."+className+";\r\n");
        str.append("import com.lib.model.vo."+className+"VO;\r\n");
        str.append("import com.lib.service."+className+"Service;\r\n");
        str.append("import org.slf4j.Logger;\r\n");
        str.append("import org.slf4j.LoggerFactory;\r\n");
        str.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
        str.append("import org.springframework.stereotype.Service;\r\n\r\n");
        str.append("@Service(\""+Underline2Camel.camelName(tableName)+"BO\")\r\n");
        str.append("public class "+className+"ServiceImpl extends AbstractBO<"+className+", "+className+"VO, String> implements "+className+"Service {\r\n");
        str.append("private static final Logger LOGGER  =  LoggerFactory.getLogger("+className+"ServiceImpl.class);\r\n");
        str.append("@Autowired\r\n");
        str.append("private "+className+"DAO "+Underline2Camel.camelName(tableName)+"DAO;\r\n");
        str.append("@Override\r\n");
        str.append("protected DAO<"+className+", "+className+"VO, String> getDAO() {\r\n");
        str.append("return "+Underline2Camel.camelName(tableName)+"DAO;\r\n}\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }

    @Override
    public String getTableDAOIntf(String tableName) {
        //获取javaBean名字
        String className = Underline2Camel.camelName(tableName);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.lib.dao;\r\n\r\n");
        str.append("import com.lib.base.DAO;\r\n");
        str.append("import com.lib.model."+className+";\r\n");
        str.append("import com.lib.model.vo."+className+"VO;\r\n\r\n");
        str.append("public interface "+className+"DAO extends DAO<"+className+", "+className+"VO, String>{\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }

    @Override
    public String getTableDAOImpl(String tableName) {
        //获取javaBean名字
        String className = Underline2Camel.camelName(tableName);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.lib.dao.impl;\r\n\r\n");
        str.append("import com.lib.base.AbstractDAO;\r\n");
        str.append("import com.lib.dao."+className+"DAO;\r\n");
        str.append("import com.lib.model."+className+";\r\n");
        str.append("import com.lib.model.vo."+className+"VO;\r\n");
        str.append("import org.mybatis.spring.SqlSessionTemplate;\r\n");
        str.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
        str.append("import org.springframework.stereotype.Repository;\r\n\r\n");
        str.append("@Repository(\""+Underline2Camel.camelName(tableName)+"Dao\")\r\n");
        str.append("public class "+className+"DAOImpl extends AbstractDAO<"+className+", "+className+"VO, String> implements "+className+"DAO {\r\n");
        str.append("@Autowired\r\n");
        str.append("private SqlSessionTemplate sqlSessionTemplate;\r\n");
        str.append("@Override\r\n");
        str.append("protected SqlSessionTemplate getSqlSessionTemplate() {\r\n");
        str.append("return sqlSessionTemplate;\r\n}\r\n");
        str.append("@Override\r\n");
        str.append("protected String getNamespace() {\r\n");
        str.append("return \""+Underline2Camel.camelName(tableName)+"Dao\";\r\n}\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }

    //获取set方法
    private StringBuffer getBeanSetMethod(String type,String name){
        name=Underline2Camel.camelName(name);
        String methodname = "set"+Underline2Camel.toUpperCase4Index(name);
        String format = String.format("    public void %s(%s %s){\n\r", new Object[]{methodname,type,name});
        format += String.format("        this.%s = %s;\r\n", new Object[]{name,name});
        format += "    }\r\n";
        return new StringBuffer(format);
    }
    //获取get方法
    private StringBuffer getBeanGetMethod(String type,String name){
        name=Underline2Camel.camelName(name);
        String methodname = "get"+Underline2Camel.toUpperCase4Index(name);
        String format = String.format("    public %s %s(){\n\r", new Object[]{type,methodname});
        format += String.format("        return %s;\r\n", new Object[]{name});
        format += "    }\r\n";
        return new StringBuffer(format);
    }
    /**
     *获取javabean的属性
     * @param type  类型
     * @param name  字段名
     * @param comment 释义
     * @return
     */
    private String getBeanAttribute(String name,String type,String comment){
        String format = String.format("    private %s %s %s %s %s;\n\r", new String[]{type,Underline2Camel.camelName(name),"/*",comment,"*/"});
        return format;
    }

    /*mysql的字段类型转化为java的类型*/
    private String sqlType2JavaType(String sqlType) {
        //避免括号带来的麻烦 截取掉
        int endindex = sqlType.indexOf("(");
        if(endindex >= 1 ) {
            sqlType = sqlType.substring(0, endindex);
        }
        System.out.println(sqlType);
        if(sqlType.equalsIgnoreCase("bit")){
            return "java.lang.Boolean";
        }else if(sqlType.equalsIgnoreCase("tinyint")){
            return "java.lang.Byte";
        }else if(sqlType.equalsIgnoreCase("smallint")){
            return "java.lang.Short";
        }else if(sqlType.equalsIgnoreCase("INTEGER")){
            return "java.lang.Integer";
        }else if(sqlType.equalsIgnoreCase("bigint")){
            return "java.lang.Long";
        }else if(sqlType.equalsIgnoreCase("int")){
            return "java.lang.Integer";
        }else if(sqlType.equalsIgnoreCase("float")){
            return "java.lang.Float";
        }else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")){
            return "java.lang.Double";
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")){
            return "java.lang.String";
        }else if(sqlType.equalsIgnoreCase("datetime") ||sqlType.equalsIgnoreCase("date")){
            return "java.util.Date";
        }else if(sqlType.equalsIgnoreCase("image")){
            return "java.lang.Blod";
        }
        return null;
    }

    //获取ResultMap
    protected String getResultMapStr(String javaName, Map<String, Map<String, String>> tableAttribute){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<resultMap id=\""+javaName+"\" type=\"com.lib.model."+className+"\">\r\n");
        for (Map.Entry<String, Map<String,String>> entry : tableAttribute.entrySet()) {
            str.append("\n<result property=\""+Underline2Camel.camelName(entry.getKey())+"\" column=\""+entry.getKey()+"\" />");
        }
        str.append("</resultMap>\r\n");
        return str.toString();
    }
    //获取SqlInsertColumnList
    protected String getSqlInsertColumnList(String javaName, Map<String, Map<String, String>> tableAttribute){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_insert_column_list\">\r\n")
                .append("<trim prefix=\"\" prefixOverrides=\",\">\r\n");
        for (Map.Entry<String, Map<String,String>> entry : tableAttribute.entrySet()) {
            str.append("\n<if test=\"entity."+Underline2Camel.camelName(entry.getKey())+" !=null and entity."+Underline2Camel.camelName(entry.getKey())+" !=''\">,"+entry.getKey()+" </if>\r\n");
        }
        str.append("</trim>\r\n</sql>\r\n");
        return str.toString();
    }
    //获取SqlInsertColumnList
    protected String getSqlInsertPropertyList(String javaName, Map<String, Map<String, String>> tableAttribute){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_insert_property_list\">\r\n")
                .append("<trim prefix=\"\" prefixOverrides=\",\">\r\n");
        for (Map.Entry<String, Map<String,String>> entry : tableAttribute.entrySet()) {
            str.append("\n<if test=\"entity."+Underline2Camel.camelName(entry.getKey())+" !=null and entity."+Underline2Camel.camelName(entry.getKey())+" !=''\">,#{entity."+Underline2Camel.camelName(entry.getKey())+"} </if>\r\n");
        }
        str.append("</trim>\r\n</sql>\r\n");
        return str.toString();
    }
    //获取sql_column_list
    protected String getSqlColumnList(String javaName, Map<String, Map<String, String>> tableAttribute){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_column_list\">\r\n");
        str.append("<trim prefix=\"\" prefixOverrides=\",\">");
        for (Map.Entry<String, Map<String,String>> entry : tableAttribute.entrySet()) {
            str.append(","+entry.getKey()+"\r\n");
        }
        str.append("</trim>");
        str.append("</sql>\r\n");
        str.substring(0,str.length()-1);
        return str.toString().substring(0,str.length()-1);
    }
    //获取sql_update_set
    protected String getSqlUpdateSet(String javaName, Map<String, Map<String, String>> tableAttribute){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_update_set\">\r\n")
                .append("<trim prefix=\"SET\" prefixOverrides=\",\">\r\n")
                .append("<if test=\"entity != null\">");
        for (Map.Entry<String, Map<String,String>> entry : tableAttribute.entrySet()) {
            str.append("<if test=\"entity."+Underline2Camel.camelName(entry.getKey())+" !=null and entity."+Underline2Camel.camelName(entry.getKey())+" !=''\">,"+entry.getKey()+" = #{entity."+Underline2Camel.camelName(entry.getKey())+"}</if>\r\n");
        }
        str.append("</if>\r\n</trim>\r\n</sql>\r\n");
        return str.toString();
    }
    //获取sql_condition
    protected String getSqlCondition(String javaName, Map<String, Map<String, String>> tableAttribute){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_condition\">\r\n")
                .append("<if test=\"condition != null\">\r\n");
        for (Map.Entry<String, Map<String,String>> entry : tableAttribute.entrySet()) {
            str.append("<if test=\"condition."+Underline2Camel.camelName(entry.getKey())+" !=null and condition."+Underline2Camel.camelName(entry.getKey())+" !=''\"> AND "+entry.getKey()+" = #{condition."+Underline2Camel.camelName(entry.getKey())+"}</if>\r\n");
        }
        str.append("</if>\r\n</sql>\r\n");
        str.append("<sql id=\"sql_pagination_end\">\r\n")
                .append("<![CDATA[\r\n")
                .append("limit ${startRow-1},#{limit}\r\n")
                .append("]]>\r\n</sql>");
        return str.toString();
    }
    //获取sql_force_update_set
    protected String getSqlForceUpdateSet(String javaName, Map<String, Map<String, String>> tableAttribute){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_force_update_set\">\r\n")
                .append("<trim prefix=\"SET\" prefixOverrides=\",\">\r\n");
        for (Map.Entry<String, Map<String,String>> entry : tableAttribute.entrySet()) {
            str.append("<if test=\"_parameter_containsKey('entity."+Underline2Camel.camelName(entry.getKey())+"')\">,"+entry.getKey()+" = #{entity."+Underline2Camel.camelName(entry.getKey())+"}</if>\r\n");
        }
        str.append("</trim>\r\n</sql>\r\n");
        return str.toString();
    }
    protected String getSqlIUDSXML(String table, Map<String, Map<String, String>> tableAttribute){

        StringBuffer str=new StringBuffer();
        str.append("<insert id=\"insert\" parameterType=\"java.util.Map\">\r\n")
                .append("<selectKey keyProperty=\"entity.id\" resultType=\"java.lang.String\" order=\"BEFORE\">\r\n")
                .append("call generate_no('SU',8,'"+table+"',@newOrderNo)\r\n")
                .append("</selectKey>\r\n")
                .append("REPLACE INTO "+table+" (\r\n")
                .append("<include refid=\"sql_insert_column_list\" />\r\n")
                .append(") VALUES (\r\n")
                .append("<include refid=\"sql_insert_property_list\" />\r\n")
                .append(")\r\n")
                .append("</insert>\r\n")

                .append("<select id=\"get\" parameterType=\"java.util.Map\" resultMap=\""+Underline2Camel.camelName(table)+"\">\r\n")
                .append("SELECT\r\n")
                .append("<include refid=\"sql_column_list\" />\r\n")
                .append("FROM "+table+"\r\n")
                .append("<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</trim>\r\n")
                .append("</select>\r\n")

                .append("<select id=\"getById\" parameterType=\"java.util.Map\" resultMap=\""+Underline2Camel.camelName(table)+"\">\r\n")
                .append("SELECT\r\n")
                .append("<include refid=\"sql_column_list\" />\r\n")
                .append("FROM "+table+"\r\n")
                .append("WHERE id = #{id}\r\n")
                .append("</select>\r\n")

                .append("<select id=\"find\" parameterType=\"java.util.Map\" resultMap=\""+Underline2Camel.camelName(table)+"\">\r\n")
                .append("SELECT\r\n")
                .append("<include refid=\"sql_column_list\" />\r\n")
                .append("FROM "+table+"\r\n")
                .append("<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</trim>\r\n")
                .append("<if test=\"orderBy != null\">\r\n")
                .append("ORDER BY ${orderBy}\r\n")
                .append("</if>\r\n")
                .append("<if test=\"offset != null\">\r\n")
                .append("<include refid=\"sql_pagination_end\" />\r\n")
                .append("</if>\r\n")
                .append("</select>\r\n")

                .append("<select id=\"findByIdList\" parameterType=\"java.util.Map\" resultMap=\""+Underline2Camel.camelName(table)+"\">\r\n")
                .append("SELECT\r\n")
                .append("<include refid=\"sql_column_list\" />\r\n")
                .append(" FROM "+table+"\r\n")
                .append("WHERE id IN\r\n")
                .append("<foreach collection=\"idList\" item=\"id\" open=\"(\" separator=\",\" close=\")\">\r\n")
                .append("#{id}\r\n")
                .append("</foreach>\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("<if test=\"orderBy != null\">\r\n")
                .append("ORDER BY ${orderBy}\r\n")
                .append("</if>\r\n")
                .append("</select>\r\n")

                .append("<select id=\"count\" parameterType=\"java.util.Map\" resultType=\"java.lang.Integer\">\r\n")
                .append("SELECT count(${count_column}) AS count_ FROM "+table+"\r\n")
                .append("<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</trim>\r\n")
                .append("</select>\r\n")

                .append("<select id=\"aggregate\" parameterType=\"java.util.Map\" resultType=\"java.util.HashMap\">\r\n")
                .append("SELECT ${aggregate_sql} FROM "+table+"\r\n")
                .append("<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</trim>\r\n")
                .append("</select>\r\n")

                .append("<update id=\"update\" parameterType=\"java.util.Map\">\r\n")
                .append("UPDATE "+table+"\r\n")
                .append("<include refid=\"sql_update_set\" />\r\n")
                .append("<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</trim>\r\n")
                .append("</update>\r\n")

                .append("<update id=\"updateById\" parameterType=\"java.util.Map\">\r\n")
                .append("UPDATE "+table+"\r\n")
                .append("<include refid=\"sql_update_set\" />\r\n")
                .append("WHERE id = #{id}\r\n")
                .append("</update>\r\n")

                .append("<update id=\"updateByIdList\" parameterType=\"java.util.Map\">\r\n")
                .append("UPDATE "+table+"\r\n")
                .append("<include refid=\"sql_update_set\" />\r\n")
                .append("WHERE id IN\r\n")
                .append("<foreach collection=\"idList\" item=\"id\" open=\"(\" separator=\",\" close=\")\">\r\n")
                .append("#{id}\r\n")
                .append("</foreach>\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</update>\r\n")

                .append("<update id=\"forceUpdate\" parameterType=\"java.util.Map\">\r\n")
                .append("UPDATE "+table+"\r\n")
                .append("<include refid=\"sql_force_update_set\" />\r\n")
                .append("<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</trim>\r\n")
                .append("</update>\r\n")

                .append("<update id=\"forceUpdateById\" parameterType=\"java.util.Map\">\r\n")
                .append("UPDATE "+table+"\r\n")
                .append("<include refid=\"sql_force_update_set\" />\r\n")
                .append("WHERE id = #{id}\r\n")
                .append("</update>\r\n")

                .append("<update id=\"forceUpdateByIdList\" parameterType=\"java.util.Map\">\r\n")
                .append("UPDATE "+table+"\r\n")
                .append("<include refid=\"sql_force_update_set\" />\r\n")
                .append("WHERE id IN\r\n")
                .append("<foreach collection=\"idList\" item=\"id\" open=\"(\" separator=\",\" close=\")\">\r\n")
                .append("#{id}\r\n")
                .append("</foreach>\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</update>\r\n")

                .append("<delete id=\"remove\" parameterType=\"java.util.Map\">\r\n")
                .append("DELETE FROM "+table+"\r\n")
                .append("<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</trim>\r\n")
                .append("</delete>\r\n")

                .append("<delete id=\"removeById\" parameterType=\"java.util.Map\">\r\n")
                .append("DELETE FROM "+table+"\r\n")
                .append("WHERE id = #{id}\r\n")
                .append("</delete>\r\n")

                .append("<delete id=\"removeByIdList\" parameterType=\"java.util.Map\">\r\n")
                .append("DELETE FROM "+table+"\r\n")
                .append("WHERE id IN\r\n")
                .append("<foreach collection=\"idList\" item=\"id\" open=\"(\" separator=\",\" close=\")\">\r\n")
                .append("#{id}\r\n")
                .append("</foreach>\r\n")
                .append("<include refid=\"sql_condition\" />\r\n")
                .append("</delete>\r\n\r\n");
        return str.toString();
    }
    //其他数据库不需要这个方法 oracle和db2需要
    private static String getSchema(Connection conn) throws Exception {
        String schema;
        schema = conn.getMetaData().getUserName();
        if ((schema == null) || (schema.length() == 0)) {
            throw new Exception("ORACLE数据库模式不允许为空");
        }
        return schema.toUpperCase().toString();

    }

}
