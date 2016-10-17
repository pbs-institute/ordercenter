package com.drpeng.ordercenter.persistence.mapper;

import com.drpeng.ordercenter.persistence.entity.OrdOrder;
import com.drpeng.ordercenter.persistence.entity.OrdOrderExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface OrdOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    int countByExample(OrdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    int deleteByExample(OrdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    int insert(OrdOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    int insertSelective(OrdOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    List<OrdOrder> selectByExampleWithRowbounds(OrdOrderExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    List<OrdOrder> selectByExample(OrdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    OrdOrder selectByPrimaryKey(Long orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OrdOrder record, @Param("example") OrdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OrdOrder record, @Param("example") OrdOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrdOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ord_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrdOrder record);
}