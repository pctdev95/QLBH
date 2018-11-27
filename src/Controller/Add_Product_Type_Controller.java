package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.PRODUCT_TYPE;
import DAO.Product_Type_DAO;
import DB.DBConnection;

@WebServlet("/Add_Product_Type_Controller")
public class Add_Product_Type_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add_Product_Type_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		PRODUCT_TYPE prot = new PRODUCT_TYPE();
		
		String id = request.getParameter("F_Id_PT");
		String name = request.getParameter("F_Name_PT");
		String dec = request.getParameter("F_Decription_PT");
		String idCa = request.getParameter("dropDownCate");
		
		prot.setId_Product_Type(id);
		prot.setName_Product_Type(name);
		prot.setDecription_Product_Type(dec);
		prot.setId_Category(idCa);
		
		
		boolean check = Product_Type_DAO.Insert_Product_Type(conn, prot);
		
		
		if (check) 
		{
			try 
			{
				request.setAttribute("msg1", "Add 1 product type");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
				rd.forward(request, response);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else 
		{
			if(id.length() > 5) // Chuoi id khong vuot qua 5
			{
				request.setAttribute("msg1", "Id must be 5 character");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
				rd.forward(request, response);
			}
			else if(name.length() > 30) 
			{
				request.setAttribute("msg1", "Name can't more than 30 character");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
				rd.forward(request, response);
			}
			else if(dec.length() > 50) 
			{
				request.setAttribute("msg1", "Decription can't more than 50 character");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
				rd.forward(request, response);
			}
			else 
			{
				request.setAttribute("msg1", "Existing object with Id :"+id);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
				rd.forward(request, response);
			}
		}
		
		/*if(id.length() > 5) // Chuoi id khong vuot qua 5
		{
			request.setAttribute("msg1", "Id must be 5 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
			rd.forward(request, response);
		}
		else if(name.length() > 30) 
		{
			request.setAttribute("msg1", "Name can't more than 30 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
			rd.forward(request, response);
		}
		else if(dec.length() > 50) 
		{
			request.setAttribute("msg1", "Decription can't more than 50 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
			rd.forward(request, response);
		}
		else if (check) 
		{
				request.setAttribute("msg1", "Add 1 product type");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
				rd.forward(request, response);
		}
		else 
		{
			request.setAttribute("msg1", "Existing object with Id :"+id);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Add_Product_Type.jsp");
			rd.forward(request, response);
		}*/
	}

}
