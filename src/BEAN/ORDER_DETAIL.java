package BEAN;

public class ORDER_DETAIL {
	private int Id_Order_Detail;;
	private int Quantity;
	private int Sum_Amount_Order_Detail;
	private String Id_Product;
	private int Id_Order;
	
	//getter & setter Id_Order_Detail
	public int getId_Order_Detail() {
		return Id_Order_Detail;
	}
	public void setId_Order_Detail(int id_Order_Detail) {
		Id_Order_Detail = id_Order_Detail;
	}
	
	//getter & setter Quantity
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	//getter & setter Sum_Amount_Order_Detail
	public int getSum_Amount_Order_Detail() {
		return Sum_Amount_Order_Detail;
	}
	public void setSum_Amount_Order_Detail(int sum_Amount_Order_Detail) {
		Sum_Amount_Order_Detail = sum_Amount_Order_Detail;
	}
	
	//getter & setter Id_Product
	public String getId_Product() {
		return Id_Product;
	}
	public void setId_Product(String id_Product) {
		Id_Product = id_Product;
	}
	
	//getter & setter Id_Order
	public int getId_Order() {
		return Id_Order;
	}
	public void setId_Order(int id_Order) {
		Id_Order = id_Order;
	}
	
	

}
