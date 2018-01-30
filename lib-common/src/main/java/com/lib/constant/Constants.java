package com.lib.constant;

import com.lib.utils.Config;

/**
 * @Author YangXiaohui
 * @Description
 * @Date Created on 2018-1-5 15:31
 * @Modified By
 */
public class Constants {
    //项目地址
    public static final String BASE_DOMAIN = Config.getConfig().get("base.domain");
    public static final String STATIC_DOMAIN = Config.getConfig().get("static.domain");
    public static final String HOME_DOMAIN = Config.getConfig().get("home.domain");

    //分页
    public static final Integer DEFAULT_PAGE_SIZE = 5;


}
