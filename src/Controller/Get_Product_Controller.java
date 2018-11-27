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

import BEAN.PRODUCT;
import DAO.Product_DAO;
import DB.DBConnection;

@WebServlet("/Get_Product_Controller")
public class Get_Product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Get_Product_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		List<PRODUCT> list = Product_DAO.DisplayProduct(conn);
		
		request.setAttribute("listProduct", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Product_Table.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		String Id = request.getParameter("Search_Id");
		
		List<PRODUCT> list = Product_DAO.SearchProduct(conn, Id);
		
		request.setAttribute("listProduct", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Product_Table.jsp");
		rd.forward(request, response);
	}

}
