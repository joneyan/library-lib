package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibPressDAO;
import com.lib.model.LibPress;
import com.lib.model.vo.LibPressVO;
import com.lib.service.LibPressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("libPressBO")
public class LibPressServiceImpl extends AbstractBO<LibPress, LibPressVO, String> implements LibPressService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibPressServiceImpl.class);
@Autowired
private LibPressDAO libPressDAO;
@Override
protected DAO<LibPress, LibPressVO, String> getDAO() {
return libPressDAO;
}
}
