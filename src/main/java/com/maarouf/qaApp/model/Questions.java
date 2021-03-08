package com.maarouf.qaApp.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qid;

    @Column(name="qtext")
    @NonNull
    private String qtext;

    @Column(name = "typeid")
    @NonNull
    private Long typeid;

    public Questions(String qtext, Long typeid) {
        this.qtext = qtext;
        this.typeid = typeid;
    }

    public Questions() {

    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getQtext() {
        return qtext;
    }

    public void setQtext(String qtext) {
        this.qtext = qtext;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questions questions = (Questions) o;
        return Objects.equals(qid, questions.qid) && Objects.equals(qtext, questions.qtext) && Objects.equals(typeid, questions.typeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qid, qtext, typeid);
    }

    @Override
    public String toString() {
        return "Questions{" +
                "qid=" + qid +
                ", qtext='" + qtext + '\'' +
                ", typeid=" + typeid +
                '}';
    }
}
