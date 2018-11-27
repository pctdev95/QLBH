package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Get_Category_DAO;
import DB.DBConnection;
import BEAN.CATEGORY;

import java.sql.*;

@WebServlet("/Add_Category_Controller")
public class Add_Category_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add_Category_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		String idCa = request.getParameter("F_Id_Cate");
		String nameCa = request.getParameter("F_Name_Cate");
		String decCa = request.getParameter("F_Decription_Cate");
		
		CATEGORY cate = new CATEGORY();
		
		cate.setId_Category(idCa);
		cate.setName_Category(nameCa);
		cate.setDecription_Category(decCa);
		
		boolean check = Get_Category_DAO.Insert_Category(conn, cate);
		
		if (check) 
		{
			try 
			{
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Table_Category.jsp");
				rd.forward(request, response);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Add_Category.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
