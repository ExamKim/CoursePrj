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
@ToString(exclude = {"jobs","candidates"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @Column(name = "skill_id")
    @EqualsAndHashCode.Include

    private String id;
    private String name;
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "jobs_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private Set<Job> jobs;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "candidates_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private Set<Candidate> candidates;


}
