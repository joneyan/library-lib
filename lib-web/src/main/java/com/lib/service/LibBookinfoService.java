package com.lib.service;

import com.lib.base.BO;
import com.lib.model.LibBookinfo;
import com.lib.model.vo.LibBookinfoVO;

import java.util.List;

public interface LibBookinfoService extends BO<LibBookinfo, LibBookinfoVO, String>{
    List<LibBookinfoVO> getBookList(LibBookinfoVO libBookinfoVO, Integer pagesize, Integer page, String startTime, String endTime);

    Integer getBookListTotal(LibBookinfoVO libBookinfoVO, String startTime, String endTime);
}
