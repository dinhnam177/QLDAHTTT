package repository;

import domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IUserReponsitory {
    /**
     *
     * @param username : truyền vào username
     * @param password : truyền vào password
     * @return : user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    User findUserByUserNameAndPassword(String username, String password) throws SQLException, ClassNotFoundException;

    /**
     *
     * @param username : truyền vào username
     * @param password : truyền vào password
     * @return : user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    User findInformationUserByUserNameAndPassword(String username, String password)
            throws SQLException, ClassNotFoundException;

    /**
     *
     * preparedStatement : query sql
     * @return : thông tin người dùng
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    ResultSet resultInformation(PreparedStatement preparedStatement)
            throws SQLException, ClassNotFoundException;


}
