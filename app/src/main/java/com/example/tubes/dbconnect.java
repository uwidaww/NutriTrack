package com.example.tubes;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnect {
    Connection conn;
    String uName, uPass, ip, port, database;

    public Connection connecting() {
        ip = "127.0.0.1";
        database = "pab";
        port = "3306";
        uName = "root";
        uPass = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String conURL = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conURL = "jdbc:jtds:sqlserver://"+ ip +":"+ port +";"+"databasename="+ database +";user="+ uName +";password="+ uPass+";";
            connection = DriverManager.getConnection(conURL);

        }
        catch (Exception ex)
        {
            Log.e("Error ", ex.getMessage());
        }
        return connection;
    }
}
