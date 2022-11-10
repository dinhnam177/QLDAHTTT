import service.LoginService;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        LoginService loginService = new LoginService();
        while (true){
            loginService.setInputLogin();
        }
    }
}
