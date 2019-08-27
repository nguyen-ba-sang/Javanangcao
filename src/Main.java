/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w7
 */import java.sql.*;
public class Main {
    public static void main(String args[])
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rst = null;
        try{
            //b1. Nap trinh dieu khien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //b2. Dinh nghia chuoi ket noi
            String url = "jdbc:sqlserver://PC215\\SQLSERVER;" +
                    "databaseName=QLSanpham_22;";
            //b3. Tao doi tuong ket noi
            conn = DriverManager.getConnection(url, "sa", "123456");
            //b4. Tao doi tuong thuc thi cai lech truy van va thi hanh
            stmt = conn.createStatement();
            System.out.println("-Bang loai san pham-");
            //B5. Thuc thi cau lech truy van
            rst = stmt.executeQuery("Select * from LoaiSP");
            //B6. Xu ly ket qua va tra ve
            while(rst.next())// duyet qua cac mau tin ket qua
            {
                System.out.println(rst.getString("MaLoai") + "_" + rst.getString("TenLoai"));
            }
        }catch (Exception ex){
            System.err.println(ex.toString());
        }
    }
}
