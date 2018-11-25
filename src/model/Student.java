package model;

public class Student {
	private String id;
	private String name;
	private String kana;
	private String birthday;
	private String school;

	public Student() {}
	public Student(String name, String kana, String birthday, String school) {
		this.name = name;
		this.kana = kana;
		this.birthday = birthday;
		this.school = school;
	}
	public Student(String id, String name, String kana, String birthday, String school) {
		this.id = id;
		this.name = name;
		this.kana = kana;
		this.birthday = birthday;
		this.school = school;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getKana() {
		return kana;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getSchool() {
		return school;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setSchool(String school) {
		this.school = school;
	}


}
