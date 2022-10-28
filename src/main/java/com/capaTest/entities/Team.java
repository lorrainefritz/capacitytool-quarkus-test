package com.capaTest.entities;



import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team extends PanacheEntity {
    public String teamName;
    public String email;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public List<Project> projects;

}
