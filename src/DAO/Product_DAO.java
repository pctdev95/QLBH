package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BEAN.PRODUCT;
import BEAN.PRODUCT_TYPE;

import java.sql.*;

public class Product_DAO {
	// Dropdown list CATEGORY trong trang Add PRODUCT TYPE
	public static List<PRODUCT_TYPE> DisplayDropdownProt(Connection conn){
		List<PRODUCT_TYPE> list = new ArrayList<PRODUCT_TYPE>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT * FROM PRODUCT_TYPE";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				PRODUCT_TYPE prot = new PRODUCT_TYPE();
				
				String Id = rs.getString("Id_Product_Type");
				String Name = rs.getString("Name_Product_Type");
				String Dec = rs.getString("Decription_Product_Type");
				String IdCate = rs.getString("Id_Category");
				
				prot.setId_Product_Type(Id);
				prot.setName_Product_Type(Name);
				prot.setDecription_Product_Type(Dec);
				prot.setId_Category(IdCate);
				
				list.add(prot);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static boolean Add_Product(Connection conn, PRODUCT pro) {
		PreparedStatement ptmt = null;

		
		
		String Idpro = pro.getId_Product();
		String name = pro.getName_Product();
		String cal = pro.getCalculation_Unit();
		String man = pro.getManufacturer();
		Date date = pro.getImport_Date();
		int impri = pro.getImport_Prices_Product();
		int expri =pro.getExport_Prices_Product();
		int inst = pro.getIn_Stock();
		String idprot = pro.getId_Product_Type();
		
		String sql = "INSERT INTO PRODUCT (Id_Product, Name_Product, Calculation_Unit, Manufacturer, Import_Date, Import_Prices_Product, Export_Prices_Product, In_Stock, Id_Product_Type) "
				+ "VALUES (?,?,?,?,?,?,?,?,?) ";
		
		
		try 
		{
			ptmt = conn.prepareStatement(sql);

			ptmt.setString(1,Idpro);
			ptmt.setString(2,name);
			ptmt.setString(3,cal);
			ptmt.setString(4,man);
			ptmt.setDate(5, date);
			ptmt.setInt(6,impri);
			ptmt.setInt(7,expri);
			ptmt.setInt(8,inst);
			ptmt.setString(9,idprot);
			
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
	
	
	public static List<PRODUCT> SearchProduct(Connection conn, String IdSe){
		List<PRODUCT> list = new ArrayList<PRODUCT>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT * FROM PRODUCT WHERE Id_Product LIKE '%"+IdSe+"%'";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				PRODUCT pro = new PRODUCT();
				
				String Id = rs.getString("Id_Product");
				String Name = rs.getString("Name_Product");
				String Cal = rs.getString("Calculation_Unit");
				String Man = rs.getString("Manufacturer");
				Date date = rs.getDate("Import_Date");
				int Impri = rs.getInt("Import_Prices_Product");
				int Expri = rs.getInt("Export_Prices_Product");
				int Inst = rs.getInt("In_Stock");
				String Idprot = rs.getString("Id_Product_Type");
				
				
				//String x = date.toString();
				
				pro.setId_Product(Id);
				pro.setName_Product(Name);
				pro.setCalculation_Unit(Cal);
				pro.setManufacturer(Man);
				pro.setImport_Date(date);
				pro.setImport_Prices_Product(Impri);
				pro.setExport_Prices_Product(Expri);
				pro.setIn_Stock(Inst);
				pro.setId_Product_Type(Idprot);

				
				list.add(pro);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static List<PRODUCT> DisplayProduct(Connection conn){
		List<PRODUCT> list = new ArrayList<PRODUCT>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT * FROM PRODUCT;";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				PRODUCT pro = new PRODUCT();
				
				String Id = rs.getString("Id_Product");
				String Name = rs.getString("Name_Product");
				String Cal = rs.getString("Calculation_Unit");
				String Man = rs.getString("Manufacturer");
				Date date = rs.getDate("Import_Date");
				int Impri = rs.getInt("Import_Prices_Product");
				int Expri = rs.getInt("Export_Prices_Product");
				int Inst = rs.getInt("In_Stock");
				String Idprot = rs.getString("Id_Product_Type");
				
				
				//String x = date.toString();
				
				pro.setId_Product(Id);
				pro.setName_Product(Name);
				pro.setCalculation_Unit(Cal);
				pro.setManufacturer(Man);
				pro.setImport_Date(date);
				pro.setImport_Prices_Product(Impri);
				pro.setExport_Prices_Product(Expri);
				pro.setIn_Stock(Inst);
				pro.setId_Product_Type(Idprot);

				
				list.add(pro);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public static PRODUCT Choose_Product(Connection conn, String id) {
		PRODUCT pro = new PRODUCT();
		
		PreparedStatement ptmt = null;
		
		String sql = "SELECT * FROM PRODUCT WHERE Id_Product='"+id+"'";
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			if(rs.next()) 
			{			
				String Id = rs.getString("Id_Product");
				String Name = rs.getString("Name_Product");
				String Cal = rs.getString("Calculation_Unit");
				String Man = rs.getString("Manufacturer");
				Date date = rs.getDate("Import_Date");
				int Impri = rs.getInt("Import_Prices_Product");
				int Expri = rs.getInt("Export_Prices_Product");
				int Inst = rs.getInt("In_Stock");
				String Idprot = rs.getString("Id_Product_Type");
				
				
				
				

				pro.setId_Product(Id);
				pro.setName_Product(Name);
				pro.setCalculation_Unit(Cal);
				pro.setManufacturer(Man);
				pro.setImport_Date(date);
				pro.setImport_Prices_Product(Impri);
				pro.setExport_Prices_Product(Expri);
				pro.setIn_Stock(Inst);
				pro.setId_Product_Type(Idprot);
				
			}		
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return pro;
	}
	
	
	public static int Update_Product(Connection conn, PRODUCT pro, String IdOld) {
		PreparedStatement ptmt = null;
		int check = 1;
		
		
		String Idpro = pro.getId_Product();
		String name = pro.getName_Product();
		String cal = pro.getCalculation_Unit();
		String man = pro.getManufacturer();
		Date date = pro.getImport_Date();
		int impri = pro.getImport_Prices_Product();
		int expri =pro.getExport_Prices_Product();
		int inst = pro.getIn_Stock();
		String idprot = pro.getId_Product_Type();
		
		
		//String Old = new String(Id);
		
		
		String sql = "UPDATE PRODUCT SET Id_Product='"+Idpro+"',Name_Product='"+name+"',Calculation_Unit='"+cal+"',Manufacturer='"+man+"',Import_Date='"+date+"',"
				+ "Import_Prices_Product='"+impri+"',Export_Prices_Product='"+expri+"',In_Stock='"+inst+"',Id_Product_Type='"+idprot+"' "
				+ "WHERE Id_Product='"+IdOld+"';";
		
		try 
		{
			//ptmt = conn.prepareStatement(sql);
			
			if (!Idpro.equals(IdOld)) 
			{
				check = 1;//Khong dc doi ten khoa chinh
			}
			else if(name.length() > 30)
			{
				check = 2;//ten khong dc lon hon 30
			}
			else if(cal.length() > 20)
			{
				check = 3;//DVT khong dc lon hon 30
			}
			else if(name.length() == 0 | cal.length()== 0 | man.length() == 0 | date.toString().length() == 0 | impri == 0 | expri == 0 | inst == 0)
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
	
	
	
	public static boolean Delete_Product(Connection conn, String Id) {
		
		PreparedStatement ptmt1 = null;
		
		
		String sql = "DELETE FROM PRODUCT WHERE Id_Product='"+Id+"';";		

		
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
	
	public static List<PRODUCT> SearchProduct_Prot(Connection conn, String IdSe){
		List<PRODUCT> list = new ArrayList<PRODUCT>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT * FROM PRODUCT WHERE Id_Product_Type LIKE '%"+IdSe+"%'";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				PRODUCT pro = new PRODUCT();
				
				String Id = rs.getString("Id_Product");
				String Name = rs.getString("Name_Product");
				String Cal = rs.getString("Calculation_Unit");
				String Man = rs.getString("Manufacturer");
				Date date = rs.getDate("Import_Date");
				int Impri = rs.getInt("Import_Prices_Product");
				int Expri = rs.getInt("Export_Prices_Product");
				int Inst = rs.getInt("In_Stock");
				String Idprot = rs.getString("Id_Product_Type");
				
				
				//String x = date.toString();
				
				pro.setId_Product(Id);
				pro.setName_Product(Name);
				pro.setCalculation_Unit(Cal);
				pro.setManufacturer(Man);
				pro.setImport_Date(date);
				pro.setImport_Prices_Product(Impri);
				pro.setExport_Prices_Product(Expri);
				pro.setIn_Stock(Inst);
				pro.setId_Product_Type(Idprot);

				
				list.add(pro);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static List<PRODUCT> SearchProduct_Cate(Connection conn, String IdSe){
		List<PRODUCT> list = new ArrayList<PRODUCT>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT *"
					+ " FROM product p"
					+ " INNER JOIN product_type pt ON pt.Id_Product_Type = p.Id_Product_Type"
					+ " INNER JOIN category c ON c.Id_Category = pt.Id_Category"
					+ " WHERE c.Id_Category='"+IdSe+"';";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				PRODUCT pro = new PRODUCT();
				
				String Id = rs.getString("Id_Product");
				String Name = rs.getString("Name_Product");
				String Cal = rs.getString("Calculation_Unit");
				String Man = rs.getString("Manufacturer");
				Date date = rs.getDate("Import_Date");
				int Impri = rs.getInt("Import_Prices_Product");
				int Expri = rs.getInt("Export_Prices_Product");
				int Inst = rs.getInt("In_Stock");
				String Idprot = rs.getString("p.Id_Product_Type");
				
				
				//String x = date.toString();
				
				pro.setId_Product(Id);
				pro.setName_Product(Name);
				pro.setCalculation_Unit(Cal);
				pro.setManufacturer(Man);
				pro.setImport_Date(date);
				pro.setImport_Prices_Product(Impri);
				pro.setExport_Prices_Product(Expri);
				pro.setIn_Stock(Inst);
				pro.setId_Product_Type(Idprot);

				
				list.add(pro);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static List<PRODUCT> SearchProduct_Prot_Cate(Connection conn, String IdProt, String IdCate){
		List<PRODUCT> list = new ArrayList<PRODUCT>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT *"
					+ " FROM product p"
					+ " INNER JOIN product_type pt ON pt.Id_Product_Type = p.Id_Product_Type"
					+ " INNER JOIN category c ON c.Id_Category = pt.Id_Category"
					+ " WHERE c.Id_Category='"+IdProt+"'"
					+ " AND pt.Id_Product_Type='"+IdCate+"';";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				PRODUCT pro = new PRODUCT();
				
				String Id = rs.getString("Id_Product");
				String Name = rs.getString("Name_Product");
				String Cal = rs.getString("Calculation_Unit");
				String Man = rs.getString("Manufacturer");
				Date date = rs.getDate("Import_Date");
				int Impri = rs.getInt("Import_Prices_Product");
				int Expri = rs.getInt("Export_Prices_Product");
				int Inst = rs.getInt("In_Stock");
				String Idprot = rs.getString("p.Id_Product_Type");
				
				
				//String x = date.toString();
				
				pro.setId_Product(Id);
				pro.setName_Product(Name);
				pro.setCalculation_Unit(Cal);
				pro.setManufacturer(Man);
				pro.setImport_Date(date);
				pro.setImport_Prices_Product(Impri);
				pro.setExport_Prices_Product(Expri);
				pro.setIn_Stock(Inst);
				pro.setId_Product_Type(Idprot);

				
				list.add(pro);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
}
