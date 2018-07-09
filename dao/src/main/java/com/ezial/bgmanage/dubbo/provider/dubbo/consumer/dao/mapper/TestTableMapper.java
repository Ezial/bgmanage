package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.dao.mapper;


import com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.model.TestTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Ezial on 2017/12/26.
 */
@Mapper
public interface TestTableMapper {

    @Select("SELECT id,name from test_table WHERE id = #{id}")
    TestTable findById(@Param("id") Long id);
}

