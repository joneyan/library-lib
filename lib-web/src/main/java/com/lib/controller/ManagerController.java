package com.lib.controller;

import com.lib.bean.PageBean;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2018-2-2.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    private static Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private LibManagerService libManagerService;

    /**
     * 得到管理员列表
     * @return
     */
    @RequestMapping("getbookemanagerlist")
    public String getBookeManagerList(HttpServletRequest request, Model model,
                                      @RequestParam(required = false) String username,
                                      @RequestParam(required = false) Integer status,
                                      @RequestParam(required = false,defaultValue = "1") Integer page,
                                      @RequestParam(required = false,defaultValue = "10") Integer pagesize){
        if(status!=null){
            if(status==-1){
                status=null;
            }
        }
        LibManagerVO libManagerVO = new LibManagerVO();
        libManagerVO.setUsername(username);
        libManagerVO.setStatus(status);
        List<LibManager> libManagers = libManagerService.find(libManagerVO, pagesize, page);
        int count = libManagerService.count(libManagerVO);
        PageBean<LibManager> libManagerPageBean = new PageBean<>();
        libManagerPageBean.setPage(page);
        libManagerPageBean.setPageElements(libManagers);
        libManagerPageBean.setTotalNum(count);
        libManagerPageBean.setPagesize(pagesize);
        libManagerPageBean.setTotalPage();
        model.addAttribute("pagebean",libManagerPageBean);
        model.addAttribute("status",status);
        model.addAttribute("pubname",username);
        return "manager_mana";
    }

    /**
     * 重置密码
     * @param request
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("resetpwd")
    public String resetPwd(HttpServletRequest request,Model model ,Integer id){
        if(id!=null){
            LibManager libManager = new LibManager();
            libManager.setPassword("111111");
            int update = libManagerService.update(libManager, id + "");
            model.addAttribute("message","重置成功，新密码为'111111'!请登录后修改");
        }else{
            model.addAttribute("message","充值失败!确认选中用户");
        }
        model.addAttribute("tourl","http://10.0.9.193:8088/manager/getbookemanagerlist");
        return "messager";
    }
}
