package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.AppStatus;
import entity.Application;
import entity.Candidate;
import entity.Job;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationDto implements Serializable{
    private LocalDate appliedDate;
    private String status;
    private String candidateId;
    private String candidateName;
    private String title;

}
