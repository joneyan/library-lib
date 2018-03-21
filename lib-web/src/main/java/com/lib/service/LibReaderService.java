package com.lib.service;


import com.lib.base.BO;
import com.lib.model.LibReader;
import com.lib.model.vo.LibReaderVO;

import java.util.List;

public interface LibReaderService extends BO<LibReader, LibReaderVO, String> {
    /**
     * 分页查询读者名单
     * @param libReaderVO
     * @param pagesize
     * @param page
     * @return
     */
    List<LibReaderVO> findBannerReader(LibReaderVO libReaderVO, Integer pagesize, Integer page,String startTime,String endTime);

    /**
     * 根据条件统计总数
     * @param libReaderVO
     * @return
     */
    int countCutoms(LibReaderVO libReaderVO,String startTime,String endTime);

    Integer countRecentReader();
}
