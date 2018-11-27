package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.EMPLOYEE;
import DAO.Employee_DAO;
import DB.DBConnection;

@WebServlet("/Update_Employee_Controller")
public class Update_Employee_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update_Employee_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DB.DBConnection.CreateConnection();
		String Id = request.getParameter("id");
		
		EMPLOYEE emp = Employee_DAO.Choose_Product_Type(conn, Id);
		
		
		String IdEmp = emp.getId_Employee();
		String Fname = emp.getFirst_Name();
		String Lname = emp.getLast_Name_Employee();
		boolean Gende = emp.isGender_Employee();
		String DOBEm = emp.getDOB_Employee();
		String CardE = emp.getId_Card_Employee();
		String Addre = emp.getAddress_Employee();
		String Phone = emp.getPhone_Employee();
		String Depar = emp.getDepartment_Employee();
		int Salar = emp.getSalary_Employee();
		String Accou = emp.getAccount_User();
		
		
		request.setAttribute("idemp", IdEmp);
		request.setAttribute("fname", Fname);
		request.setAttribute("lname", Lname);
		request.setAttribute("gen", Gende);
		request.setAttribute("dob", DOBEm);
		request.setAttribute("card", CardE);
		request.setAttribute("add", Addre);
		request.setAttribute("pho", Phone);
		request.setAttribute("dep", Depar);
		request.setAttribute("sal", Salar);
		request.setAttribute("acc", Accou);

		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Update_Employee.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		EMPLOYEE emp = new EMPLOYEE();
		
		String IdEmp = request.getParameter("Idemp");
		String Fname = request.getParameter("Fname");
		String Lname = request.getParameter("Lname");
		String Gende = request.getParameter("dropDownGen");
		String DOBEm = request.getParameter("Dob");
		String CardE = request.getParameter("Card");
		String Addre = request.getParameter("Add");
		String Phone = request.getParameter("Pho");
		String Depar = request.getParameter("Dep");
		String Salar = request.getParameter("Sal");
		String Accou = request.getParameter("Acc");
		
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
		
		int check = Employee_DAO.Update_Employee(conn, emp, IdEmp);
		
		if(check == 1)
		{
			request.setAttribute("msg2", "Can't change ID Employee");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Employee_Table.jsp");
			rd.forward(request, response);
		}
		else if(check == 2)
		{
			request.setAttribute("msg2", "First name can't more than 30 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Employee_Table.jsp");
			rd.forward(request, response);
		}
		else if(check ==3)
		{
			request.setAttribute("msg2", "Last name can't more than 30 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Employee_Table.jsp");
			rd.forward(request, response);
		}
		else if(check == 4)
		{
			request.setAttribute("msg2", "Please enter full infomation for Employee");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Employee_Table.jsp");
			rd.forward(request, response);
		}
		else if(check == 0)
		{
			request.setAttribute("msg1", "Update employee Success");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee/Employee_Table.jsp");
			rd.forward(request, response);
		}
	}

}
