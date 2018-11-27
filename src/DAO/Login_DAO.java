package DAO;

import java.sql.*;

public class Login_DAO {
	public static boolean CheckUser(Connection conn, String name, String password) {	
		boolean check = false;
		
		PreparedStatement ptmt = null;
		String sql = "SELECT Account_User, Password_User FROM USERS WHERE Account_User = '"+name+"'";

		try 
		{
			ptmt = conn.prepareStatement(sql);			
			ResultSet rs = ptmt.executeQuery();

			if(rs.next()) //Tim thay tai khoan trong CSDL
			{
				
				String uname = rs.getString("Account_User");
				String pass = rs.getString("Password_User");
				//int i = Integer.parseInt(Id);
				
				if (name.equals(uname) && password.equals(pass))  //Dung tai khoan va mat khau
				{
					check =  true;
				}
				else
				{
					check = false;
				}
			}
			else //Tai khoan khong ton tai
			{
				check = false;
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return check;
	}
	
	public static int CheckGroup(Connection conn, String name) {	
		int Id_Group_User = 3;
		
		PreparedStatement ptmt = null;
		String sql = "SELECT Id_Group_User FROM USERS WHERE Account_User = '"+name+"'";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);			
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) //Neu co quyen user
			{
				String Id = rs.getString("Id_Group_User");
				int i = Integer.parseInt(Id);
				
				if (i == 0) //Neu la quyen Admin
				{
					Id_Group_User = 0;
				}
				else if(i == 1) //Neu la quyen Employee
					{
						Id_Group_User = 1;
					}
					else if(i == 2) //Neu la quyen Customer
						{
							Id_Group_User = 2;
						}
						else if(i != 0 && i !=1 && i != 2 ) //Neu khac cac quyen trong CSDL
						{
							Id_Group_User = 3;
						}
			}
			else // Khong ton tai quyen user
			{
				Id_Group_User = 3;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		
		
		return Id_Group_User;
	}
	
	public static String getSessionNameAdmin(Connection conn, String name) {
		String SessionName = "";
		
		PreparedStatement ptmt = null;
		String sqlAdmin = "SELECT Account_User FROM ADMIN WHERE Account_User = '"+name+"'";
	
		try 
		{
			ptmt = conn.prepareStatement(sqlAdmin);			
			ResultSet rs = ptmt.executeQuery();
			
			if(rs.next()) 
			{
				SessionName = rs.getString("Account_User");
			}
			else 
			{
				SessionName = "Null";
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return SessionName;
	}
	
	public static String getSessionNameEmployee(Connection conn, String name) {
		String SessionName = "";
		
		PreparedStatement ptmt = null;

		String sqlEmp = "SELECT Account_User FROM EMPLOYEE WHERE Account_User = '"+name+"'";
		
		try 
		{
			ptmt = conn.prepareStatement(sqlEmp);			
			ResultSet rs = ptmt.executeQuery();
			
			if(rs.next()) 
			{
				SessionName = rs.getString("Account_User");
			}
			else 
			{
				SessionName = "Null";
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return SessionName;
	}
	
	public static String getSessionNameCustomer(Connection conn, String name) {
		String SessionName = "";
		
		PreparedStatement ptmt = null;
		
		String sqlCus = "SELECT Account_User FROM CUSTOMER WHERE Account_User = '"+name+"'";
		
		try 
		{
			ptmt = conn.prepareStatement(sqlCus);			
			ResultSet rs = ptmt.executeQuery();
			
			if(rs.next()) 
			{
				SessionName = rs.getString("Account_User");
			}
			else 
			{
				SessionName = "Null";
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return SessionName;
	}
}
