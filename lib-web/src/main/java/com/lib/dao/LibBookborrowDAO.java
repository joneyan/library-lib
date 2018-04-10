package com.lib.dao;

import com.lib.base.DAO;
import com.lib.model.LibBookborrow;
import com.lib.model.vo.LibBookborrowVO;

import java.util.Date;
import java.util.List;

public interface LibBookborrowDAO extends DAO<LibBookborrow, LibBookborrowVO, String>{
    List<LibBookborrowVO> gethaveBorrowList(Integer pageNumber, String name, int i);

    Integer gethaveBorrowCount(String name);

    List<LibBookborrowVO> getBorrowListTopFive();

    Integer getEveryMothBorrow(Date time, Date time1);
}
