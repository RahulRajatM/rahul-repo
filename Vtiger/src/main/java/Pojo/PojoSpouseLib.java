package Pojo;

public class PojoSpouseLib {

	//global variable
	public String name;
	public int phoneNo;
	public int id;

	//parameterized constructor
	public PojoSpouseLib(String name, int phoneNo, int id) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.id = id;
	}

	//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



}
