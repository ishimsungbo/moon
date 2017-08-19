package com.moon.sample.impl;

import com.moon.sample.mapper.ComMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ComMapper")
public class ComMapperImp implements ComMapper {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private ComMapper comMapper;

    @Override
    public List<Map<String, Object>> getUserMapList() {
        logger.info("Sql Com service called 1");
        logger.info("저를 call 했습니다...임플리먼트");
        return comMapper.getUserMapList();
    }

}
