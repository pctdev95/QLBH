package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BEAN.EMPLOYEE;

public class Employee_DAO {
	public static boolean Add_Employee(Connection conn, EMPLOYEE emp) {
		PreparedStatement ptmt0 = null;
		PreparedStatement ptmt1 = null;
		
		String IdEmp = emp.getId_Employee();
		String Fname = emp.getFirst_Name();
		String Lname = emp.getLast_Name_Employee();
		boolean Gende = emp.isGender_Employee();
		String DOBEm = emp.getDOB_Employee();
		String CardE = emp.getId_Card_Employee();
		String Addre = emp.getAddress_Employee();
		String Phone = emp.getPhone_Employee();
		String Depar = emp.getDepartment_Employee();
		int Salar = emp.getSalary_Employee();
		String Accou = emp.getAccount_User();
		String Passw = emp.getPassword_User();
		
		String Gen = "1";
		String i = "1";
		String j = Integer.toString(Salar);
		
		if(Gende == true)
		{
			Gen = "1";
		}
		else
		{
			Gen = "0";
		}

		String sqlAcc = "INSERT INTO USERS(Account_User, Password_User, Id_Group_User) VALUES(?,?,?)";
		
		String sqlEmp = "INSERT INTO EMPLOYEE(Id_Employee, First_Name_Employee, Last_Name_Employee, Gender_Employee,"
				+ " DOB_Employee, Id_Card_Employee, Address_Employee, Phone_Employee, Department_Employee, Salary_Employee, Account_User) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try 
		{
			ptmt0 = conn.prepareStatement(sqlAcc);
			ptmt1 = conn.prepareStatement(sqlEmp);
			
			ptmt0.setString(1,Accou);
			ptmt0.setString(2,Passw);
			ptmt0.setString(3, i);
			
			ptmt1.setString(1,IdEmp);
			ptmt1.setString(2,Fname);
			ptmt1.setString(3,Lname);
			ptmt1.setString(4,Gen);
			ptmt1.setString(5,DOBEm);
			ptmt1.setString(6,CardE);
			ptmt1.setString(7,Addre);
			ptmt1.setString(8,Phone);
			ptmt1.setString(9,Depar);
			ptmt1.setString(10,j);
			ptmt1.setString(11,Accou);

			
			
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
	
	public static List<EMPLOYEE> DisplayEmployee(Connection conn){
		List<EMPLOYEE> list = new ArrayList<EMPLOYEE>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT * FROM EMPLOYEE;";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				EMPLOYEE Emp = new EMPLOYEE();
				
				String Id = rs.getString("Id_Employee");
				String FName = rs.getString("First_Name_Employee");
				String LName = rs.getString("Last_Name_Employee");
				boolean Gend = rs.getBoolean("Gender_Employee");
				String DOBEmp = rs.getString("DOB_Employee");
				//Date date = rs.getDate("DOB_Employee");
				String IdCard = rs.getString("Id_Card_Employee");
				String Address = rs.getString("Address_Employee");
				String Phone = rs.getString("Phone_Employee");
				String Deprat = rs.getString("Department_Employee");
				int Salar = rs.getInt("Salary_Employee");
				String Acc = rs.getString("Account_User");
				
				
				//String x = date.toString();
				

				Emp.setId_Employee(Id);
				Emp.setFirst_Name(FName);
				Emp.setLast_Name_Employee(LName);
				Emp.setGender_Employee(Gend);
				Emp.setDOB_Employee(DOBEmp);
				Emp.setId_Card_Employee(IdCard);
				Emp.setAddress_Employee(Address);
				Emp.setPhone_Employee(Phone);
				Emp.setDepartment_Employee(Deprat);
				Emp.setSalary_Employee(Salar);
				Emp.setAccount_User(Acc);
				
				list.add(Emp);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static List<EMPLOYEE> SearchEmployee(Connection conn, String Id)
	{
		List<EMPLOYEE> list = new ArrayList<EMPLOYEE>();
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM EMPLOYEE WHERE Id_Employee LIKE '%"+Id+"%'";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			try 
			{
				
				while (rs.next()) 
				{	
					EMPLOYEE Emp = new EMPLOYEE();
					
					String IdEmp = rs.getString("Id_Employee");
					String FName = rs.getString("First_Name_Employee");
					String LName = rs.getString("Last_Name_Employee");
					boolean Gend = rs.getBoolean("Gender_Employee");
					String DOBEmp = rs.getString("DOB_Employee");
					String IdCard = rs.getString("Id_Card_Employee");
					String Address = rs.getString("Address_Employee");
					String Phone = rs.getString("Phone_Employee");
					String Deprat = rs.getString("Department_Employee");
					int Salar = rs.getInt("Salary_Employee");
					String Acc = rs.getString("Account_User");
					
					
					

					Emp.setId_Employee(IdEmp);
					Emp.setFirst_Name(FName);
					Emp.setLast_Name_Employee(LName);
					Emp.setGender_Employee(Gend);
					Emp.setDOB_Employee(DOBEmp);
					Emp.setId_Card_Employee(IdCard);
					Emp.setAddress_Employee(Address);
					Emp.setPhone_Employee(Phone);
					Emp.setDepartment_Employee(Deprat);
					Emp.setSalary_Employee(Salar);
					Emp.setAccount_User(Acc);
					
					list.add(Emp);
					
					
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static EMPLOYEE Choose_Product_Type(Connection conn, String id) {
		EMPLOYEE Emp = new EMPLOYEE();
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM EMPLOYEE WHERE Id_Employee='"+id+"'";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				String IdEmp = rs.getString("Id_Employee");
				String FName = rs.getString("First_Name_Employee");
				String LName = rs.getString("Last_Name_Employee");
				boolean Gend = rs.getBoolean("Gender_Employee");
				String DOBEmp = rs.getString("DOB_Employee");
				String IdCard = rs.getString("Id_Card_Employee");
				String Address = rs.getString("Address_Employee");
				String Phone = rs.getString("Phone_Employee");
				String Deprat = rs.getString("Department_Employee");
				int Salar = rs.getInt("Salary_Employee");
				String Acc = rs.getString("Account_User");
				
				
				
				

				Emp.setId_Employee(IdEmp);
				Emp.setFirst_Name(FName);
				Emp.setLast_Name_Employee(LName);
				Emp.setGender_Employee(Gend);
				Emp.setDOB_Employee(DOBEmp);
				Emp.setId_Card_Employee(IdCard);
				Emp.setAddress_Employee(Address);
				Emp.setPhone_Employee(Phone);
				Emp.setDepartment_Employee(Deprat);
				Emp.setSalary_Employee(Salar);
				Emp.setAccount_User(Acc);
				
			}		
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return Emp;
	}
	
	public static int Update_Employee(Connection conn, EMPLOYEE Emp, String IdOld) {
		PreparedStatement ptmt = null;
		int check = 1;
		
		
		String Id = Emp.getId_Employee();
		String Fname = Emp.getFirst_Name();
		String Lname = Emp.getLast_Name_Employee();
		boolean Gend = Emp.isGender_Employee();
		String DOB = Emp.getDOB_Employee();
		String Idcard = Emp.getId_Card_Employee();
		String Addre = Emp.getAddress_Employee();
		String Phone = Emp.getPhone_Employee();
		String Depar = Emp.getDepartment_Employee();
		int Salar = Emp.getSalary_Employee();
		String Acco = Emp.getAccount_User();
		
		int gen = 1;
		if (Gend) 
		{
			gen = 1;
		} 
		else 
		{
			gen = 0;
		}
		
		//String Old = new String(Id);
		
		
		String sql = "UPDATE EMPLOYEE SET Id_Employee='"+Id+"', First_Name_Employee='"+Fname+"', Last_Name_Employee='"+Lname+"', Gender_Employee='"+gen+"',"
				+ " DOB_Employee='"+DOB+"', Id_Card_Employee='"+Idcard+"', Address_Employee='"+Addre+"', Phone_Employee='"+Phone+"', Department_Employee='"+Depar+"', Salary_Employee='"+Salar+"', Account_User='"+Acco+"' "
						+ "WHERE Id_Employee='"+IdOld+"'";
		
		try 
		{
			//ptmt = conn.prepareStatement(sql);
			
			if (!Id.equals(IdOld)) 
			{
				check = 1;//Khong dc doi ten khoa chinh
			}
			else if(Fname.length() > 30)
			{
				check = 2;//ten khong dc lon hon 30
			}
			else if(Lname.length() > 30)
			{
				check = 3;//Ho khong dc lon hon 30
			}
			else if(Fname.length() == 0 | Lname.length()== 0 | DOB.length() == 0 | Idcard.length() == 0 | Addre.length() == 0 | Phone.length() == 0 | Depar.length() == 0 | Salar == 0 | Acco.length() == 0)
			{
				check = 4;//Khong duoc de trong
			}
			else 
			{
				check = 0;
				ptmt = conn.prepareStatement(sql);
				ptmt.execute();
				ptmt.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return check;
	}
	
	public static boolean Delete_Employee(Connection conn, String Id) {
		
		PreparedStatement ptmt1 = null;
		
		
		String sql = "DELETE FROM EMPLOYEE WHERE Id_Employee='"+Id+"';";		

		
		try 
		{
			ptmt1 = conn.prepareStatement(sql);
			
			
			int rs = ptmt1.executeUpdate();//Thuc thi xoa Employee

			
			if(rs != 0) 
			{
				return true;
			}

			ptmt1.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
