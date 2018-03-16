package com.lib.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.lib.utils.ResponseUtils;
import sun.applet.Main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2018-3-16.
 */
public class test {
    public static void main(String args[]) throws IOException {
        String param = "key=c8926378e8b04f38903d0c76f89b3c2e&location=杭州&now?";
        StringBuilder sb = new StringBuilder();
        InputStream is=null;
        BufferedReader br=null;
        PrintWriter out =null;
        try {
            //接口地址
            String            url        = "https://free-api.heweather.com/s6/weather";
            URL uri        = new URL(url);
            HttpURLConnection connection= (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setRequestProperty("accept", "*/*");
            //发送参数
            connection.setDoOutput(true);
            out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.flush();
            //接收结果
            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String         line;
            //缓冲逐行读取
            while ( (line = br.readLine()) != null ) {
                sb.append(line);
            }
            System.out.println(sb.toString());
            String s = sb.toString();
            Object o = JSONObject.parse(s);
            System.out.println(o);
        }catch ( Exception ignored ){}
        finally {
            //关闭流
            try {
                if(is!=null){
                    is.close();
                }
                if(br!=null){
                    br.close();
                }
                if (out!=null){
                    out.close();
                }
            } catch (IOException e2) {}
        }
    }
}
