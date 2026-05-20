package service.impl;

import dao.ApplicationDao;
import dao.impl.ApplicationDaoImpl;
import dto.ApplicationDto;
import entity.Application;
import mapper.Mapper;
import service.ApplicationService;

import java.util.List;

public class ApplicationServiceImpl implements ApplicationService {


    private ApplicationDao applicationDao;
    public ApplicationServiceImpl(){
        applicationDao = new ApplicationDaoImpl();
    }

    @Override
    public ApplicationDto findById(Application.ApplicationID applicationID) {
        Application application = applicationDao.findById(applicationID);
        return Mapper.map(application);
    }

    @Override
    public List<ApplicationDto> loadAll() {
        List<Application> applications = applicationDao.loadAll();
        return applications
                .stream()
                .map(application -> Mapper.map(application, ApplicationDto.class))
                .toList();
    }

    @Override
    public List<ApplicationDto> findBySkillInOpenJobs(String skill) {
        List<Object[]> list = applicationDao.findBySkillInOpenJobs(skill);
        return list
                .stream()
                .map(application ->
                    Mapper.map(application,ApplicationDto.class))
                    .toList();
    }

    public static void main(String[] args) {
        ApplicationService applicationService= new ApplicationServiceImpl();
        ApplicationDto applicationDto= applicationService.findById(Application.ApplicationID.builder().candidate("C2").jobs("J2").build());
        System.out.println(applicationDto);
//        applicationService
//                .loadAll().forEach(System.out::println);
    }
}
