package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.EMPLOYEE;
import DAO.Employee_DAO;
import DB.DBConnection;

@WebServlet("/Add_Employee_Controller")
public class Add_Employee_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add_Employee_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		EMPLOYEE emp = new EMPLOYEE();
		
		String IdEmp = request.getParameter("idemp");
		String Fname = request.getParameter("fname");
		String Lname = request.getParameter("lname");
		String Gende = request.getParameter("dropDownGend");
		String DOBEm = request.getParameter("dob");
		String CardE = request.getParameter("card");
		String Addre = request.getParameter("addr");
		String Phone = request.getParameter("phone");
		String Depar = request.getParameter("depar");
		String Salar = request.getParameter("salar");
		String Accou = request.getParameter("accu");
		String Passw = request.getParameter("passw");
		
		int i = Integer.parseInt(Gende);
		int j = Integer.parseInt(Salar);
		



	    
		
		boolean gen = true;
		if(i == 1)
		{
			gen = true;
		}
		else
		{
			gen = false;
		}
		
		emp.setId_Employee(IdEmp);
		emp.setFirst_Name(Fname);
		emp.setLast_Name_Employee(Lname);
		emp.setGender_Employee(gen);
		emp.setDOB_Employee(DOBEm);
		emp.setId_Card_Employee(CardE);
		emp.setAddress_Employee(Addre);
		emp.setPhone_Employee(Phone);
		emp.setDepartment_Employee(Depar);
		emp.setSalary_Employee(j);
		emp.setAccount_User(Accou);
		emp.setPassword_User(Passw);
		
		boolean check = Employee_DAO.Add_Employee(conn, emp);
		
		if (check) {
			
			try {
				request.setAttribute("msg1", "Add Employee Success");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Add_Employee.jsp");
				rd.forward(request, response);
				
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("msg2", "Add Employee Failed");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Add_Employee.jsp");
			rd.forward(request, response);
		}
	
	}

}
