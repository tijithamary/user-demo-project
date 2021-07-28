package com.demo.user.repositories;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.user.configs.DBConstants;
import com.demo.user.dataobjects.User;

/**
 * This class used for User CRUD operations.
 */
@Repository
public class UserJdbcServer {
	
	@Autowired
	private DBConstants dbConstents;
	
	public boolean login(String username, String password) {
		
		boolean result = false;
		String sql = "Select * from users where username = ? and password = ?";
					
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbConstents.URL, dbConstents.USERNAME, dbConstents.PASSWORD);
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
			con = DriverManager.getConnection(dbConstents.URL, dbConstents.USERNAME, dbConstents.PASSWORD);
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
			con = DriverManager.getConnection(dbConstents.URL, dbConstents.USERNAME, dbConstents.PASSWORD);
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
	
	public int createUser(User user) {
		
		String sql = "insert into users(username, password, firstname, lastname, city, state, country, phone, emailid, zipcode) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbConstents.URL, dbConstents.USERNAME, dbConstents.PASSWORD);
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
			result = stmt.executeUpdate();
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
		
		return result;
	}
	
	
	public static void main(String[] args) {
	
		UserJdbcServer userJdbc = new UserJdbcServer();
		User user = new User();
		user.setUsername("aaa11");
		user.setPassword("bbb");
		user.setFirstname("aaa");
		user.setLastname("bbb");
		user.setCity("Chennai");
		user.setState("TN");
		user.setCountry("India");
		user.setZipcode(898989);
		user.setPhone("9349302843");
		user.setEmailid("aaaa@gmail.com");
		int id = userJdbc.createUser(user);
		System.out.println(id);
	}
}


