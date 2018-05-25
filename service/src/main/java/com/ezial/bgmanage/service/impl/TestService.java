package com.ezial.bgmanage.service.impl;

import com.ezial.bgmanage.common.model.TestTable;
import com.ezial.bgmanage.dao.mapper.TestTableMapper;
import com.ezial.bgmanage.service.ITestService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Ezial on 2017/12/27.
 */
@Service
public class TestService implements ITestService{
    @Resource
    private TestTableMapper testTableMapper;


    @Override
    public TestTable findById(Long id) {
        return testTableMapper.findById(id);
    }

    @Override
    public String testSpringContextHold() {
        return "Hello World!";
    }

    //@Scheduled(cron = "*/3 * * * * ?")
    private void test(){
        System.out.println("hello world!");
    }
}
