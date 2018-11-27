package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Order_DAO;
import DB.DBConnection;

@WebServlet("/Order_Forward_Controller")
public class Order_Forward_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Order_Forward_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		Date date = Order_DAO.getDate(conn);
		
		request.setAttribute("sysdate", date);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Add_Order.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
