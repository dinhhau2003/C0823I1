package TaiKhoan.service;

public interface IBankService {
    void addBank();
    void displayBank();
    void removeBank(int idBankDel);
    void findBank(String nameFind);
}
