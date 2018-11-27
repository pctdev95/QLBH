package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.sql.*;

import DAO.Login_DAO;
import DB.DBConnection;

@WebServlet("/Login_Controller")
public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acc = request.getParameter("F_Account");
		String pass = request.getParameter("F_Password");
		
		Connection conn = DBConnection.CreateConnection();
		
		//PreparedStatement ptmt = null;
		//String sql = "SELECT * FROM USERS WHERE Account_User = '"+acc+"';";
		
		//String msg1 = "Login Fail - Password was wrong";
		//String msg2 = "Login Fail - Account was wrong";
		//String msg3 = "Account khong co quyen";
		
		boolean checkAcc = Login_DAO.CheckUser(conn, acc, pass);
		int checkGroup = Login_DAO.CheckGroup(conn, acc);
		
		if(checkAcc == true)//Dung tai khoan & mk
		{
			if(checkGroup == 0) //Neu la quyen nguoi dung Admin
			{
				//create new session
				HttpSession session = request.getSession(true);
				
				String SessName = Login_DAO.getSessionNameAdmin(conn, acc);
				
				//Luu session 
				session.setAttribute("sessionName", SessName);
				
				//chuyen toi trang AdminPage
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/AdminPage.jsp");
				rd.forward(request, response);
			}
			else if(checkGroup == 1)
			{
				//create new session
				HttpSession session = request.getSession(true);
				
				String SessName = Login_DAO.getSessionNameEmployee(conn, acc);
				//Luu session 
				session.setAttribute("sessionName", SessName);
				
				//chuyen toi trang Employee
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/EmployeePage.jsp");
				rd.forward(request, response);
			}
			else if(checkGroup == 2)
			{
				//create new session
				HttpSession session = request.getSession(true);
				
				String SessName = Login_DAO.getSessionNameCustomer(conn, acc);
				
				//Luu session 
				session.setAttribute("sessionName", SessName);
				
				//chuyen toi trang Customer
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Customer_Page/CustomerPage.jsp");
				rd.forward(request, response);
			}
			else if(checkGroup != 0 && checkGroup != 1 && checkGroup != 2) 
			{
				//Luu message1
				request.setAttribute("mess1", "Account don't have Group User!!!");
				
				//Chuyen toi trang Login
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Login.jsp");
				rd.forward(request, response);
			}
		}
		else//Sai tk & mk
		{
			//Luu message1
			request.setAttribute("mess1", "Login Fail - Account or Password was wrong!!!");
			
			//Chuyen toi trang Login
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Login.jsp");
			rd.forward(request, response);
		}
		
/*		-----------------------------------------------------------------------------------------------------------------------------*/
/*		try 
		{
			ptmt = conn.prepareStatement(sql);			
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) 
			{
				
				String uname = rs.getString("Account_User");
				String upass = rs.getString("Password_User");
				String Id = rs.getString("Id_Group_User");
				

				if (pass.equals(upass) && Id.equals("0") ) {
					//create new session
					HttpSession session = request.getSession(true);
					
					//Luu session 
					session.setAttribute("sessionName", acc);
					
					//chuyen toi trang AdminPage
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/AdminPage.jsp");
					rd.forward(request, response);
					
				}else if(pass.equals(upass) && Id.equals("1")) {
					//create new session
					HttpSession session = request.getSession(true);
					
					//Luu session 
					session.setAttribute("sessionName", acc);
					
					//chuyen toi trang EmployeePage
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/EmployeePage.jsp");
					rd.forward(request, response);
					
				}else if(pass.equals(upass) && Id.equals("2")) {
					//create new session
					HttpSession session = request.getSession(true);
					
					//Luu session 
					session.setAttribute("sessionName", acc);
					
					//chuyen toi trang CustomerPage
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/CustomerPage.jsp");
					rd.forward(request, response);
				}
				else {
					//Luu message1
					request.setAttribute("mess1", msg1);
					
					//Chuyen toi trang Login
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Login.jsp");
					rd.forward(request, response);
					
				}
				rs.close();
			}
			else 
			{
				//Luu message1
				request.setAttribute("mess1", "Tai khoan khong ton tai");
				
				//Chuyen toi trang Login
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Login.jsp");
				rd.forward(request, response);
			}
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}*/
/*		-----------------------------------------------------------------------------------------------------------------------------*/
			
		
		
	}

}
