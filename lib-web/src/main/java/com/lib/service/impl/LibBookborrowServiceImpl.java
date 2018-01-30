package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibBookborrowDAO;
import com.lib.model.LibBookborrow;
import com.lib.model.vo.LibBookborrowVO;
import com.lib.service.LibBookborrowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("libBookborrowBO")
public class LibBookborrowServiceImpl extends AbstractBO<LibBookborrow, LibBookborrowVO, String> implements LibBookborrowService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibBookborrowServiceImpl.class);
@Autowired
private LibBookborrowDAO libBookborrowDAO;
@Override
protected DAO<LibBookborrow, LibBookborrowVO, String> getDAO() {
return libBookborrowDAO;
}
}
