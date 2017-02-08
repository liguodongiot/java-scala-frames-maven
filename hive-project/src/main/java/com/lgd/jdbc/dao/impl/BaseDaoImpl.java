package com.lgd.jdbc.dao.impl;

import com.lgd.jdbc.dao.BaseDao;
import com.lgd.jdbc.mapper.hive.BaseMapper;
import com.lgd.jdbc.mapper.mysql.StudentInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by liguodong on 2016/9/26.
 */


@Repository("baseDao")
public class BaseDaoImpl implements BaseDao,Serializable{

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDaoImpl.class);

    @Autowired
    BaseMapper baseMapper;

    @Autowired
    StudentInfoMapper studentInfoMapper;


    public int selectTableCount() {
        LOGGER.info("BaseDao");
        //return studentInfoMapper.selectTableCount();
        return baseMapper.selectTableCount();

    }




}
