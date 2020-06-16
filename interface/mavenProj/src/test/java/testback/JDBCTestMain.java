package testback;

import java.util.*;
import dao.*;
import web.*;

public class JDBCTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//增
		SqlVisiter.executeUpdate(
			"insert into students (student_id, name, point) value(?,?,?)",
			"170105040007",
			"小伙子",
			88.32
		);
		
		List<Student> students = SqlVisiter.executeQuery(
				"select * from students",
				Student.class
		);
		for(Student student : students)
			System.out.println(student.toString());
		
		//删
		SqlVisiter.executeUpdate("delete from students where name=?", "小伙子");
		
		//改
		SqlVisiter.executeUpdate("update students set point=? where name=?", 66.66, "温宇东");
		
		//查
		List<Student> stuwen = SqlVisiter.executeQuery(
			"select * from students where name=?",
			Student.class,
			"温宇东"
		);
		
		for(Student student : stuwen)
			System.out.println(student.toString());
	}

}
