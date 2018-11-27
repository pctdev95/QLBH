package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;
import BEAN.CATEGORY;
import DB.DBConnection;

@WebServlet("/Add_Category_Forward_Controller")
public class Add_Category_Forward_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add_Category_Forward_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		List<CATEGORY> list = DAO.Product_Type_DAO.DisplayDropdownCategory(conn);
		
		request.setAttribute("listCategory", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Category/Add_Category.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
