package BEAN;

public class USERS {
	protected String Account_User;
	protected String Password_User;
	private String Id_Group_User;
	
	//getter & setter Account_User
	public String getAccount_User() {
		return Account_User;
	}
	public void setAccount_User(String account_User) {
		Account_User = account_User;
	}
	
	//getter & setter Password_User
	public String getPassword_User() {
		return Password_User;
	}
	public void setPassword_User(String password_User) {
		Password_User = password_User;
	}
	
	//getter & setter Id_Group_User
	public String getId_Group_User() {
		return Id_Group_User;
	}
	public void setId_Group_User(String id_Group_User) {
		Id_Group_User = id_Group_User;
	}
}
