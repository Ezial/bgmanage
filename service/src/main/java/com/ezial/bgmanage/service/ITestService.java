package com.ezial.bgmanage.service;

import com.ezial.bgmanage.common.model.TestTable;

/**
 * Created by Ezial on 2017/12/27.
 */
public interface ITestService {
    public TestTable findById(Long id);

    public String testSpringContextHold();
}
