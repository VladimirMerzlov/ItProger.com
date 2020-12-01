package com.itProgerSQL;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class DB {

    private final String HOST = "localhost";
    private final String PORT = "8889";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public Integer selectUsers() throws SQLException, ClassNotFoundException {
        Integer users = null;
        String sql = "SELECT `id`, `login` FROM `users` WHERE `login` = 'john'";

        Statement st = getDbConnection().createStatement();
        ResultSet res = st.executeQuery(sql);

        while (res.next()) {
            users = res.getInt("id");
        }
        return users;
    }

    public ArrayList<Integer> selectItems() throws SQLException, ClassNotFoundException {
        ArrayList<Integer> items = new ArrayList<>();
        String sql = "SELECT `id`, `title` FROM `items` WHERE `category` = 'hats'";
        Statement st = getDbConnection().createStatement();
        ResultSet res = st.executeQuery(sql);

        while (res.next()) {
            items.add(res.getInt("id"));
        }
        return items;
    }

    public void insertData(Integer user_id,Integer item_id) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `orders` (user_id, item_id ) VALUES (? , ?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setInt(1, user_id);
        prSt.setInt(2, item_id);
        prSt.executeUpdate();
    }

    public void toStringOrders() throws SQLException, ClassNotFoundException{
        
        String sql = "SELECT `id`, `title` FROM `items` WHERE `category` = 'hats'";
        Statement st = getDbConnection().createStatement();
        ResultSet res = st.executeQuery(sql);

//        while (res.next()) {
//            items.add(res.getInt("id"));
//        }
        // GHJGKG
    }

}

