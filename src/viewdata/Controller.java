/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author zhangquan
 */
public class Controller {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/stuInfo?useUnicode=true&characterEncoding=utf8";
    static final String USER = "root";
    static final String PASS = "AQYYADSDSW123zq";
    Connection conn;
    Controller() throws ClassNotFoundException, SQLException{
        conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
    }
    
    public String Search(String str) throws SQLException, ClassNotFoundException{
        Statement stmt = null;
        String result;
        String sql;
        String Sno = str;
        sql = "select * from student where Sno = '" + Sno + "'" + ";";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            result = rs.getString("Sno") + "  " + rs.getString("Sname")
             + "  " + rs.getString("Ssex") + "  " + rs.getString("Sage") + "  " +
                    rs.getString("Sdept");
        }
        else{
            result = "没有该学生信息";
        }
        rs.close();
        stmt.close();
        //conn.close();
        return result;
    }
    
    public void Insert(String s1,String s2,String s3,String s4,String s5) throws SQLException{
        //插入学生信息
        Statement stmt = null;
        String sql;
        sql = "insert into student values (" + "'" + s1 + "'" + "," + "'" + s2 + "'" 
                + "," +  "'" + s3 + "'" + "," + Integer.parseInt(s4) + "," + "'" + s5 + "'" + ")";
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        //conn.close();
    }
    
    public void Del(String Sno) throws SQLException{
        Statement stmt = null;
        if(isValue(stmt,Sno)) {
            String sql;
            sql = "delete from student where Sno = '" + Sno + "'";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            int i = stmt.executeUpdate(sql);
            //java中int型是不能转化为boolean的
        }
        else{
                JOptionPane.showConfirmDialog(null, "对不起，没有该学生信息！！！","提示框",JOptionPane.OK_OPTION);
        }
        stmt.close();
        //conn.close();
    }

    //按学号修改学生信息
    public void Update(String Sno,String Sage) throws SQLException{
        Statement stmt = null;
        int age = Integer.parseInt(Sage);
        if(isValue(stmt,Sno)) {
            String sql;
            sql = "UPDATE student set Sage = " + Sage + ";";
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                //conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt.close();
        }
    }

    //判断是否有该学生
    public boolean isValue(Statement stmt,String Sno){
        String sql;
        sql = "select * from student where Sno = '" + Sno + "'";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //判断学生年龄是否在15-45之间
    public boolean isAge(int age){
        if(age>=15&&age<=45){
            return true;
        }
        return false;
    }

    //判断学生性别是否符合要求
    public boolean isSex(String sex){
        if(sex.equals('男') || sex.equals('女')){
            return true;
        }
        return false;
    }
}

    

