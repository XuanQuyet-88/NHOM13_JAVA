package SanPham;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SanPham {

    public String maSP;
    private String tenSP;
    private String moTa;
    private String kichThuoc;
    private int SoLuong;
    private double Gia;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }
    
    public SanPham() {
        maSP = "";
        tenSP = "";
        moTa = "";
        kichThuoc="";
        SoLuong=0;
        Gia=0;
    }

    public SanPham(String maSP, String tenSP, String moTa, String kichThuoc, int SoLuong, double Gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.kichThuoc = kichThuoc;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
    }

    @Override
    public String toString() {
        return this.maSP+","+this.tenSP+","+this.moTa+","+this.kichThuoc+","+this.SoLuong+","+this.Gia;
    }

    //get data from database
    public static ArrayList<SanPham> getSanPhamList() {
        ArrayList<SanPham> listSP = new ArrayList<SanPham>();
        String fileName = "CSDL\\SanPham.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String maSP = fields[0];
                String tenSP = fields[1];
                String moTa = fields[2];
                String kichThuoc = fields[3];
                int SoLuong = Integer.parseInt(fields[4]);
                double Gia = Double.parseDouble(fields[5]);
                SanPham SP = new SanPham(maSP, tenSP, moTa, kichThuoc, SoLuong, Gia);
                listSP.add(SP);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listSP;
    }
}
