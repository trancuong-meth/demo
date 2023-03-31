package Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "IdSP")
    private String idSP;
    @Column(name = "IdNSX")
    private String idNSX;
    @Column(name = "IdMauSac")
    private String idMauSac;
    @Column(name = "IdDongSP")
    private String idDongSP;
    @Column(name = "NamBH")
    private String namBH;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private String soLuongTon;
    @Column(name = "GiaNhap")
    private String giaNhap;
    @Column(name = "GiaBan")
    private String giaBan;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(UUID id, String idSP, String idNSX, String idMauSac, String idDongSP, String namBH, String moTa, String soLuongTon, String giaNhap, String giaBan) {
        this.id = id;
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public void setNamBH(String namBH) {
        this.namBH = namBH;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setSoLuongTon(String soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public UUID getId() {
        return id;
    }

    public String getIdSP() {
        return idSP;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public String getNamBH() {
        return namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getSoLuongTon() {
        return soLuongTon;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public String getGiaBan() {
        return giaBan;
    }
}
