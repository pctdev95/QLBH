package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.CUSTOMER;
import BEAN.ORDER;
import DAO.Order_DAO;
import DB.DBConnection;

@WebServlet("/Add_Order_Controller")
public class Add_Order_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add_Order_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		ORDER order = new ORDER();
		
		int maxId = Order_DAO.maxIdOrder(conn);
		maxId = maxId + 1;
		
		Date sys = Order_DAO.getDate(conn);
		String IdCus = request.getParameter("idcus");
		String Session = request.getParameter("idemp");
		
		String IdEmp = Order_DAO.chooseIdEmployee(conn, Session);
		
		order.setId_Order(maxId);
		order.setOrder_Date(sys);
		order.setSum_Amount_Order(0);
		order.setSum_Point(0);
		order.setId_Customer(IdCus);
		order.setId_Employee(IdEmp);
		
		boolean check = Order_DAO.Add_Order(conn, order);
		
		if (check) {
			
			try {
				
				CUSTOMER cus = new CUSTOMER();
				cus = Order_DAO.chooseCustomer(conn, IdCus);
				String Fname = cus.getFirst_Name_Customer();
				String Lname = cus.getLast_Name_Customer();
				int Point = cus.getPoints();
				Date date = Order_DAO.getDate(conn);
				
				request.setAttribute("Idcus", IdCus);
				request.setAttribute("Fname", Fname);
				request.setAttribute("Lname", Lname);
				request.setAttribute("Point", Point);
				request.setAttribute("Idorder", maxId);
				request.setAttribute("Idemp", IdEmp);
				request.setAttribute("sysdate", date);
				
				
				request.setAttribute("msg1", "Add Order Success   "+maxId);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/OrderDetail/Add_Order_Detail.jsp");
				rd.forward(request, response);
				
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			
			request.setAttribute("msg2", "Add Order Failed - Please check Id Customer again!!!   "+maxId);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/OrderDetail/Add_Order_Detail.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		Date date = Order_DAO.getDate(conn);
		
		request.setAttribute("sysdate", date);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Add_Order.jsp");
		rd.forward(request, response);
	}

}
