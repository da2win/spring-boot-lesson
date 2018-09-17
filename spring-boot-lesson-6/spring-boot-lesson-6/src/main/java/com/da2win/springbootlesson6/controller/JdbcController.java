package com.da2win.springbootlesson6.controller;

import com.da2win.springbootlesson6.domain.User;
import com.da2win.springbootlesson6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@RestController
public class JdbcController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/jdbc/meta/transaction/supported")
    public boolean supportedTransaction() {
        boolean supported = false;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            supported = metaData.supportsTransactions();
            return supported;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/users")
    public List<Map<String, Object>> getUsers() {
        return jdbcTemplate.execute(new StatementCallback<List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
                ResultSetMetaData metaData = resultSet.getMetaData();

                int columnCount = metaData.getColumnCount();
                List<String> columnNames = new ArrayList<>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    columnNames.add(metaData.getColumnName(i));
                }
                List<Map<String, Object>> data = new LinkedList<>();
                while (resultSet.next()) {
                    Map<String, Object> columnData = new LinkedHashMap<>();
                    for (String columnName : columnNames) {
                        Object columnValue = resultSet.getObject(columnName);
                        columnData.put(columnName, columnValue);
                    }
                    data.add(columnData);
                }
                return data;
            }
        });
    }

    @RequestMapping("/user/get")
    public Map<String, Object> getUser(@RequestParam(value = "id", defaultValue = "1") int id) {
        Map<String, Object> data = new HashMap<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT id, name, age FROM user where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id_ = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                data.put("id", id_);
                data.put("name", name);
                data.put("age", age);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public Map<String, Object> addUser(@RequestBody User user) {
        Map<String, Object> data = new HashMap<>();
        boolean result = userService.save(user);
        data.put("SUCCESS", result);
        return data;
    }
}
