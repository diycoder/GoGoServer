package com.yif.bean;

import java.util.Date;

public class User {
    
    private Integer id;

   
    private String accout;

   
    private String password;

   
    private String username;

    
    private String loginIp;

    
    private Date loginTime;

   
    private Integer role;

   
    private String ext1;

   
    private Integer ext2;

   
    private String ext3;

   
    private Date addtime;

    
    private Integer isuse;

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getAccout() {
        return accout;
    }

    
    public void setAccout(String accout) {
        this.accout = accout;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getUsername() {
        return username;
    }

   
    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginIp() {
        return loginIp;
    }

   
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    
    public Date getLoginTime() {
        return loginTime;
    }

    
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

   
    public Integer getRole() {
        return role;
    }

   
    public void setRole(Integer role) {
        this.role = role;
    }

    
    public String getExt1() {
        return ext1;
    }

   
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column y_user.ext2
     *
     * @return the value of y_user.ext2
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    public Integer getExt2() {
        return ext2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column y_user.ext2
     *
     * @param ext2 the value for y_user.ext2
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    public void setExt2(Integer ext2) {
        this.ext2 = ext2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column y_user.ext3
     *
     * @return the value of y_user.ext3
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column y_user.ext3
     *
     * @param ext3 the value for y_user.ext3
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column y_user.addtime
     *
     * @return the value of y_user.addtime
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column y_user.addtime
     *
     * @param addtime the value for y_user.addtime
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column y_user.isuse
     *
     * @return the value of y_user.isuse
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    public Integer getIsuse() {
        return isuse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column y_user.isuse
     *
     * @param isuse the value for y_user.isuse
     *
     * @mbggenerated Sat Apr 16 15:30:57 CST 2016
     */
    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }
}