package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet {
    @Id
    @Column(name = "IdGioHang")
    private String idHoaDon;
    @Id
    @Column(name = "IdChiTiet")
    private String idChiTietSP;
    @Column(name = "SoLuong")
    private String soLuong;
    @Column(name = "DonGia")
    private String donGia;
    @Column(name = "DonGiaKhiGiam")
    private String donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(String idHoaDon, String idChiTietSP, String soLuong, String donGia, String donGiaKhiGiam) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public String getDonGia() {
        return donGia;
    }

    public String getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public void setDonGiaKhiGiam(String donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }
}
