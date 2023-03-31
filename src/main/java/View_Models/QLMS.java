package View_Models;

public class QLMS {
    private String ma,ten;

    public QLMS(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public QLMS() {

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
