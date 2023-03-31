package View_Models;

public class QLCH {
    private String ma,ten,dia_chi,thanh_pho,quoc_gia;

    public QLCH(String ma, String ten, String dia_chi, String thanh_pho, String quoc_gia) {
        this.ma = ma;
        this.ten = ten;
        this.dia_chi = dia_chi;
        this.thanh_pho = thanh_pho;
        this.quoc_gia = quoc_gia;
    }

    public QLCH() {

    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
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

    public String getDia_chi() {
        return dia_chi;
    }

    public String getThanh_pho() {
        return thanh_pho;
    }

    public String getQuoc_gia() {
        return quoc_gia;
    }
}
