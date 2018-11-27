package BEAN;

public class BILL {
	private int stt;
	private String Name_Product;
	private String Calculation_Unit;
	private int Export_Prices_Product;
	private int Quantity;
	private int Sum_Amount_Order_Detail;
	
	//getter & setter stt
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	
	//getter & setter name
	public String getName_Product() {
		return Name_Product;
	}
	public void setName_Product(String name_Product) {
		Name_Product = name_Product;
	}
	
	//getter & setter calculation
	public String getCalculation_Unit() {
		return Calculation_Unit;
	}
	public void setCalculation_Unit(String calculation_Unit) {
		Calculation_Unit = calculation_Unit;
	}
	
	//getter & setter price
	public int getExport_Prices_Product() {
		return Export_Prices_Product;
	}
	public void setExport_Prices_Product(int export_Prices_Product) {
		Export_Prices_Product = export_Prices_Product;
	}
	
	//getter & setter quantity
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	//getter & setter sumamount
	public int getSum_Amount_Order_Detail() {
		return Sum_Amount_Order_Detail;
	}
	public void setSum_Amount_Order_Detail(int sum_Amount_Order_Detail) {
		Sum_Amount_Order_Detail = sum_Amount_Order_Detail;
	}
	
	

}
