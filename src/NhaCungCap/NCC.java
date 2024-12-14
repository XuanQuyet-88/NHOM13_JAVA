/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhaCungCap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Administrator
 */
public class NCC{
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String soDT;
    private int soLuongNhap;
    private String maSP;

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int SoLuongNhap) {
        this.soLuongNhap = SoLuongNhap;
    }
 
    public NCC() {
        this.maNCC = "";
        this.tenNCC = "";
        this.diaChi = "";
        this.soDT = "";
        soLuongNhap = 0;
        this.maSP="";
    }

    public NCC(String maNCC, String tenNCC, String diaChi, String soDT, int soLuongNhap, String maSP) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.soLuongNhap = soLuongNhap;
        this.maSP=maSP;
    }

    @Override
    public String toString() {
        return this.maNCC+","+this.tenNCC+","+this.diaChi+","+this.soDT+","+this.soLuongNhap+","+this.maSP;
    }
    
    public static ArrayList<NCC> getNCCList() {
        ArrayList<NCC> listNCC = new ArrayList<NCC>();
        String fileName = "CSDL\\NCC.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String maNCC = fields[0];
                String tenNCC = fields[1];
                String diaChi = fields[2];
                String soDT = fields[3];
                int soLuongNhap = Integer.parseInt(fields[4]);
                String maSP = fields[5];
                NCC ncc = new NCC(maNCC, tenNCC, diaChi, soDT,soLuongNhap,  maSP);
                listNCC.add(ncc);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listNCC;
    }
}
