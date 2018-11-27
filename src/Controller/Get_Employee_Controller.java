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

import BEAN.EMPLOYEE;
import DAO.Employee_DAO;
import DB.DBConnection;

@WebServlet("/Get_Employee_Controller")
public class Get_Employee_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Get_Employee_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = DBConnection.CreateConnection();
		
		List<EMPLOYEE> list = Employee_DAO.DisplayEmployee(conn);
		
		request.setAttribute("listEmployee", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Employee_Table.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		String Id = request.getParameter("Search_Id");
		
		List<EMPLOYEE> list = Employee_DAO.SearchEmployee(conn, Id);
		
		request.setAttribute("listEmployee", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Employee_Table.jsp");
		rd.forward(request, response);
	}

}
