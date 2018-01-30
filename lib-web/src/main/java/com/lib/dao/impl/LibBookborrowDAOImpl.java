package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibBookborrowDAO;
import com.lib.model.LibBookborrow;
import com.lib.model.vo.LibBookborrowVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libBookborrowDao")
public class LibBookborrowDAOImpl extends AbstractDAO<LibBookborrow, LibBookborrowVO, String> implements LibBookborrowDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libBookborrowDao";
}
}
