package com.yif.dao.mapper;

import com.yif.bean.Userinfo;

public interface UserinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_userinfo
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_userinfo
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int insert(Userinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_userinfo
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int insertSelective(Userinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_userinfo
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    Userinfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_userinfo
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int updateByPrimaryKeySelective(Userinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_userinfo
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int updateByPrimaryKey(Userinfo record);
}