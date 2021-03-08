package com.maarouf.qaApp.PacketsManager;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class QuestionsByTypePacket {
    @JsonProperty(value="pagenumber")
    private int pagenumber;

    @JsonProperty(value="typename")
    private String typename;

    public QuestionsByTypePacket(int pagenumber, String typename) {
        this.pagenumber = pagenumber;
        this.typename = typename;
    }

    public QuestionsByTypePacket(){

    }

    public int getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionsByTypePacket that = (QuestionsByTypePacket) o;
        return pagenumber == that.pagenumber && Objects.equals(typename, that.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagenumber, typename);
    }

    @Override
    public String toString() {
        return "QuestionsByTypePacket{" +
                "pagenumber=" + pagenumber +
                ", typename='" + typename + '\'' +
                '}';
    }
}
