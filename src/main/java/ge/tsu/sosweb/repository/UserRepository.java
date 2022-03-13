package ge.tsu.sosweb.repository;

import ge.tsu.sosweb.db.Database;
import ge.tsu.sosweb.model.User;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.DbUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Slf4j
public class UserRepository {
    private static final String SELECT_BY_ID = "SELECT * FROM USERS WHERE ID=?;";

    @Setter
    private static User user;

    public static User searchById(int userId){

        user = new User();

        try (PreparedStatement preparedStatement = Database.getConnection().prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user.setId(userId);
                    user.setName(resultSet.getString("name"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                }
            }finally {
                DbUtils.closeQuietly(preparedStatement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }finally {
            Database.closeConnection();
        }
        return null;
    }
}
