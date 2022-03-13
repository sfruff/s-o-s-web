package ge.tsu.sosweb.db;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.DbUtils;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Slf4j
public class Database {

    private static Database INSTANCE;

    @Getter
    private DataSource dataSource;

    private Connection connection;

    private Database() {
        DBConfig config = DBConfig.getInstance();
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(config.getJdbcUrl());
        dataSource.setUser(config.getUsername());
        dataSource.setPassword(config.getPassword());
        this.dataSource = dataSource;
    }

    public static synchronized Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }


    private Connection createConnection(){
        try {
            this.connection = getInstance().getDataSource().getConnection();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return this.connection;
    }

    private Connection getConn(){
        return this.connection;
    }


    public static Connection getConnection() {
            return getInstance().createConnection();
    }

    public static void closeConnection(){
        DbUtils.closeQuietly(getInstance().getConn());
    }
}