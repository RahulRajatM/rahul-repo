package Pojo;

public class PojoArrayLib {

	// global variable 
	public String name;
	public int id;
	public	String emailId;
	public int[] phoneNo;

	//parameterized  constructor
	public PojoArrayLib(String name, int id, String emailId, int[] phoneNo) {
		super();
		this.name = name;
		this.id = id;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}
	//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int[] getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int[] phoneNo) {
		this.phoneNo = phoneNo;
	}


}
