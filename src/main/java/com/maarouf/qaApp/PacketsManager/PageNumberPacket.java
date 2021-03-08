package com.maarouf.qaApp.PacketsManager;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class PageNumberPacket {
    @JsonProperty(value = "pagenumber")
    private int pagenumber;

    public PageNumberPacket(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    public PageNumberPacket() {

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
        PageNumberPacket that = (PageNumberPacket) o;
        return pagenumber == that.pagenumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagenumber);
    }

    @Override
    public String toString() {
        return "PageNumberPacket{" +
                "pagenumber=" + pagenumber +
                '}';
    }
}
