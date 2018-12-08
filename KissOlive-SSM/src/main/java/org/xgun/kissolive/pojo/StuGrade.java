package org.xgun.kissolive.pojo;

public class StuGrade {
    private String sno;
    private String sname;
    private int grade;
    private int cno;

    public StuGrade() {
    }

    public StuGrade(String sno, String sname, int grade, int cno) {
        this.sno = sno;
        this.sname = sname;
        this.grade = grade;
        this.cno = cno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    @Override
    public String toString() {
        return "StuGrade{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", grade=" + grade +
                ", cno=" + cno +
                '}';
    }
}
