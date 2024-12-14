/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class SanPhamDAO {
    private Connection conn;

    public SanPhamDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=Product;user=sa;password=123456789;encrypt=false;Product?useUnicode=true&characterEncoding=UTF-8");
            if (conn != null) {
                System.out.println("Kết nối cơ sở dữ liệu thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
    }

    public boolean addProduct(SanPham p) {
        String sql = "INSERT INTO tblProduct(maSP, tenSP, moTa, kichThuoc, SoLuong, Gia) " + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getMaSP());
            ps.setString(2, p.getTenSP());
            ps.setString(3, p.getMoTa());
            ps.setString(4, p.getKichThuoc());
            ps.setInt(5, p.getSoLuong());
            ps.setDouble(6, p.getGia());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduct(String maSP) {
        String sql = "DELETE FROM tblProduct WHERE maSP = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            return ps.executeUpdate() > 0; // Trả về true nếu có ít nhất một dòng bị xóa
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProduct(SanPham p) {
        String sql = "UPDATE tblProduct SET tenSP = ?, moTa = ?, kichThuoc = ?, SoLuong = ?, Gia = ? WHERE maSP = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getTenSP());
            ps.setString(2, p.getMoTa());
            ps.setString(3, p.getKichThuoc());
            ps.setInt(4, p.getSoLuong());
            ps.setDouble(5, p.getGia());
            ps.setString(6, p.getMaSP()); // Điều kiện sửa dựa trên maSP
            return ps.executeUpdate() > 0; // Trả về true nếu có ít nhất một dòng được cập nhật
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SanPham> getListProduct() {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM tblProduct";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham p = new SanPham();
                p.setMaSP(rs.getString("maSP"));
                p.setTenSP(rs.getString("tenSP"));
                p.setMoTa(rs.getString("moTa"));
                p.setKichThuoc(rs.getString("kichThuoc"));
                p.setSoLuong(rs.getInt("SoLuong"));
                p.setGia(rs.getDouble("Gia"));

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    

    public static void main(String[] args) {
        new SanPhamDAO();
    }
}
