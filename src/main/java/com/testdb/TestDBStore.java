package com.testdb;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestDBStore implements AutoCloseable {

    private Connection cn;

    public TestDBStore() {
        init();
    }

    public void init() {
        try (InputStream in = TestDBStore.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("jdbc.driver"));
            cn = DriverManager.getConnection(
                    config.getProperty("jdbc.url"),
                    config.getProperty("jdbc.username"),
                    config.getProperty("jdbc.password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    public List<String> findAll() {
        List<String> rsl = new ArrayList<>();
        try (Statement st = cn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT email FROM customer");
            while (rs.next()) {
                rsl.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
