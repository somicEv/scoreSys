package com.ztkj.scoreSys.model;

public class Teacher {
	private int id; 
    private String tname;
    private String tpwd;
    private String collage;
    
    public Teacher(){}
    
	public Teacher(String tname, String tpwd, String collage) {
		super();
		this.tname = tname;
		this.tpwd = tpwd;
		this.collage = collage;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	public String getCollage() {
		return collage;
	}

	public void setCollage(String collage) {
		this.collage = collage;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"id=" + id +
				", tname='" + tname + '\'' +
				", tpwd='" + tpwd + '\'' +
				", collage='" + collage + '\'' +
				'}';
	}
}
