package com.lib.dao;

import com.lib.base.DAO;
import com.lib.model.LibReadertype;
import com.lib.model.vo.LibReadertypeVO;

import java.util.List;

public interface LibReadertypeDAO extends DAO<LibReadertype, LibReadertypeVO, String>{
    List<LibReadertypeVO> getPeopleNumList();
}
