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

@WebServlet("/Delete_Order_Detail_Controller")
public class Delete_Order_Detail_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete_Order_Detail_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DB.DBConnection.CreateConnection();
		
		String Idord = request.getParameter("idord");
		String idcus = request.getParameter("idcus");
		CUSTOMER cus = new CUSTOMER();
		cus = Customer_DAO.Choose_Customer(conn, idcus);
		int IdOrder = Integer.parseInt(Idord);
		Date date = Order_DAO.getDate(conn);
		String Idemp = request.getParameter("idemp");
		
		String Id = request.getParameter("id");
		int IdOrderDetail = Integer.parseInt(Id);
		
		String idProduct = OrderDetail_DAO.getIdProduct(conn, Id); 
		int Quantity = OrderDetail_DAO.getQuantity(conn, Id);
		
		boolean checkUpdate = OrderDetail_DAO.UpdateInStockWhenRemove(conn, idProduct, Quantity);
		
		if(checkUpdate)//Cap nhat hang trong kho thanh cong
		{
			boolean checkRemoveOrderDetail = OrderDetail_DAO.RemoveProduct(conn,IdOrderDetail);
			
			if (checkRemoveOrderDetail) //Xoa san pham khoi hoa don thanh cong
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
				
				request.setAttribute("msg1", "Remove 1 Product");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/OrderDetail/Add_Order_Detail.jsp");
				rd.forward(request, response);
			}
			else//Xoa san pham khoi hoa don khong thanh cong
			{
				request.setAttribute("msg2", "Can't remove Product");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/OrderDetail/Add_Order_Detail.jsp");
				rd.forward(request, response);
			}
		}
		else//Cap nhat hang trong kho khong thanh cong
		{
			request.setAttribute("msg2", "Can't update in stock");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/OrderDetail/Add_Order_Detail.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
