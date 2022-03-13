package ge.tsu.sosweb.servlet;

import ge.tsu.sosweb.model.User;
import ge.tsu.sosweb.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    @Setter
    private Map<String, String> errorMessages = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Login Page");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        errorMessages.clear();
        Integer userId;
        try {
            userId = Integer.parseInt(req.getParameter("userid"));
        } catch (NumberFormatException e) {
            userId = null;
        }
        String password = req.getParameter("password");

        // Validate fields
        if (userId == null) {
            log.info("log in userId is null");
            errorMessages.put("userId", "User ID must not be empty");
        }
        if (password == null || password.isBlank()) {
            log.info("registration password is null or is blank");
            errorMessages.put("password", "Password must not be empty");
        }
        if (!errorMessages.isEmpty()) {
            req.setAttribute("errorMessages", errorMessages);
            doGet(req, resp);
            return;
        }

        User user = UserRepository.searchById(userId);
        if (user == null) {
            log.info("user with {} Id does not exists", userId );
            errorMessages.put("general", "User ID or password is incorrect");
            req.setAttribute("errorMessages", errorMessages);
            doGet(req, resp);
            return;
        }



        // Login user
        HttpSession session = null;
        if (user.getPassword().equals(password)) {
            session = req.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getName());
            log.info("user with Id '{}' successfully logged in", userId);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }else {
            log.info("User ID or password is incorrect");
            errorMessages.put("general", "User ID or password is incorrect");
            req.setAttribute("errorMessages", errorMessages);
            doGet(req, resp);
            return;
        }
    }
}
