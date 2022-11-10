package service;
import repository.IDonateReponsitory;
import repository.IUserReponsitory;
import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    Scanner input = new Scanner(System.in);
    public void viewMenuUser(){
        System.out.println("1.Xem thông tin");
        System.out.println("2.Nạp thẻ");
        System.out.println("3.Xem lịch sử nạp thẻ");
        System.out.println("0.Thoát !!!");
    }
    public void showInformationUser(IUserReponsitory iUserReponsitory,
                               String username, String password) throws SQLException, ClassNotFoundException {
        iUserReponsitory.findInformationUserByUserNameAndPassword(username,password);
    }
    public void donateByUser(IDonateReponsitory iDonateReponsitory,
                             String username) throws SQLException, ClassNotFoundException{
        System.out.print("Nhập số tiền (K/VNĐ) : ");
        String card = input.nextLine();
        iDonateReponsitory.setDonateByUser(card, username);
    }
    public void showDonateHistoryByUser(IDonateReponsitory iDonateReponsitory,
                                        String username, String password) throws SQLException, ClassNotFoundException{
        iDonateReponsitory.findHistoryDonateByUser(username,password);
    }
}
