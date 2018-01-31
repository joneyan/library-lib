package com.lib.controller;

import com.lib.bean.PageBean;
import com.lib.model.LibBookcase;
import com.lib.model.vo.LibBookcaseVO;
import com.lib.service.LibBookcaseService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.catalina.util.LifecycleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2018-1-31.
 */
@Controller
@RequestMapping("/bookcase")
public class BookCaseController {
    private static Logger logger = LoggerFactory.getLogger(BookCaseController.class);
    @Autowired
    private LibBookcaseService libBookcaseService;

    /**
     * 获取列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getbookecaselist")
    public String getBookCaselist(HttpServletRequest request,
                                  Model model,
                                  @RequestParam(required = false,defaultValue = "1") Integer page,
                                  @RequestParam(required = false,defaultValue = "10") Integer pagesize){
        List<LibBookcase> libBookcases = libBookcaseService.find(pagesize, page);
        int count = libBookcaseService.count();
        PageBean<LibBookcase> libBookcasePageBean = new PageBean<>();
        libBookcasePageBean.setPage(page);
        libBookcasePageBean.setPageElements(libBookcases);
        libBookcasePageBean.setTotalNum(count);
        libBookcasePageBean.setPagesize(pagesize);
        libBookcasePageBean.setTotalPage();
        model.addAttribute("pagebean",libBookcasePageBean);
        return "bookcase_mana";
    }

    /**
     * 添加书架
     * @param request
     * @param model
     * @param region 区域
     * @param casename 名字
     * @return
     */
    @RequestMapping("/saveInfo")
    public String saveInfo(HttpServletRequest request,Model model,String region,String casename){
        if(!"".equals(region)&&!"".equals(casename)&&region!=null&&casename!=null){
            String finalname=region+"-"+casename;
            LibBookcaseVO libBookcaseVO = new LibBookcaseVO();
            libBookcaseVO.setCasename(finalname);
            List<LibBookcase> libBookcases = libBookcaseService.find(libBookcaseVO);
            if(libBookcases.size()>0){
                model.addAttribute("message","添加失败，已经拥有这个书架！");
                model.addAttribute("tourl","http://10.0.9.193:8088/bookcase/getbookecaselist");
                return "messager";
            }
            LibBookcase libBookcase = new LibBookcase();
            libBookcase.setCasename(finalname);
            libBookcaseService.insert(libBookcase);
            model.addAttribute("message","恭喜，添加成功！");
           /* Random random = new Random();

            for(int j=0;j<65535;j++){
                int i1 = random.nextInt(68 - 65) + 65;
                char ch=(char)i1;
                int i = random.nextInt(999);
                String name=ch+"-"+i;
                LibBookcase libBookcase2 = new LibBookcase();
                libBookcase2.setCasename(name);
                libBookcaseService.insert(libBookcase2);
            }*/
        }else{
            model.addAttribute("message","传入参数不能为空，添加失败");
        }
        model.addAttribute("tourl","http://10.0.9.193:8088/bookcase/getbookecaselist");
        return "messager";
    }

}
