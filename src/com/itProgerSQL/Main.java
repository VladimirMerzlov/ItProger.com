package com.itProgerSQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        DB db = new DB();
        ArrayList<Integer> items;

        try {
            Integer users_id = db.selectUsers();
            items = db.selectItems();
            for (Integer index : items){
                db.insertData(users_id , index);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Тестирую гит.



}
