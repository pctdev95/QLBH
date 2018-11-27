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
import BEAN.PRODUCT;
import BEAN.PRODUCT_TYPE;
import DAO.Product_DAO;
import DAO.Product_Type_DAO;
import DB.DBConnection;

@WebServlet("/Report_Product_Emp")
public class Report_Product_Emp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Report_Product_Emp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		List<PRODUCT> list = Product_DAO.DisplayProduct(conn);
		List<PRODUCT_TYPE> listProt = Product_DAO.DisplayDropdownProt(conn);
		List<CATEGORY> listCate = Product_Type_DAO.DisplayDropdownCategory(conn);
		
		request.setAttribute("listProduct", list);
		request.setAttribute("listProt", listProt);
		request.setAttribute("listCategory", listCate);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/Report_Product.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		String Id = request.getParameter("Search_Id");
		String Prot = request.getParameter("dropDownProt");
		String Cate = request.getParameter("dropDownCate");
		if(Id.length() >= 1 )
		{
			List<PRODUCT> list = Product_DAO.SearchProduct(conn, Id);
			List<PRODUCT_TYPE> listProt = Product_DAO.DisplayDropdownProt(conn);
			List<CATEGORY> listCate = Product_Type_DAO.DisplayDropdownCategory(conn);
			
			request.setAttribute("listProduct", list);
			
			request.setAttribute("listProt", listProt);
			request.setAttribute("listCategory", listCate);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/Report_Product.jsp");
			rd.forward(request, response);
		}
		else if(Prot.length()>=0 && Cate.length()==0)
		{
			List<PRODUCT> list = Product_DAO.SearchProduct_Prot(conn, Prot);
			List<PRODUCT_TYPE> listProt = Product_DAO.DisplayDropdownProt(conn);
			List<CATEGORY> listCate = Product_Type_DAO.DisplayDropdownCategory(conn);
			
			request.setAttribute("listProduct", list);
			
			request.setAttribute("listProt", listProt);
			request.setAttribute("listCategory", listCate);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/Report_Product.jsp");
			rd.forward(request, response);
		}
		else if(Prot.length()==0 && Cate.length()>=0)
		{
			List<PRODUCT> list = Product_DAO.SearchProduct_Cate(conn, Cate);
			List<PRODUCT_TYPE> listProt = Product_DAO.DisplayDropdownProt(conn);
			List<CATEGORY> listCate = Product_Type_DAO.DisplayDropdownCategory(conn);
			
			request.setAttribute("listProduct", list);
			
			request.setAttribute("listProt", listProt);
			request.setAttribute("listCategory", listCate);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/Report_Product.jsp");
			rd.forward(request, response);
		}
		else if(Prot.length()>0 && Cate.length()>0)
		{
			List<PRODUCT> list = Product_DAO.SearchProduct_Prot_Cate(conn, Cate, Prot);
			List<PRODUCT_TYPE> listProt = Product_DAO.DisplayDropdownProt(conn);
			List<CATEGORY> listCate = Product_Type_DAO.DisplayDropdownCategory(conn);
			
			request.setAttribute("listProduct", list);
			
			request.setAttribute("listProt", listProt);
			request.setAttribute("listCategory", listCate);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Employee_Page/Report_Product.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
