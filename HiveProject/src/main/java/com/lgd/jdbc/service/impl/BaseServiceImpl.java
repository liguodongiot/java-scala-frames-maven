package com.lgd.jdbc.service.impl;

import com.lgd.jdbc.dao.BaseDao;
import com.lgd.jdbc.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liguodong on 2016/9/26.
 */

@Service("baseService")
public class BaseServiceImpl implements BaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public boolean checkTableResult() {
        LOGGER.info("BaseService");
        return baseDao.selectTableCount()>0;
    }


}
