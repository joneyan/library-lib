package com.lib.base;


import com.lib.constant.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017-8-4.
 */
@Controller
public class BaseController {
//    private static Logger logger = LoggerFactory.getLogger(BaseController.class);
    //默认访问首页
    @RequestMapping("/{page}")
    public String index(Model model, HttpServletRequest request ,@PathVariable("page") String page) {
        model.addAttribute("sss","1111");
        return page;
    }
    //400页面
    @GetMapping("/400")
    public String badRequest(){
        return "/error/400";
    }
    //404页面
    @GetMapping("/404")
    public String notFound(){
        return "/error/404";
    }
    //500页面
    @GetMapping("/500")
    public String serverError(){
        return "/error/500";
    }


    @ModelAttribute("baseDomain")
    public String getBaseDomain() {
        return Constants.BASE_DOMAIN;
    }
    @ModelAttribute("staticDomain")
    public String getStaticDomain() {
        return Constants.STATIC_DOMAIN;
    }

    @ModelAttribute("homeDomain")
    public String getHomeDomain() {
        return Constants.HOME_DOMAIN;
    }

    @ModelAttribute("base")
    public String getBase() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getContextPath();
    }
    @ModelAttribute("requestUrl")
    public String getRequestUrl() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //基本路径
        StringBuffer requestpath= new StringBuffer(request.getRequestURL().toString());
        if(StringUtils.isNotBlank(request.getQueryString())){
            requestpath.append("?")
                    .append(request.getQueryString());
        }
        //获取基本属性
        return requestpath.toString();
    }
}
