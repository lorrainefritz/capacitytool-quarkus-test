package com.capaTest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
public class Project extends PanacheEntity {

    public String projectName;
    public String link;
    public int avlPods;
    public boolean limits;
    public boolean quotas;
    public boolean rollingUpdate;
    public String curCpu;
    public int curCpuPercentage;
    public String reqCpu;
    public int reqCpuPercentage;
    public String cpuReqLim;
    public int percentageReqLim;
    public String curMem;
    public int percentageCurMem;
    public String reqMem;
    public int percentageReqMem;
    public String limMem;
    public int percentageLimMem;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public List<Pod> pods;

    @ManyToOne
    @JsonIgnore
    public Team team;
    @ManyToOne
    @JsonIgnore
    Environment environment;

    public Project(String projectName, String link, int avlPods, boolean limits, boolean quotas, boolean rollingUpdate, String curCpu, int curCpuPercentage, String reqCpu, int reqCpuPercentage, String cpuReqLim, int percentageReqLim, String curMem, int percentageCurMem, String reqMem, int percentageReqMem, String limMem, int percentageLimMem, List<Pod> pods, Team team, Environment environment) {
        this.projectName = projectName;
        this.link = link;
        this.avlPods = avlPods;
        this.limits = limits;
        this.quotas = quotas;
        this.rollingUpdate = rollingUpdate;
        this.curCpu = curCpu;
        this.curCpuPercentage = curCpuPercentage;
        this.reqCpu = reqCpu;
        this.reqCpuPercentage = reqCpuPercentage;
        this.cpuReqLim = cpuReqLim;
        this.percentageReqLim = percentageReqLim;
        this.curMem = curMem;
        this.percentageCurMem = percentageCurMem;
        this.reqMem = reqMem;
        this.percentageReqMem = percentageReqMem;
        this.limMem = limMem;
        this.percentageLimMem = percentageLimMem;
        this.pods = pods;
        this.team = team;
        this.environment = environment;
    }
}
