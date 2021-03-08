package com.maarouf.qaApp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answers")
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerid;

    @Column(name="answer")
    private String answer;

    @Column(name="qid")
    private Long qid;

    public Answers(String answer, Long qid) {
        this.answer = answer;
        this.qid = qid;
    }

    public Answers() {

    }

    public Long getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Long answerid) {
        this.answerid = answerid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answers answers = (Answers) o;
        return Objects.equals(answerid, answers.answerid) && Objects.equals(answer, answers.answer) && Objects.equals(qid, answers.qid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerid, answer, qid);
    }

    @Override
    public String toString() {
        return "Answers{" +
                "answerid=" + answerid +
                ", answer='" + answer + '\'' +
                ", qid=" + qid +
                '}';
    }
}
