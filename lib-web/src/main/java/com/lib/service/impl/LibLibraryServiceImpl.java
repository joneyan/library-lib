package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibLibraryDAO;
import com.lib.model.LibLibrary;
import com.lib.model.vo.LibLibraryVO;
import com.lib.service.LibLibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("libLibraryBO")
public class LibLibraryServiceImpl extends AbstractBO<LibLibrary, LibLibraryVO, String> implements LibLibraryService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibLibraryServiceImpl.class);
@Autowired
private LibLibraryDAO libLibraryDAO;
@Override
protected DAO<LibLibrary, LibLibraryVO, String> getDAO() {
return libLibraryDAO;
}
}
