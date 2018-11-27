package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import BEAN.BILL;
import BEAN.ORDER_DETAIL;
import BEAN.PRODUCT;

public class OrderDetail_DAO {
	
	//Lay ra thong tin san pham
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
	
	//Them san pham vao chi tiet hoa don
	public static boolean Add_Order_Detail(Connection conn, ORDER_DETAIL od) {
		PreparedStatement ptmt = null;

		
		
		int quan = od.getQuantity();
		int suma = od.getSum_Amount_Order_Detail();
		String idpro = od.getId_Product();
		int idod = od.getId_Order();
		
		String sql = "INSERT INTO order_detail (Quantity,Sum_Amount_Order_Detail,Id_Product,Id_Order) "
				+ "VALUES (?,?,?,?);";
		
		
		try 
		{
			ptmt = conn.prepareStatement(sql);

			ptmt.setInt(1,quan);
			ptmt.setInt(2,suma);
			ptmt.setString(3,idpro);
			ptmt.setInt(4,idod);
			
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
	
	
	public static List<ORDER_DETAIL> DisplayOrderDetail(Connection conn, int Idod){
		List<ORDER_DETAIL> list = new ArrayList<ORDER_DETAIL>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT * FROM order_detail WHERE Id_Order='"+Idod+"';";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				ORDER_DETAIL odd = new ORDER_DETAIL();
				
				int stt = rs.getInt("Id_Order_Detail");
				int sl = rs.getInt("Quantity");
				int sum = rs.getInt("Sum_Amount_Order_Detail");
				String idpro = rs.getString("Id_Product");
				int idodr = rs.getInt("Id_Order");

				odd.setId_Order_Detail(stt);
				odd.setQuantity(sl);
				odd.setSum_Amount_Order_Detail(sum);
				odd.setId_Product(idpro);
				odd.setId_Order(idodr);
							
				list.add(odd);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	//Tra ve danh sach chi tiet hoa don
	public static List<BILL> DisplayBill(Connection conn, int Idod){
		List<BILL> list = new ArrayList<BILL>();
		
		PreparedStatement ptmt = null;
		String sql = "SELECT Id_Order_Detail, Name_Product, Calculation_Unit, Export_Prices_Product, Quantity, Sum_Amount_Order_Detail "
				+ "FROM PRODUCT, ORDER_DETAIL "
				+ "WHERE PRODUCT.Id_Product = ORDER_DETAIL.Id_Product "
				+ "AND ORDER_DETAIL.Id_Order='"+Idod+"';";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				
				BILL bill = new BILL();
				
				int i = rs.getInt("Id_Order_Detail");
				String namepro = rs.getString("Name_Product");
				String calcu = rs.getString("Calculation_Unit");
				int expri = rs.getInt("Export_Prices_Product");
				int quanti = rs.getInt("Quantity");
				int sum = rs.getInt("Sum_Amount_Order_Detail");
				
				bill.setStt(i);
				bill.setName_Product(namepro);
				bill.setCalculation_Unit(calcu);
				bill.setExport_Prices_Product(expri);
				bill.setQuantity(quanti);
				bill.setSum_Amount_Order_Detail(sum);

				list.add(bill);
					
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	

	//Hien thi tong tien cua hoa don
	public static int DisplaySumOrder(Connection conn, int Idod){
		int total = 0;
		
		PreparedStatement ptmt = null;
		String sql = "SELECT SUM(Sum_Amount_Order_Detail) as total FROM order_detail WHERE order_detail.Id_Order="+Idod;
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			if (rs.next()) 
			{
				total = rs.getInt("total");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	//Lay ra ngay he thong
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
	
	//Cap nhat lai tong tien cua cua hoa don
	public static boolean UpdateTotalOrder(Connection conn, int IdOrder, int total){
		boolean checkUpdate = false;
		
		String sqlUpdateTotal = "UPDATE ORDERS SET Sum_Amount_Order='"+total+"' WHERE Id_Order='"+IdOrder+"'";
		
		PreparedStatement ptmt = null;	
		try 
		{		
				
			ptmt = conn.prepareStatement(sqlUpdateTotal);
			int check = ptmt.executeUpdate();
			
			if (check != 0) 
			{
				checkUpdate = true;
			}
			ptmt.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		return checkUpdate;
		
	}
	
	//Cap nhat lai So luong hang trong kho khi ad san pham vao CTHD
	public static boolean UpdateQuantityInStock(Connection conn, String IdProduct, int QuantityDiscount){
		
		
		PreparedStatement ptmtSelectQuantity = null;
		PreparedStatement ptmtUpdateQuantity = null;
		
		try 
		{							
			
			String sqlInStock = "SELECT In_Stock AS inStock FROM PRODUCT WHERE Id_Product='"+IdProduct+"'";
			
			ptmtSelectQuantity = conn.prepareStatement(sqlInStock);
			ResultSet rs = ptmtSelectQuantity.executeQuery();
			
			
			if (rs.next()) 
			{
				int InStock = rs.getInt("inStock"); // So luong san pham trong kho	
				
				int UpdateInStock = InStock - QuantityDiscount;//Tru so luong san pham trong kho
						
				String sqlUpdateInStock = "UPDATE PRODUCT SET In_Stock='"+UpdateInStock+"' WHERE Id_Product='"+IdProduct+"'";
				
				ptmtUpdateQuantity = conn.prepareStatement(sqlUpdateInStock);
				int check = ptmtUpdateQuantity.executeUpdate();
				if (check != 0) 
				{
					return true;
				}
			}
		
			ptmtSelectQuantity.close();
			ptmtUpdateQuantity.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
				
		return false;
		
	}
	
	//accumulate points
	//Tich luy diem vao Point cua khach hang && Update Sum_Point cua Order
	public static boolean AccumulatePoints(Connection conn, String IdCusomer, int OrderTotal, int IdOrder){
		
		
		PreparedStatement ptmtSelectPoint = null;
		PreparedStatement ptmtUpdatePoint = null;
		PreparedStatement ptmtUpdateOrderPoint = null;
		
		try 
		{							
			
			String sqlInStock = "SELECT Points AS Point FROM CUSTOMER WHERE Id_Customer='"+IdCusomer+"'";
			
			ptmtSelectPoint = conn.prepareStatement(sqlInStock);
			ResultSet rs = ptmtSelectPoint.executeQuery();
			
			
			if (rs.next()) 
			{
				int Point = rs.getInt("Point"); // So diem hien tai
				
				//int PlusPoint = 0;
				float i = Math.round(OrderTotal / 10000); // So diem tich luy tu khi thanh toan hoa don
				
				int PlusPoint = (int) i;
				
				int UpdatePoint = Point + PlusPoint;
						
				String sqlUpdateInStock = "UPDATE CUSTOMER SET Points='"+UpdatePoint+"' WHERE Id_Customer='"+IdCusomer+"'";		
				ptmtUpdatePoint = conn.prepareStatement(sqlUpdateInStock);
				int checkUpdatePoint = ptmtUpdatePoint.executeUpdate();
				
				String sqlUpdateOrderPoint = "UPDATE ORDERS SET Sum_Point='"+PlusPoint+"' WHERE Id_Order='"+IdOrder+"'";
				ptmtUpdateOrderPoint = conn.prepareStatement(sqlUpdateOrderPoint);
				int checkUpdateOrderPoint = ptmtUpdateOrderPoint.executeUpdate();
				
				if (checkUpdatePoint != 0 && checkUpdateOrderPoint != 0) 
				{
					return true;
				}
			}
		
			ptmtSelectPoint.close();
			ptmtUpdatePoint.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
				
		return false;
		
	}
	
	//Lay ra so tien ma Sum(Point) cua khach co the doi ra
	public static int discountMoney(Connection conn, String idCustomer) {
		PreparedStatement ptmtgetPoint = null;
		
		int discountMoney = 0;
		int BalancePoint = 0;
		
		String sqlChoosePoint = "SELECT Points AS CPoint FROM CUSTOMER WHERE Id_Customer='"+idCustomer+"'";
		
		try 
		{
			ptmtgetPoint = conn.prepareStatement(sqlChoosePoint);
			ResultSet rs = ptmtgetPoint.executeQuery();
			
			if (rs.next()) 
			{
				int SumPoint = rs.getInt("CPoint");
				if (SumPoint >= 500) 
				{
					BalancePoint = SumPoint % 500;
					int ConvertPoint = SumPoint - BalancePoint; // So diem co the doi thanh tien
					
					discountMoney = ConvertPoint * 200; 		
				}
				
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return discountMoney;
	}
	
	// Cap nhat diem cua khach hang
	public static boolean updatePoint(Connection conn, String idCustomer, int Point) {
		PreparedStatement ptmtgetPoint = null;
		
		String sqlChoosePoint = "UPDATE CUSTOMER SET Points='"+Point+"' WHERE Id_Customer='"+idCustomer+"'";
		
		try 
		{
			ptmtgetPoint = conn.prepareStatement(sqlChoosePoint);
			int check = ptmtgetPoint.executeUpdate();
			
			if (check >= 0) 
			{
				return true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	//Lay ra so Point con du khi discount vd:530 -> Balance 30
	public static int balancePoint(Connection conn, String idCustomer) {
		PreparedStatement ptmtgetPoint = null;

		int BalancePoint = 0;
		
		String sqlChoosePoint = "SELECT Points AS CPoint FROM CUSTOMER WHERE Id_Customer='"+idCustomer+"'";
		
		try 
		{
			ptmtgetPoint = conn.prepareStatement(sqlChoosePoint);
			ResultSet rs = ptmtgetPoint.executeQuery();
			
			if (rs.next()) 
			{
				int SumPoint = rs.getInt("CPoint");
				if (SumPoint >= 500) 
				{
					BalancePoint = SumPoint % 500;	
				}
				
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return BalancePoint;
	}
	
	// Tra ve so luong San pham co ma chi tiet hoa don
	public static int getQuantity(Connection conn, String idOrderDetail) {
		PreparedStatement ptmtgetQuantity = null;

		int Quantity = 0;
		
		String sqlgetQuantity = "SELECT Quantity AS quantity FROM order_detail WHERE Id_Order_Detail='"+idOrderDetail+"';";

		try 
		{
			ptmtgetQuantity = conn.prepareStatement(sqlgetQuantity);
			ResultSet rs = ptmtgetQuantity.executeQuery();
			
			if (rs.next()) 
			{
				Quantity = rs.getInt("quantity");	
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return Quantity;
	}
	
	// Tra ve id san pham trong order detail
	public static String getIdProduct(Connection conn, String idOrderDetail) {
		PreparedStatement ptmtgetId = null;

		String IdProduct = null;
		
		String sqlgetId = "SELECT Id_Product AS id FROM order_detail WHERE Id_Order_Detail='"+idOrderDetail+"';";
		try 
		{
			ptmtgetId = conn.prepareStatement(sqlgetId);
			ResultSet rs = ptmtgetId.executeQuery();
			
			if (rs.next()) 
			{
				IdProduct = rs.getString("id");	
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return IdProduct;
	}
	
	//Delete 1 sam pham khoi don hang
	public static boolean RemoveProduct(Connection conn, int IdOrderDetail){
		
		PreparedStatement ptmtRemove = null;
		
		try 
		{												
				String sqlRemove = "DELETE FROM order_detail WHERE Id_Order_Detail='"+IdOrderDetail+"';";
				
				ptmtRemove = conn.prepareStatement(sqlRemove);
				int check = ptmtRemove.executeUpdate();
				if (check != 0) 
				{
					return true;
				}
		
			ptmtRemove.close();

			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
				
		return false;
		
	}
	
	
	
	// Update Quantity san pham khi remove 1 sp 
	public static boolean UpdateInStockWhenRemove(Connection conn, String IdProduct, int QuantityPlus){
		
		
		PreparedStatement ptmtSelectQuantity = null;
		PreparedStatement ptmtUpdateQuantity = null;
		
		try 
		{							
			
			String sqlInStock = "SELECT In_Stock AS inStock FROM PRODUCT WHERE Id_Product='"+IdProduct+"'";
			
			ptmtSelectQuantity = conn.prepareStatement(sqlInStock);
			ResultSet rs = ptmtSelectQuantity.executeQuery();
			
			
			if (rs.next()) 
			{
				int InStock = rs.getInt("inStock"); // So luong san pham trong kho	
				
				int UpdateInStock = InStock + QuantityPlus;//Tru so luong san pham trong kho
						
				String sqlUpdateInStock = "UPDATE PRODUCT SET In_Stock='"+UpdateInStock+"' WHERE Id_Product='"+IdProduct+"'";
				
				ptmtUpdateQuantity = conn.prepareStatement(sqlUpdateInStock);
				int check = ptmtUpdateQuantity.executeUpdate();
				if (check != 0) 
				{
					return true;
				}
			}
		
			ptmtSelectQuantity.close();
			ptmtUpdateQuantity.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
				
		return false;
		
	}
	
	
	
}
