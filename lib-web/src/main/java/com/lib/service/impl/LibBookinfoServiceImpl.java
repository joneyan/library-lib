package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibBookinfoDAO;
import com.lib.model.LibBookinfo;
import com.lib.model.vo.LibBookinfoVO;
import com.lib.service.LibBookinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("libBookinfoBO")
public class LibBookinfoServiceImpl extends AbstractBO<LibBookinfo, LibBookinfoVO, String> implements LibBookinfoService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibBookinfoServiceImpl.class);
@Autowired
private LibBookinfoDAO libBookinfoDAO;
@Override
protected DAO<LibBookinfo, LibBookinfoVO, String> getDAO() {
return libBookinfoDAO;
}

    @Override
    public List<LibBookinfoVO> getBookList(LibBookinfoVO libBookinfoVO, Integer pagesize, Integer page, String startTime, String endTime) {
        return libBookinfoDAO.getBookList( libBookinfoVO,  pagesize,  page,  startTime,  endTime);
    }

    @Override
    public Integer getBookListTotal(LibBookinfoVO libBookinfoVO, String startTime, String endTime) {
        return libBookinfoDAO.getBookListTotal( libBookinfoVO,  startTime,  endTime);
    }

    @Override
    public Integer countRecentBook(Date date) {
        if(date==null){
            Date date1 = new Date();
            Calendar instance = Calendar.getInstance();
            instance.setTime(date1);
            instance.add(Calendar.DAY_OF_MONTH,-30);
            date = instance.getTime();
        }
        return libBookinfoDAO.countRecentBook(date);
    }

    @Override
    public List<LibBookinfoVO> getNewFiveTop() {
        return libBookinfoDAO.getNewFiveTop();
    }
}
