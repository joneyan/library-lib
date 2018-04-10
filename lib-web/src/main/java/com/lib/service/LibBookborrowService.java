package com.lib.service;


import com.lib.base.BO;
import com.lib.model.LibBookborrow;
import com.lib.model.LibManager;
import com.lib.model.LibReader;
import com.lib.model.vo.LibBookborrowVO;
import com.lib.model.vo.LibBookinfoVO;
import com.lib.model.vo.LibReaderVO;

import java.util.List;

public interface LibBookborrowService extends BO<LibBookborrow, LibBookborrowVO, String> {
    void borrowBook(LibReaderVO libReaderVO, String bookid, Integer readerid, LibManager loginfo);

    List<LibBookborrowVO> gethaveBorrowList(Integer pageNumber, String name, int i);

    Integer gethaveBorrowCount(String name);

    List<Integer> getEveryMothBorrow();

    List<LibBookborrowVO> getBorrowListTopFive();

    List<LibBookinfoVO> getNewFiveTop();
}
