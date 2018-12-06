package org.xgun.kissolive.pojo;

import java.util.Objects;

public class Course {
    private int cno;
    private String ctype;
    private String cterm;
    private String cdesc;
    private String ctno;
    private String cname;
    private int ccredit;
    private int cresnum;
    private int cstatus;
    private String tname;

    public Course() {
    }

    public Course(int cno, String ctype, String cterm, String cdesc, String ctno, String cname, int ccredit, int cresnum, int cstatus, String tname) {
        this.cno = cno;
        this.ctype = ctype;
        this.cterm = cterm;
        this.cdesc = cdesc;
        this.ctno = ctno;
        this.cname = cname;
        this.ccredit = ccredit;
        this.cresnum = cresnum;
        this.cstatus = cstatus;
        this.tname = tname;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCterm() {
        return cterm;
    }

    public void setCterm(String cterm) {
        this.cterm = cterm;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    public String getCtno() {
        return ctno;
    }

    public void setCtno(String ctno) {
        this.ctno = ctno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCcredit() {
        return ccredit;
    }

    public void setCcredit(int ccredit) {
        this.ccredit = ccredit;
    }

    public int getCresnum() {
        return cresnum;
    }

    public void setCresnum(int cresnum) {
        this.cresnum = cresnum;
    }

    public int getCstatus() {
        return cstatus;
    }

    public void setCstatus(int cstatus) {
        this.cstatus = cstatus;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getCno() == course.getCno() &&
                getCcredit() == course.getCcredit() &&
                getCresnum() == course.getCresnum() &&
                getCstatus() == course.getCstatus() &&
                Objects.equals(getCtype(), course.getCtype()) &&
                Objects.equals(getCterm(), course.getCterm()) &&
                Objects.equals(getCdesc(), course.getCdesc()) &&
                Objects.equals(getCtno(), course.getCtno()) &&
                Objects.equals(getCname(), course.getCname()) &&
                Objects.equals(getTname(), course.getTname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCno(), getCtype(), getCterm(), getCdesc(), getCtno(), getCname(), getCcredit(), getCresnum(), getCstatus(), getTname());
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno=" + cno +
                ", ctype='" + ctype + '\'' +
                ", cterm='" + cterm + '\'' +
                ", cdesc='" + cdesc + '\'' +
                ", ctno='" + ctno + '\'' +
                ", cname='" + cname + '\'' +
                ", ccredit=" + ccredit +
                ", cresnum=" + cresnum +
                ", cstatus=" + cstatus +
                ", tname='" + tname + '\'' +
                '}';
    }
}
