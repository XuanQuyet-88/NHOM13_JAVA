/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DonHang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class DonHang {
    private String maDH;
    private String maSP;
    private String maNV;
    private int soLuongMua;
    private String Ngay;

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    public DonHang() {
        this.maDH = maDH;
        this.maSP = maSP;
        this.maNV = maNV;
        this.soLuongMua = 0;
        this.Ngay = Ngay;
    }

    public DonHang(String maDH, String maSP, String maNV, int soLuongMua, String Ngay) {
        this.maDH = maDH;
        this.maSP = maSP;
        this.maNV = maNV;
        this.soLuongMua = soLuongMua;
        this.Ngay = Ngay;
    }
    
    @Override
    public String toString() {
        return this.maDH+","+this.maSP+","+this.maNV+","+this.soLuongMua+","+this.Ngay;
    }
    
    //get data from database
    public static ArrayList<DonHang> getDonHangList() {
        ArrayList<DonHang> listDH = new ArrayList<DonHang>();
        String fileName = "CSDL\\DonHang.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String maDH = fields[0];
                String maSP = fields[1];
                String maNV = fields[2];
                int soLuongMua = Integer.parseInt(fields[3]);
                String Ngay = fields[4];
                
                DonHang dh = new DonHang(maDH, maSP, maNV, soLuongMua, Ngay);
                listDH.add(dh);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listDH;
    }
}
