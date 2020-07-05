package com.yang.blog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 2020/6/28
 *
 * @author yangyang
 */
@Entity
@Table(name = "tb_article_content")
@Component
public class ArticleContent implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "content", length = 255)
    private String content;

    @Column(name = "article_id", length = 64)
    private String articleId;

    /**
     * 添加时间
     * */
    @CreatedDate
    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    private Date createTime;

    /**
     * 修改时间
     * */
    @LastModifiedDate
    @Column(name = "update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    private Date updateTime;

    @OneToOne(targetEntity = ArticleInfo.class)
    @JoinColumn(name = "id", referencedColumnName = "article_id")
    private ArticleInfo articleInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
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

    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }

    @Override
    public String toString() {
        return "ArticleContent{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", articleId='" + articleId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", articleInfo=" + articleInfo +
                '}';
    }
}
