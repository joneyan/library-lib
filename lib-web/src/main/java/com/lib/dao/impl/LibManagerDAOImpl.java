package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibManagerDAO;
import com.lib.model.LibManager;
import com.lib.model.vo.LibManagerVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libManagerDao")
public class LibManagerDAOImpl extends AbstractDAO<LibManager, LibManagerVO, String> implements LibManagerDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libManagerDao";
}
}
