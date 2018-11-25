package model;

import dao.StudentDAO;

public class SearchStudentByIdLogic {
	public Student execute(String id) {
		StudentDAO dao = new StudentDAO();
		Student student = dao.searchById(id);
		return student;
	}
}
