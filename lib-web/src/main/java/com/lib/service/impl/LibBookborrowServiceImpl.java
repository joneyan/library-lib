package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibBookborrowDAO;
import com.lib.dao.LibBookinfoDAO;
import com.lib.model.*;
import com.lib.model.vo.LibBookborrowVO;
import com.lib.model.vo.LibBookinfoVO;
import com.lib.model.vo.LibReaderVO;
import com.lib.service.LibBookborrowService;
import com.lib.service.LibBooktypeService;
import com.lib.service.LibReaderService;
import com.lib.service.LibReadertypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("libBookborrowBO")
public class LibBookborrowServiceImpl extends AbstractBO<LibBookborrow, LibBookborrowVO, String> implements LibBookborrowService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibBookborrowServiceImpl.class);
@Autowired
private LibBookborrowDAO libBookborrowDAO;
    @Autowired
    private LibBookinfoDAO libBookinfoDAO;
    @Autowired
    private LibReaderService libReaderService;
    @Autowired
    private LibReadertypeService libReadertypeService;

    @Autowired
    private LibBooktypeService booktypeService;

@Override
protected DAO<LibBookborrow, LibBookborrowVO, String> getDAO() {
return libBookborrowDAO;
}

    @Override
    @Transactional
    public void borrowBook(LibReaderVO libReaderVO, String bookid ,Integer readerid, LibManager loginfo) {
        LibBookborrow libBookborrow = new LibBookborrow();
        dealBookBorrowEntity(readerid,bookid,libBookborrow,loginfo);
        libBookborrowDAO.insert(libBookborrow);
        LibBookinfoVO libBookinfoVO = new LibBookinfoVO();
        libBookinfoVO.setId(Integer.parseInt(bookid));
        LibBookinfo libBookinfo = libBookinfoDAO.get(bookid);
        Integer leftnum = libBookinfo.getLeftnum()-1;
        libBookinfo.setLeftnum(leftnum);
        int update = libBookinfoDAO.update(libBookinfo, libBookinfoVO);
    }

    @Override
    public List<LibBookborrowVO> gethaveBorrowList(Integer pageNumber, String name, int i) {
        return libBookborrowDAO.gethaveBorrowList(pageNumber,name,i);
    }

    @Override
    public Integer gethaveBorrowCount(String name) {
        return libBookborrowDAO.gethaveBorrowCount(name);
    }

    @Override
    public List<Integer> getEveryMothBorrow() {
        List<Integer> monthlist= new ArrayList<>();
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int year = instance.get(Calendar.YEAR);

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        for(Integer month=0;month<12;month++){
            start.set(year,month,1);
            end.set(year,month+1,1);
            Integer count = libBookborrowDAO.getEveryMothBorrow(start.getTime(),end.getTime());
            monthlist.add(count);
        }
        return monthlist;
    }

    @Override
    public List<LibBookborrowVO> getBorrowListTopFive() {
        return libBookborrowDAO.getBorrowListTopFive();
    }

    @Override
    public List<LibBookinfoVO> getNewFiveTop() {
        return libBookinfoDAO.getNewFiveTop();
    }

    private void dealBookBorrowEntity(Integer readerid, String bookid, LibBookborrow libBookborrow, LibManager loginfo) {

        libBookborrow.setBorrowTime(new Date());
        libBookborrow.setBookId(Integer.parseInt(bookid));
        libBookborrow.setReaderId(readerid);
        libBookborrow.setStatus(2);
        libBookborrow.setOperator(loginfo.getId());
        LibBookinfo libBookinfo = libBookinfoDAO.get(bookid);
        LibBooktype libBooktype = booktypeService.get(libBookinfo.getTypeid()+"");
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.DAY_OF_MONTH,libBooktype.getDays());
        libBookborrow.setStipulateTime(instance.getTime());
    }
}
