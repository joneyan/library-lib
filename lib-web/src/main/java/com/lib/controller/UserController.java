package com.lib.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.lib.bean.PageBean;
import com.lib.model.LibManager;
import com.lib.model.LibReader;
import com.lib.model.LibReadertype;
import com.lib.model.vo.LibReaderVO;
import com.lib.model.vo.LibReadertypeVO;
import com.lib.service.LibManagerService;
import com.lib.service.LibReaderService;
import com.lib.service.LibReadertypeService;
import com.lib.utils.ResponseUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.logging.log4j.core.util.JsonUtils;
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
    private LibManagerService libManagerService;
    @Autowired
    private LibReadertypeService  libReadertypeService;
    @RequestMapping("/getbookbanneruserlist")
    public String getBookBannerUserList(HttpServletRequest request, Model model,
                                        @RequestParam(required = false) Integer isBanner,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) Integer operator,
                                        @RequestParam(required = false) Integer typeid,
                                        @RequestParam(required = false) String vocation,
                                        @RequestParam(required = false) Integer sex,
                                        @RequestParam(required = false,defaultValue = "1") Integer page,
                                        @RequestParam(required = false,defaultValue = "10") Integer pagesize){
        LibReaderVO libReaderVO = new LibReaderVO();
        dealSearch(isBanner,name,operator,typeid,vocation,sex,null, null, libReaderVO);
        List<LibReaderVO> libReaders = libReaderService.findBannerReader(libReaderVO, pagesize, page,null,null);
        int totalNum=libReaderService.countCutoms(libReaderVO,null,null);
        PageBean<LibReaderVO> libReaderVOPageBean = new PageBean<>();
        libReaderVOPageBean.setPageElements(libReaders);
        libReaderVOPageBean.setPagesize(pagesize);
        libReaderVOPageBean.setPage(page);
        libReaderVOPageBean.setTotalNum(totalNum);
        libReaderVOPageBean.setTotalPage();
        model.addAttribute("pagebean",libReaderVOPageBean);
        model.addAttribute("banner",libReaderVO);
        List<LibReadertype> libReadertypes = libReadertypeService.find();
        List<LibManager> libManagers = libManagerService.find();
        model.addAttribute("operators",libManagers);
        model.addAttribute("types",libReadertypes);
        return "banner_mana";

    }

    /**
     * 得到读者列表
     * @return
     */
    @RequestMapping("/getReaderList")
    public String getReaderList(HttpServletRequest request, Model model,
                                @RequestParam(required = false) Integer isBanner,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) Integer operator,
                                @RequestParam(required = false) String barcode,
                                @RequestParam(required = false) String papernum,
                                @RequestParam(required = false) Integer typeid,
                                @RequestParam(required = false) String vocation,
                                @RequestParam(required = false) Integer sex,
                                @RequestParam(required = false,defaultValue = "1") Integer page,
                                @RequestParam(required = false,defaultValue = "10") Integer pagesize,
                                @RequestParam(required = false) String startTime,
                                @RequestParam(required = false) String endTime){
        if(operator!=null&&typeid!=null&&sex!=null){
            if(operator==-1){
                operator=null;
            }
            if(sex==-1){
                sex=null;
            }
            if(typeid==-1){
                typeid=null;
            }
        }
        LibReaderVO libReaderVO = new LibReaderVO();
        dealSearch(isBanner,name,operator,typeid,vocation,sex,papernum,barcode,libReaderVO);
        List<LibReaderVO> libReaders = libReaderService.findBannerReader(libReaderVO, pagesize, page,startTime,endTime);
        int totalNum=libReaderService.countCutoms(libReaderVO,startTime,endTime);
        PageBean<LibReaderVO> libReaderVOPageBean = new PageBean<>();
        libReaderVOPageBean.setPageElements(libReaders);
        libReaderVOPageBean.setPagesize(pagesize);
        libReaderVOPageBean.setPage(page);
        libReaderVOPageBean.setTotalNum(totalNum);
        libReaderVOPageBean.setTotalPage();
        model.addAttribute("pagebean",libReaderVOPageBean);
        model.addAttribute("banner",libReaderVO);
        List<LibReadertype> libReadertypes = libReadertypeService.find();
        List<LibManager> libManagers = libManagerService.find();
        model.addAttribute("operators",libManagers);
        model.addAttribute("types",libReadertypes);
        model.addAttribute("reader",libReaderVO);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        return "reader_mana";
    }

    /**
     * 添加用户
     * @param request
     * @param response
     * @param model
     * @param name
     * @param barcode
     * @param papernum
     * @param typeid
     * @param vocation
     * @param sex
     * @param readermail
     * @param readertel
     * @return
     */
    @RequestMapping("adduser")
    public String addReader(HttpServletRequest request, HttpServletResponse response,Model model,
                            String name,
                            String barcode,
                            String papernum,
                            Integer typeid,
                            String vocation,
                            String sex,
                            String readermail,
                            String readertel){
        LibManager loginInfo = (LibManager) request.getSession().getAttribute("loginInfo");
        LibReader libReader = new LibReader();
        LibReaderVO libReaderVO = new LibReaderVO();
        libReaderVO.setName(name);
        libReaderVO.setPapernum(papernum);
        List<LibReader> libReaders = libReaderService.find(libReaderVO);
        if(libReaders.size()>0){
            model.addAttribute("message","添加失败，已经存在此用户！");
        }else{
            addParamDeal(loginInfo, libReader,name, barcode, papernum, typeid, vocation,sex,readermail,readertel);
            libReader.setCreatedate(new Date());
            libReaderService.insert(libReader);
            model.addAttribute("message","添加成功！");
        }
        model.addAttribute("tourl","/user/getReaderList");
        return "messager";
    }

    /**
     * 获得要修改的读者信息
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("updateuser")
    @ResponseBody
    public void updateReader(HttpServletRequest request, HttpServletResponse response,Model model,
                            String name,
                            String barcode,
                            String papernum,
                            Integer typeid,
                            String vocation,
                            String sex,
                            String readermail,
                            String readertel){
        String data=null;
        LibManager loginInfo = (LibManager) request.getSession().getAttribute("loginInfo");
        LibReader libReader = new LibReader();
        LibReaderVO libReaderVO = new LibReaderVO();
        libReaderVO.setName(name);
        libReaderVO.setPapernum(papernum);
        List<LibReader> libReaders = libReaderService.find(libReaderVO);

        addParamDeal(loginInfo, libReader,name, barcode, papernum, typeid, vocation,sex,readermail,readertel);
        int update = libReaderService.update(libReader, libReaderVO);
        if(update>0){
            data="1";
        }
        ResponseUtils.writeJson(response,data);
    }
    /**
     * 获得修改的读者信息
     * @param request
     * @param response
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("geteditreader")
    public String getEidtReader(HttpServletRequest request,HttpServletResponse response,Integer id,Model model){
        LibReaderVO libReaderVO = new LibReaderVO();
        libReaderVO.setId(id);
        List<LibReader> libReaders = libReaderService.find(libReaderVO);
        LibReader libReader = libReaders.get(0);
        model.addAttribute("reader",libReader);
        List<LibReadertype> libReadertypes = libReadertypeService.find();
        model.addAttribute("types",libReadertypes);
        return "reader_edit";
    }

    /**
     * 跳转新增页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toaddpage")
    public String toAddPage(HttpServletRequest request ,HttpServletResponse response,Model model){
        List<LibReadertype> libReadertypes = libReadertypeService.find();
        model.addAttribute("types",libReadertypes);
        return "reader_add";
    }

    /**
     * 删除用户
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("removereader")
    public String removeReader(HttpServletRequest request,HttpServletResponse response,Model model,Integer id){
       //查找此用户
        LibReaderVO libReaderVO = new LibReaderVO();
        libReaderVO.setId(id);
        List<LibReader> libReaders = libReaderService.find(libReaderVO);
        //得到读者类型
        Integer typeid = libReaders.get(0).getTypeid();
        LibReadertypeVO libReadertypeVO = new LibReadertypeVO();
        libReadertypeVO.setId(typeid);
        List<LibReadertype> libReadertypes = libReadertypeService.find(libReadertypeVO);
        //得到原本可借的数目
        Integer brownum = libReadertypes.get(0).getBrownum();
        //目前剩下的数目
        Integer remainum = libReaders.get(0).getRemainum();
        if(remainum==brownum){
            int remove = libReaderService.remove(libReaderVO);
            if(remove >0){
                model.addAttribute("message","删除成功！");
            }else{
                model.addAttribute("message","删除成功！请确认数据库有此数据");
            }
        }else{
            model.addAttribute("message","不能删除，此用户还有未归还图书");
        }
        model.addAttribute("tourl","/user/getReaderList");
        return "messager";
    }

    //处理增加的数据
    private void addParamDeal(LibManager loginInfo, LibReader libReader, String name, String barcode, String papernum, Integer typeid, String vocation, String sex, String readermail, String readertel) {
        libReader.setName(name);
        libReader.setBarcode(barcode);
        libReader.setPapernum(papernum);
        libReader.setPapertype("身份证");
        libReader.setTypeid(typeid);
        libReader.setVocation(vocation);
        libReader.setSex(sex);
        libReader.setReadermail(readermail);
        libReader.setReadertel(readertel);
        libReader.setUpdatedate(new Date());
        libReader.setOperator(loginInfo.getId());
        LibReadertypeVO libReadertypeVO = new LibReadertypeVO();
        libReadertypeVO.setId(typeid);
        List<LibReadertype> libReadertypes = libReadertypeService.find(libReadertypeVO);
        libReader.setRemainum(libReadertypes.get(0).getBrownum());
    }


    /**
     * 处理传入的搜索数据
     */
    public  void dealSearch(Integer isBanner, String name, Integer operator, Integer typeid, String vocation
            , Integer sex, String papernum, String barcode, LibReaderVO libReaderVO){
        libReaderVO.setIsBanner(isBanner);
        libReaderVO.setName(name);
        libReaderVO.setOperator(operator);
        libReaderVO.setTypeid(typeid);
        libReaderVO.setVocation(vocation);
        libReaderVO.setPapernum(papernum);
        libReaderVO.setBarcode(barcode);
        if(sex!=null){
            libReaderVO.setSex(sex+"");
        }

    }
}
