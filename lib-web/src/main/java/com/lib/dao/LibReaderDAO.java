package com.lib.dao;

import com.lib.base.DAO;
import com.lib.model.LibReader;
import com.lib.model.vo.LibReaderVO;

import java.util.Date;
import java.util.List;

public interface LibReaderDAO extends DAO<LibReader, LibReaderVO, String>{
    /**
     * 查询读者列表
     * @param libReaderVO
     * @param pagesize
     * @param page
     * @return
     */
    List<LibReaderVO> findBannerReader(LibReaderVO libReaderVO, Integer pagesize, Integer page,String startTime,String endTime);

    int countCutoms(LibReaderVO libReaderVO,String startTime,String endTime);

    Integer countRecentReader(Date time);
}
