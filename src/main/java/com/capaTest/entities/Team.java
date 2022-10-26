package com.capaTest.entities;



import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Team {
    private String teamName;
    private List<Project> projects;

}
