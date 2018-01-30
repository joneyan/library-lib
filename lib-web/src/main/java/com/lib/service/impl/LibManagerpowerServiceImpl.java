package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibManagerpowerDAO;
import com.lib.model.LibManagerpower;
import com.lib.model.vo.LibManagerpowerVO;
import com.lib.service.LibManagerpowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("libManagerpowerBO")
public class LibManagerpowerServiceImpl extends AbstractBO<LibManagerpower, LibManagerpowerVO, String> implements LibManagerpowerService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibManagerpowerServiceImpl.class);
@Autowired
private LibManagerpowerDAO libManagerpowerDAO;
@Override
protected DAO<LibManagerpower, LibManagerpowerVO, String> getDAO() {
return libManagerpowerDAO;
}
}
