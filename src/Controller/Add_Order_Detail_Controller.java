package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.BILL;
import BEAN.CUSTOMER;
import BEAN.ORDER_DETAIL;
import BEAN.PRODUCT;
import DAO.Customer_DAO;
import DAO.OrderDetail_DAO;
import DAO.Order_DAO;
import DB.DBConnection;

@WebServlet("/Add_Order_Detail_Controller")
public class Add_Order_Detail_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add_Order_Detail_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		
		String Idpro = request.getParameter("idpro");
		String Idord = request.getParameter("idord");
		String Quant = request.getParameter("quantity");
		
		String idcus = request.getParameter("idcus");
		CUSTOMER cus = new CUSTOMER();
		cus = Customer_DAO.Choose_Customer(conn, idcus);
		String Idemp = request.getParameter("idemp");
		Date date = Order_DAO.getDate(conn);
		
		PRODUCT pro = new PRODUCT();
		pro = OrderDetail_DAO.Choose_Product(conn, Idpro);
		
		int Expri = pro.getExport_Prices_Product(); //Lay ra gia ban cua san pham
		int Quantity = Integer.parseInt(Quant); //Ep kieu so luong nhap vao
		int IdOrder = Integer.parseInt(Idord);
		
		int Sum = Expri * Quantity; //Tong gia tri
		
		ORDER_DETAIL od= new ORDER_DETAIL();
		
		od.setQuantity(Quantity);
		od.setSum_Amount_Order_Detail(Sum);
		od.setId_Product(Idpro);
		od.setId_Order(IdOrder);
		
		boolean check = OrderDetail_DAO.Add_Order_Detail(conn, od);
		
		if(check)
		{
			try 
			{
				boolean checkUpdateStock = OrderDetail_DAO.UpdateQuantityInStock(conn, Idpro, Quantity);
				
				if (checkUpdateStock) 
				{
					List<BILL> list = OrderDetail_DAO.DisplayBill(conn, IdOrder);
					int Sumtotal = OrderDetail_DAO.DisplaySumOrder(conn, IdOrder);
					String Lname = cus.getLast_Name_Customer();
					String Fname = cus.getFirst_Name_Customer();
					int Point = cus.getPoints();
					
					
					request.setAttribute("Idorder", IdOrder);
					
					request.setAttribute("Idcus", idcus);
					request.setAttribute("Lname", Lname);
					request.setAttribute("Fname", Fname);
					request.setAttribute("Point", Point);
					request.setAttribute("Sysdate", date);
					request.setAttribute("Idemp", Idemp);
					
					request.setAttribute("listBill", list);
					request.setAttribute("total", Sumtotal);
					request.setAttribute("msg3", "Add 1 product to order success");

					
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/OrderDetail/Add_Order_Detail.jsp");
					rd.forward(request, response);
				}
				else
				{
					List<BILL> list = OrderDetail_DAO.DisplayBill(conn, IdOrder);
					int total = OrderDetail_DAO.DisplaySumOrder(conn, IdOrder);
					
					request.setAttribute("listBill", list);
					request.setAttribute("total", total);
					request.setAttribute("msg4", "Product is Out Stock");
					
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/OrderDetail/Add_Order_Detail.jsp");
					rd.forward(request, response);
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			
		}
		else	
		{
			List<BILL> list = OrderDetail_DAO.DisplayBill(conn, IdOrder);
			int total = OrderDetail_DAO.DisplaySumOrder(conn, IdOrder);
			

			

			
			request.setAttribute("listBill", list);
			request.setAttribute("total", total);
			request.setAttribute("msg4", "Id product was wrong - Please check Id product again");
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/OrderDetail/Add_Order_Detail.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}

}
