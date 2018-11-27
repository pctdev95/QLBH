package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Product_DAO;

@WebServlet("/Delete_Product_Controller")
public class Delete_Product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete_Product_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DB.DBConnection.CreateConnection();
		String Id = request.getParameter("id");
		
		boolean check = Product_DAO.Delete_Product(conn, Id);
		
		if(check == true)//Delete thanh cong
		{
			request.setAttribute("msg1", "Deleted 1 Product");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Product_Table.jsp");
			rd.forward(request, response);
		}
		else//Delete khong thanh cong
		{
			request.setAttribute("msg2", "Can't delete");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product/Product_Table.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
