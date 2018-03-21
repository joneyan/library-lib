package com.lib.controller;

import com.google.j2objc.annotations.AutoreleasePool;
import com.lib.bean.PageBean;
import com.lib.model.*;
import com.lib.model.vo.LibBookborrowVO;
import com.lib.model.vo.LibBookinfoVO;
import com.lib.model.vo.LibReaderVO;
import com.lib.service.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by JONEYAN on 2018/3/19.
 */
@RequestMapping("borrow")
@Controller
public class BorrowController {
    @Autowired
    private LibBookborrowService libBookborrowService;
    @Autowired
    private LibBookinfoService libBookinfoService;

    @Autowired
    private LibReaderService libReaderService;

    @Autowired
    private LibReadertypeService libReadertypeService;

    @Autowired
    private LibBooktypeService libBooktypeService;


    @RequestMapping("toborrow")
    public String toBorrow(HttpServletRequest request, Model model , LibBookinfoVO libBookinfoVO,
                           @RequestParam(required = false ,defaultValue = "1") Integer pageNumber){
        List<LibBookinfoVO> libBookVos = libBookinfoService.getBookList(libBookinfoVO, 10, pageNumber,null,null);
        Integer total = libBookinfoService.getBookListTotal(libBookinfoVO,null,null);
        PageBean<LibBookinfoVO> libReaderVOPageBean = new PageBean<>();
        libReaderVOPageBean.setPageElements(libBookVos);
        libReaderVOPageBean.setPagesize(10);
        libReaderVOPageBean.setPage(pageNumber);
        libReaderVOPageBean.setTotalNum(total);
        libReaderVOPageBean.setTotalPage();
        model.addAttribute("pagebean",libReaderVOPageBean);
        return "borrow_mana";
    }

    /**
     * 跳转到借书页面
     * @param request
     * @param model
     * @param id 所选择的书籍id
     * @return
     */
    @RequestMapping("toborrowpage")
    public String toBorrowPage(HttpServletRequest request,Model model,String id){
        model.addAttribute("bookid",id);
        return "fillborrowpage";
    }
    @RequestMapping("borrowbook")
    @ResponseBody
    public String borrowbook(HttpServletRequest request, Model model, String bookid, @ModelAttribute LibReaderVO libReaderVO){
        String data=null;
        if(libReaderVO!=null){
            if(!"".equals(libReaderVO.getName()) && libReaderVO.getName() !=null && !"".equals(libReaderVO.getPapernum()) && libReaderVO.getPapernum() !=null &&
                    !"".equals(libReaderVO.getName()) && libReaderVO.getName() !=null && !"".equals(libReaderVO.getBarcode()) && libReaderVO.getBarcode() !=null){
                List<LibReader> libReaders = libReaderService.find(libReaderVO);
                if(libReaders.size() <=0){
                    return data="2";
                }
                LibReader libReader = libReaders.get(0);
                if(libReader.getName().equals(libReaderVO.getName())){
                    if(libReader.getBarcode().equals(libReaderVO.getBarcode())){
                        if(libReader.getPapernum().equals(libReaderVO.getPapernum())){

                            LibReadertype libReadertype = libReadertypeService.get(libReader.getTypeid() + "");
                            LibBookborrowVO libBookborrowVO = new LibBookborrowVO();
                            libBookborrowVO.setReaderId(libReader.getId());
                            libBookborrowVO.setStatus(2);
                            List<LibBookborrow> libBookborrows = libBookborrowService.find(libBookborrowVO);
                            int size = libBookborrows.size();
                            if(libReadertype.getBrownum()>size){
                                HttpSession session = request.getSession();
                                LibManager loginInfo = (LibManager) session.getAttribute("loginInfo");
                                libBookborrowService.borrowBook(libReaderVO,bookid,libReader.getId(),loginInfo);
                                LibBookinfo libBookinfo = libBookinfoService.get(bookid);
                                LibBooktype libBooktype = libBooktypeService.get(libBookinfo.getTypeid()+"");
                                Calendar instance = Calendar.getInstance();
                                instance.setTime(new Date());
                                instance.add(Calendar.DAY_OF_MONTH,libBooktype.getDays());
                                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
                                String format = sdf1.format(instance.getTime());
                                model.addAttribute("message","成功借出，提醒按期归还！最后归还日期为:"+format);
                                data="1";
                            }else {
                                model.addAttribute("message","借出失败此读者已经借出最大数量！");
                                data="2";
                            }

                        }
                        else{
                            model.addAttribute("message","借出失败，无此身份证号读者！");
                            data="2";
                        }
                    }
                    else{
                        model.addAttribute("message","借出失败，无此编码读者！");
                        data="2";
                    }
                }else{
                    model.addAttribute("message","借出失败，无此名字读者！");
                    data="2";
                }

            }else{
                model.addAttribute("message","借出失败，传入参数不能为空！");
                data="2";
            }

        }
        return data;
    }

