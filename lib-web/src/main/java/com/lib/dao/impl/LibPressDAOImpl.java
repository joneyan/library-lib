package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibPressDAO;
import com.lib.model.LibPress;
import com.lib.model.vo.LibPressVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libPressDao")
public class LibPressDAOImpl extends AbstractDAO<LibPress, LibPressVO, String> implements LibPressDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libPressDao";
}
}
