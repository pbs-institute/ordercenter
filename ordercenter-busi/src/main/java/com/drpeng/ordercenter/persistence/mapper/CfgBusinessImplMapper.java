package com.drpeng.ordercenter.persistence.mapper;

import com.drpeng.ordercenter.persistence.entity.CfgBusinessImpl;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessImplExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface CfgBusinessImplMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    int countByExample(CfgBusinessImplExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    int deleteByExample(CfgBusinessImplExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer businessImplId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    int insert(CfgBusinessImpl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    int insertSelective(CfgBusinessImpl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    List<CfgBusinessImpl> selectByExampleWithRowbounds(CfgBusinessImplExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    List<CfgBusinessImpl> selectByExample(CfgBusinessImplExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    CfgBusinessImpl selectByPrimaryKey(Integer businessImplId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CfgBusinessImpl record, @Param("example") CfgBusinessImplExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CfgBusinessImpl record, @Param("example") CfgBusinessImplExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CfgBusinessImpl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cfg_business_impl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CfgBusinessImpl record);
}