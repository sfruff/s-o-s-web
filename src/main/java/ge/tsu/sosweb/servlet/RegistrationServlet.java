package ge.tsu.sosweb.servlet;

import ge.tsu.sosweb.db.Database;
import ge.tsu.sosweb.model.User;
import ge.tsu.sosweb.repository.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.DbUtils;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@WebServlet(name = "registrationServlet", value = "/registration-servlet" )
public class RegistrationServlet extends HttpServlet {

    private static final String INSERT = "INSERT INTO USERS(id, name, password) VALUES(?, ?, ?)";

    @Setter
    private Map<String, String> errorMessages = new HashMap<>();

    @Setter
    @Getter
    private int insertedRows = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Registration Page");
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        errorMessages.clear();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/registration.jsp");

        String username = req.getParameter("username");
        Integer userId;
        try {
            userId = Integer.parseInt(req.getParameter("userid"));
        } catch (NumberFormatException e) {
            userId = null;
        }
        String password = req.getParameter("password");


        // Validate fields
        if (username == null || username.isBlank()) {
            log.info("registration username is null or is blank");
            errorMessages.put("username", "Username must not be empty");
        }
        if (userId == null) {

            log.info("registration userId is null");
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
        if (user != null) {
            log.info("user with {} Id already exists", userId );
            errorMessages.put("general", "User with that user ID already exist");
            req.setAttribute("errorMessages", errorMessages);
            doGet(req, resp);
            return;
        }

        Connection connection = Database.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT);) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            insertedRows = preparedStatement.executeUpdate();
            DbUtils.closeQuietly(preparedStatement);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }finally {
            DbUtils.closeQuietly(connection);
        }

        if (insertedRows > 0){
            log.info("user with name '{}' registered successfully", username);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}