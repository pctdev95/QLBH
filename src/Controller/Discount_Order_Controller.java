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

@WebServlet("/Discount_Order_Controller")
public class Discount_Order_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Discount_Order_Controller() {
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
		
		int discountMoney = OrderDetail_DAO.discountMoney(conn, idcus); // Tong tien sau khi giam gia
		
		int Sumtotal = OrderDetail_DAO.DisplaySumOrder(conn, IdOrder);
		
		int TotalAfterDiscount = Sumtotal - discountMoney;
		
		if (TotalAfterDiscount > 0 || TotalAfterDiscount == 0) // Tru thieu tien hoa don OR tru du tien hoa don
		{
			boolean checkUpdateOrder = OrderDetail_DAO.UpdateTotalOrder(conn, IdOrder, TotalAfterDiscount);
			if (checkUpdateOrder) // Cap nhat tong tien hoa don thanh cong
			{
				int BalancePoint = OrderDetail_DAO.balancePoint(conn, idcus);
				boolean checkUpdatePoint = OrderDetail_DAO.updatePoint(conn, idcus, BalancePoint);
				if (checkUpdatePoint) //Cap nhat diem thanh cong
				{
					List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
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
					request.setAttribute("discountM", discountMoney);
					request.setAttribute("afterdiscount", TotalAfterDiscount);
					
					request.setAttribute("msg1", "Discount order success - Customer balance point is :"+Point);
					request.setAttribute("msg3", "Id Customer: "+idcus+" | Id Order: "+IdOrder+" | Checkout: "+TotalAfterDiscount);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Discount_Order.jsp");
					rd.forward(request, response);
				}
				else //Cap nhat diem khong thanh cong
				{
					List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
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
					request.setAttribute("discountM", discountMoney);
					request.setAttribute("afterdiscount", TotalAfterDiscount);
					
					request.setAttribute("msg2", "Update Point's customer failed - Customer balance point is :"+Point);
					request.setAttribute("msg4", "Id Customer: "+idcus+" | Id Order: "+IdOrder+" | Checkout: "+TotalAfterDiscount);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Discount_Order.jsp");
					rd.forward(request, response);
				}
			}
			else // Cap nhat tong tien hoa don khong thanh cong
			{
				List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
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
				request.setAttribute("discountM", discountMoney);
				request.setAttribute("afterdiscount", TotalAfterDiscount);
				
				request.setAttribute("msg2", "Update order total failed - Customer balance point is :"+Point);
				request.setAttribute("msg4", "Id Customer: "+idcus+" | Id Order: "+IdOrder+" | Checkout: "+TotalAfterDiscount);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Discount_Order.jsp");
				rd.forward(request, response);
			}

		}
		else if(TotalAfterDiscount < 0)// Tru du tien hoa don
		{
			boolean checkUpdateOrder = OrderDetail_DAO.UpdateTotalOrder(conn, IdOrder, 0);
			if (checkUpdateOrder) // Cap nhat tong tien hoa don thanh cong
			{
				int BalancePointConvertFromMoney = Math.abs(TotalAfterDiscount) / 200; //Tinh so diem sau khi thanh toan ma tien thi du(So tien doi tu Point lon hon so tien thanh toan)
				int BalancePoint = OrderDetail_DAO.balancePoint(conn, idcus); //Lay ra diem du khi quy doi thanh tien
				boolean checkUpdatePoint = OrderDetail_DAO.updatePoint(conn, idcus, BalancePoint + BalancePointConvertFromMoney);
				if (checkUpdatePoint) //Cap nhat diem thanh cong
				{
					List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
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
					request.setAttribute("discountM", discountMoney);
					request.setAttribute("afterdiscount", 0);
					
					request.setAttribute("msg1", "Discount order success - Customer balance point is :"+Point);
					request.setAttribute("msg3", "Id Customer: "+idcus+" | Id Order: "+IdOrder+" | Checkout: "+0);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Discount_Order.jsp");
					rd.forward(request, response);
				}
				else //Cap nhat diem khong thanh cong
				{
					List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
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
					request.setAttribute("discountM", discountMoney);
					request.setAttribute("afterdiscount", TotalAfterDiscount);
					
					request.setAttribute("msg2", "Update Point's customer failed - Customer balance point is :"+Point);
					request.setAttribute("msg4", "Id Customer: "+idcus+" | Id Order: "+IdOrder+" | Checkout: "+TotalAfterDiscount);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Discount_Order.jsp");
					rd.forward(request, response);
				}
			}
			else // Cap nhat tong tien hoa don khong thanh cong
			{
				List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
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
				request.setAttribute("discountM", discountMoney);
				request.setAttribute("afterdiscount", TotalAfterDiscount);
				
				request.setAttribute("msg2", "Update order total failed - Customer balance point is :"+Point);
				request.setAttribute("msg4", "Id Customer: "+idcus+" | Id Order: "+IdOrder+" | Checkout: "+TotalAfterDiscount);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Discount_Order.jsp");
				rd.forward(request, response);
			}		
		}
		else
		{
			List<BILL> listbill = OrderDetail_DAO.DisplayBill(conn, IdOrder);
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
			request.setAttribute("discountM", discountMoney);
			request.setAttribute("afterdiscount", TotalAfterDiscount);
			
			request.setAttribute("msg2", "BIG ERROR - Customer balance point is :"+Point);
			request.setAttribute("msg4", "Id Customer: "+idcus+" | Id Order: "+IdOrder+" | Checkout: "+TotalAfterDiscount);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Order/Checkout_Discount_Order.jsp");
			rd.forward(request, response);
		}


		
		
	}

}
