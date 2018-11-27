package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.PRODUCT_TYPE;
import DAO.Product_Type_DAO;
import DB.DBConnection;

@WebServlet("/Report_Product_Type_Emp")
public class Report_Product_Type_Emp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Report_Product_Type_Emp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		List<PRODUCT_TYPE> list = Product_Type_DAO.DisplayProductType(conn);
		
		request.setAttribute("listProductType", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/Report_Product_Type.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		String Id = request.getParameter("Search_Id");
		
		List<PRODUCT_TYPE> list = Product_Type_DAO.SearchProductType(conn, Id);
		
		request.setAttribute("listProductType", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/Report_Product_Type.jsp");
		rd.forward(request, response);
	}

}
