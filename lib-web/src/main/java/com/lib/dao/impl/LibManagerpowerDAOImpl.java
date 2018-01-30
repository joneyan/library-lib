package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibManagerpowerDAO;
import com.lib.model.LibManagerpower;
import com.lib.model.vo.LibManagerpowerVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libManagerpowerDao")
public class LibManagerpowerDAOImpl extends AbstractDAO<LibManagerpower, LibManagerpowerVO, String> implements LibManagerpowerDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libManagerpowerDao";
}
}
