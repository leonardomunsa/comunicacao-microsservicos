package br.com.cursoudemy.productapi.config.interceptor;

import br.com.cursoudemy.productapi.modules.jwt.service.JwtService;
import feign.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (isOptions(request)) {
            return true;
        }
        var authorization = request.getHeader("Authorization");
        jwtService.validateAuthorization(authorization);
        return true;
    }

    private boolean isOptions(HttpServletRequest request) {
        return HttpMethod.OPTIONS.name().equals(request.getMethod());
    }
}
