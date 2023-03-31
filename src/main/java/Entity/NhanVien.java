package Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "TenDem")
    private String tenDem;
    @Column(name = "Ho")
    private String ho;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "IdCH")
    private String idCH;
    @Column(name = "IdCV")
    private String idCV;
    @Column(name = "IdGuiBC")
    private String iduiBC;
    @Column(name = "TrangThai")
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(UUID id, String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, String idCH, String idCV, String iduiBC, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCH = idCH;
        this.idCV = idCV;
        this.iduiBC = iduiBC;
        this.trangThai = trangThai;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public void setIduiBC(String iduiBC) {
        this.iduiBC = iduiBC;
    }

    public String getIdCH() {
        return idCH;
    }

    public String getIdCV() {
        return idCV;
    }

    public String getIduiBC() {
        return iduiBC;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public UUID getId() {
        return id;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getTenDem() {
        return tenDem;
    }

    public String getHo() {
        return ho;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public int getTrangThai() {
        return trangThai;
    }
}
