package com.lib.controller;

import com.lib.bean.PageBean;
import com.lib.model.LibBooktype;
import com.lib.model.LibReadertype;
import com.lib.model.vo.LibBooktypeVO;
import com.lib.model.vo.LibReadertypeVO;
import com.lib.service.LibBooktypeService;
import com.lib.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2018-3-16.
 */
@RequestMapping("booktype")
@Controller
public class BookTypeController {
    private static Logger logger = LoggerFactory.getLogger(BookTypeController.class);

    @Autowired
    private LibBooktypeService libBooktypeService;

    /**
     * 得到书籍类型列表
     * @param request
     * @param model
     * @param page
     * @param pagesize
     * @return
     */
    @RequestMapping("/getBookTypeList")
    public String getBookTypeList(HttpServletRequest request, Model model,
                                  @RequestParam(required = false,defaultValue = "1") Integer page,
                                  @RequestParam(required = false,defaultValue = "10") Integer pagesize){
        List<LibBooktypeVO>  libBooktypeVOs = libBooktypeService.getPeopleNumList();
        List<LibBooktype> libBooktypes = libBooktypeService.find();
        int size = libBooktypes.size();
        PageBean<LibBooktypeVO> libBooktypeVOPageBean = new PageBean<>();
        libBooktypeVOPageBean.setPageElements(libBooktypeVOs);
        libBooktypeVOPageBean.setPagesize(pagesize);
        libBooktypeVOPageBean.setPage(page);
        libBooktypeVOPageBean.setTotalNum(size);
        libBooktypeVOPageBean.setTotalPage();
        model.addAttribute("pagebean",libBooktypeVOPageBean);
        return "booktype_mana";

    }

    /**
     * 跳转到修改窗口
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toeditpage")
    public String toAddPageEdit(HttpServletRequest request, HttpServletResponse response, Model model, Integer id){
        LibBooktypeVO libBooktypeVO = new LibBooktypeVO();
        libBooktypeVO.setId(id);
        List<LibBooktype> libBooktypes = libBooktypeService.find(libBooktypeVO);
        model.addAttribute("booktype",libBooktypes.get(0));
        return "booktype_edit";
    }

    @RequestMapping("updatebooktype")
    @ResponseBody
    public void updatebooktype(HttpServletRequest request , HttpServletResponse response, Model model,
                               String typename,
                               Integer days){
        String data=null;
        LibBooktypeVO libBooktypeVO = new LibBooktypeVO();
        libBooktypeVO.setTypename(typename);
        List<LibBooktype> libReadertypes = libBooktypeService.find(libBooktypeVO);
        if(libReadertypes.size()>0){
            LibBooktype libBooktype = new LibBooktype();
            libBooktype.setTypename(typename);
            libBooktype.setDays(days);
            libBooktypeService.update(libBooktype,libBooktypeVO);
            data="1";
        }else{

            data="2";
        }
        ResponseUtils.writeJson(response,data);
    }

    /**
     * 跳转到新增窗口
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toaddpage")
    public String toAddPage(HttpServletRequest request, HttpServletResponse response,Model model){
        return "booktype_add";
    }

    /**
     * 添加新类型
     * @param request
     * @param response
     * @param model
     * @param typename
     * @param days
     */
    @RequestMapping("addbooktype")
    @ResponseBody
    public void addUserType(HttpServletRequest request ,HttpServletResponse response,Model model,
                            String typename,
                            Integer days){
        String data=null;
        LibBooktypeVO libBooktypeVO = new LibBooktypeVO();
        libBooktypeVO.setTypename(typename);
        List<LibBooktype> libBooktypes = libBooktypeService.find(libBooktypeVO);
        if(libBooktypes.size()>0){
            data="2";
        }else{
            LibBooktype libBooktype = new LibBooktype();
            libBooktype.setTypename(typename);
            libBooktype.setDays(days);
            libBooktypeService.insert(libBooktype);
            data="1";
        }
        ResponseUtils.writeJson(response,data);
    }

    @RequestMapping("removetype")
    public String removeType(HttpServletRequest request,HttpServletResponse response,Model model,Integer id){
        LibBooktypeVO libBooktypeVO = new LibBooktypeVO();
        libBooktypeVO.setId(id);
        int remove = libBooktypeService.remove(libBooktypeVO);
        if(remove>0){
            model.addAttribute("message","删除成功!");
        }else{
            model.addAttribute("message","删除失败!");
        }
        model.addAttribute("tourl","/booktype/getBookTypeList");
        return "messager";
    }
}
