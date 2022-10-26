package com.capaTest.dto;

import com.capaTest.enums.Health;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkerDto {

    private String name;
    private Health health;
    private int nbrOfPods;
    private String usgCpu;
    private int usgCpuPercentage;
    private String reqCpu;
    private int reqCpuPercentage;
    private String cpuReqLim;
    private int cpuReqLimPercentage;
    private String usgMem;
    private int usgMemPercentage;
    private String reqMem;
    private int reqMemPercentage;
    private String limMem;
    private int limMemPercentage;
}
