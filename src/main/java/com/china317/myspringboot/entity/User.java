package com.china317.myspringboot.entity;

import java.util.Date;

/**
 * Created by lx-dong on 2017/11/1.
 */
public class User {
    private String accessToken;// varchar(255) DEFAULT NULL COMMENT app端'Token，用于记住密码',
    private Date accessTokenExpireTime;// datetime DEFAULT NULL COMMENT app端'Token失效时间',
    private String account;// varchar(255) DEFAULT NULL COMMENT '账号-登录名',
    private String name;// varchar(255) DEFAULT NULL COMMENT '姓名',
    private String password;// varchar(255) DEFAULT NULL COMMENT '密码',
    private String salt;// varchar(255) DEFAULT NULL,
    private String telephone;// varchar(50) DEFAULT NULL COMMENT '手机号码',
    private Integer sex;// int(1) DEFAULT NULL COMMENT '性别，0：男，1：女',
    private Date createTime;// datetime DEFAULT NULL COMMENT '创建时间',
    private Date updateTime;// datetime DEFAULT NULL,
    private Integer deleteFlag;// int(1) DEFAULT '0' COMMENT '删除位0:未删除，1:已删除。默认为0',

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getAccessTokenExpireTime() {
        return accessTokenExpireTime;
    }

    public void setAccessTokenExpireTime(Date accessTokenExpireTime) {
        this.accessTokenExpireTime = accessTokenExpireTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
