package com.maarouf.qaApp.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="questiontypes")
public class QuestionTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeid;

    @Column(name = "typename")
    private String typename;

    public QuestionTypes(/*@JsonProperty("typename")*/ String typename) {
        this.typename = typename;
    }

    public QuestionTypes() {

    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionTypes that = (QuestionTypes) o;
        return Objects.equals(typeid, that.typeid) && Objects.equals(typename, that.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeid, typename);
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }


}
