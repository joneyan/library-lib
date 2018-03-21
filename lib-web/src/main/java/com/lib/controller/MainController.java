package com.lib.controller;

import com.lib.model.LibBookborrow;
import com.lib.model.LibBookinfo;
import com.lib.model.vo.LibBookborrowVO;
import com.lib.model.vo.LibBookinfoVO;
import com.lib.service.LibBookborrowService;
import com.lib.service.LibBookinfoService;
import com.lib.service.LibManagerService;
import com.lib.service.LibReaderService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by JONEYAN on 2018/3/22.
 */
@Controller
@RequestMapping("main")
public class MainController {
    @Autowired
    private LibReaderService libReaderService;

    @Autowired
    private LibBookinfoService libBookinfoService;
    @Autowired
    private LibBookborrowService libBookborrowService;
    @Autowired
    private LibManagerService libManagerService;
    @RequestMapping("statistics ")
    public String getStatistics(HttpServletRequest request,Model model){
        Integer count = libReaderService.countRecentReader();
        //新读者
        model.addAttribute("readercount",count);
        LibBookborrowVO libBookborrowVO = new LibBookborrowVO();
        libBookborrowVO.setStatus(2);
        //借出数量
        int count1 = libBookborrowService.count(libBookborrowVO);
        model.addAttribute("borrowcount",count1);
        //新入图书数量
        Integer count2 = libBookinfoService.countRecentBook(null);
        model.addAttribute("newbookcount",count2);

        //书籍总数
        LibBookinfoVO libBookinfoVO = new LibBookinfoVO();
        libBookinfoVO.setStatus(1);
        int count3 = libBookinfoService.count(libBookinfoVO);
        model.addAttribute("booktotalcount",count3);

        List<Integer> mothlist = libBookborrowService.getEveryMothBorrow();
        model.addAttribute("monthlist",mothlist);
        return "index";
    }

}
