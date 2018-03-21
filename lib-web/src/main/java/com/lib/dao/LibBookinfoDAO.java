package com.lib.dao;

import com.lib.base.DAO;
import com.lib.model.LibBookinfo;
import com.lib.model.vo.LibBookinfoVO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface LibBookinfoDAO extends DAO<LibBookinfo, LibBookinfoVO, String>{
    List<LibBookinfoVO> getBookList(LibBookinfoVO libBookinfoVO, Integer pagesize, Integer page, String startTime, String endTime);

    Integer getBookListTotal(LibBookinfoVO libBookinfoVO, String startTime, String endTime);

    Integer countRecentBook(Date date);


    Integer getEveryMothBorrow(Date start, Date end);
}
