package ge.tsu.sosweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import lombok.SneakyThrows;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

class TestLoginServlet {

    @SneakyThrows
    @Test
    void TestDoPost() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);
        LoginServlet loginServlet = spy(new LoginServlet());

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);
        doNothing().when(loginServlet).doGet(request,response);


        when(request.getParameter("userid")).thenReturn("111111111");
        when(request.getParameter("password")).thenReturn("11111111");


//      when id and password is correct
//-----------------------------------------------------
//
//        loginServlet.doPost(request,response);
//        verify(request).getSession();


//      when id and password is incorrect
//---------------------------------------------------------------------

        Map<String, String> errorMessages = spy(new HashMap<>());
        loginServlet.setErrorMessages(errorMessages);
        loginServlet.doPost(request,response);

        verify(errorMessages).put("general", "User ID or password is incorrect");
        verify(request).setAttribute("errorMessages", errorMessages);
        verify(loginServlet).doGet(request,response);

//----------------------------------------------------------------------
    }
}