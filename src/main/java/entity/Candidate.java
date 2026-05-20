package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"skills","applications"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "candidates")
public class Candidate  {
    @Id
    @Column(name = "cand_id")
    @EqualsAndHashCode.Include
    private String id;
    private String name;
    private String email;
    private int experience;

    @ManyToMany(mappedBy = "candidates")
    @JsonIgnore
    private Set<Skill> skills;

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private Set<Application> applications;

}
