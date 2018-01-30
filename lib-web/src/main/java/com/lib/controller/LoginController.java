package com.lib.controller;


import com.lib.model.LibManager;
import com.lib.model.vo.LibManagerVO;
import com.lib.service.LibManagerService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018-1-27.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LibManagerService libManagerService;

    @RequestMapping("/manalogin")
    public String manaLogin(HttpServletRequest request, HttpServletResponse response, LibManagerVO libManager, String remember , Model model){
        HttpSession session = request.getSession();
        if(libManager!=null){
            List<LibManager> libManagers = libManagerService.find(libManager);
            if(libManagers!=null &&libManagers.size()>0){
                if(libManagers.get(0).getUsername().equals(libManager.getUsername())){
                    if(!"".equals(libManager.getPassword())){
                        if(libManagers.get(0).getPassword().equals(libManager.getPassword())){
                            model.addAttribute("manager",libManagers.get(0));
                            session.setAttribute("managerlog",libManagers.get(0));
                            //记住密码操作和没记住密码操作
                            if(remember!=null){
                                Cookie loginUsername = new Cookie("loginUsername", libManagers.get(0).getUsername());
                                Cookie loginPassword = new Cookie("loginPassword", libManagers.get(0).getPassword());
                                loginPassword.setMaxAge(15*24*3600);
                                loginUsername.setMaxAge(15*24*3600);
                                response.addCookie(loginPassword);
                                response.addCookie(loginUsername);
                                session.setAttribute("loginInfo",libManagers.get(0));
                            }else{
                                Cookie[] cookies = request.getCookies();
                                for(Cookie cookie:cookies){
                                    if(cookie.getName().equals("loginUsername")||cookie.equals("loginPassword")){
                                        cookie.setMaxAge(0);
                                    }
                                    response.addCookie(cookie);
                                }
                                session.removeAttribute("loginInfo");
                            }
                        }else{
                            model.addAttribute("message","密码错误");
                            return "/login";
                        }
                    }
                }else{
                    model.addAttribute("message","用户名错误");
                    return "/login";
                }
            }else{
                model.addAttribute("message","用户名或密码错误");
                return "/login";
            }
        }else{
            model.addAttribute("message","请输入相关信息");
            return "/login";
        }
        return "redirect:/index";
    }
}
