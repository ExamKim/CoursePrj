package dao.impl;

import dao.ApplicationDao;
import entity.Application;
import entity.JobStatus;

import java.util.List;

public class ApplicationDaoImpl extends AbstractGenericDaoImpl<Application, Application.ApplicationID> implements ApplicationDao {
    public ApplicationDaoImpl() {
        super(Application.class);
    }

    public static void main(String[] args) {
        ApplicationDao applicationDao= new ApplicationDaoImpl();
//        Application application = applicationDao.findById(Application.ApplicationID.builder().candidate("C2").jobs("J2").build());
//        System.out.println(application);
//        applicationDao.loadAll().forEach(System.out::println);
        List<Object[]> list=applicationDao.findBySkillInOpenJobs("java");
        for (Object[] arr: list){
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);

        }
    }

    @Override
    public List<Object[]> findBySkillInOpenJobs(String skill) {
        String query="select c,j.title, app.appliedDate " +
                "from Candidate c "+
                "join c.applications app "+
                "join app.jobs j "+
                "join j.skills jsk "+
                "join c.skills csk "+
                "where j.status = :status "+
                "and jsk.name=:skill "+
                "and csk.name=:skill ";
        return doInTransaction(em->{
            return em.createQuery(query)
                    .setParameter("status", JobStatus.OPEN)
                    .setParameter("skill",skill)
                    .getResultList();
        });
    }
}
