package com.lib.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @Author YangXiaohui
 * @Description 封装json结果集
 * @Date Created on 2018-1-5 0:54
 * @Modified By
 */
public class ResultJson extends JSONObject {
    public void ResultJson(){
        this.put("data","");
        this.put("result","");
        this.put("code",200);
        this.put("message","");
        this.put("date",new Date());
    }
    public void putData(Object data){
        this.put("data",data);
    }
    public void putResult(Object result){
        this.put("result",result);
    }
    public void putCode(Object code){
        this.put("code",code);
    }
    public void putMessage(Object message){
        this.put("message",message);
    }
}
