package repository;
import connection.MySqlConnection;
import domain.Donate;
import java.sql.*;

public class DonateRepository implements IDonateReponsitory {
    @Override
    public Donate setDonateByUser(String card, String username) throws SQLException, ClassNotFoundException {
        Donate donate = new Donate();
        try(Connection connection = MySqlConnection.getMySQLConnection();) {
            String sql = "INSERT INTO donate (username,card,statuss,time_in,time_out) VALUES (?, ?, ?,?,?)";
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, username);
            query.setString(2, card);
            query.setString(3, "request");
            query.setTimestamp(4, donate.getdateIn());
            query.setTimestamp(5, null);
            query.executeUpdate();
            query.close();
        }
        return donate;
    }

    @Override
    public Donate acceptRequestDonate(String userName) throws SQLException, ClassNotFoundException {
        Donate donate = new Donate();
        try(Connection connection = MySqlConnection.getMySQLConnection()){
            String sql = "UPDATE donate SET statuss = ?, time_out = ? WHERE username = ? AND statuss = ?";
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1,"success");
            query.setTimestamp(2, donate.getdateOut());
            query.setString(3, userName);
            query.setString(4,"request");
            query.executeUpdate();
            query.close();
        }
        return donate;
    }
    @Override
    public Donate findHistoryDonateByUser(String username, String password) throws SQLException, ClassNotFoundException {
        Donate donate = new Donate();
        try(Connection connection = MySqlConnection.getMySQLConnection()){
            String sql = "SELECT u.username,u.email, d.card, d.statuss, d.time_in, d.time_out FROM users AS u " +
                    "INNER JOIN donate AS d ON u.username = d.username " +
                    "WHERE u.username = ? AND u.password = ?";
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, username);
            query.setString(2,password);
            resultHistoryDonate(query).close();
            query.close();
        }
        return donate;
    }

    @Override
    public Donate findHistoryDonateByAdmin() throws SQLException, ClassNotFoundException {
        Donate donate = new Donate();
        try (Connection connection = MySqlConnection.getMySQLConnection()) {
            String sql = "SELECT * FROM donate";
            PreparedStatement query = connection.prepareStatement(sql);
            resultHistoryDonate(query).close();
            query.close();
        }
        return donate;
    }

    @Override
    public ResultSet resultHistoryDonate(PreparedStatement preparedStatement) throws SQLException{
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("User Name : " + resultSet.getString("username"));
            System.out.println("Card : " + resultSet.getString("card"));
            System.out.println("Trạng thái : " + resultSet.getString("statuss"));
            System.out.println("Thời gian nạp : " + resultSet.getTimestamp("time_in") + "-" +
                    resultSet.getTimestamp("time_out"));
        }
        return resultSet;
    }
}
