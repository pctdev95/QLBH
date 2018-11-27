package BEAN;

import java.sql.Date;

public class CUSTOMER extends USERS{
	private int Id_Customer;
	private String First_Name_Customer;
    private String Last_Name_Customer;
    private boolean Gender_Customer;
    private Date DOB_Customer;
    private String Id_Card_Customer;
    private String Address_Customer;
    private String Phone_Customer;
    private int Points;
    
    //getter && setterId_Customer
	public int getId_Customer() {
		return Id_Customer;
	}
	public void setId_Customer(int id_Customer) {
		Id_Customer = id_Customer;
	}
	
	//getter && setter First_Name_Customer
	public String getFirst_Name_Customer() {
		return First_Name_Customer;
	}
	public void setFirst_Name_Customer(String first_Name_Customer) {
		First_Name_Customer = first_Name_Customer;
	}
	
	//getter && setter Last_Name_Customer
	public String getLast_Name_Customer() {
		return Last_Name_Customer;
	}
	public void setLast_Name_Customer(String last_Name_Customer) {
		Last_Name_Customer = last_Name_Customer;
	}
	
	//getter && setter Gender_Customer
	public boolean isGender_Customer() {
		return Gender_Customer;
	}
	public void setGender_Customer(boolean gender_Customer) {
		Gender_Customer = gender_Customer;
	}
	
	//getter && setter DOB_Customer
	public Date getDOB_Customer() {
		return DOB_Customer;
	}
	public void setDOB_Customer(Date dOB_Customer) {
		DOB_Customer = dOB_Customer;
	}
	
	//getter && setter Id_Card_Customer
	public String getId_Card_Customer() {
		return Id_Card_Customer;
	}
	public void setId_Card_Customer(String id_Card_Customer) {
		Id_Card_Customer = id_Card_Customer;
	}
	
	//getter && setter Address_Customer
	public String getAddress_Customer() {
		return Address_Customer;
	}
	public void setAddress_Customer(String address_Customer) {
		Address_Customer = address_Customer;
	}
	
	//getter && setter Phone_Customer
	public String getPhone_Customer() {
		return Phone_Customer;
	}
	public void setPhone_Customer(String phone_Customer) {
		Phone_Customer = phone_Customer;
	}
	
	//getter && setter Points
	public int getPoints() {
		return Points;
	}
	public void setPoints(int points) {
		Points = points;
	}


}
