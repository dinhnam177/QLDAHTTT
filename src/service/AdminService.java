package service;
import repository.IDonateReponsitory;
import repository.IUserReponsitory;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminService {

    public void viewMenuAdmin(){
        System.out.println("1.Xem thông tin");
        System.out.println("2.Xem yêu cầu nạp thẻ");
        System.out.println("3.Chấp nhận nạp thẻ");
        System.out.println("0.Thoát !!!");
    }
    public void showInformationAdmin(IUserReponsitory iUserReponsitory,
                                    String username, String password) throws SQLException, ClassNotFoundException {
        iUserReponsitory.findInformationUserByUserNameAndPassword(username,password);
    }
    public void showRequestDonate(IDonateReponsitory iDonateReponsitory,
                                  String username, String password) throws SQLException, ClassNotFoundException {
        iDonateReponsitory.findHistoryDonateByAdmin();
    }
    public void acceptRequestDonate(IDonateReponsitory iDonateReponsitory)
            throws SQLException, ClassNotFoundException{
        System.out.print("Nhập user name : ");
        String userName = new Scanner(System.in).nextLine();
        if(userName != null){
            iDonateReponsitory.acceptRequestDonate(userName);
            System.out.println("-------------------");
        }
    }
}
