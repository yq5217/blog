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
@Table(name = "sys_role")
@Component
public class Role implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "name_zh", length = 64)
    private String nameZh;

    @Column(name = "parent_id", length = 64)
    private String parentId;

    // 角色描述
    @Column(name="role_desc")
    private String roleDesc;

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

    @Column(name = "state", length = 8)
    private Integer state;

    /*@ManyToMany(cascade=CascadeType.REFRESH,mappedBy="roles",fetch = FetchType.LAZY)
    private List<User> users;*/

    //角色相关权限
    @ManyToMany(cascade=CascadeType.REFRESH)
    @JoinTable(name="sys_role_menu",
            inverseJoinColumns=@JoinColumn(name="menu_id"),
            joinColumns=@JoinColumn(name="role_id"))
    private List<Menu> menus;

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

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

   /* public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }*/

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", parentId='" + parentId + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", state=" + state +
                //", users=" + users +
                ", menus=" + menus +
                '}';
    }


}
