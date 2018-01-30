package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibBookcaseDAO;
import com.lib.model.LibBookcase;
import com.lib.model.vo.LibBookcaseVO;
import com.lib.service.LibBookcaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("libBookcaseBO")
public class LibBookcaseServiceImpl extends AbstractBO<LibBookcase, LibBookcaseVO, String> implements LibBookcaseService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibBookcaseServiceImpl.class);
@Autowired
private LibBookcaseDAO libBookcaseDAO;
@Override
protected DAO<LibBookcase, LibBookcaseVO, String> getDAO() {
return libBookcaseDAO;
}
}
