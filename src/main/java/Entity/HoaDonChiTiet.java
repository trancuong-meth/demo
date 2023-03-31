package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @Column(name = "IdHoaDon")
    private String idHoaDon;
    @Id
    @Column(name = "IdChiTiet")
    private String idChiTietSP;
    @Column(name = "SoLuong")
    private String soLuong;
    @Column(name = "DonGia")
    private String donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDon, String idChiTietSP, String soLuong, String donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
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
}
