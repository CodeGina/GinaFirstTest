package org.xgun.kissolive.pojo;

public class StuGradeDto {
    private String cname;
    private int cno;
    private String sno;
    private String termno;
    private int grade;

    @Override
    public String toString() {
        return "StuGradeDto{" +
                "cname='" + cname + '\'' +
                ", cno=" + cno +
                ", sno='" + sno + '\'' +
                ", termno='" + termno + '\'' +
                ", grade=" + grade +
                '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getTermno() {
        return termno;
    }

    public void setTermno(String termno) {
        this.termno = termno;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public StuGradeDto(String cname, int cno, String sno, String termno, int grade) {
        this.cname = cname;
        this.cno = cno;
        this.sno = sno;
        this.termno = termno;
        this.grade = grade;
    }

    public StuGradeDto() {
    }
}
