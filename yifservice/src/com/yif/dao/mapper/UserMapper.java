package com.yif.dao.mapper;

import com.yif.bean.User;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_user
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_user
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_user
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_user
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_user
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_user
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int updateByPrimaryKey(User record);
}