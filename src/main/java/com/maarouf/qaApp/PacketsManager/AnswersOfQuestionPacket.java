package com.maarouf.qaApp.PacketsManager;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class AnswersOfQuestionPacket {
    @JsonProperty(value = "qid")
    private Long qid;

    @JsonProperty(value = "pagenumber")
    private int pagenumber;

    public AnswersOfQuestionPacket() {
    }

    public AnswersOfQuestionPacket(Long qid, int pagenumber) {
        this.qid = qid;
        this.pagenumber = pagenumber;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public int getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswersOfQuestionPacket that = (AnswersOfQuestionPacket) o;
        return Objects.equals(qid, that.qid) && Objects.equals(pagenumber, that.pagenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qid, pagenumber);
    }

    @Override
    public String toString() {
        return "AnswersOfQuestionPacket{" +
                "qid=" + qid +
                ", pagenumber=" + pagenumber +
                '}';
    }
}
