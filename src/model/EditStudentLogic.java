package model;

import dao.StudentDAO;

public class EditStudentLogic {
	public void execute(Student student) {
		StudentDAO dao = new StudentDAO();
		dao.edit(student);
	}
}
