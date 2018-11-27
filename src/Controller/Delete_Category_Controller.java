package Controller;

import java.io.IOException;
import java.sql.Connection;
import DAO.Get_Category_DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete_Category_Controller")
public class Delete_Category_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete_Category_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DB.DBConnection.CreateConnection();
		String Id = request.getParameter("id");
		
		boolean check = Get_Category_DAO.Delete_Category(conn, Id);
		
		if(check == true)//Delete thanh cong
		{
			request.setAttribute("mess2", "Deleted 1 row");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Table_Category.jsp");
			rd.forward(request, response);
		}
		else//Delete khong thanh cong
		{
			request.setAttribute("mess2", "Can't delete");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Table_Category.jsp");
			rd.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
