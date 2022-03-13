package ge.tsu.sosweb.db;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Slf4j
public class DBConfig {

    private static DBConfig INSTANCE;

    @Getter
    private String jdbcUrl;

    @Getter
    private String username;

    @Getter
    private String password;

    private DBConfig() {
        Properties props = new Properties();
        try (InputStream inputStream = DBConfig.class.getResourceAsStream("/db.properties")) {
            props.load(inputStream);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        jdbcUrl = props.getProperty("jdbc-url");
        username = props.getProperty("username");
        password = props.getProperty("password");
    }

    public static synchronized DBConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DBConfig();
        }
        return INSTANCE;
    }
}
