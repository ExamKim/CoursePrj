package dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import entity.Application;
import entity.Company;
import entity.JobStatus;
import entity.Skill;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class JobDto implements Serializable {
    private String id;
    private String title;
    private String description;
    private double salary  ;
    private String status;
}
