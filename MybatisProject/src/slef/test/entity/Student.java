package slef.test.entity;

public class Student {
	private int sNo;
	private  String sName;
	private  int sAge;
	private  String graName;
	public Student() {

	}
	public Student(int sNo, String sName, int sAge, String graName) {
		
		this.sNo = sNo;
		this.sName = sName;
		this.sAge = sAge;
		this.graName = graName;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	public String getGraName() {
		return graName;
	}
	public void setGraName(String graName) {
		this.graName = graName;
	}
	@Override
	public String toString() {
		return "Student [sNo=" + sNo + ", sName=" + sName + ", sAge=" + sAge + ", graName=" + graName + "]";
	}
	
}
