package model;

import dao.StudentDAO;

public class DeleteStudentLogic {
	public void execute(String id) {
		StudentDAO dao = new StudentDAO();
		dao.delete(id);
	}
}
