/*
package com.yang.blog.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

*/
/**
 * Created by 2020/6/23
 *
 * @author yangyang
 *//*

@Entity
@Table(name = "sys_role_menu")
public class RoleMenu {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;*/
/**//*


    @Column(name = "role_id", nullable = false, length = 64)
    private String roleId;

    @Column(name = "menu_id", nullable = false, length = 64)
    private String menuId;

    */
/**
     * 添加时间*//*

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    */
/**
     * 修改时间
     *//*

    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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
}
*/
