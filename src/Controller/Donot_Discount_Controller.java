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
import DAO.Customer_DAO;
import DAO.OrderDetail_DAO;
import DAO.Order_DAO;
import DB.DBConnection;

@WebServlet("/Donot_Discount_Controller")
public class Donot_Discount_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Donot_Discount_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		String Idord = request.getParameter("idord");
		
		String idcus = request.getParameter("idcus");
		String Idemp = request.getParameter("idemp");
		Date date = Order_DAO.getDate(conn);
		
		int IdOrder = Integer.parseInt(Idord);
		
		int total = OrderDetail_DAO.DisplaySumOrder(conn, IdOrder);
		
		boolean checkUpdateTotal = OrderDetail_DAO.UpdateTotalOrder(conn, IdOrder, total);
				
		if (checkUpdateTotal)  //Neu Cap nhat Tong tien cho hoa don thanh cong
		{

				try 
				{
					boolean checkUpdatePlusPoint = OrderDetail_DAO.AccumulatePoints(conn, idcus, total, IdOrder); //Cap nhap diem tich luy
					
					if(checkUpdatePlusPoint)
					{
						List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
						int Sumtotal = OrderDetail_DAO.DisplaySumOrder(conn, IdOrder);
						CUSTOMER cus = new CUSTOMER();
						cus = Customer_DAO.Choose_Customer(conn, idcus);
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
						
						request.setAttribute("listBill", listbill);
						request.setAttribute("total", Sumtotal);
						
						request.setAttribute("msg1", "Checkout Success ID Order "+IdOrder);
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Order.jsp");
						rd.forward(request, response);
					}
					else
					{
						List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
						int Sumtotal = OrderDetail_DAO.DisplaySumOrder(conn, IdOrder);
						CUSTOMER cus = new CUSTOMER();
						cus = Customer_DAO.Choose_Customer(conn, idcus);
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
						
						request.setAttribute("listBill", listbill);
						request.setAttribute("total", Sumtotal);
						
						request.setAttribute("msg1", "Can't update Point"+IdOrder);
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Order.jsp");
						rd.forward(request, response);
					}
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}


		}
		else //Neu cap nhat tong tien cho hoa don khong thanh cong
		{
			List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
			int Sumtotal = OrderDetail_DAO.DisplaySumOrder(conn, IdOrder);
			CUSTOMER cus = new CUSTOMER();
			cus = Customer_DAO.Choose_Customer(conn, idcus);
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
			
			request.setAttribute("listBill", listbill);
			request.setAttribute("total", Sumtotal);
			request.setAttribute("msg2", "Can't Checkout ID Order "+IdOrder);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Order.jsp");
			rd.forward(request, response);

		}
	}

}
