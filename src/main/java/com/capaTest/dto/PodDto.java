package com.capaTest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PodDto {
    private String podName;
    private int restart;
    private String cpuReqLim;
    private String memReqLim;
    private String usgCpu;
    private String maxCpu;
    private String usgMem;
    private String maxMem;
}
