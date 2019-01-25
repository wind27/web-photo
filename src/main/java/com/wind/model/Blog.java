package com.wind.model;

import java.io.Serializable;

import java.util.Date;

/**
* blog信息表
*/
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 
    */
    private Long id;
    /**
    * 标签：多个之间用,隔开
    */
    private String tags;
    /**
    * 文章来源：1、阿里云
    */
    private Integer source;
    /**
    * ??
    */
    private String title;
    /**
    * 内容
    */
    private String content;
    /**
    * 摘要
    */
    private String summary;
    /**
    * 用户id：0、表示网上爬取
    */
    private Long uid;
    /**
    * 状态：1、编辑,2 发布, 3 删除
    */
    private Integer status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 发布时间
    */
    private Date publishTime;


    public Long getId () {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTags () {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    public Integer getSource () {
        return this.source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
    public String getTitle () {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent () {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getSummary () {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public Long getUid () {
        return this.uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Integer getStatus () {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getCreateTime () {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime () {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getPublishTime () {
        return this.publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public void copy(Blog blog) {
        this.id = blog.id;
        this.tags = blog.tags;
        this.source = blog.source;
        this.title = blog.title;
        this.content = blog.content;
        this.summary = blog.summary;
        this.uid = blog.uid;
        this.status = blog.status;
        this.createTime = blog.createTime;
        this.updateTime = blog.updateTime;
        this.publishTime = blog.publishTime;
    }

}