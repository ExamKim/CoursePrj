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
@ToString(exclude = {"jobs"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "companies")

public class Company   {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "company_id")
    private String id;
    private String name;
    private String industry;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    public Set<Job> jobs;
}
