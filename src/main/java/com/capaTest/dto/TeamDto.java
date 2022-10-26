package com.capaTest.dto;

import com.capaTest.entities.Project;
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
   private List<Project> projects;
   private String diagram;

}
