package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibReadertypeDAO;
import com.lib.model.LibReadertype;
import com.lib.model.vo.LibReadertypeVO;
import com.lib.service.LibReadertypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("libReadertypeBO")
public class LibReadertypeServiceImpl extends AbstractBO<LibReadertype, LibReadertypeVO, String> implements LibReadertypeService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibReadertypeServiceImpl.class);
@Autowired
private LibReadertypeDAO libReadertypeDAO;
@Override
protected DAO<LibReadertype, LibReadertypeVO, String> getDAO() {
return libReadertypeDAO;
}

    @Override
    public List<LibReadertypeVO> getPeopleNumList() {
        return libReadertypeDAO.getPeopleNumList();
    }
}