    /**
     * 得到借出的图书
     * @param request
     * @param model
     * @param name
     * @param pageNumber
     * @return
     */
    @RequestMapping("tohaveborrows")
    public String gethaveBorrowList(HttpServletRequest request,Model model,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(defaultValue = "1" ,required = false) Integer pageNumber){
        List<LibBookborrowVO> libBookborrowVOs = libBookborrowService.gethaveBorrowList(pageNumber,name,10);
        Integer count = libBookborrowService.gethaveBorrowCount(name);
        PageBean<LibBookborrowVO> libReaderVOPageBean = new PageBean<>();
        libReaderVOPageBean.setPageElements(libBookborrowVOs);
        libReaderVOPageBean.setPagesize(10);
        libReaderVOPageBean.setPage(pageNumber);
        libReaderVOPageBean.setTotalNum(count);
        libReaderVOPageBean.setTotalPage();
        model.addAttribute("pagebean",libReaderVOPageBean);
        model.addAttribute("name",name);
        return "borrow_list";
    }

    /**
     * 续借
     * @param request
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("keeplong")
    @ResponseBody
    public String keepLong(HttpServletRequest request,Model model ,Integer id){
        String data=null;
        LibBookborrow libBookborrow = libBookborrowService.get(id + "");
        if(libBookborrow!=null){
            Integer bookId = libBookborrow.getBookId();
            LibBookinfo libBookinfo = libBookinfoService.get(bookId + "");
            Integer typeid = libBookinfo.getTypeid();
            LibBooktype libBooktype = libBooktypeService.get(typeid + "");
            Date stipulateTime = libBookborrow.getStipulateTime();
            Calendar instance = Calendar.getInstance();
            instance.setTime(stipulateTime);
            instance.add(Calendar.DAY_OF_MONTH, libBooktype.getDays());
            Date time = instance.getTime();
            libBookborrow.setStipulateTime(time);
            int update = libBookborrowService.update(libBookborrow, id + "");
            if(update>0){
                data="1";

            }else{
                data="2";
            }
        }else{
            data="2";
        }
        return data;
    }

    @RequestMapping("returnbook")
    @ResponseBody
    public String returnBook(HttpServletRequest request, Model model,String id){
        String data=null;
        LibBookborrow libBookborrow = libBookborrowService.get(id + "");
        if(libBookborrow !=null){
            libBookborrow.setStatus(1);
            libBookborrow.setBackTime(new Date());
            int update = libBookborrowService.update(libBookborrow, id + "");
            if(update>0){
                Integer bookId = libBookborrow.getBookId();
                LibBookinfo libBookinfo = libBookinfoService.get(bookId + "");
                Integer leftnum = libBookinfo.getLeftnum()+1;
                libBookinfo.setLeftnum(leftnum);
                int update1 = libBookinfoService.update(libBookinfo, bookId + "");
                if(update1>0){
                    data="1";
                }

            }else{
                data="2";
            }
        }else{
            data="2";
        }
        return data;
    }


}
