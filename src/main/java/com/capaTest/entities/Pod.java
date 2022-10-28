package com.capaTest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@NoArgsConstructor
@AllArgsConstructor
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
