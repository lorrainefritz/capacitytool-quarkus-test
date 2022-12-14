package com.capaTest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamDto {
   private String teamName;
   private List<ProjectDto> projectsDtos;
   private String diagram;

}
