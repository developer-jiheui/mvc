package model;

import jakarta.servlet.http.HttpServletRequest;

public class MyInterfaceImpl implements MyInterface{
    @Override
    public String getDate(HttpServletRequest request) {
        return null;
    }

    @Override
    public String getTime(HttpServletRequest request) {
        return null;
    }

    @Override
    public String getDateTime(HttpServletRequest request) {
        return null;
    }
}
