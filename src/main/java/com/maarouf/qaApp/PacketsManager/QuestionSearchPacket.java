package com.maarouf.qaApp.PacketsManager;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class QuestionSearchPacket {
    @JsonProperty(value = "keyword")
    private String keyword;
    @JsonProperty(value="pagenumber")
    private int pagenumber;

    public QuestionSearchPacket(String keyword, int pagenumber) {
        this.keyword = keyword;
        this.pagenumber = pagenumber;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
        QuestionSearchPacket that = (QuestionSearchPacket) o;
        return pagenumber == that.pagenumber && Objects.equals(keyword, that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword, pagenumber);
    }

    @Override
    public String toString() {
        return "QuestionSearchPacket{" +
                "keyword='" + keyword + '\'' +
                ", pagenumber=" + pagenumber +
                '}';
    }
}
