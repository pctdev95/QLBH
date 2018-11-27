package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.PRODUCT;
import BEAN.PRODUCT_TYPE;
import DAO.Product_DAO;
import DB.DBConnection;

@WebServlet("/Add_Product_Controller")
public class Add_Product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add_Product_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		List<PRODUCT_TYPE> list = Product_DAO.DisplayDropdownProt(conn);
		
		request.setAttribute("listProt", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Add_Product.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		PRODUCT pro = new PRODUCT();
		
		String IdPro = request.getParameter("idpro");
		String NamePro = request.getParameter("namepro");
		String Calcu= request.getParameter("calpro");
		String Manua = request.getParameter("manua");
		String ImDate = request.getParameter("imdate");
		String Impri = request.getParameter("imprice");
		String Expri = request.getParameter("exprice");
		String Instock = request.getParameter("instock");
		String IdProt = request.getParameter("dropDownProt");
		
		int i = Integer.parseInt(Impri);
		int j = Integer.parseInt(Expri);
		int a = Integer.parseInt(Instock);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		
		try 
		{
			date = sdf.parse(ImDate);
		} 
		catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  


		pro.setId_Product(IdPro);
		pro.setName_Product(NamePro);
		pro.setCalculation_Unit(Calcu);
		pro.setManufacturer(Manua);
		pro.setImport_Date(sqlStartDate);
		pro.setImport_Prices_Product(i);
		pro.setExport_Prices_Product(j);
		pro.setIn_Stock(a);
		pro.setId_Product_Type(IdProt);
		
		boolean check = Product_DAO.Add_Product(conn, pro);
		
		if (check) {
			
			try {
				request.setAttribute("msg1", "Add Product Success");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Add_Product.jsp");
				rd.forward(request, response);
				
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("msg2", "Add Product Failed - Please check fields");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Add_Product.jsp");
			rd.forward(request, response);
		}
	}

}
