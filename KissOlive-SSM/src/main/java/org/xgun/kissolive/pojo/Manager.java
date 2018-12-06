package org.xgun.kissolive.pojo;

import java.util.Objects;

public class Manager {
    private String mno;
    private String mname;
    private String mpwd;

    public Manager() {
    }

    public Manager(String mno, String mname, String mpwd) {
        this.mno = mno;
        this.mname = mname;
        this.mpwd = mpwd;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpwd() {
        return mpwd;
    }

    public void setMpwd(String mpwd) {
        this.mpwd = mpwd;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mno='" + mno + '\'' +
                ", mname='" + mname + '\'' +
                ", mpwd='" + mpwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(getMno(), manager.getMno()) &&
                Objects.equals(getMname(), manager.getMname()) &&
                Objects.equals(getMpwd(), manager.getMpwd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMno(), getMname(), getMpwd());
    }
}
