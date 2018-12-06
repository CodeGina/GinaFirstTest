package org.xgun.kissolive.pojo;

import java.util.Objects;

public class Term {
    private String termno;
    private String termdesc;

    public Term() {
    }

    public Term(String termno, String termdesc) {
        this.termno = termno;
        this.termdesc = termdesc;
    }

    public String getTermno() {
        return termno;
    }

    public void setTermno(String termno) {
        this.termno = termno;
    }

    public String getTermdesc() {
        return termdesc;
    }

    public void setTermdesc(String termdesc) {
        this.termdesc = termdesc;
    }

    @Override
    public String toString() {
        return "Term{" +
                "termno='" + termno + '\'' +
                ", termdesc='" + termdesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return Objects.equals(getTermno(), term.getTermno()) &&
                Objects.equals(getTermdesc(), term.getTermdesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTermno(), getTermdesc());
    }
}
