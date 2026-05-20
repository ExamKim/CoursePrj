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
@ToString(exclude = {"company","skills","applications"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name ="jobs")

public class Job  {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "job_id")
    private String id;
    private String title;
    private String description;
    private double salary  ;
    @Enumerated(EnumType.STRING)
    private JobStatus status;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(mappedBy = "jobs")
    @JsonIgnore
    private Set<Skill> skills;

    @OneToMany(mappedBy = "jobs")
    @JsonIgnore
    private Set<Application> applications;
}
