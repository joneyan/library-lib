package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibBooktypeDAO;
import com.lib.model.LibBooktype;
import com.lib.model.vo.LibBooktypeVO;
import com.lib.service.LibBooktypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("libBooktypeBO")
public class LibBooktypeServiceImpl extends AbstractBO<LibBooktype, LibBooktypeVO, String> implements LibBooktypeService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibBooktypeServiceImpl.class);
@Autowired
private LibBooktypeDAO libBooktypeDAO;
@Override
protected DAO<LibBooktype, LibBooktypeVO, String> getDAO() {
return libBooktypeDAO;
}

    @Override
    public List<LibBooktypeVO> getPeopleNumList() {
        return libBooktypeDAO.getPeopleNumList();
    }
}
