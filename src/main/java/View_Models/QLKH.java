package View_Models;

public class QLKH {
    private String ma;
    private String ten;
    private String ten_dem;
    private String ho;
    private String ngay_sinh;
    private String sdt;
    private String dia_chi;
    private String mat_khau;
    private String thanh_pho;
    private String quoc_gia;

    public QLKH(String ma, String ten, String ten_dem, String ho, String ngay_sinh, String sdt, String dia_chi, String mat_khau, String thanh_pho, String quoc_gia) {
        this.ma = ma;
        this.ten = ten;
        this.ten_dem = ten_dem;
        this.ho = ho;
        this.ngay_sinh = ngay_sinh;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
        this.mat_khau = mat_khau;
        this.thanh_pho = thanh_pho;
        this.quoc_gia = quoc_gia;
    }

    public QLKH() {
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

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public void setThanh_pho(String thanh_pho) {
        this.thanh_pho = thanh_pho;
    }

    public void setQuoc_gia(String quoc_gia) {
        this.quoc_gia = quoc_gia;
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

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public String getThanh_pho() {
        return thanh_pho;
    }

    public String getQuoc_gia() {
        return quoc_gia;
    }
}
