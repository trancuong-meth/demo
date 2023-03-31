package View_Models;

public class QLNV {
    private String ma, ten, ten_dem, ho, gioi_tinh, ngay_sinh, dia_chi, sdt, mat_khau, trang_thai;

    public QLNV(String ma, String ten, String ten_dem, String ho, String gioi_tinh, String ngay_sinh, String dia_chi, String sdt, String mat_khau, String trang_thai) {
        this.ma = ma;
        this.ten = ten;
        this.ten_dem = ten_dem;
        this.ho = ho;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.mat_khau = mat_khau;
        this.trang_thai = trang_thai;
    }

    public QLNV() {

    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTen_dem(String ten_dem) {
        this.ten_dem = ten_dem;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getTen_dem() {
        return ten_dem;
    }

    public String getHo() {
        return ho;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public String getTrang_thai() {
        return trang_thai;
    }
}
