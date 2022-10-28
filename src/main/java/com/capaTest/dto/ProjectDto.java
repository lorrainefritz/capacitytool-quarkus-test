package com.capaTest.dto;

import com.capaTest.entities.Pod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDto {
    private String projectName;
    private int avlPods;
    private boolean limits;
    private boolean quotas;
    private boolean rollingUpdate;
    private String curCpu;
    private int curCpuPercentage;
    private String reqCpu;
    private int reqCpuPercentage;
    private String cpuReqLim;
    private int percentageReqLim;
    private String curMem;
    private int percentageCurMem;
    private String reqMem;
    private int percentageReqMem;
    private String limMem;
    private int percentageLimMem;
    private List<Pod> pods;
}
