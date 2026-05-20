package dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import entity.Job;
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

public class CompanyDto implements Serializable {
    private String id;
    private String name;
    private String industry;

}
