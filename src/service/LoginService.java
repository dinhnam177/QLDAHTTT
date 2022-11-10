package service;
import repository.DonateRepository;
import repository.IDonateReponsitory;
import repository.IUserReponsitory;
import repository.UserRepository;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginService {
    public void setInputLogin() throws SQLException, ClassNotFoundException {
        AdminService adminService = new AdminService();
        UserService userService = new UserService();
        IUserReponsitory iUserReponsitory = new UserRepository();
        IDonateReponsitory iDonateReponsitory = new DonateRepository();
        Scanner input = new Scanner(System.in);
        System.out.print("Tài khoản 3212: ");
        String username = input.nextLine();
        System.out.print("Mật khẩu  1233: ");
        String password = input.nextLine();
        boolean check = true;
        if(!iUserReponsitory.findUserByUserNameAndPassword(username,password).checkExits()
                && 1 == iUserReponsitory.findUserByUserNameAndPassword(username,password).getRole()){
            while (check == true){
                adminService.viewMenuAdmin();
                System.out.print("Nhập : ");
                int chosse = input.nextInt();
                if(1 == chosse) adminService.showInformationAdmin(iUserReponsitory,username,password);
                else if(2 == chosse) adminService.showRequestDonate(iDonateReponsitory,username,password);
                else if(3 == chosse) adminService.acceptRequestDonate(iDonateReponsitory);
                else check = false;
            }
        }
        else if (!iUserReponsitory.findUserByUserNameAndPassword(username,password).checkExits()
                && 0 == iUserReponsitory.findUserByUserNameAndPassword(username,password).getRole()){
            while (check == true){
                userService.viewMenuUser();
                System.out.print("Nhập : ");
                int chosse = input.nextInt();
                if(1 == chosse) userService.showInformationUser(iUserReponsitory,username,password);
                else if(2 == chosse) userService.donateByUser(iDonateReponsitory,username);
                else if(3 == chosse) userService.showDonateHistoryByUser(iDonateReponsitory, username,password);
                else check = false;
            }
        }
        else {
            System.out.println("Nhập sai tài khoản hoặc mật khẩu !!!");
        }
    }
}
