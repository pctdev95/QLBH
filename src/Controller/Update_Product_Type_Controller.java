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
import BEAN.PRODUCT_TYPE;
import DAO.Product_Type_DAO;
import DB.DBConnection;

@WebServlet("/Update_Product_Type_Controller")
public class Update_Product_Type_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update_Product_Type_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		String Id = request.getParameter("id");
		
		PRODUCT_TYPE prot = DAO.Product_Type_DAO.Choose_Product_Type(conn, Id);
		List<CATEGORY> list = Product_Type_DAO.DisplayDropdownCategory(conn);
		
		String IdPT = prot.getId_Product_Type();
		String NamePT = prot.getName_Product_Type();
		String DecPT = prot.getDecription_Product_Type();
		String IdCate = prot.getId_Category();
		
		
		request.setAttribute("idPT", IdPT);
		request.setAttribute("namePT", NamePT);
		request.setAttribute("decPT", DecPT);
		request.setAttribute("idCate", IdCate);
		request.setAttribute("listCate", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Update_Product_Type.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		String IdPT = request.getParameter("F_Id_PT");
		String NamePT = request.getParameter("F_Name_PT");
		String DecPT = request.getParameter("F_Decription_PT");
		String IdCate = request.getParameter("dropDownCate");
		
		PRODUCT_TYPE prot = new PRODUCT_TYPE();
		
		prot.setId_Product_Type(IdPT);
		prot.setName_Product_Type(NamePT);
		prot.setDecription_Product_Type(DecPT);
		prot.setId_Category(IdCate);
		
		int check = DAO.Product_Type_DAO.Update_Product_Type(conn, prot, IdPT);
		
		if(check == 1)
		{
			request.setAttribute("msg1", "Can't change ID Category");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Update_Product_Type.jsp");
			rd.forward(request, response);
		}
		else if(check == 2)
		{
			request.setAttribute("msg1", "ID Category can't more than 5 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Update_Product_Type.jsp");
			rd.forward(request, response);
		}
		else if(check ==3)
		{
			request.setAttribute("msg1", "Category name can't more than 30 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Update_Product_Type.jsp");
			rd.forward(request, response);
		}
		else if(check == 4)
		{
			request.setAttribute("msg1", "Category decription can't more than 50 character");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Update_Product_Type.jsp");
			rd.forward(request, response);
		}
		else if(check == 0)
		{
			request.setAttribute("msg1", "Update Success");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Product_Type/Update_Product_Type.jsp");
			rd.forward(request, response);
		}
	}

}
