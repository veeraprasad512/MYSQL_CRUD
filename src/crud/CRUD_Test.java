package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD_Test {
	
	public static void main(String[] args) {
		CRUD_Test objTest = new CRUD_Test();
		objTest.create_data(1, "veera", "chirukuri", "veerac87@gmail.com");
		//objTest.read_data(2);
		//objTest.update_data(1, 2, "veera", "chirukuri", "veerac87@gmail.com");
		//objTest.read_data(2);
	}
	
	public void create_data(int s_no, String first_name, String last_name, String email) {
		
		DB_Connection obj_DB_Connection = new DB_Connection();
		
		Connection connection = obj_DB_Connection.get_Connection();
		
		PreparedStatement ps = null;
		
		try {
			String query = "insert into user(s_no,first_name,last_name,email) values(?,?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, s_no);
			ps.setString(2, first_name);
			ps.setString(3, last_name);
			ps.setString(4, email);
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	public void read_data(int s_no) {
		
		DB_Connection obj_DB_Connection = new DB_Connection();
		
		Connection connection = obj_DB_Connection.get_Connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String query = "select * from user where s_no = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, s_no);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("s.no - " + rs.getInt("s_no"));
				System.out.println("First_Nmae - " + rs.getString("first_name"));
				System.out.println("Last_Name - " + rs.getString("last_name"));
				System.out.println("Email - " + rs.getString("email"));
				System.out.println("---------------------------------");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	public void update_data(int s_no, int new_s_no, String first_name, String last_name, String email) {
		
		DB_Connection obj_DB_Connection = new DB_Connection();
		
		Connection connection = obj_DB_Connection.get_Connection();
		
		PreparedStatement ps = null;
		
		try {
			String query = "update user set s_no = ?, first_name = ?, last_name = ?, email = ? where s_no = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, new_s_no);
			ps.setString(2, first_name);
			ps.setString(3, last_name);
			ps.setString(4, email);
			ps.setInt(5, s_no);
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	public void delete_data(int s_no) {
		
		DB_Connection obj_DB_Connection = new DB_Connection();
		
		Connection connection = obj_DB_Connection.get_Connection();
		
		PreparedStatement ps = null;
		
		try {
			String query = "delete from user where s_no = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, s_no);
			System.out.println(ps);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}
