package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import BEAN.CUSTOMER;

public class Customer_DAO {
	
	public static int Choose_Max_Id_Customer(Connection conn) {
		PreparedStatement ptmt = null;
		
		int i = 0;
		
		String sql = "SELECT MAX(Id_Customer) AS LastId FROM CUSTOMER;";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				 i = rs.getInt("LastId");
			}		
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
				
		return i;
	}
	
	public static boolean Add_Customer(Connection conn, CUSTOMER cus) {
		PreparedStatement ptmt0 = null;
		PreparedStatement ptmt1 = null;
		
		int IdCus = cus.getId_Customer();
		String Fname = cus.getFirst_Name_Customer();
		String Lname = cus.getLast_Name_Customer();
		boolean Gende = cus.isGender_Customer();
		Date DOBEm = cus.getDOB_Customer();
		String CardE = cus.getId_Card_Customer();
		String Addre = cus.getAddress_Customer();
		String Phone = cus.getPhone_Customer();
		int Point = cus.getPoints();
		String Accou = cus.getAccount_User();
		String Passw = cus.getPassword_User();
		
		/*String Gen = "1"; //Gender*/		
		String GroupUser = "2"; //Group user
		
		/*Ep kieu gioi tinh*/
		/*if(Gende == true)
		{
			Gen = "1";
		}
		else
		{
			Gen = "0";
		}*/

		String sqlAcc = "INSERT INTO USERS(Account_User, Password_User, Id_Group_User) VALUES(?,?,?)";
		
		String sqlCus = "INSERT INTO CUSTOMER(Id_Customer,First_Name_Customer,Last_Name_Customer,Gender_Customer,DOB_Customer,Id_Card_Customer,Address_Customer,Phone_Customer,Points,Account_User) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";

		
		try 
		{
			ptmt0 = conn.prepareStatement(sqlAcc);
			ptmt1 = conn.prepareStatement(sqlCus);
			
			ptmt0.setString(1,Accou);
			ptmt0.setString(2,Passw);
			ptmt0.setString(3,GroupUser);
			
			ptmt1.setInt(1,IdCus);
			ptmt1.setString(2,Fname);
			ptmt1.setString(3,Lname);
			ptmt1.setBoolean(4,Gende);
			ptmt1.setDate(5,DOBEm);
			ptmt1.setString(6,CardE);
			ptmt1.setString(7,Addre);
			ptmt1.setString(8,Phone);
			ptmt1.setInt(9,Point);
			ptmt1.setString(10,Accou);

			
			
			int kt0 = ptmt0.executeUpdate();
			
			int kt1 = ptmt1.executeUpdate();
			
			if (kt0 != 0 && kt1 != 0) 
			{
				return true;
			}
			
			ptmt0.close();
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public static CUSTOMER Choose_Customer(Connection conn, String id) {
		CUSTOMER cus = new CUSTOMER();
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM CUSTOMER WHERE Id_Customer='"+id+"'";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				int IdCus = rs.getInt("Id_Customer");
				String Fname = rs.getString("First_Name_Customer");
				String Lname = rs.getString("Last_Name_Customer");
				boolean Gende = rs.getBoolean("Gender_Customer");
				Date DOBEm = rs.getDate("DOB_Customer");
				String CardE = rs.getString("Id_Card_Customer");
				String Addre = rs.getString("Address_Customer");
				String Phone = rs.getString("Phone_Customer");
				int Point = rs.getInt("Points");
				String Accou = rs.getString("Account_User");

				cus.setId_Customer(IdCus);
				cus.setFirst_Name_Customer(Fname);
				cus.setLast_Name_Customer(Lname);
				cus.setGender_Customer(Gende);
				cus.setDOB_Customer(DOBEm);
				cus.setId_Card_Customer(CardE);
				cus.setAddress_Customer(Addre);
				cus.setPhone_Customer(Phone);
				cus.setPoints(Point);
				cus.setAccount_User(Accou);
			
			}		
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cus;
	}
}
