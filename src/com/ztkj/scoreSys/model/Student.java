package com.ztkj.scoreSys.model;

public class Student {
	private int id;
    private String stuno;
    private String stuname;
    private String spwd;
    private String gender;
    private String birthday;
    private Integer age;
	private Classes cl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public Classes getCl() {
		return cl;
	}

	public void setCl(Classes cl) {
		this.cl = cl;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", stuno='" + stuno + '\'' +
				", stuname='" + stuname + '\'' +
				", spwd='" + spwd + '\'' +
				", gender='" + gender + '\'' +
				", birthday=" + birthday +
				", age=" + age +
				", cl=" + cl +
				'}';
	}

	public Student(){}

	public Student(int id, String stuno, String stuname, String spwd, String gender, String birthday, Integer age, Classes cl) {
		this.id = id;
		this.stuno = stuno;
		this.stuname = stuname;
		this.spwd = spwd;
		this.gender = gender;
		this.birthday = birthday;
		this.age = age;
		this.cl = cl;
	}

	public Student(String stuno, String stuname, String spwd, String gender, String birthday, Integer age, Classes cl) {
		this.stuno = stuno;
		this.stuname = stuname;
		this.spwd = spwd;
		this.gender = gender;
		this.birthday = birthday;
		this.age = age;
		this.cl = cl;
	}
}
