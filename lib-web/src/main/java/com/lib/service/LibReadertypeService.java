package com.lib.service;

import com.lib.base.BO;
import com.lib.model.LibReadertype;
import com.lib.model.vo.LibReadertypeVO;

import java.util.List;

public interface LibReadertypeService extends BO<LibReadertype, LibReadertypeVO, String>{
    List<LibReadertypeVO> getPeopleNumList();
}
