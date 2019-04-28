package com.songnan.student_exam_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "request")
public class Request {
    @Id
    private Integer id;
    private String description;
    private String api;
    private String httpMethod;

    @OneToMany(mappedBy = "request")
    @JsonManagedReference
    private Set<HttpParam> params;

    public Request() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApi() {
        return this.api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Set<HttpParam> getParams() {
        return this.params;
    }

    public void setParams(Set<HttpParam> params) {
        this.params = params;
    }
}
