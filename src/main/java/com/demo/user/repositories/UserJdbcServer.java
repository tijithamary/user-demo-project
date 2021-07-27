package com.demo.user.repositories;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.demo.user.dataobjects.User;
import com.demo.user.utils.DBConstants;

/**
 * This class used for User CRUD operations.
 */
@Repository
public class UserJdbcServer {
	
	public boolean login(String username, String password) {
		
		boolean result = false;
		String sql = "Select * from users where username = ? and password = ?";
					
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConstants.MYSQL_DB_URL, DBConstants.MYSQL_DB_USER, DBConstants.MYSQL_DB_PASS);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error: " + e);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		finally {
			try {
				stmt.close();
				con.close();
				rs.close();
			}
			catch(Exception e) {
				System.out.println("Error while close the DB");
			}
		}
		
		return result;
	}

	public User findUser(String username) {
		
		User user = null;
		String sql = "Select * from users where username = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConstants.MYSQL_DB_URL, DBConstants.MYSQL_DB_USER, DBConstants.MYSQL_DB_PASS);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("Id"));
				user.setUsername(rs.getString("Username"));
				user.setFirstname(rs.getString("Firstname"));
				user.setLastname(rs.getString("Lastname"));
				user.setCity(rs.getString("City"));
				user.setState(rs.getString("State"));
				user.setCountry(rs.getString("Country"));
				user.setZipcode(rs.getInt("Zipcode"));
				user.setPhone(rs.getString("Phone"));
				user.setEmailid(rs.getString("Emailid"));
			}
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
				rs.close();
			}
			catch (Exception e) {
			}
		}
		return user;
	}

	public User findUserByEmail(String emailid) {
		
		User user = null;
		String sql = "Select * from users where emailid = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConstants.MYSQL_DB_URL, DBConstants.MYSQL_DB_USER, DBConstants.MYSQL_DB_PASS);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, emailid);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("Id"));
				user.setUsername(rs.getString("Username"));
				user.setFirstname(rs.getString("Firstname"));
				user.setLastname(rs.getString("Lastname"));
				user.setCity(rs.getString("City"));
				user.setState(rs.getString("State"));
				user.setCountry(rs.getString("Country"));
				user.setZipcode(rs.getInt("Zipcode"));
				user.setPhone(rs.getString("Phone"));
				user.setEmailid(rs.getString("Emailid"));
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
				rs.close();
			}
			catch (Exception e) {
			}
		}
		return user;
	}
	
	public String createUser(User user) {
		
		String sql = "insert into users(username, password, firstname, lastname, city, state, country, phone, emailid, zipcode) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement stmt = null;
		boolean success = false;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConstants.MYSQL_DB_URL, DBConstants.MYSQL_DB_USER, DBConstants.MYSQL_DB_PASS);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstname());
			stmt.setString(4, user.getLastname());
			stmt.setString(5, user.getCity());
			stmt.setString(6, user.getState());
			stmt.setString(7, user.getCountry());
			stmt.setString(8, user.getPhone());
			stmt.setString(9, user.getEmailid());
			stmt.setInt(10, user.getZipcode());
			int result = stmt.executeUpdate();
			success = (result > 0);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
			}
			catch (Exception e) {
			}
		}
		if (success == true) {
			return "Successfully created!!!!!";
		}
		else {
			return "Try Again!!!!!!";
		}
	}
	
//	public static void main(String[] args) {
//		
//		User user = new User();
//		user.setUsername("Ishika");
//		user.setPassword("ishika2006");
//		user.setFirstname("Ishika");
//		user.setLastname("Shadon");
//		user.setCity("Kuwait");
//		user.setState("Kuwait");
//		user.setCountry("Kuwait");
//		user.setPhone("9994440567");
//		user.setEmailid("ishika2006@gmail.com");
//		user.setZipcode(902903);
//		System.out.println(createUser(user));
//	}
}


