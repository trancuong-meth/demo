package View_Models;

public class QLCV {
    private String ma,ten;

    public QLCV(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public QLCV() {

    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
}
