package com.yang.blog.pojo;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 2020/6/23
 *
 * @author yangyang
 */
@Entity
@Table(name = "sys_menu")
@Component
public class Menu implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "url", nullable = false, length = 64)
    private String url;

    @Column(name = "path", nullable = false, length = 64)
    private String path;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Column(name = "icon", length = 64)
    private String icon;


    @Column(name = "parent_id", length = 64)
    private String parentId;

    @Column(name = "sort", length = 64)
    private String sort;

    /**
     * 添加时间*/
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "state", length = 64)
    private String state;

/*    //菜单相关角色
    @ManyToMany(cascade=CascadeType.REFRESH,mappedBy="menus",fetch = FetchType.LAZY)
    private List<Role> roles;*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

/*    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }*/

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", parentId='" + parentId + '\'' +
                ", sort='" + sort + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", state='" + state + '\'' +
                //", roles=" + roles +
                '}';
    }
}
