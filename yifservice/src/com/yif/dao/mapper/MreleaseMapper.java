package com.yif.dao.mapper;

import com.yif.bean.Mrelease;

public interface MreleaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_release_info
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_release_info
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int insert(Mrelease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_release_info
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int insertSelective(Mrelease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_release_info
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    Mrelease selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_release_info
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int updateByPrimaryKeySelective(Mrelease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_release_info
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    int updateByPrimaryKey(Mrelease record);
}