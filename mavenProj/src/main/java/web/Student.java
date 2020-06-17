package web;

public class Student {

	private int id;
	//数据库属性在规范上上应该是小驼峰
	private String studentId;
	private String name;
	private double point;
	
	@Override
	public String toString() {
		return id + "\t" + studentId + "\t" + name + "\t" + point;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}
}
