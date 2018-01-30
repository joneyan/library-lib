package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibManagerDAO;
import com.lib.model.LibManager;
import com.lib.model.vo.LibManagerVO;
import com.lib.service.LibManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("libManagerBO")
public class LibManagerServiceImpl extends AbstractBO<LibManager, LibManagerVO, String> implements LibManagerService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibManagerServiceImpl.class);
@Autowired
private LibManagerDAO libManagerDAO;
@Override
protected DAO<LibManager, LibManagerVO, String> getDAO() {
return libManagerDAO;
}
}
