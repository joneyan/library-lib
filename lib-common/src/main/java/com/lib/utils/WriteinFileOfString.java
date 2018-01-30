package com.lib.utils;

/**
 * @Author YangXiaohui
 * @Description 写入文件
 * @Date Created on 2017-12-29 15:03
 * @Modified By
 */
public class WriteinFileOfString {
    private static String bathPath = System.getProperty("user.dir");
//    private static String bathPath1 = Thread.currentThread().getContextClassLoader().getResource("/").getPath();

    public static void writeIn(String str){
        System.out.println(bathPath);
//        System.out.println(bathPath1);

    }
    public static void writeFile(){
        //获取文件路径
//        File file = new File(s3);
//        //如果没有文件路径就创建
//        if(!file.exists()){
//            file.mkdirs();
//        }
//        //一个写入流
//        BufferedWriter write = null;
//        //开始写文件
//        try {
//            write = new BufferedWriter(new FileWriter(new File(s3+File.separator+className+".java")));
//            write.write(str.toString());
//            write.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            if (write != null)
//                try {
//                    write.close();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//        }
    }
}
