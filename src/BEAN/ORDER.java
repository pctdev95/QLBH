package BEAN;

import java.sql.Date;

public class ORDER {
	private int Id_Order;
	private Date Order_Date;
	private int Sum_Amount_Order;
	private int Sum_Point;
	private String Id_Customer;
	private String Id_Employee;
	
	//getter & setter Id_Order
	public int getId_Order() {
		return Id_Order;
	}
	public void setId_Order(int id_Order) {
		Id_Order = id_Order;
	}
	
	//getter & setter Order_Date
	public Date getOrder_Date() {
		return Order_Date;
	}
	public void setOrder_Date(Date order_Date) {
		Order_Date = order_Date;
	}
	
	//getter & setter Sum_Amount_Order
	public int getSum_Amount_Order() {
		return Sum_Amount_Order;
	}
	public void setSum_Amount_Order(int sum_Amount_Order) {
		Sum_Amount_Order = sum_Amount_Order;
	}
	
	//getter & setter Sum_Point
	public int getSum_Point() {
		return Sum_Point;
	}
	public void setSum_Point(int sum_Point) {
		Sum_Point = sum_Point;
	}
	
	//getter & setter Id_Customer
	public String getId_Customer() {
		return Id_Customer;
	}
	public void setId_Customer(String id_Customer) {
		Id_Customer = id_Customer;
	}
	
	//getter & setter Id_Employee
	public String getId_Employee() {
		return Id_Employee;
	}
	public void setId_Employee(String id_Employee) {
		Id_Employee = id_Employee;
	}

	
	
	
}
