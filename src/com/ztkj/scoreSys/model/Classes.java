package com.ztkj.scoreSys.model;

public class Classes {
    private int id;
    private String clno;
    private String clname;
    private String collage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClno() {
        return clno;
    }

    public void setClno(String clno) {
        this.clno = clno;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public Classes() {
    }

    public Classes(String clno, String clname, String collage) {
        super();
        this.clno = clno;
        this.clname = clname;
        this.collage = collage;
    }

}
