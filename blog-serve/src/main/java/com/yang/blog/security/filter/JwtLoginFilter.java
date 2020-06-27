package com.yang.blog.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.blog.security.configuration.TokenAuthenticationHelper;
import com.yang.blog.security.pojo.UserDetail;
import com.yang.blog.security.service.JwtUserService;
import com.yang.blog.until.ResJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StreamUtils;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * Created by 2020/6/21
 *
 * @author yangyang
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {


    private JwtUserService jwtUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @param defaultFilterProcessesUrl 配置要过滤的地址，即登陆地址
     * @param authenticationManager 认证管理器，校验身份时会用到
     * @param jwtUserService */
    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager,
                          JwtUserService jwtUserService) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        this.jwtUserService = jwtUserService;
        // 为 AbstractAuthenticationProcessingFilter 中的属性赋值
        setAuthenticationManager(authenticationManager);

    }



    /**
     * 提取用户账号密码进行验证
     * */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        // 判断是否要抛出 登陆请求过快的异常
        //jwtUserService.judgeLoginCount(httpServletRequest);
        // 获取 User 对象
        // readValue 第一个参数 输入流，第二个参数 要转换的对象
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), Charset.forName("UTF-8"));
        UserDetail user = new ObjectMapper().readValue(body, UserDetail.class);
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                username,
                user.getPassword()

        );
        // 添加验证的附加信息
        // 包括验证码信息和是否记住我
        //token.setDetails(new LoginDetails(user.getRememberMe(), user.getVerifyCode()));
        // 进行登陆验证
        return getAuthenticationManager().authenticate(token);
    }

    /**
     * 登陆成功回调
     * */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // 登陆成功
        TokenAuthenticationHelper.addAuthentication(request, response ,authResult);
    }

    /**
     * 登陆失败回调
     * */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException, IOException {
        // 错误请求次数加 1

        // 向前端写入数据
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(ResJson.createByError("登录失败，请重新登录！")));
        out.flush();
        out.close();
    }
}
