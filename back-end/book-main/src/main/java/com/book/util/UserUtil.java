package com.book.util;

import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 夏日云泊镇 on 2019/7/9
 **/
@Component
public class UserUtil {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService service;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    public String getAuthenticatedUsername(HttpServletRequest request) {
        String authHeader = request.getHeader(tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            String authToken = authHeader.substring(tokenHead.length());// The part after "Bearer "
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            return username;
        } else {
            return null;
        }
    }

    public Long getAuthenticatedUserId(HttpServletRequest request) {
        String authHeader = request.getHeader(tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            String authToken = authHeader.substring(tokenHead.length());// The part after "Bearer "
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            return service.getUserByUsername(username).getId();
        } else {
            return null;
        }
    }
}
