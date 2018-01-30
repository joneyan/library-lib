package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibReaderDAO;
import com.lib.model.LibReader;
import com.lib.model.vo.LibReaderVO;
import com.lib.service.LibReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("libReaderBO")
public class LibReaderServiceImpl extends AbstractBO<LibReader, LibReaderVO, String> implements LibReaderService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibReaderServiceImpl.class);
@Autowired
private LibReaderDAO libReaderDAO;
@Override
protected DAO<LibReader, LibReaderVO, String> getDAO() {
return libReaderDAO;
}
}