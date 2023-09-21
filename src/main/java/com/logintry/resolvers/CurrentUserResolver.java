package com.logintry.resolvers;

import com.logintry.annotations.CurrentUser;
import com.logintry.services.UserService;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public record CurrentUserResolver(UserService userService) implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(CurrentUser.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        CurrentUser attr = parameter.getParameterAnnotation(CurrentUser.class);
        assert attr != null;
        Jwt jwtIns = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.loadUserByUsername(jwtIns.getSubject());
    }
}
