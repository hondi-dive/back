package com.example.kakao.global.utils.argumentresolver;

import com.example.kakao.domain.user.User;
import com.example.kakao.domain.user.UserRepository;
import com.example.kakao.domain.user.dto.UserDto;
import com.example.kakao.global.securityV1.cookie.CookieUtil;
import com.example.kakao.global.types.RoleType;
import com.example.kakao.global.utils.HeaderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {
    private final UserRepository userRepository;
    private final CookieUtil cookieUtil;

    @Value("${app.base-url}")
    private String baseUrl;
    private String defaultUserImgUrl = baseUrl + "/imgStorage/" + "defaultUserImg.jpeg";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);
        boolean hasUserType = User.class.isAssignableFrom(parameter.getParameterType());
        return hasLoginAnnotation && true; //hasUserType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
        Cookie cookie = cookieUtil.getCookie(request,"accessToken").orElse(null);
        String userName;
        if (Objects.isNull(cookie))
            userName = "JaeHyuk";
        else
            userName = cookie.getValue();
        System.out.println("COOKIE VALUE : " + cookie.getValue());
        User user = userRepository.findByUserName(cookie.getValue()).orElse(null);
        if (Objects.isNull(user)) {
            User newUser = new User(userName, defaultUserImgUrl, RoleType.USER);
            userRepository.save(newUser);
            return newUser;
        }
        return user;
    }
}
