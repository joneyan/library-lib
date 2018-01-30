package com.lib.service.impl;

import com.lib.base.AbstractBO;
import com.lib.base.DAO;
import com.lib.dao.LibBookinfoDAO;
import com.lib.model.LibBookinfo;
import com.lib.model.vo.LibBookinfoVO;
import com.lib.service.LibBookinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("libBookinfoBO")
public class LibBookinfoServiceImpl extends AbstractBO<LibBookinfo, LibBookinfoVO, String> implements LibBookinfoService {
private static final Logger LOGGER  =  LoggerFactory.getLogger(LibBookinfoServiceImpl.class);
@Autowired
private LibBookinfoDAO libBookinfoDAO;
@Override
protected DAO<LibBookinfo, LibBookinfoVO, String> getDAO() {
return libBookinfoDAO;
}
}
