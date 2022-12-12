package com.nini.menu;

import static Core.Decorator.OrderType.*;


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
import Core.Singleton.Controller;

public class DBM {

    private static DBM instance = new DBM();
    
    // 資料庫定義
    String mysql_ip = "85.10.205.173";
    int mysql_port = 3306; // Port 預設為 3306
    String db_name = "oose0829";
    String url = "jdbc:mysql://" + mysql_ip + ":" + mysql_port + "/" + db_name + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    String db_user = "root0829";
    String db_password = "123456789";
    
    String data = "";
    String sql;
    Menu m_Folder;

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

    }

    public Menu getData(String[] s)
    {

        Menu rootMenu = new Folder("目錄");
        for(int i=0;i<s.length;i++)
        {
            switch (i)
            {
                case 0:
                {
                    m_Folder = new Folder("主餐");
                    sql = s[i];
                    queryData(MainDish);
                    break;
                }
                case 1:
                {
                    m_Folder = new Folder("甜點");
                    sql = s[i];
                    queryData(Dessert);
                    break;
                }
                case 2:
                {
                    m_Folder = new Folder("湯品");
                    sql = s[i];
                    queryData(Dessert);
                    break;
                }
                case 3:
                {
                    m_Folder = new Folder("飲料");
                    sql = s[i];
                    queryData(Drink);
                    break;
                }

                default:
                    throw new IllegalStateException("Unexpected value: " + i);

            }
            rootMenu.add(m_Folder);

        }
        // ===================DB測試===================
        String Mname;
        for(int i=0;i<rootMenu.getChildren().size();i++)
        {
            Mname = rootMenu.getChildren().get(i).getName();
            System.out.println("=====" + Mname + "=====");


            for(int j=0;j<rootMenu.getChildren().get(i).getChildren().size();j++)
            {
                System.out.println(Mname +" " + rootMenu.getChildren().get(i).getChildren().get(j).getName() + " " + rootMenu.getChildren().get(i).getChildren().get(j).getPrice());

            }
            System.out.println("=====" + Mname + "=====");

        }
        // ===================DB測試===================
        Controller.getInstance().DB_OK = true;
        return rootMenu;
    }
    public Menu queryData(OrderType orderType)
    {
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);

            OrderType ot = orderType;

            String Name;
            float price;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
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
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m_Folder;
    }
}
