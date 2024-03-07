package controller;

import common.ActionForward;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MyInterface;
import model.MyInterfaceImpl;

import java.io.IOException;


@WebServlet(name = "MyController", value = "*.do")
public class MyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        /* 어떤 요청인지 확인 (URLMapping 확인) */
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String urlMapping = requestURI.substring(requestURI.indexOf(contextPath) + contextPath.length());

        /* MyInterface 타임의 MyInterfaceImpl 객체 생성 */
        //pakage가 다르므로 Import 해야한다
        MyInterface myInterface = new MyInterfaceImpl();

        ActionForward actionForward = null;

        /* 메소드 호출 결과 (view 경로)를 저장할 변수 */
        String path = null;

        /* 요청에 따른 메소드 호출 */
        switch (urlMapping) {
            case "/getDate.do":
                actionForward = myInterface.getDate(request);
                System.out.println(request.getAttribute("date"));
                break;
            case "/getTime.do":
                actionForward = myInterface.getTime(request);
                System.out.println(request.getAttribute("time"));
                break;
            case "/getDateTime.do":
                actionForward = myInterface.getDateTime(request);
                System.out.println(request.getAttribute("datetime"));
                break;
        }
        /* 어디로 어떻게 이동할 것인지 결정 */
        if (actionForward != null) {
            if (actionForward.isRedirect()) {
                response.sendRedirect(actionForward.getView());
            } else {
                request.getRequestDispatcher(actionForward.getView()).forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
