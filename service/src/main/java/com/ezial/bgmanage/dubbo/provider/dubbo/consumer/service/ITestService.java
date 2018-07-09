package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.service;


import com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.model.TestTable;

/**
 * Created by Ezial on 2017/12/27.
 */
public interface ITestService {
    public TestTable findById(Long id);

    public String testSpringContextHold();
}
