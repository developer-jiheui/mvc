package model;

import jakarta.servlet.http.HttpServletRequest;

public interface MyInterface {//public abstract 생략 가능
    String getDate(HttpServletRequest request);
    String getTime(HttpServletRequest request);
    String getDateTime(HttpServletRequest request);


}
