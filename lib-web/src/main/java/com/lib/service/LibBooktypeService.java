package com.lib.service;

import com.lib.base.BO;
import com.lib.model.LibBooktype;
import com.lib.model.vo.LibBooktypeVO;

import java.util.List;

public interface LibBooktypeService extends BO<LibBooktype, LibBooktypeVO, String>{
    List<LibBooktypeVO> getPeopleNumList();
}
