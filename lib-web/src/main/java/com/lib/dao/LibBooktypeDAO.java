package com.lib.dao;

import com.lib.base.DAO;
import com.lib.model.LibBooktype;
import com.lib.model.vo.LibBooktypeVO;

import java.util.List;

public interface LibBooktypeDAO extends DAO<LibBooktype, LibBooktypeVO, String>{
    List<LibBooktypeVO> getPeopleNumList();
}
