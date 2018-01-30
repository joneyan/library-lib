package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibLibraryDAO;
import com.lib.model.LibLibrary;
import com.lib.model.vo.LibLibraryVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libLibraryDao")
public class LibLibraryDAOImpl extends AbstractDAO<LibLibrary, LibLibraryVO, String> implements LibLibraryDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libLibraryDao";
}
}
