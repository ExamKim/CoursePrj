package service;

import dto.ApplicationDto;
import entity.Application;

import java.util.List;

public interface ApplicationService {
    ApplicationDto findById(Application.ApplicationID applicationID);
    List<ApplicationDto> loadAll();
    List<ApplicationDto> findBySkillInOpenJobs(String skill);
}
