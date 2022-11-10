package repository;

import connection.MySqlConnection;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository implements IUserReponsitory {

    @Override
    public User findUserByUserNameAndPassword(String username, String password)
            throws SQLException, ClassNotFoundException {
        User user = new User();
        try(Connection connection = MySqlConnection.getMySQLConnection()){
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, username);
            query.setString(2,password);
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()){
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFullname(resultSet.getString("fullname"));
                user.setRole(resultSet.getInt("role"));
            }
            resultSet.close();
            query.close();
        }catch (SQLException sqlException){
            System.out.println(sqlException);
        }catch (ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException);
        }
        return user;
    }
    @Override
    public User findInformationUserByUserNameAndPassword(String username, String password)
            throws SQLException , ClassNotFoundException{
        User user = new User();
        try (Connection connection = MySqlConnection.getMySQLConnection()){
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1,username);
            query.setString(2,password);
            resultInformation(query);
            query.close();
        } catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return user;
    }

    @Override
    public ResultSet resultInformation(PreparedStatement preparedStatement)
            throws SQLException, ClassNotFoundException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("Tên người dùng : " + resultSet.getString("fullname"));
            if(resultSet.getInt("role") == 1){
                System.out.println("Quyền : Admin ");
            }
            System.out.println("Email : " + resultSet.getString("email"));
        }
        return resultSet;
    }


}
