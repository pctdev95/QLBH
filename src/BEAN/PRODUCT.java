package BEAN;

import java.sql.Date;

public class PRODUCT {
	private String Id_Product;
	private String Name_Product;
	private String Calculation_Unit;
	private String Manufacturer;
	private Date Import_Date;
	private int Import_Prices_Product;
	private int Export_Prices_Product;
	private int In_Stock;
	private String Id_Product_Type;
	
	//getter & setter Id_Product
	public String getId_Product() {
		return Id_Product;
	}
	public void setId_Product(String id_Product) {
		Id_Product = id_Product;
	}
	
	//getter & setter Name_Product
	public String getName_Product() {
		return Name_Product;
	}
	public void setName_Product(String name_Product) {
		Name_Product = name_Product;
	}
	
	//getter & setter alculation_Unit
	public String getCalculation_Unit() {
		return Calculation_Unit;
	}
	public void setCalculation_Unit(String calculation_Unit) {
		Calculation_Unit = calculation_Unit;
	}
	
	//getter & setter Manufacturer
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	
	//getter & setter Import_Date
	public Date getImport_Date() {
		return Import_Date;
	}
	public void setImport_Date(Date import_Date) {
		Import_Date = import_Date;
	}
	
	//getter & setter Import_Prices_Product
	public int getImport_Prices_Product() {
		return Import_Prices_Product;
	}
	public void setImport_Prices_Product(int import_Prices_Product) {
		Import_Prices_Product = import_Prices_Product;
	}
	
	//getter & setter Export_Prices_Product
	public int getExport_Prices_Product() {
		return Export_Prices_Product;
	}
	public void setExport_Prices_Product(int export_Prices_Product) {
		Export_Prices_Product = export_Prices_Product;
	}
	
	//getter & setter In_Stock
	public int getIn_Stock() {
		return In_Stock;
	}
	public void setIn_Stock(int in_Stock) {
		In_Stock = in_Stock;
	}
	
	//getter & setter Id_Product_Type
	public String getId_Product_Type() {
		return Id_Product_Type;
	}
	public void setId_Product_Type(String id_Product_Type) {
		Id_Product_Type = id_Product_Type;
	}
}
