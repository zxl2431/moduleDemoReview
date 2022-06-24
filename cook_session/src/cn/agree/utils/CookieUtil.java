package cn.agree.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    /*
    *  创建并配置Cookie
    *  name value
    *  time path
    *
    * */
    public static Cookie createCookie(String name, String value, int time, String path) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(time);
        cookie.setPath(path);
        return cookie;
    }

    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        String value = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    value = cookie.getValue();
                }
            }
        }

        return value;
    }




}
