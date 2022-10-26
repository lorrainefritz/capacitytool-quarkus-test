package com.capaTest.entities;
import com.capaTest.enums.Health;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Worker extends PanacheEntity {


    public String name;
    public Health health;
    public int nbrOfPods;
    public String usgCpu;
    public int usgCpuPercentage;
    public String reqCpu;
    public int reqCpuPercentage;
    public String cpuReqLim;
    public int cpuReqLimPercentage;
    public String usgMem;
    public int usgMemPercentage;
    public String reqMem;
    public int reqMemPercentage;
    public String limMem;
    public int limMemPercentage;


}
