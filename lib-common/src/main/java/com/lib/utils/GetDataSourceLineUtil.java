package com.lib.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author YangXiaohui
 * @Description 获取数据源里的所有列数据并进行转换
 * @Date Created on 2017-12-6 17:00
 * @Modified By
 */
public class GetDataSourceLineUtil {
    public static String driver = "com.mysql.jdbc.Driver";
    public Connection conn = null;
    public PreparedStatement pst = null;
    //用来生成所有文件的集合
    private Map<String,Object> resultLines;
    //用来Java   key:字段名 , value:字段类型
    Map<String,String> javaMap;
    public Map<String, String> getDataSourceLineUtil(String dbhost,String dbport,String dbname,String dbuser,String dbpass,String table){
        String url="jdbc:mysql://"+dbhost+":"+dbport+"/"+dbname+"?useUnicode=true&characterEncoding=utf-8&useOldAliasMetadataBehavior=true";
        String sql="select * from "+table;
        //数据库的列名称
        String[] colnames; // 列名数组
        //列名类型数组
        String[] colTypes;
        try {
            //驱动注册
            Class.forName(driver);
            //获取连接
            conn = DriverManager.getConnection(url, dbuser, dbpass);
            //执行语句
            pst = conn.prepareStatement(sql);
            //获取数据库的元数据
            ResultSetMetaData metadata = pst.getMetaData();
            //数据库的字段个数
            int len = metadata.getColumnCount();
            //字段名称
            colnames = new String[len+1];
            //字段类型
            colTypes = new String[len+1];
            //字段结果Map --Java
            javaMap=new HashMap<String,String>();
            for(int i= 1;i<=len;i++){
                //System.out.println(metadata.getColumnName(i)+":"+metadata.getColumnTypeName(i)+":"+sqlType2JavaType(metadata.getColumnTypeName(i).toLowerCase())+":"+metadata.getColumnDisplaySize(i));
                //metadata.getColumnDisplaySize(i);
                colnames[i] = metadata.getColumnName(i); //获取字段名称
                colTypes[i] = sqlType2JavaType(metadata.getColumnTypeName(i)); //获取字段类型
                javaMap.put(colnames[i],colTypes[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,String> resultMap=new HashMap<String,String>();
        resultMap.put("bean",formatJavaFileStr(table));
        resultMap.put("beanVO",getJavaBeanVOStr(table));
        resultMap.put("serviceIntf",getJavaServiceIntfStr(table));
        resultMap.put("serviceImpl",getJavaServiceImplStr(table));
        resultMap.put("daoIntf",getJavaDaoIntfStr(table));
        resultMap.put("daoImpl",getJavaDaoImplStr(table));
        resultMap.put("xml",getJavaXmlbase(table));
        resultMap.put("xmlExt",getJavaXmlEXT(table));
        return resultMap;
    }
    private String formatJavaFileStr(String table){
        //获取javaBean名字
        String className = Underline2Camel.camelName(table);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.uhope.www.model;\r\n\r\n");
        str.append("public class "+className+" {\r\n");
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            str.append(getBeanAttribute(entry.getValue(),entry.getKey()));
        }
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            str.append(getBeanGetMethod(entry.getValue(),entry.getKey()));
            str.append(getBeanSetMethod(entry.getValue(),entry.getKey()));
        }
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }
    //获取java  VO的文件字符串
    private String getJavaBeanVOStr(String table){
        //获取javaBean名字
        String className = Underline2Camel.camelName(table);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.uhope.www.model.vo;\r\n\r\n");
        str.append("public class "+className+"VO extends "+className+"{\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }
    //获取java  serviceIntf的文件字符串
    private String getJavaServiceIntfStr(String table){
        //获取javaBean名字
        String className = Underline2Camel.camelName(table);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.uhope.www.service;\r\n\r\n");
        str.append("import com.uhope.www.base.BO;\r\n");
        str.append("import com.uhope.www.model."+className+";\r\n");
        str.append("import com.uhope.www.model.vo."+className+"VO;\r\n\r\n");
        str.append("public class "+className+"ServiceIntf extends BO<"+className+", "+className+"VO, String>{\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }
    //获取java  serviceImpl的文件字符串
    private String getJavaServiceImplStr(String table){
        //获取javaBean名字
        String className = Underline2Camel.camelName(table);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.uhope.www.service.impl;\r\n\r\n");
        str.append("import com.uhope.www.base.AbstractBO;\r\n");
        str.append("import com.uhope.www.base.DAO;\r\n");
        str.append("import com.uhope.www.dao."+className+"DAO;\r\n");
        str.append("import com.uhope.www.model."+className+";\r\n");
        str.append("import com.uhope.www.model.vo."+className+"VO;\r\n");
        str.append("import com.uhope.www.service."+className+"ServiceIntf;\r\n");
        str.append("import org.slf4j.Logger;\r\n");
        str.append("import org.slf4j.LoggerFactory;\r\n");
        str.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
        str.append("import org.springframework.stereotype.Service;\r\n\r\n");
        str.append("@Service(\""+Underline2Camel.camelName(table)+"BO\")\r\n");
        str.append("public class "+className+"ServiceImpl extends AbstractBO<"+className+", "+className+"VO, String> implements "+className+"ServiceIntf {\r\n");
        str.append("private static final Logger LOGGER  =  LoggerFactory.getLogger("+className+"ServiceImpl.class);\r\n");
        str.append("@Autowired\r\n");
        str.append("private "+className+"DAO "+Underline2Camel.camelName(table)+"DAO;\r\n");
        str.append("@Override\r\n");
        str.append("protected DAO<"+className+", PmProjectVO, String> getDAO() {\r\n");
        str.append("return pmProjectDAO;\r\n}\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }
    //获取java  dao的文件字符串
    private String getJavaDaoIntfStr(String table){
        //获取javaBean名字
        String className = Underline2Camel.camelName(table);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.uhope.www.dao;\r\n\r\n");
        str.append("import com.uhope.www.base.DAO;\r\n");
        str.append("import com.uhope.www.model."+className+";\r\n");
        str.append("import com.uhope.www.model.vo."+className+"VO;\r\n\r\n");
        str.append("public interface "+className+"DAO extends DAO<"+className+", "+className+"VO, String>{\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }
    //获取java  daoImpl的文件字符串
    private String getJavaDaoImplStr(String table){
        //获取javaBean名字
        String className = Underline2Camel.camelName(table);
        className = Underline2Camel.toUpperCase4Index(className);
        StringBuffer str=new StringBuffer();
        str.append("package com.uhope.www.dao.impl;\r\n\r\n");
        str.append("import com.uhope.www.base.AbstractDAO;\r\n");
        str.append("import com.uhope.www.dao."+className+"DAO;\r\n");
        str.append("import com.uhope.www.model."+className+";\r\n");
        str.append("import com.uhope.www.model.vo."+className+"VO;\r\n");
        str.append("import org.mybatis.spring.SqlSessionTemplate;\r\n");
        str.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
        str.append("import org.springframework.stereotype.Repository;\r\n\r\n");
        str.append("@Repository(\""+Underline2Camel.camelName(table)+"Dao\")\r\n");
        str.append("public interface "+className+"DAO extends DAO<"+className+", "+className+"VO, String>{\r\n");
        str.append("@Autowired\r\n");
        str.append("private SqlSessionTemplate sqlSessionTemplate;\r\n");
        str.append("@Override\r\n");
        str.append("protected SqlSessionTemplate getSqlSessionTemplate() {\r\n");
        str.append("return sqlSessionTemplate;\r\n}\r\n");
        str.append("@Override\r\n");
        str.append("protected String getNamespace() {\r\n");
        str.append("return \""+Underline2Camel.camelName(table)+"Dao\";\r\n}\r\n");
        str.append("}\r\n");
        System.out.println(str.toString());
        return str.toString();
    }

    //获取xml的文件信息
    private String getJavaXmlbase(String table){
        String javaName = Underline2Camel.camelName(table);
        StringBuffer str=new StringBuffer();
        str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE mapper PUBLIC")
                .append("-//mybatis.org//DTD Mapper 3.0//EN\"")
                .append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n")
                .append("<mapper namespace=\""+javaName+"Dao\">\r\n")
                .append(getResultMapStr(javaName))
                .append(getSqlInsertColumnList(javaName))
                .append(getSqlInsertPropertyList(javaName))
                .append(getSqlColumnList(javaName))
                .append(getSqlUpdateSet(javaName))
                .append(getSqlCondition(javaName))
                .append(getSqlForceUpdateSet(javaName))
                .append(getSqlIUDSXML(javaName,table))
                .append("</mapper>");
        return str.toString();
    }
    //获取xmlext的文件信息
    private String getJavaXmlEXT(String table){
        String javaName = Underline2Camel.camelName(table);
        StringBuffer str=new StringBuffer();
        str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE mapper PUBLIC")
                .append("-//mybatis.org//DTD Mapper 3.0//EN\"")
                .append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n")
                .append("<mapper namespace=\""+javaName+"Dao_EXT\">\r\n")
                .append(getResultMapStr(javaName))
                .append(getSqlInsertColumnList(javaName))
                .append(getSqlInsertPropertyList(javaName))
                .append(getSqlColumnList(javaName))
                .append(getSqlUpdateSet(javaName))
                .append(getSqlCondition(javaName))
                .append(getSqlForceUpdateSet(javaName))
                .append("</mapper>");
        return str.toString();
    }

    //获取ResultMap
    protected String getResultMapStr(String javaName){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<resultMap id=\""+javaName+"\" type=\"com.uhope.www.model."+className+"\">\r\n");
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            str.append("\n<result property=\""+Underline2Camel.camelName(entry.getKey())+"\" column=\""+entry.getKey()+"\" />");
        }
        str.append("</resultMap>\r\n");
        return str.toString();
    }
    //获取SqlInsertColumnList
    protected String getSqlInsertColumnList(String javaName){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_insert_column_list\">\r\n")
                .append("\n<trim prefix=\"\" prefixOverrides=\",\">\r\n");
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            str.append("\n\n<if test=\"entity."+Underline2Camel.camelName(entry.getKey())+" !=null and entity."+Underline2Camel.camelName(entry.getKey())+" !=''\">,"+entry.getKey()+" </if>\r\n");
        }
        str.append("\n</trim>\r\n</sql>\r\n");
        return str.toString();
    }
    //获取SqlInsertColumnList
    protected String getSqlInsertPropertyList(String javaName){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_insert_property_list\">\r\n")
                .append("\n<trim prefix=\"\" prefixOverrides=\",\">\r\n");
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            str.append("\n\n<if test=\"entity."+Underline2Camel.camelName(entry.getKey())+" !=null and entity."+Underline2Camel.camelName(entry.getKey())+" !=''\">,#{entity."+Underline2Camel.camelName(entry.getKey())+"} </if>\r\n");
        }
        str.append("\n</trim>\r\n</sql>\r\n");
        return str.toString();
    }
    //获取sql_column_list
    protected String getSqlColumnList(String javaName){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_column_list\">\r\n");
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            str.append("\n"+entry.getKey()+",\r\n");
        }
        str.deleteCharAt(str.length() - 1);
        str.append("</sql>\r\n");
        return str.toString();
    }
    //获取sql_update_set
    protected String getSqlUpdateSet(String javaName){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_update_set\">\r\n")
                .append("\n<trim prefix=\"SET\" prefixOverrides=\",\">\r\n")
                .append("\n\n<if test=\"entity != null\">");
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            str.append("\n\n\n<if test=\"entity."+Underline2Camel.camelName(entry.getKey())+" !=null and entity."+Underline2Camel.camelName(entry.getKey())+" !=''\">,"+entry.getKey()+" = #{entity."+Underline2Camel.camelName(entry.getKey())+"}</if>\r\n");
        }
        str.append("\n\n</if>\r\n</trim>\r\n</sql>\r\n");
        return str.toString();
    }
    //获取sql_condition
    protected String getSqlCondition(String javaName){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_condition\">\r\n")
                .append("\n<if test=\"condition != null\">\r\n");
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            str.append("\n\n<if test=\"entity."+Underline2Camel.camelName(entry.getKey())+" !=null and entity."+Underline2Camel.camelName(entry.getKey())+" !=''\">,"+entry.getKey()+" = #{entity."+Underline2Camel.camelName(entry.getKey())+"}</if>\r\n");
            str.append("\n\n<if test=\"condition."+Underline2Camel.camelName(entry.getKey())+" !=null and condition."+Underline2Camel.camelName(entry.getKey())+" !=''\"> AND "+entry.getKey()+" = #{condition."+Underline2Camel.camelName(entry.getKey())+"}</if>\r\n");
        }
        str.append("\n</if>\r\n</sql>\r\n");
        str.append("<sql id=\"sql_pagination_end\">\r\n")
                .append("<![CDATA[\r\n")
                .append("limit ${startRow-1},#{limit}\r\n")
                .append("]]>\r\n</sql>");
        return str.toString();
    }
    //获取sql_force_update_set
    protected String getSqlForceUpdateSet(String javaName){
        String className=Underline2Camel.toUpperCase4Index(javaName);
        StringBuffer str=new StringBuffer();
        str.append("<sql id=\"sql_force_update_set\">\r\n")
                .append("\n<trim prefix=\"SET\" prefixOverrides=\",\">\r\n");
        for (Map.Entry<String, String> entry : javaMap.entrySet()) {
            str.append("\n\n<if test=\"_parameter_containsKey('entity."+Underline2Camel.camelName(entry.getKey())+"')\">,"+entry.getKey()+" = #{entity."+Underline2Camel.camelName(entry.getKey())+"}</if>\r\n");
        }
        str.append("\n</trim>\r\n</sql>\r\n");
        return str.toString();
    }

    protected String getSqlIUDSXML(String javaName,String table){
        
        StringBuffer str=new StringBuffer();
            str.append("<insert id=\"insert\" parameterType=\"java.util.Map\">\r\n")
                    .append("\n<selectKey keyProperty=\"entity.id\" resultType=\"java.lang.String\" order=\"BEFORE\">\r\n")
                    .append("\n\nSELECT REPLACE(UUID(),'-','')\r\n")
                    .append("\n</selectKey>\r\n")
                    .append("\nREPLACE INTO "+table+" (\r\n")
                    .append("\n\n<include refid=\"sql_insert_column_list\" />\r\n")
                    .append("\n) VALUES (\r\n")
                    .append("\n\n<include refid=\"sql_insert_property_list\" />\r\n")
                    .append("\n)\r\n")
                    .append("</insert>\r\n")

                    .append("<select id=\"get\" parameterType=\"java.util.Map\" resultMap=\""+Underline2Camel.camelName(table)+"\">\r\n")
                    .append("\nSELECT\r\n")
                    .append("\n<include refid=\"sql_column_list\" />\r\n")
                    .append("\nFROM "+table+"\r\n")
                    .append("\n<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                    .append("\n\n<include refid=\"sql_condition\" />\r\n")
                    .append("\n</trim>\r\n")
                    .append("</select>\r\n")

                    .append("<select id=\"getById\" parameterType=\"java.util.Map\" resultMap=\""+Underline2Camel.camelName(table)+"\">\r\n")
                    .append("\nSELECT\r\n")
                    .append("\n<include refid=\"sql_column_list\" />\r\n")
                    .append("\nFROM "+table+"\r\n")
                    .append("\nWHERE id = #{id}\r\n")
                    .append("</select>\r\n")

                    .append("<select id=\"find\" parameterType=\"java.util.Map\" resultMap=\""+Underline2Camel.camelName(table)+"\">\r\n")
                    .append("\nSELECT\r\n")
                    .append("\n<include refid=\"sql_column_list\" />\r\n")
                    .append("\nFROM "+table+"\r\n")
                    .append("\n<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                    .append("\n\n<include refid=\"sql_condition\" />\r\n")
                    .append("\n</trim>\r\n")
                    .append("\n<if test=\"orderBy != null\">\r\n")
                    .append("\n\nORDER BY ${orderBy}\r\n")
                    .append("\n</if>\r\n")
                    .append("\n<if test=\"offset != null\">\r\n")
                    .append("\n\n<include refid=\"sql_pagination_end\" />\r\n")
                    .append("\n</if>\r\n")
                    .append("</select>\r\n")

                    .append("<select id=\"findByIdList\" parameterType=\"java.util.Map\" resultMap=\""+Underline2Camel.camelName(table)+"\">\r\n")
                    .append("\nSELECT\r\n")
                    .append("\n\n<include refid=\"sql_column_list\" />\r\n")
                    .append("\nFROM "+table+"\r\n")
                    .append("\nWHERE id IN\r\n")
                    .append("\n<foreach collection=\"idList\" item=\"id\" open=\"(\" separator=\",\" close=\")\">\r\n")
                    .append("\n\n#{id}\r\n")
                    .append("\n</foreach>\r\n")
                    .append("\n<include refid=\"sql_condition\" />\r\n")
                    .append("\n<if test=\"orderBy != null\">\r\n")
                    .append("\n\nORDER BY ${orderBy}\r\n")
                    .append("\n</if>\r\n")
                    .append("</select>\r\n")

                    .append("<select id=\"count\" parameterType=\"java.util.Map\" resultType=\"java.lang.Integer\">\r\n")
                    .append("\nSELECT count(${count_column}) AS count_ FROM "+table+"\r\n")
                    .append("\n<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                    .append("\n\n<include refid=\"sql_condition\" />\r\n")
                    .append("\n</trim>\r\n")
                    .append("</select>\r\n")

                    .append("<select id=\"aggregate\" parameterType=\"java.util.Map\" resultType=\"java.util.HashMap\">\r\n")
                    .append("\nSELECT ${aggregate_sql} FROM "+table+"\r\n")
                    .append("\n<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                    .append("\n\n<include refid=\"sql_condition\" />\r\n")
                    .append("\n</trim>\r\n")
                    .append("</select>\r\n")

                    .append("<update id=\"update\" parameterType=\"java.util.Map\">\r\n")
                    .append("\nUPDATE "+table+"\r\n")
                    .append("\n<include refid=\"sql_update_set\" />\r\n")
                    .append("\n<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                    .append("\n\n<include refid=\"sql_condition\" />\r\n")
                    .append("\n</trim>\r\n")
                    .append("</update>\r\n")

                    .append("<update id=\"updateById\" parameterType=\"java.util.Map\">\r\n")
                    .append("\nUPDATE "+table+"\r\n")
                    .append("\n\n<include refid=\"sql_update_set\" />\r\n")
                    .append("\nWHERE id = #{id}\r\n")
                    .append("</update>\r\n")

                    .append("<update id=\"updateByIdList\" parameterType=\"java.util.Map\">\r\n")
                    .append("\nUPDATE "+table+"\r\n")
                    .append("\n\n<include refid=\"sql_update_set\" />\r\n")
                    .append("\nWHERE id IN\r\n")
                    .append("\n<foreach collection=\"idList\" item=\"id\" open=\"(\" separator=\",\" close=\")\">\r\n")
                    .append("\n\n#{id}\r\n")
                    .append("\n</foreach>\r\n")
                    .append("\n<include refid=\"sql_condition\" />\r\n")
                    .append("</update>\r\n")

                    .append("<update id=\"forceUpdate\" parameterType=\"java.util.Map\">\r\n")
                    .append("\nUPDATE "+table+"\r\n")
                    .append("\n\n<include refid=\"sql_force_update_set\" />\r\n")
                    .append("\n<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                    .append("\n\n<include refid=\"sql_condition\" />\r\n")
                    .append("\n</trim>\r\n")
                    .append("</update>\r\n")

                    .append("<update id=\"forceUpdateById\" parameterType=\"java.util.Map\">\r\n")
                    .append("\nUPDATE "+table+"\r\n")
                    .append("\n\n<include refid=\"sql_force_update_set\" />\r\n")
                    .append("\nWHERE id = #{id}\r\n")
                    .append("</update>\r\n")

                    .append("<update id=\"forceUpdateByIdList\" parameterType=\"java.util.Map\">\r\n")
                    .append("\nUPDATE "+table+"\r\n")
                    .append("\n\n<include refid=\"sql_force_update_set\" />\r\n")
                    .append("\nWHERE id IN\r\n")
                    .append("\n<foreach collection=\"idList\" item=\"id\" open=\"(\" separator=\",\" close=\")\">\r\n")
                    .append("\n\n#{id}\r\n")
                    .append("\n</foreach>\r\n")
                    .append("\n<include refid=\"sql_condition\" />\r\n")
                    .append("</update>\r\n")

                    .append("<delete id=\"remove\" parameterType=\"java.util.Map\">\r\n")
                    .append("\nDELETE FROM "+table+"\r\n")
                    .append("\n<trim prefix=\"WHERE\" prefixOverrides=\"AND\">\r\n")
                    .append("\n\n<include refid=\"sql_condition\" />\r\n")
                    .append("\n</trim>\r\n")
                    .append("</delete>\r\n")

                    .append("<delete id=\"removeById\" parameterType=\"java.util.Map\">\r\n")
                    .append("\nDELETE FROM "+table+"\r\n")
                    .append("\nWHERE id = #{id}\r\n")
                    .append("</delete>\r\n")

                    .append("<delete id=\"removeByIdList\" parameterType=\"java.util.Map\">\r\n")
                    .append("\nDELETE FROM "+table+"\r\n")
                    .append("\nWHERE id IN\r\n")
                    .append("\n<foreach collection=\"idList\" item=\"id\" open=\"(\" separator=\",\" close=\")\">\r\n")
                    .append("\n\n#{id}\r\n")
                    .append("\n</foreach>\r\n")
                    .append("\n<include refid=\"sql_condition\" />\r\n")
                    .append("</delete>\r\n\r\n");
        return str.toString();
    }
    //获取javabean的属性
    public StringBuffer getBeanAttribute(String type,String name){
        String format = String.format("    private %s %s;\n\r", new String[]{type,Underline2Camel.camelName(name)});
        return new StringBuffer(format);
    }
    //获取set方法
    public StringBuffer getBeanGetMethod(String type,String name){
        name=(Underline2Camel.toUpperCase4Index(Underline2Camel.camelName(name)));
        String Methodname = "set"+name;
        String format = String.format("    public void %s(%s %s){\n\r", new Object[]{Methodname,type,(Underline2Camel.toUpperCase4Index(Underline2Camel.camelName(name)))});
        format += String.format("        this.%s = %s;\r\n", new Object[]{name,name});
        format += "    }\r\n";
        return new StringBuffer(format);
    }
    //获取get方法
    public StringBuffer getBeanSetMethod(String type,String name){
        name=(Underline2Camel.toUpperCase4Index(Underline2Camel.camelName(name)));
        String Methodname = "set"+name;
        String format = String.format("    public void %s(%s %s){\n\r", new Object[]{Methodname,type,name});
        format += String.format("        this.%s = %s;\r\n", new Object[]{name,name});
        format += "    }\r\n";
        return new StringBuffer(format);
    }
    /*mysql的字段类型转化为java的类型*/
    private String sqlType2JavaType(String sqlType) {
        if(sqlType.equalsIgnoreCase("bit")){
            return "Boolean";
        }else if(sqlType.equalsIgnoreCase("tinyint")){
            return "Byte";
        }else if(sqlType.equalsIgnoreCase("smallint")){
            return "Short";
        }else if(sqlType.equalsIgnoreCase("INTEGER")){
            return "Integer";
        }else if(sqlType.equalsIgnoreCase("bigint")){
            return "Long";
        }else if(sqlType.equalsIgnoreCase("float")){
            return "Float";
        }else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")){
            return "Double";
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")){
            return "String";
        }else if(sqlType.equalsIgnoreCase("datetime") ||sqlType.equalsIgnoreCase("date")){
            return "java.util.Date";
        }else if(sqlType.equalsIgnoreCase("image")){
            return "Blod";
        }
        return null;
    }
}
