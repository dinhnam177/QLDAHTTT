package repository;
import domain.Donate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDonateReponsitory {

    Donate setDonateByUser(String card, String username) throws SQLException, ClassNotFoundException;

    Donate acceptRequestDonate(String userName) throws SQLException, ClassNotFoundException;

    Donate findHistoryDonateByUser(String username, String password) throws SQLException, ClassNotFoundException;

    Donate findHistoryDonateByAdmin()throws SQLException , ClassNotFoundException;

    /**
     *
     * preparedStatement : query sql
     * @return : thông tin lịch sử nạp thẻ của người dùng
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    ResultSet resultHistoryDonate(PreparedStatement preparedStatement)
            throws SQLException, ClassNotFoundException;
}
