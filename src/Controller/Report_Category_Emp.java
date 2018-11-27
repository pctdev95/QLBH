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

import BEAN.CATEGORY;
import DAO.Get_Category_DAO;
import DB.DBConnection;

@WebServlet("/Report_Category_Emp")
public class Report_Category_Emp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Report_Category_Emp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		List<CATEGORY> list = Get_Category_DAO.DisplayCategory(conn);
		
		request.setAttribute("listCategory", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/Report_Category.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		String Id = request.getParameter("Search_Id");
		
		List<CATEGORY> list = Get_Category_DAO.SearchCategory(conn, Id);
		
		request.setAttribute("listCategory", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/Report_Category.jsp");
		rd.forward(request, response);
	}


}
