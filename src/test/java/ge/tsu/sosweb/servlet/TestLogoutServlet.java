package ge.tsu.sosweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class TestLogoutServlet {
    @SneakyThrows
    @Test
    void testDoGet() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(false)).thenReturn(session);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);

        new LogoutServlet().doGet(request,response);

        verify(session).invalidate();
    }
}