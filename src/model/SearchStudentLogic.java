package model;

import java.util.List;

import dao.StudentDAO;

public class SearchStudentLogic {
	public List<Student> execute(Student student){
		StudentDAO dao = new StudentDAO();
		List<Student> studentList = dao.search(student);
		return studentList;
	}
}
