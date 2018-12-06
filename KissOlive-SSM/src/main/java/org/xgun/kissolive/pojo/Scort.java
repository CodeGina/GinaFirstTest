package org.xgun.kissolive.pojo;

import java.util.Objects;

public class Scort {
    private int sno;
    private String ssno;
    private int scno;
    private int grade;
    private String stermno;

    private String cname;
    private int ccredit;
    private String tname;
    private int cresnum;
    private  String cdesc;

    public Scort() {
    }

    public Scort( String ssno, int scno, int grade, String stermno, String cname, int ccredit, String tname, int cresnum, String cdesc) {
        this.ssno = ssno;
        this.scno = scno;
        this.grade = grade;
        this.stermno = stermno;
        this.cname = cname;
        this.ccredit = ccredit;
        this.tname = tname;
        this.cresnum = cresnum;
        this.cdesc = cdesc;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSsno() {
        return ssno;
    }

    public void setSsno(String ssno) {
        this.ssno = ssno;
    }

    public int getScno() {
        return scno;
    }

    public void setScno(int scno) {
        this.scno = scno;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getStermno() {
        return stermno;
    }

    public void setStermno(String stermno) {
        this.stermno = stermno;
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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getCresnum() {
        return cresnum;
    }

    public void setCresnum(int cresnum) {
        this.cresnum = cresnum;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scort)) return false;
        Scort scort = (Scort) o;
        return getSno() == scort.getSno() &&
                getScno() == scort.getScno() &&
                getGrade() == scort.getGrade() &&
                getCcredit() == scort.getCcredit() &&
                getCresnum() == scort.getCresnum() &&
                Objects.equals(getSsno(), scort.getSsno()) &&
                Objects.equals(getStermno(), scort.getStermno()) &&
                Objects.equals(getCname(), scort.getCname()) &&
                Objects.equals(getTname(), scort.getTname()) &&
                Objects.equals(getCdesc(), scort.getCdesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSno(), getSsno(), getScno(), getGrade(), getStermno(), getCname(), getCcredit(), getTname(), getCresnum(), getCdesc());
    }
}
