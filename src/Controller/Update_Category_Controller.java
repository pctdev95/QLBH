package Controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.CATEGORY;
import DB.DBConnection;

@WebServlet("/Update_Category_Controller")
public class Update_Category_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update_Category_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DB.DBConnection.CreateConnection();
		String Id = request.getParameter("id");
		
		CATEGORY ca = DAO.Get_Category_DAO.Choose_cate(conn, Id);
		
		String Idca = ca.getId_Category();
		String NameCa = ca.getName_Category();
		String DeCa = ca.getDecription_Category();
		
		
		request.setAttribute("id", Idca);
		request.setAttribute("name", NameCa);
		request.setAttribute("dec", DeCa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Update_Category.jsp");
		rd.forward(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		String Id = request.getParameter("F_Id_Cate");
		String Name = request.getParameter("F_Name_Cate");
		String Dec = request.getParameter("F_Decription_Cate");
		
		CATEGORY cate = new CATEGORY();
		cate.setId_Category(Id);
		cate.setName_Category(Name);
		cate.setDecription_Category(Dec);
		
		int check = DAO.Get_Category_DAO.Update_Category(conn, cate, Id);
		
		if(check == 1)
		{
			request.setAttribute("mess1", "Can't change ID Category");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Update_Category.jsp");
			rd.forward(request, response);
		}
		else if(check == 2)
		{
			request.setAttribute("mess1", "ID Category can't more than 5 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Update_Category.jsp");
			rd.forward(request, response);
		}
		else if(check ==3)
		{
			request.setAttribute("mess1", "Category name can't more than 30 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Update_Category.jsp");
			rd.forward(request, response);
		}
		else if(check == 4)
		{
			request.setAttribute("mess1", "Category decription can't more than 50 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Update_Category.jsp");
			rd.forward(request, response);
		}
		else if(check == 0)		{
			request.setAttribute("mess1", "Update Success");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Table_Category.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}

}
