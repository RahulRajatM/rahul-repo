package Pojo;

public class PojoLibrary {

	//global variable
	public String name;
	public int id;
	public long phoneNo;
	public String email;


	// zero parameterized constructor
	public PojoLibrary() {
	}

	//parameterized constructor
	public PojoLibrary(String name, int id, long phoneNo, String email) {
		super();
		this.name = name;
		this.id = id;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	// getter and setter methods
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
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
