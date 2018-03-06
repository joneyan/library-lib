package com.lib.controller;

import com.lib.bean.PageBean;
import com.lib.model.LibManager;
import com.lib.model.LibReadertype;
import com.lib.model.vo.LibReaderVO;
import com.lib.model.vo.LibReadertypeVO;
import com.lib.service.LibManagerService;
import com.lib.service.LibReaderService;
import com.lib.service.LibReadertypeService;
import com.lib.utils.ResponseUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2018-3-6.
 */
@Controller
@RequestMapping("usertype")
public class ReaderTypeController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private LibReaderService libReaderService;
    @Autowired
    private LibManagerService libManagerService;
    @Autowired
    private LibReadertypeService libReadertypeService;

    /**
     * 得到读者类型列表
     * @param request
     * @param model
     * @param page
     * @param pagesize
     * @return
     */
    @RequestMapping("/getusertypelist")
    public String getBookBannerUserList(HttpServletRequest request, Model model,
                                        @RequestParam(required = false,defaultValue = "1") Integer page,
                                        @RequestParam(required = false,defaultValue = "10") Integer pagesize){
        List<LibReadertypeVO>  libReaderTypes = libReadertypeService.getPeopleNumList();
        List<LibReadertype> libReadertypes1 = libReadertypeService.find();
        int size = libReadertypes1.size();
        PageBean<LibReadertypeVO> libReaderVOPageBean = new PageBean<>();
        libReaderVOPageBean.setPageElements(libReaderTypes);
        libReaderVOPageBean.setPagesize(pagesize);
        libReaderVOPageBean.setPage(page);
        libReaderVOPageBean.setTotalNum(size);
        libReaderVOPageBean.setTotalPage();
        model.addAttribute("pagebean",libReaderVOPageBean);
        return "readertype_mana";

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
        return "readertype_add";
    }

    /**
     * 添加新类型
     * @param request
     * @param response
     * @param model
     * @param rolename
     * @param brownum
     */
    @RequestMapping("addusrtype")
    @ResponseBody
    public void addUserType(HttpServletRequest request ,HttpServletResponse response,Model model,
                              String rolename,
                              Integer brownum){
        String data=null;
        LibReadertypeVO libReadertypeVO = new LibReadertypeVO();
        libReadertypeVO.setRolename(rolename);
        List<LibReadertype> libReadertypes = libReadertypeService.find(libReadertypeVO);
        if(libReadertypes.size()>0){
            data="2";
        }else{
            LibReadertype libReadertype = new LibReadertype();
            libReadertype.setRolename(rolename);
            libReadertype.setBrownum(brownum);
            libReadertypeService.insert(libReadertype);
            data="1";
        }
        ResponseUtils.writeJson(response,data);
    }

    /**
     * 跳转到修改窗口
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toeditpage")
    public String toAddPageEdit(HttpServletRequest request, HttpServletResponse response,Model model,Integer id){
        LibReadertypeVO libReadertypeVO = new LibReadertypeVO();
        libReadertypeVO.setId(id);
        List<LibReadertype> libReadertypes = libReadertypeService.find(libReadertypeVO);
        model.addAttribute("readertype",libReadertypes.get(0));
        return "readertype_edit";
    }

    /**
     * 修改类型
     * @param request
     * @param response
     * @param model
     * @param rolename
     * @param brownum
     */
    @RequestMapping("updateusertype")
    @ResponseBody
    public void updateUserType(HttpServletRequest request ,HttpServletResponse response,Model model,
                            String rolename,
                            Integer brownum){
        String data=null;
        LibReadertypeVO libReadertypeVO = new LibReadertypeVO();
        libReadertypeVO.setRolename(rolename);
        List<LibReadertype> libReadertypes = libReadertypeService.find(libReadertypeVO);
        if(libReadertypes.size()>0){
            LibReadertype libReadertype = new LibReadertype();
            libReadertype.setRolename(rolename);
            libReadertype.setBrownum(brownum);
            libReadertypeService.update(libReadertype,libReadertypeVO);
            data="1";
        }else{

            data="2";
        }
        ResponseUtils.writeJson(response,data);
    }
    @RequestMapping("removetype")
    public String removeType(HttpServletRequest request,HttpServletResponse response,Model model,Integer id){
        LibReadertypeVO libReadertypeVO = new LibReadertypeVO();
        libReadertypeVO.setId(id);
        int remove = libReadertypeService.remove(libReadertypeVO);
        if(remove>0){
            model.addAttribute("message","删除成功!");
        }else{
            model.addAttribute("message","删除失败!");
        }
        model.addAttribute("tourl","/usertype/getusertypelist");
        return "messager";
    }

}
