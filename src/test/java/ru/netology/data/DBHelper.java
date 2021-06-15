package ru.netology.data;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    private final static QueryRunner runner = new QueryRunner();
    private final static Connection conn = getConnection();

    @SneakyThrows
    private static Connection getConnection() {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "user", "pass");
    }

    @SneakyThrows
    public static String getStatusPurchase() {
        val status = "SELECT status FROM payment_entity ORDER BY created DESC";
        return runner.query(conn, status, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getStatusCredit() {
        val status = "SELECT status FROM credit_request_entity ORDER BY created DESC";
        return runner.query(conn, status, new ScalarHandler<>());
    }





}
