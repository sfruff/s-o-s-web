package ge.tsu.sosweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.SneakyThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

class TestRegistrationServlet {

    @SneakyThrows
    @Test
    void TestDoPost() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        RegistrationServlet registrationServlet = spy(new RegistrationServlet());
        int insertedRows = 0;

        when(request.getRequestDispatcher("/registration.jsp")).thenReturn(dispatcher);
        when(request.getRequestDispatcher("/login.jsp")).thenReturn(dispatcher);


        when(request.getParameter("username")).thenReturn("1");
        when(request.getParameter("userid")).thenReturn("1");
        when(request.getParameter("password")).thenReturn("1");


//      when the user doesn't exists yet
//-----------------------------------------------------
//        registrationServlet.setInsertedRows(insertedRows);
//        registrationServlet.doPost(request,response);
//        Assertions.assertEquals(1, registrationServlet.getInsertedRows());


//      when the user already exists
//---------------------------------------------------------------------

        Map<String, String> errorMessages = spy(new HashMap<>());
        registrationServlet.setErrorMessages(errorMessages);
        registrationServlet.doPost(request,response);

        verify(errorMessages).put("general", "User with that user ID already exist");
        verify(request).setAttribute("errorMessages", errorMessages);
        verify(registrationServlet).doPost(request,response);

//----------------------------------------------------------------------
    }
}