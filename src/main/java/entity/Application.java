package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "applications")
@IdClass(Application.ApplicationID.class)
public class Application {
    private LocalDate appliedDate;
    @Enumerated(EnumType.STRING)
    private AppStatus status;

    @Id
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job jobs;

    @Setter
    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    @NoArgsConstructor
    @Builder
    @ToString
    public static class ApplicationID implements Serializable{
        private String candidate;
        private String jobs;
    }

}
