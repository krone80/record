package model;

import dao.StudentDAO;

public class RegisterStudentLogic {
	public void execute(Student registered) {
		StudentDAO dao = new StudentDAO();
		dao.register(registered);
	}
}
