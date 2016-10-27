package com.drpeng.ordercenter.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by huangxiaomao on 10/26/2016.
 */

@Mapper
public interface SequenceMapper {

    @Insert("replace into seq_ord_number(stub) values('a')")
    public int replaceOrdNumber();

    @Select("select last_insert_id()")
    public long getLastInsertId();
}
