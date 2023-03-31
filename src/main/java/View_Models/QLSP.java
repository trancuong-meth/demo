package View_Models;

public class QLSP {
    private String ma,ten;

    public QLSP(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public QLSP() {

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
