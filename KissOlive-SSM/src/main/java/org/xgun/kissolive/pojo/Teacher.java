package org.xgun.kissolive.pojo;

import java.util.Objects;

public class Teacher {
    private String tno;
    private String tname;
    private String tsex;
    private String tbirth;
    private String teducation;
    private String tposition;
    private String tintroduction;
    private String tpwd;

    public Teacher() {
    }

    public Teacher(String tno, String tname, String tsex, String tbirth, String teducation, String tposition, String tintroduction, String tpwd) {
        this.tno = tno;
        this.tname = tname;
        this.tsex = tsex;
        this.tbirth = tbirth;
        this.teducation = teducation;
        this.tposition = tposition;
        this.tintroduction = tintroduction;
        this.tpwd = tpwd;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTbirth() {
        return tbirth;
    }

    public void setTbirth(String tbirth) {
        this.tbirth = tbirth;
    }

    public String getTeducation() {
        return teducation;
    }

    public void setTeducation(String teducation) {
        this.teducation = teducation;
    }

    public String getTposition() {
        return tposition;
    }

    public void setTposition(String tposition) {
        this.tposition = tposition;
    }

    public String getTintroduction() {
        return tintroduction;
    }

    public void setTintroduction(String tintroduction) {
        this.tintroduction = tintroduction;
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tbirth='" + tbirth + '\'' +
                ", teducation='" + teducation + '\'' +
                ", tposition='" + tposition + '\'' +
                ", tintroduction='" + tintroduction + '\'' +
                ", tpwd='" + tpwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getTno(), teacher.getTno()) &&
                Objects.equals(getTname(), teacher.getTname()) &&
                Objects.equals(getTsex(), teacher.getTsex()) &&
                Objects.equals(getTbirth(), teacher.getTbirth()) &&
                Objects.equals(getTeducation(), teacher.getTeducation()) &&
                Objects.equals(getTposition(), teacher.getTposition()) &&
                Objects.equals(getTintroduction(), teacher.getTintroduction()) &&
                Objects.equals(getTpwd(), teacher.getTpwd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTno(), getTname(), getTsex(), getTbirth(), getTeducation(), getTposition(), getTintroduction(), getTpwd());
    }
}
