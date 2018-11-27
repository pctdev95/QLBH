package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.CUSTOMER;
import DAO.Customer_DAO;
import DB.DBConnection;

@WebServlet("/Add_Customer_Controller")
public class Add_Customer_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add_Customer_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		CUSTOMER cus = new CUSTOMER();
		
		
		int Point = 0;
		int temp;
		temp = Customer_DAO.Choose_Max_Id_Customer(conn);
		int Id = temp + 1;
		
		String Fname = request.getParameter("fname");
		String Lname = request.getParameter("lname");
		String Gende = request.getParameter("dropDownGend");
		String DOB = request.getParameter("dob");
		String Card = request.getParameter("card");
		String Addr = request.getParameter("addr");
		String Phone = request.getParameter("phone");
		String Accou = request.getParameter("accu");
		String Passw = request.getParameter("passw");
		
		
		/*Ep kieu gioi tinh*/
		int i = Integer.parseInt(Gende);
		
		boolean gen = true;
		if(i == 1)
		{
			gen = true;
		}
		else
		{
			gen = false;
		}
		
		/*Ep kieu Date ngay sinh*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		
		try 
		{
			date = sdf.parse(DOB);
		} 
		catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		
		cus.setId_Customer(Id);
		cus.setFirst_Name_Customer(Fname);
		cus.setLast_Name_Customer(Lname);
		cus.setGender_Customer(gen);
		cus.setDOB_Customer(sqlStartDate);
		cus.setId_Card_Customer(Card);
		cus.setAddress_Customer(Addr);
		cus.setPhone_Customer(Phone);
		cus.setPoints(Point);
		cus.setAccount_User(Accou);
		cus.setPassword_User(Passw);
		
		boolean check = Customer_DAO.Add_Customer(conn, cus);
		
		if (check) {
			
			try {
				request.setAttribute("msg1", "Register Success"+Id+"f"+Fname+""+Lname+""+gen+""+sqlStartDate+""+Card+""+Addr+""+Phone+""+Point+""+Accou+""+Passw);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Customer_Page/Register.jsp");
				rd.forward(request, response);
				
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("msg2", "Register Failed - Please check fields"+Id+"f"+Fname+""+Lname+""+gen+""+sqlStartDate+""+Card+""+Addr+""+Phone+""+Point+""+Accou+""+Passw);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Customer_Page/Register.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
