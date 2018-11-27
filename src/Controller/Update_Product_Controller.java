package Controller;

import java.io.IOException;
import java.sql.Connection;
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
import java.sql.*;

@WebServlet("/Update_Product_Controller")
public class Update_Product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update_Product_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DB.DBConnection.CreateConnection();
		String Id = request.getParameter("id");
		
		PRODUCT pro = Product_DAO.Choose_Product(conn, Id);
		
		List<PRODUCT_TYPE> list = Product_DAO.DisplayDropdownProt(conn);
		
		request.setAttribute("listProt", list);
		
		
		String IdPro = pro.getId_Product();
		String NamePro = pro.getName_Product();
		String Calcu = pro.getCalculation_Unit();
		String Manua = pro.getManufacturer();
		Date ImDate = pro.getImport_Date();
		int Impri = pro.getImport_Prices_Product();
		int ExPri = pro.getExport_Prices_Product();
		int InSto = pro.getIn_Stock();
		String Idprot = pro.getId_Product_Type(); 

		
		
		request.setAttribute("idpro", IdPro);
		request.setAttribute("name", NamePro);
		request.setAttribute("cal", Calcu);
		request.setAttribute("man", Manua);
		request.setAttribute("imdate", ImDate);
		request.setAttribute("impri", Impri);
		request.setAttribute("expri", ExPri);
		request.setAttribute("instock", InSto);
		request.setAttribute("idprot", Idprot);

		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Update_Product.jsp");
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
		
		int check = Product_DAO.Update_Product(conn, pro, IdPro);
		
		if(check == 1)
		{
			request.setAttribute("msg2", "Can't change ID Product");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Product_Table.jsp");
			rd.forward(request, response);
		}
		else if(check == 2)
		{
			request.setAttribute("msg2", "Product name can't more than 30 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Product_Table.jsp");
			rd.forward(request, response);
		}
		else if(check ==3)
		{
			request.setAttribute("msg2", "Calculation can't more than 20 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Product_Table.jsp");
			rd.forward(request, response);
		}
		else if(check == 4)
		{
			request.setAttribute("msg2", "Please enter full fields for Product");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Product_Table.jsp");
			rd.forward(request, response);
		}
		else if(check == 0)
		{
			request.setAttribute("msg1", "Update Product Success");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Product_Table.jsp");
			rd.forward(request, response);
		}
	}

}
