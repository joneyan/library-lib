package com.lib.controller;

import com.lib.bean.PageBean;
import com.lib.model.LibReader;
import com.lib.model.LibReadertype;
import com.lib.model.vo.LibReaderVO;
import com.lib.service.LibReaderService;
import com.lib.service.LibReadertypeService;
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
 * Created by Administrator on 2018-2-6.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private LibReaderService libReaderService;
    @Autowired
    private LibReadertypeService  libReadertypeService;
    @RequestMapping("/getbookbanneruserlist")
    public String getBookBannerUserList(HttpServletRequest request, Model model,
                                        @RequestParam(required = false) Integer isBanner,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) Integer operator,
                                        @RequestParam(required = false) Integer typeid,
                                        @RequestParam(required = false) String vocation,
                                        @RequestParam(required = false) String sex,
                                        @RequestParam(required = false,defaultValue = "1") Integer page,
                                        @RequestParam(required = false,defaultValue = "10") Integer pagesize){
        LibReaderVO libReaderVO = new LibReaderVO();
        dealSearch(isBanner,name,operator,typeid,vocation,sex,libReaderVO);
        List<LibReaderVO> libReaders = libReaderService.findBannerReader(libReaderVO, pagesize, page);
        int totalNum=libReaderService.countCutoms(libReaderVO);
        PageBean<LibReaderVO> libReaderVOPageBean = new PageBean<>();
        libReaderVOPageBean.setPageElements(libReaders);
        libReaderVOPageBean.setPagesize(pagesize);
        libReaderVOPageBean.setPage(page);
        libReaderVOPageBean.setTotalNum(totalNum);
        libReaderVOPageBean.setTotalPage();
        model.addAttribute("pagebean",libReaderVOPageBean);
        model.addAttribute("banner",libReaderVO);
        List<LibReadertype> libReadertypes = libReadertypeService.find();
        model.addAttribute("types",libReadertypes);
        return "banner_mana";

    }

    /**
     * 处理传入的搜索数据
     */
    public  void dealSearch(Integer isBanner,String name,Integer operator,Integer typeid,String vocation
                            ,String sex,LibReaderVO libReaderVO){
        libReaderVO.setIsBanner(isBanner);
        libReaderVO.setName(name);
        libReaderVO.setOperator(operator);
        libReaderVO.setTypeid(typeid);
        libReaderVO.setVocation(vocation);
        libReaderVO.setSex(sex);
    }
}