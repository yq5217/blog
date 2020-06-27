package com.yang.blog.security.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 2020/6/27
 *
 * @author yangyang
 */

/**
 * @TODO 对访问路径的权限进行判断 待完成
 * */
@Component("rbacauthorityservice")
public class RbacAuthority {


    /**
     * 判断是否有权限
     *
     * @param request
     * @param authentication
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Collection<ConfigAttribute> collection = getAttributes(request);
        if (authentication.getPrincipal().equals("")) {
            return false;
        }

        if (null == collection || collection.size() <= 0) {
            return false;
        }

        ConfigAttribute configAttribute;
        String needRole;
        for (Iterator<ConfigAttribute> iterator = collection.iterator(); iterator.hasNext(); ) {
            configAttribute = iterator.next();
            needRole = configAttribute.getAttribute();
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needRole.trim().equals(grantedAuthority.getAuthority())) {
                    return true;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    /**
     * 判定用户请求的url是否在权限表中，如果在权限表中，则返回decide方法，
     * 用来判定用户是否有权限，如果不在权限表中则放行
     *
     * @param request
     * @return
     * @throws IllegalArgumentException
     */
    public Collection<ConfigAttribute> getAttributes(HttpServletRequest request) throws IllegalArgumentException {
        HashMap<String, Collection<ConfigAttribute>> map = null;
        if (map == null) {
            map = loadResourceDefine(map);
        }
        for (Map.Entry<String, Collection<ConfigAttribute>> entry : map.entrySet()) {
            String url = entry.getKey();
            if (new AntPathRequestMatcher(url).matches(request)) {
                return map.get(url);
            }
        }
        return null;
    }

    /**
     * 加载权限表中所有权限
     */
    private HashMap<String, Collection<ConfigAttribute>> loadResourceDefine(HashMap<String, Collection<ConfigAttribute>> map) {
        map = new HashMap<>();
       /* List<Menu> all = menuService.findAllMenu();
        for (Menu menu : all) {
            List<ConfigAttribute> configAttributeList = menu.getRoles().stream().map(name -> {
                ConfigAttribute configAttribute = new SecurityConfig(name.getName());
                return configAttribute;
            }).collect(Collectors.toList());
            map.put(menu.getUrl(), configAttributeList);
        }
        //menu.map = map;*/
        return map;
    }

}
