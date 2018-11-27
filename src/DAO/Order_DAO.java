package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BEAN.CUSTOMER;
import BEAN.ORDER;

public class Order_DAO {
	
	public static Date getDate(Connection conn) {
		Date sysdate = null;
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT CURDATE() AS systemdate;";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				sysdate = rs.getDate("systemdate");
			}		
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return sysdate;
	}
	
	public static int maxIdOrder(Connection conn) {
		int maxId = 0;
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT MAX(Id_Order) AS IdOrder FROM ORDERS;";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				maxId = rs.getInt("IdOrder");
			}		
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return maxId;
	}
	
	
	public static String chooseIdEmployee(Connection conn, String Acc) {
		String IdEmp = null;
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT Id_Employee AS id FROM EMPLOYEE WHERE Account_User='"+Acc+"';";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				IdEmp = rs.getString("id");

			}		
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return IdEmp;
	}
	
	
	public static CUSTOMER chooseCustomer(Connection conn, String Id) {
		CUSTOMER cus = new CUSTOMER();
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM CUSTOMER WHERE Id_Customer='"+Id+"';";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				int IdCus = rs.getInt("Id_Customer");
				String FName = rs.getString("First_Name_Customer");
				String LName = rs.getString("Last_Name_Customer");
				boolean Gend = rs.getBoolean("Gender_Customer");
				Date DOB = rs.getDate("DOB_Customer");
				String IdCard = rs.getString("Id_Card_Customer");
				String Address = rs.getString("Address_Customer");
				String Phone = rs.getString("Phone_Customer");
				int Point = rs.getInt("Points");
				String Acc = rs.getString("Account_User");
				
				cus.setId_Customer(IdCus);
				cus.setFirst_Name_Customer(FName);
				cus.setLast_Name_Customer(LName);
				cus.setGender_Customer(Gend);
				cus.setDOB_Customer(DOB);
				cus.setId_Card_Customer(IdCard);
				cus.setAddress_Customer(Address);
				cus.setPhone_Customer(Phone);
				cus.setPoints(Point);
				cus.setAccount_User(Acc);

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
	
	public static boolean Add_Order(Connection conn, ORDER order ) {
		PreparedStatement ptmt = null;

	
	    
		int idOder = order.getId_Order();
		Date sysdate = order.getOrder_Date();
		int SumAmount = order.getSum_Amount_Order();
		int SumPoint = order.getSum_Point();
		String IdCus = order.getId_Customer();
		String IdEmp = order.getId_Employee();


		
		String sql = "INSERT INTO ORDERS (Id_Order, Order_Date, Sum_Amount_Order, Sum_Point, Id_Customer, Id_Employee) "
				+ "VALUES (?,?,?,?,?,?) ";
		
		
		try 
		{
			ptmt = conn.prepareStatement(sql);

			ptmt.setInt(1,idOder);
			ptmt.setDate(2,sysdate);
			ptmt.setInt(3,SumAmount);
			ptmt.setInt(4,SumPoint);
			ptmt.setString(5,IdCus);
			ptmt.setString(6,IdEmp);
			
			int kt = ptmt.executeUpdate();
			
			if (kt != 0) 
			{
				return true;
			}
			
			ptmt.close();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return false;
	}
}
