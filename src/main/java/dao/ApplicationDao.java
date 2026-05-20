package dao;

import entity.Application;

import java.util.List;

public interface ApplicationDao extends GenericDao<Application,Application.ApplicationID> {
    List<Object[]> findBySkillInOpenJobs(String Skill);
}
