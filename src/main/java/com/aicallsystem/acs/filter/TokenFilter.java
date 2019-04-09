package com.aicallsystem.acs.filter;

import com.aicallsystem.acs.entity.AcsAccountInfo;
import com.aicallsystem.acs.entity.AcsTokenInfo;
import com.aicallsystem.acs.service.IAcsTokenInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenFilter implements Filter {

    @Autowired
    private IAcsTokenInfoService iAcsTokenInfoService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String token = String.valueOf(req.getHeader("token"));
        AcsTokenInfo acsTokenInfo = new AcsTokenInfo(token);
        AcsAccountInfo accountInfo = iAcsTokenInfoService.verifyToken(acsTokenInfo);

        if(accountInfo==null || "".equals(accountInfo.getUserUuid())){
            request.getRequestDispatcher("/sys/tokenError").forward(req, resp);
            return;
        }

        req.setAttribute("userUuid",accountInfo.getUserUuid());
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
