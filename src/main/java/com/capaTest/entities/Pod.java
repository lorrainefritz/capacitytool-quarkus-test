package com.capaTest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Pod extends PanacheEntity {


    public String podName;
    public int restart;
    public String cpuReqLim;
    public String memReqLim;
    public String usgCpu;
    public String maxCpu;
    public String usgMem;
    public String maxMem;
    @ManyToOne
    @JsonIgnore
    public Project project;

}
