package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeleteStudentLogic;
import model.EditStudentLogic;
import model.RegisterStudentLogic;
import model.SearchStudentLogic;
import model.Student;

/**
 * Servlet implementation class StudentDataServlet
 */
@WebServlet("/StudentDataServlet")
public class StudentDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/jsp/studentList.jsp";
		//リクエストパラメーターの取得
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String index = request.getParameter("index");
		//前回の検索条件を取得
		HttpSession session = request.getSession();
		Student criteria = (Student)session.getAttribute("criteria");
		if(action != null) {
			//編集，削除，新規登録の分岐
			switch (action) {
			case "edit":
				List<Student> studentList = (List<Student>)session.getAttribute("studentList");
//				SearchStudentByIdLogic ssbiLogic = new SearchStudentByIdLogic();
				Student student = studentList.get(Integer.parseInt(index));
				request.setAttribute("student", student);
				path = "/WEB-INF/jsp/editStudentData.jsp";
				break;
			case "delete":
				DeleteStudentLogic dsLogic = new DeleteStudentLogic();
				dsLogic.execute(id);
				break;
			case "register":
				path = "/WEB-INF/jsp/registerStudentData.jsp";
				break;
			}
		}
		if(criteria != null) {
			//検索を実行，結果をstudentListに格納
			SearchStudentLogic ssLogic = new SearchStudentLogic();
			List<Student> studentList = ssLogic.execute(criteria);
			//studenListをセッションスコープに保存
			session.setAttribute("studentList", studentList);
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/jsp/studentList.jsp";
		//リクエストパラメーターの取得
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String kana = request.getParameter("kana");
		String birthday = request.getParameter("birthday");
		String school = request.getParameter("school");
		//前回の検索条件を取得
		HttpSession session = request.getSession();
		Student criteria = (Student)session.getAttribute("criteria");
		//検索，新規登録，編集の分岐
		switch (action) {
		case "search":
			criteria = new Student(id, name, kana, birthday, school);
			session.setAttribute("criteria", criteria);
			break;
		case "register":
			Student registered = new Student(name, kana, birthday, school);
			RegisterStudentLogic rsLogic = new RegisterStudentLogic();
			rsLogic.execute(registered);
			break;
		case "edit":
			Student edited = new Student(id, name, kana, birthday, school);
			EditStudentLogic esLogic = new EditStudentLogic();
			esLogic.execute(edited);
			break;
		}
		if(criteria != null) {
			//検索を実行，結果をstudentListに格納
			SearchStudentLogic ssLogic = new SearchStudentLogic();
			List<Student> studentList = ssLogic.execute(criteria);
			//studenListをセッションスコープに保存
			session.setAttribute("studentList", studentList);
		}
		//フォワード
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

}
