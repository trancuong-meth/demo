package Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
public class HoaDon {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "IdKH")
    private String idKH;
    @Column(name = "IdNV")
    private String idNV;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name = "NgayShip")
    private Date ngayShip;
    @Column(name = "NgayNhan")
    private Date ngayNhan;
    @Column(name = "TinhTrang")
    private String tinhTrang;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;

    public UUID getId() {
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public Date getNgayShip() {
        return ngayShip;
    }

    public Date getNgayNhan() {
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

    public HoaDon(UUID id, String idKH, String idNV, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date  ngayNhan, String tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
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
