package com.lib.constant;

/**
 * @Author YangXiaohui
 * @Description
 * @Date Created on 2017-12-29 15:25
 * @Modified By
 */
public class GetDataConstant {
    //生成service和model文件的目录
    public static final String BASE_DAO_PATH = System.getProperty("user.dir")+"\\idc-service\\src\\main\\java\\com\\uhope\\idc\\dao\\";
    public static final String BASE_DAO_IMPL_PATH = System.getProperty("user.dir")+"\\idc-service\\src\\main\\java\\com\\uhope\\idc\\dao\\impl\\";

    public static final String BASE_SERVICE_PATH = System.getProperty("user.dir")+"\\idc-service\\src\\main\\java\\com\\uhope\\idc\\service\\";
    public static final String BASE_SERVICE_IMPL_PATH = System.getProperty("user.dir")+"\\idc-service\\src\\main\\java\\com\\uhope\\idc\\service\\impl\\";

    public static final String BASE_MAPPER_PATH = System.getProperty("user.dir")+"\\idc-common\\src\\main\\resources\\mapper\\";
    public static final String BASE_MAPPER_EXT_PATH = System.getProperty("user.dir")+"\\idc-service\\src\\main\\resources\\mapper\\";

    public static final String BASE_MODEL_PATH = System.getProperty("user.dir")+"\\idc-common\\src\\main\\java\\com\\uhope\\idc\\model\\";
    public static final String BASE_MODEL_VO_PATH = System.getProperty("user.dir")+"\\idc-service\\src\\main\\java\\com\\uhope\\idc\\model\\";

    //生成数据库的操作文件的数据库连接
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_PATH = "101.132.176.163";
    public static final String DB_PROT = "3306";
    public static final String DB_NAME = "library";
    public static final String DB_USER = "root";
    public static final String DB_PSWD = "joneyanyj520.";
    //生成数据库的操作文件的表 可以是多个，以逗号分隔
    public static final String DB_TABLENAME = "lib_bookborrow,lib_bookcase,lib_bookinfo,lib_booktype,lib_library" +
            ",lib_manager,lib_managerpower,lib_press,lib_reader,lib_readertype";
    //p

}
