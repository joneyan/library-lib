package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibBookinfoDAO;
import com.lib.model.LibBookinfo;
import com.lib.model.vo.LibBookinfoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libBookinfoDao")
public class LibBookinfoDAOImpl extends AbstractDAO<LibBookinfo, LibBookinfoVO, String> implements LibBookinfoDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libBookinfoDao";
}
}
