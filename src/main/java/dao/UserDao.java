package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.Dbconnection;
import dto.UserDto;

public class UserDao {
	// name email pwd
	public static int adduser(UserDto dto) throws SQLException {
		Connection conn = Dbconnection.getConnection();
		PreparedStatement ps;

		ps = conn.prepareStatement("INSERT INTO user (Name, Email, pwd) VALUES (?,?,?);");
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getEmail());
		ps.setString(3, dto.getPwd());

		int k = ps.executeUpdate();

		return k;
	}

	public boolean signUp(UserDto dto) throws SQLException {
		Connection conn = Dbconnection.getConnection();
		Statement ps;
		String email = dto.getEmail();
		String pwd = dto.getPwd();
		int User_id = 0;
		ps = conn.createStatement();
		boolean check = false;
		System.out.println(pwd);
		ResultSet rs = ps.executeQuery("SELECT * FROM user where email= " + "'" + email + "'");

		while (rs.next()) {// student_id, Name, Email, Branch

			String cpwd = rs.getString("pwd");
			// int User_id=rs.getInt("user_id");
			System.out.println(cpwd);

			if (pwd.equals(cpwd)) {

				check = true;
				System.out.println(check);
			}

		}
		return check;
	}

}