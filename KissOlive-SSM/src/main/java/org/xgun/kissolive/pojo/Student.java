package org.xgun.kissolive.pojo;

import java.util.Objects;

public class Student {
    private String sno;
    private String sname;
    private String ssex;
    private String sbirth;
    private String spwd;
    private String sdno;
    private String dname;//院系

    public Student() {
    }

    public Student(String sno, String sname, String ssex, String sbirth, String spwd, String sdno, String dname) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sbirth = sbirth;
        this.spwd = spwd;
        this.sdno = sdno;
        this.dname = dname;
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

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSbirth() {
        return sbirth;
    }

    public void setSbirth(String sbirth) {
        this.sbirth = sbirth;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }

    public String getSdno() {
        return sdno;
    }

    public void setSdno(String sdno) {
        this.sdno = sdno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sbirth='" + sbirth + '\'' +
                ", spwd='" + spwd + '\'' +
                ", sdno='" + sdno + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getSno(), student.getSno()) &&
                Objects.equals(getSname(), student.getSname()) &&
                Objects.equals(getSsex(), student.getSsex()) &&
                Objects.equals(getSbirth(), student.getSbirth()) &&
                Objects.equals(getSpwd(), student.getSpwd()) &&
                Objects.equals(getSdno(), student.getSdno()) &&
                Objects.equals(getDname(), student.getDname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSno(), getSname(), getSsex(), getSbirth(), getSpwd(), getSdno(), getDname());
    }
}
