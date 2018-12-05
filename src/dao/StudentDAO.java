package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAO {
	public List<Student> search(Student student){
		Connection conn = null;

		String id = student.getId();
		String name = student.getName();
		String kana = student.getKana();
		String birthday = student.getBirthday();
		String school = student.getSchool();
		List<Student> studentList = new ArrayList<Student>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/record", "root", "root");
			String sql = "SELECT ID,NAME,KANA,BIRTHDAY,SCHOOL FROM STUDENT";
			String whereOrAnd = " WHERE";

			if(id != null && id != "") {
				sql  += whereOrAnd + " ID=?";
				whereOrAnd =" AND";
			}
			if(name != null && name != "") {
				sql  += whereOrAnd + " NAME LIKE ?";
				whereOrAnd =" AND";
			}
			if(kana != null && kana != "") {
				sql  += whereOrAnd + " KANA LIKE ?";
				whereOrAnd =" AND";
			}
			if(birthday != null && birthday != "") {
				sql  += whereOrAnd + " BIRTHDAY=?";
				whereOrAnd =" AND";
			}
			if(school != null && school != "") {
				sql  += whereOrAnd + " SCHOOL=?";
				whereOrAnd =" AND";
			}

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt = conn.prepareStatement(sql);

			int i = 1;
			if(id != null && id != "") {
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(i, id);
				i++;
			}
			if(name != null && name != "") {
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(i, "%" + name + "%");
				i++;
			}
			if(kana != null && kana != "") {
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(i, "%" + kana + "%");
				i++;
			}
			if(birthday != null && birthday != "") {
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(i, birthday);
				i++;
			}
			if(school != null && school != "") {
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(i, school);
				i++;
			}

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				id = rs.getString("ID");
				name = rs.getString("NAME");
				kana = rs.getString("KANA");
				birthday = rs.getString("BIRTHDAY");
				school = rs.getString("SCHOOL");
				student = new Student(id, name, kana, birthday, school);
				studentList.add(student);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return studentList;
	}

	public Student searchById(String id){
		Connection conn = null;
		Student student = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/record", "root", "root");
			String sql = "SELECT ID,NAME,KANA,BIRTHDAY,SCHOOL FROM STUDENT WHERE ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);

			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				 id = rs.getString("ID");
				String name = rs.getString("NAME");
				String kana = rs.getString("KANA");
				String birthday = rs.getString("BIRTHDAY");
				String school = rs.getString("SCHOOL");
				student = new Student(id, name, kana, birthday, school);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return student;
	}

	public boolean edit(Student student){
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/record", "root", "root");
			String sql = "UPDATE STUDENT SET NAME=?,KANA=?,BIRTHDAY=?,SCHOOL=? WHERE ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, student.getName());
			pStmt.setString(2, student.getKana());
			pStmt.setString(3, student.getBirthday());
			pStmt.setString(4, student.getSchool());
			pStmt.setString(5, student.getId());

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	public boolean register(Student registered){
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/record", "root", "root");
			String sql = "INSERT INTO STUDENT (NAME,KANA,BIRTHDAY,SCHOOL) VALUES (?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, registered.getName());
			pStmt.setString(2, registered.getKana());
			pStmt.setString(3, registered.getBirthday());
			pStmt.setString(4, registered.getSchool());

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	public boolean delete(String id){
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/record", "root", "root");
			String sql = "DELETE FROM STUDENT WHERE ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

}
