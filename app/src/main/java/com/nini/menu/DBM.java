package com.nini.menu;

import static Core.Decorator.OrderType.Dessert;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Core.Composite.Folder;
import Core.Composite.Item;
import Core.Composite.Menu;
import Core.Decorator.OrderType;

public class DBM {

    private static DBM instance = new DBM();

    // 資料庫定義
    String mysql_ip = "85.10.205.173";
    int mysql_port = 3306; // Port 預設為 3306
    String db_name = "oose0829";
    String url = "jdbc:mysql://" + mysql_ip + ":" + mysql_port + "/" + db_name + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    String db_user = "root0829";
    String db_password = "123456789";

    public static DBM getInstance()
    {
        if (instance == null)
        {
            instance = new DBM();
        }
        return instance;
    }

    private DBM(){}

    public void run() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Log.v("DB", "加載驅動成功");
        } catch (ClassNotFoundException e) {
            Log.e("DB", "加載驅動失敗");
            return;
        }

        // 連接資料庫
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            Log.v("DB", "遠端連接成功");
        } catch (SQLException e) {
            Log.e("DB", "遠端連接失敗");
            Log.e("DB", e.toString());
        }
    }

    public String getData(String s) {
        String data = "";
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = s, Name;
            float price;
            OrderType ot = Dessert;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Menu m_Folder = new Folder("甜點");
            Menu Item;
            int i = 0;

            while (rs.next()) {
                Name = rs.getString("Name");
                price = rs.getFloat("price");
                // 建composite start
                Item = new Item(Name,price,ot);
                m_Folder.add(Item);
                Item = m_Folder.getChildren().get(i);
                // 建composite end
                i++;

                data += "\n" + m_Folder.getName() + Item.getName() + ", " + Item.getPrice() + "\n";
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

}