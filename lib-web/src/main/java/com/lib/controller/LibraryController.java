package com.lib.controller;


import com.lib.model.LibLibrary;
import com.lib.model.vo.LibLibraryVO;
import com.lib.service.LibLibraryService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.tomcat.jni.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2018-1-29.
 */
@Controller
@RequestMapping("/library")
public class LibraryController {
    private static Logger logger = LoggerFactory.getLogger(LibraryController.class);
    @Autowired
    private LibLibraryService libLibraryService;

    /**
     * 得到图书馆信息
     * @return
     */
    @RequestMapping("/libraryInfo")
    public String getLibraryInfo(HttpServletRequest request, Model model){
        List<LibLibrary> libLibraries = libLibraryService.find();
        model.addAttribute("lib",libLibraries.get(0));
        return "library_info";
    }

    /**
     * 得到要修改的图书馆页面信息
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getEditInfo")
    public String getEditInfo(HttpServletRequest request,Model model) {
        List<LibLibrary> libLibraries = libLibraryService.find();
        model.addAttribute("lib",libLibraries.get(0));
        return "library_infoedit";
    }



    /**
     * @author yanjing
     * @param request
     * @param model
     * @param library
     * @return
     */
    @RequestMapping("saveInfo")
    public String saveInfo(HttpServletRequest request, Model model, LibLibrary library,String createdate1){
        String[] dates = createdate1.split("-");
        Calendar instance = Calendar.getInstance();
        instance.set(Integer.parseInt(dates[0]),Integer.parseInt(dates[1]),Integer.parseInt(dates[2]));
        System.out.println(instance);
        if(library !=null){
            System.out.println(library.getAddress());
            int update = libLibraryService.update(library, 1 + "");
            if(update>0){
                model.addAttribute("message","修改成功！");
            }else{
                model.addAttribute("message","修改失败");
            }
        }
        model.addAttribute("tourl","http://10.0.9.193:8088/library/getEditInfo");
        return "messager";
    }
}
