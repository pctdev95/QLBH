package DAO;

import java.sql.*;
import java.util.*;
import BEAN.PRODUCT_TYPE;
import BEAN.CATEGORY;

public class Product_Type_DAO {

	// Dropdown list CATEGORY trong trang Add PRODUCT TYPE
	public static List<CATEGORY> DisplayDropdownCategory(Connection conn){
		List<CATEGORY> list = new ArrayList<CATEGORY>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT * FROM CATEGORY";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				CATEGORY cate = new CATEGORY();
				
				String Id = rs.getString("Id_Category");
				String Name = rs.getString("Name_Category");
				String Dec = rs.getString("Decription_Category");
				
				cate.setId_Category(Id);
				cate.setName_Category(Name);
				cate.setDecription_Category(Dec);
				
				list.add(cate);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public static List<PRODUCT_TYPE> SearchProductType(Connection conn, String Id)
	{
		List<PRODUCT_TYPE> list = new ArrayList<PRODUCT_TYPE>();
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM PRODUCT_TYPE WHERE Id_Product_Type LIKE '%"+Id+"%'";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			while (rs.next()) 
			{
				PRODUCT_TYPE prot = new PRODUCT_TYPE(); //De trong vong lap de moi lan truy xuat tren dong deu gan vao 
				
				String IdPT = rs.getString("Id_Product_Type");
				String NamePT = rs.getString("Name_Product_Type");
				String DecriptionPT = rs.getString("Decription_Product_Type");
				String IdCate = rs.getString("Id_Category");
				
				prot.setId_Product_Type(IdPT);
				prot.setName_Product_Type(NamePT);
				prot.setDecription_Product_Type(DecriptionPT);
				prot.setId_Category(IdCate);
				

				list.add(prot);
				
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
	
	
	
	
	
	//Display bang loai san pham 
	public static List<PRODUCT_TYPE> DisplayProductType(Connection conn)
	{
		List<PRODUCT_TYPE> list = new ArrayList<PRODUCT_TYPE>();
		//List phia tren la mot Interface nen no phai su dung ArrayList de thuc thi Interface nay
		//Ban than cua List khong the  tao duoc doi tuong Account
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM PRODUCT_TYPE";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			while (rs.next()) 
			{
				PRODUCT_TYPE prot = new PRODUCT_TYPE(); //De trong vong lap de moi lan truy xuat tren dong deu gan vao 
				
				String IdPT = rs.getString("Id_Product_Type");
				String NamePT = rs.getString("Name_Product_Type");
				String DecriptionPT = rs.getString("Decription_Product_Type");
				String IdCate = rs.getString("Id_Category");
				
				prot.setId_Product_Type(IdPT);
				prot.setName_Product_Type(NamePT);
				prot.setDecription_Product_Type(DecriptionPT);
				prot.setId_Category(IdCate);
				

				list.add(prot);
				
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
	
	public static boolean Insert_Product_Type(Connection conn, PRODUCT_TYPE prot) {
		//Khoi tao doi tuong PreparedStament
		PreparedStatement ptmt = null;
		
		//Truyen truy van sql cho doi tuong PreparedStament
		String sql = "INSERT INTO PRODUCT_TYPE(Id_Product_Type,Name_Product_Type,Decription_Product_Type,Id_Category) VALUES (?,?,?,?)";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			
			String idPT = prot.getId_Product_Type();
			String namePT = prot.getName_Product_Type();
			String decPT = prot.getDecription_Product_Type();
			String idCate = prot.getId_Category();
			
			ptmt.setString(1, idPT);
			ptmt.setString(2, namePT);
			ptmt.setString(3, decPT);
			ptmt.setString(4, idCate);
			
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
	
	public static PRODUCT_TYPE Choose_Product_Type(Connection conn, String id) {
		PRODUCT_TYPE prot = new PRODUCT_TYPE();
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM PRODUCT_TYPE WHERE Id_Product_Type='"+id+"'";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				String IdPT = rs.getString("Id_Product_Type");
				String NamePT = rs.getString("Name_Product_Type");
				String DecriptionPT = rs.getString("Decription_Product_Type");
				String IdCate = rs.getString("Id_Category");
				
				prot.setId_Product_Type(IdPT);
				prot.setName_Product_Type(NamePT);
				prot.setDecription_Product_Type(DecriptionPT);
				prot.setId_Category(IdCate);
				
			}		
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return prot;
	}
	
	public static int Update_Product_Type(Connection conn, PRODUCT_TYPE prot, String IdOld) {
		PreparedStatement ptmt = null;
		int check = 5;
		
		String Id = prot.getId_Product_Type();
		String Name = prot.getName_Product_Type();
		String Dec = prot.getDecription_Product_Type();
		String IdCate= prot.getId_Category();
		
		//String Old = new String(Id);
		
		String sql = "UPDATE PRODUCT_TYPE SET Id_Product_Type='"+Id+"',Name_Product_Type='"+Name+"',Decription_Product_Type='"+Dec+"',Id_Category='"+IdCate+"' WHERE Id_Product_Type='"+Id+"'";
		
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
	
	public static boolean Delete_Product_Type (Connection conn, String Id) {
		
		PreparedStatement ptmt = null;
		
		
		String sql = "DELETE FROM PRODUCT_TYPE WHERE Id_Product_Type='"+Id+"';";		
		
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
	
}
