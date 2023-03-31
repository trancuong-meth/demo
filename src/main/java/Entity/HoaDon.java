package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "IdKH")
    private String idKH;
    @Column(name = "IdNV")
    private String idNV;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private String ngayTao;
    @Column(name = "NgayThanhToan")
    private String ngayThanhToan;
    @Column(name = "NgayShip")
    private String ngayShip;
    @Column(name = "NgayNhan")
    private String ngayNhan;
    @Column(name = "TinhTrang")
    private String tinhTrang;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;

    public String getId() {
        return id;
    }

    public String getIdKH() {
        return idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public String getMa() {
        return ma;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public String getNgayShip() {
        return ngayShip;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public HoaDon() {
    }

    public HoaDon(String id, String idKH, String idNV, String ma, String ngayTao, String ngayThanhToan, String ngayShip, String ngayNhan, String tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }
}
