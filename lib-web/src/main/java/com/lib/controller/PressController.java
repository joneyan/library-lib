package com.lib.controller;

import com.lib.base.OrderBy;
import com.lib.bean.PageBean;
import com.lib.model.LibPress;
import com.lib.model.vo.LibPressVO;
import com.lib.service.LibPressService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2018-2-1.
 */
@Controller
@RequestMapping("/press")
public class PressController {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(PressController.class);
    @Autowired
    private LibPressService libPressService;

    /**
     * 得到出版社列表
     * @param request
     * @param model
     * @param page
     * @param pagesize
     * @return
     */
    @RequestMapping("/getbookepresslist")
    public String getBookPressList(HttpServletRequest request, Model model,
                                   @RequestParam(required = false) String pubname,
                                   @RequestParam(required = false) Integer status,
                                   @RequestParam(required = false,defaultValue = "1") Integer page,
                                   @RequestParam(required = false,defaultValue = "10") Integer pagesize){
       if(status!=null){
           if(status==-1){
               status=null;
           }
       }
        LibPressVO libPressVO = new LibPressVO();
        libPressVO.setPubname(pubname);
        libPressVO.setStatus(status);
        List<LibPress> libPresses = libPressService.find(libPressVO,pagesize,page);
        int count = libPressService.count(libPressVO);
        PageBean<LibPress> libPressPageBean = new PageBean<>();
        libPressPageBean.setPage(page);
        libPressPageBean.setPageElements(libPresses);
        libPressPageBean.setTotalNum(count);
        libPressPageBean.setPagesize(pagesize);
        libPressPageBean.setTotalPage();
        model.addAttribute("pagebean",libPressPageBean);
        model.addAttribute("status",status);
        model.addAttribute("pubname",pubname);
        return "press_mana";
    }

    /**
     * 新增
     * @param request
     * @param model
     * @param pubname
     * @param status
     * @retur!
     */
    @RequestMapping("/savePressInfo")
    public String savePressInfo(HttpServletRequest request, Model model,
                                  String pubname,
                                 Integer status){
        if(!"".equals(pubname)){
            LibPressVO libPressVO = new LibPressVO();
            libPressVO.setStatus(status);
            libPressVO.setPubname(pubname);
            List<LibPress> libPresses = libPressService.find(libPressVO);
            if(libPresses.size()>0){
                model.addAttribute("message","新增失败！已经存在此出版社");
                model.addAttribute("tourl","/press_add");
                return "messager";
            }
            LibPress libPress = new LibPress();
            libPress.setPubname(pubname);
            libPress.setStatus(status);
            libPressService.insert(libPress);
            model.addAttribute("message","添加成功！");


        }else{
            model.addAttribute("message","输入不能为空，添加失败！");
        }
        model.addAttribute("tourl","/press/getbookepresslist");
        return "messager";

    }

    @RequestMapping("/romovepress")
    public String romovebookcase(HttpServletRequest request,Model model,Integer id){
        int remove = libPressService.remove(id + "");
        if(remove>0){
            model.addAttribute("message","删除成功！");
        }else{
            model.addAttribute("message","删除失败！");
        }
        model.addAttribute("tourl","/press/getbookepresslist");
        return "messager";
    }
    @RequestMapping("/turnuse")
    public String turnUse(HttpServletRequest request,Model model,Integer status,String id){
        LibPress libPress = new LibPress();
        libPress.setStatus(status);
        int update = libPressService.update(libPress, id + "");
        if(update>0){
            model.addAttribute("message","修改成功！");
        }else{
            model.addAttribute("message","修改失败！");
        }
        model.addAttribute("tourl","/press/getbookepresslist");
        return "messager";
    }
}
