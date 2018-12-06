package org.xgun.kissolive.pojo;

import java.util.Objects;

public class Department {
    private String dno;
    private String dname;
    private String dmanager;
    private String dtel;

    public Department() {
    }

    public Department(String dno, String dname, String dmanager, String dtel) {
        this.dno = dno;
        this.dname = dname;
        this.dmanager = dmanager;
        this.dtel = dtel;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDmanager() {
        return dmanager;
    }

    public void setDmanager(String dmanager) {
        this.dmanager = dmanager;
    }

    public String getDtel() {
        return dtel;
    }

    public void setDtel(String dtel) {
        this.dtel = dtel;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dno='" + dno + '\'' +
                ", dname='" + dname + '\'' +
                ", dmanager='" + dmanager + '\'' +
                ", dtel='" + dtel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(getDno(), that.getDno()) &&
                Objects.equals(getDname(), that.getDname()) &&
                Objects.equals(getDmanager(), that.getDmanager()) &&
                Objects.equals(getDtel(), that.getDtel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDno(), getDname(), getDmanager(), getDtel());
    }
}
