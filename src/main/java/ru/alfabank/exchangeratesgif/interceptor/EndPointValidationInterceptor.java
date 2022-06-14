package ru.alfabank.exchangeratesgif.interceptor;


import org.hamcrest.Matchers;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class EndPointValidationInterceptor implements HandlerInterceptor {
    private static final String REGEX = "/rates/" + "[A-Z]{3}";
    private final String MESSAGE_BAD_REQUEST = "Введен не верный запрос, пример запроса: rates/RUB";
    private final int STATUS_BAD_REQUEST = 400;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!Matchers.matchesRegex(REGEX).matches(request.getRequestURI())) {
            response.getWriter().write(MESSAGE_BAD_REQUEST);
            response.setStatus(STATUS_BAD_REQUEST);
            return false;
        }
        return true;
    }
}


