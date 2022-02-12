package Pojo;

public class PojoEmpLib {

	//global variable
	public String name;
	public int id;
	public int phoneNo;
	Object spouse;
	
	//parameterized constructor
	public PojoEmpLib(String name, int id, int phoneNo, Object spouse) {
		super();
		this.name = name;
		this.id = id;
		this.phoneNo = phoneNo;
		this.spouse = spouse;
	}
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
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Object getSpouse() {
		return spouse;
	}
	public void setSpouse(Object spouse) {
		this.spouse = spouse;
	}


}
