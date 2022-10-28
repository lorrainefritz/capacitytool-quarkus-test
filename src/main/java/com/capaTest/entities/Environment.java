package com.capaTest.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class Environment extends PanacheEntity {
    public String environmentName;
    public int numberOfProjects;
    public int numberOfPods;
    public int reqCpu;
    public int reqCpuPercentage;
    public int limCpu;
    public int limCpuPercentage;
    public int reqMem;
    public int percentageReqMem;
    public int limMem;
    public int percentageLimMem;
    public int quotaRequestCpu;
    public int quotaRequestCpuPercentage;
    public int quotaLimitCpu;
    public int quotaLimitCpuPercentage;
    public int quotaRequestMem;
    public int quotaRequestMemPercentage;
    public int quotaLimitMem;
    public int quotaLimitMemPercentage;
    @OneToMany(mappedBy = "environment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public List<Project> projects;

    public Environment(String environmentName, int numberOfProjects, int numberOfPods, int reqCpu, int reqCpuPercentage, int limCpu, int limCpuPercentage, int reqMem, int percentageReqMem, int limMem, int percentageLimMem, int quotaRequestCpu, int quotaRequestCpuPercentage, int quotaLimitCpu, int quotaLimitCpuPercentage, int quotaRequestMem, int quotaRequestMemPercentage, int quotaLimitMem, int quotaLimitMemPercentage, List<Project> projects) {
        this.environmentName = environmentName;
        this.numberOfProjects = numberOfProjects;
        this.numberOfPods = numberOfPods;
        this.reqCpu = reqCpu;
        this.reqCpuPercentage = reqCpuPercentage;
        this.limCpu = limCpu;
        this.limCpuPercentage = limCpuPercentage;
        this.reqMem = reqMem;
        this.percentageReqMem = percentageReqMem;
        this.limMem = limMem;
        this.percentageLimMem = percentageLimMem;
        this.quotaRequestCpu = quotaRequestCpu;
        this.quotaRequestCpuPercentage = quotaRequestCpuPercentage;
        this.quotaLimitCpu = quotaLimitCpu;
        this.quotaLimitCpuPercentage = quotaLimitCpuPercentage;
        this.quotaRequestMem = quotaRequestMem;
        this.quotaRequestMemPercentage = quotaRequestMemPercentage;
        this.quotaLimitMem = quotaLimitMem;
        this.quotaLimitMemPercentage = quotaLimitMemPercentage;
        this.projects = projects;
    }
}
