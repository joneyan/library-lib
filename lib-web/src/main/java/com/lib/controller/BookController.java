package com.lib.controller;

import com.lib.bean.PageBean;
import com.lib.model.*;
import com.lib.model.vo.LibBookinfoVO;
import com.lib.service.*;
import com.lib.utils.ResponseUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018-3-7.
 */
@Controller
@RequestMapping("book")
public class BookController {
    private static Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private LibBookcaseService libBookcaseService;
    @Autowired
    private LibPressService libPressService;
    @Autowired
    private LibBooktypeService libBooktypeService;
    @Autowired
    private LibBookinfoService libBookinfoService;
    @Autowired
    private LibManagerService libManagerService;

    /**
     * 查询图书
     * @param request
     * @param response
     * @param model
     * @param bookname
     * @param author
     * @param operator
     * @param pressid
     * @param typeid
     * @param bookcaseid
     * @param startTime
     * @param endTime
     * @param status
     * @return
     */
    @RequestMapping("getBookList")
    public String getBookList(HttpServletRequest request, HttpServletResponse response, Model model,
                              @RequestParam(required = false) String bookname,
                              @RequestParam(required = false) String author,
                              @RequestParam(required = false) Integer operator,
                              @RequestParam(required = false) Integer pressid,
                              @RequestParam(required = false) Integer typeid,
                              @RequestParam(required = false) Integer bookcaseid,
                              @RequestParam(required = false) String startTime,
                              @RequestParam(required = false) String endTime,
                              @RequestParam(required = false) Integer status,
                              @RequestParam(required = false,defaultValue = "1") Integer page,
                              @RequestParam(required = false,defaultValue = "10") Integer pagesize){
        if(operator!=null && pressid!=null && typeid!=null && bookcaseid!=null &&status!=null ){
            if(operator==-1){
                operator=null;
            }
            if(pressid==-1){
                pressid=null;
            }
            if(typeid==-1){
                typeid=null;
            }
            if(bookcaseid==-1){
                bookcaseid=null;
            }
            if(status==-1){
                status=null;
            }
        }
        LibBookinfoVO libBookinfoVO = new LibBookinfoVO();
        dealSearch(bookname,author,operator,pressid,typeid,bookcaseid,status,libBookinfoVO);
        List<LibBookinfoVO> libBookVos = libBookinfoService.getBookList(libBookinfoVO, pagesize, page,startTime,endTime);
        Integer total = libBookinfoService.getBookListTotal(libBookinfoVO,startTime,endTime);
        PageBean<LibBookinfoVO> libReaderVOPageBean = new PageBean<>();
        libReaderVOPageBean.setPageElements(libBookVos);
        libReaderVOPageBean.setPagesize(pagesize);
        libReaderVOPageBean.setPage(page);
        libReaderVOPageBean.setTotalNum(total);
        libReaderVOPageBean.setTotalPage();
        model.addAttribute("pagebean",libReaderVOPageBean);
        model.addAttribute("book",libBookinfoVO);
        List<LibManager> libManagers = libManagerService.find();
        List<LibBookcase> libBookcases = libBookcaseService.find();
        List<LibPress> libPresses = libPressService.find();
        List<LibBooktype> libBooktypes = libBooktypeService.find();
        model.addAttribute("operators",libManagers);
        model.addAttribute("bookcases",libBookcases);
        model.addAttribute("presses",libPresses);
        model.addAttribute("catelogs",libBooktypes);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        return "book_mana";
    }

    /**
     * 跳转新增页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toaddpage")
    public String toAddPage(HttpServletRequest request,HttpServletResponse response,Model model){
        List<LibManager> libManagers = libManagerService.find();
        List<LibBookcase> libBookcases = libBookcaseService.find();
        List<LibPress> libPresses = libPressService.find();
        List<LibBooktype> libBooktypes = libBooktypeService.find();
        model.addAttribute("operators",libManagers);
        model.addAttribute("bookcases",libBookcases);
        model.addAttribute("presses",libPresses);
        model.addAttribute("catelogs",libBooktypes);
        return "book_add";
    }

    /**
     * 新增书籍
     * @param request
     * @param response
     * @param model
     * @param bookname
     * @param author
     * @param pressid
     * @param typeid
     * @param bookcaseid
     * @param status
     * @param isbn
     * @param price
     * @param page
     * @param totalnum
     * @param barcode
     */
    @RequestMapping("addbook")
    @ResponseBody
    public void addBook(HttpServletRequest request,HttpServletResponse response,Model model,
                        String bookname,
                        String author,
                        Integer pressid,
                        Integer typeid,
                        Integer bookcaseid,
                        Integer status,
                        String isbn,
                        Integer price,
                        Integer page,
                        Integer totalnum,
                        String barcode){
        String data=null;
        LibManager loginInfo = (LibManager) request.getSession().getAttribute("loginInfo");
        LibBookinfoVO libBookinfoVO = new LibBookinfoVO();
        libBookinfoVO.setAuthor(author);
        libBookinfoVO.setBookname(bookname);
        List<LibBookinfo> libBookinfos = libBookinfoService.find(libBookinfoVO);
        LibBookinfo libBookinfo = new LibBookinfo();
        //如果已经 存在，则进行修改
        if(libBookinfos.size()>0){
            libBookinfoVO.setBarcode(libBookinfos.get(0).getBarcode());
            libBookinfo.setTotalnum(totalnum+libBookinfos.get(0).getTotalnum());
            libBookinfo.setLeftnum(totalnum+libBookinfos.get(0).getLeftnum());
            int update = libBookinfoService.update(libBookinfo, libBookinfoVO);
            if(update>0){
                data="1";
            }else{
                data="0";
            }
        }else{
            dealAdd(bookname,author,pressid,typeid,bookcaseid,status,libBookinfo, isbn, price, page, totalnum, barcode,loginInfo);
            libBookinfoService.insert(libBookinfo);
            data="1";
        }

        ResponseUtils.writeJson(response,data);
    }
    //处理要新增的数据
    private void dealAdd(String bookname, String author, Integer pressid, Integer typeid, Integer bookcaseid, Integer status, LibBookinfo libBookinfo,
                         String isbn, Integer price, Integer page, Integer totalnum, String barcode, LibManager loginInfo) {
        libBookinfo.setBookname(bookname);
        libBookinfo.setAuthor(author);
        libBookinfo.setPressid(pressid);
        libBookinfo.setTypeid(typeid);
        libBookinfo.setBookcaseid(bookcaseid);
        libBookinfo.setStatus(status);
        libBookinfo.setLeftnum(totalnum);
        libBookinfo.setTotalnum(totalnum);
        libBookinfo.setBarcode(barcode+UUID.randomUUID().toString());
        libBookinfo.setPage(page);
        libBookinfo.setPrice(price);
        libBookinfo.setIsbn(isbn+ UUID.randomUUID().toString());
        libBookinfo.setOperator(loginInfo.getId());
        libBookinfo.setIntime(new Date());
    }
//处理搜索数据
    private void dealSearch(String bookname, String author, Integer operator, Integer pressid, Integer typeid, Integer bookcaseid, Integer status, LibBookinfoVO libBookinfoVO) {
        libBookinfoVO.setBookname(bookname);
        libBookinfoVO.setAuthor(author);
        libBookinfoVO.setOperator(operator);
        libBookinfoVO.setPressid(pressid);
        libBookinfoVO.setTypeid(typeid);
        libBookinfoVO.setBookcaseid(bookcaseid);
        libBookinfoVO.setStatus(status);
    }
}
