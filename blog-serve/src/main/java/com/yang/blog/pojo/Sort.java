package com.yang.blog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 2020/7/13
 *
 * @author yangyang
 */
@Entity
@Table(name = "tb_sort")
@Component
public class Sort {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "value", nullable = false, length = 64)
    private String value;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "icon", length = 64)
    private String icon;

    @Column(name = "parent_id", nullable = false, length = 64)
    private String parentId;
    /**
     * 添加时间
     * */
    @CreatedDate
    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    private Date createTime;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private List<Sort> children;

    /**
     * 修改时间
     * */
    @LastModifiedDate
    @Column(name = "update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    @Override
    public String toString() {
        return "Sort{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", parentId='" + parentId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
