package DAO;

import java.sql.*;
import java.util.*;
import BEAN.CATEGORY;

public class Get_Category_DAO {
	public static List<CATEGORY> DisplayCategory(Connection conn)
	{
		List<CATEGORY> list = new ArrayList<CATEGORY>();
		//List phia tren la mot Interface nen no phai su dung ArrayList de thuc thi Interface nay
		//Ban than cua List khong the  tao duoc doi tuong Account
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM CATEGORY;";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			while (rs.next()) 
			{
				CATEGORY cate = new CATEGORY(); //De trong vong lap de moi lan truy xuat tren dong deu gan vao 
				
				String IdC = rs.getString("Id_Category");
				String NameC = rs.getString("Name_Category");
				String DecriptionC = rs.getString("Decription_Category");
				
				cate.setId_Category(IdC);
				cate.setName_Category(NameC);
				cate.setDecription_Category(DecriptionC);

				list.add(cate);
				
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
	
	public static boolean Insert_Category(Connection conn, CATEGORY cate) {
		//Khoi tao doi tuong PreparedStament
		PreparedStatement ptmt = null;
		
		//Truyen truy van sql cho doi tuong PreparedStament
		String sql = "insert into CATEGORY(Id_Category,Name_Category,Decription_Category) values (?,?,?)";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			
			String id = cate.getId_Category();
			String name = cate.getName_Category();
			String dec = cate.getDecription_Category();
			
			ptmt.setString(1, id);
			ptmt.setString(2, name);
			ptmt.setString(3, dec);

			
			int kt = ptmt.executeUpdate();
			
			
			if (kt != 0) 
			{
				return true;
			}
			
			ptmt.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;

	}
	
	public static CATEGORY Choose_cate(Connection conn, String id) {
		CATEGORY ca = new CATEGORY();
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM CATEGORY WHERE Id_Category='"+id+"'";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				String IdC = rs.getString("Id_Category");
				String NameC = rs.getString("Name_Category");
				String DecriptionC = rs.getString("Decription_Category");
				
				ca.setId_Category(IdC);
				ca.setName_Category(NameC);
				ca.setDecription_Category(DecriptionC);			
			}		
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return ca;
	}
	
	public static int Update_Category(Connection conn, CATEGORY cate, String IdOld) {
		PreparedStatement ptmt = null;
		int check = 5;
		
		String Id = cate.getId_Category();
		String Name = cate.getName_Category();
		String Dec = cate.getDecription_Category();
		
		//String Old = new String(Id);
		
		String sql = "UPDATE CATEGORY SET Id_Category='"+Id+"',Name_Category='"+Name+"',Decription_Category='"+Dec+"' WHERE Id_Category='"+Id+"'";
		
		try 
		{
			//ptmt = conn.prepareStatement(sql);
			
			if (!Id.equals(IdOld)) 
			{
				check = 1;//Khong dc doi ten khoa chinh
			}
			else if(Id.length() > 5)
			{
				check = 2;//Id khong dc lon hon 5
			}
			else if(Name.length() > 30)
			{
				check = 3;//Ky tu ten khong qua 30
			}
			else if(Dec.length() > 50)
			{
				check = 4;//Dc khong dc lon hon 50
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
	
	public static boolean Delete_Category (Connection conn, String Id) {
		
		PreparedStatement ptmt = null;
		
		
		String sql = "DELETE FROM CATEGORY WHERE Id_Category='"+Id+"';";		
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			int rs = ptmt.executeUpdate();
			
			if(rs != 0) 
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
	
	
	public static List<CATEGORY> SearchCategory(Connection conn, String IdSe){
		List<CATEGORY> list = new ArrayList<CATEGORY>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT * FROM CATEGORY WHERE Id_Category LIKE '%"+IdSe+"%'";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				CATEGORY catego = new CATEGORY();
				
				
				String Id = rs.getString("Id_Category");
				String Name = rs.getString("Name_Category");
				String Dec = rs.getString("Decription_Category");
							
				//String x = date.toString();
				
				catego.setId_Category(Id);
				catego.setName_Category(Name);
				catego.setDecription_Category(Dec);

				list.add(catego);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
