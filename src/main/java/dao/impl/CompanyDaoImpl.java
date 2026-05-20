package dao.impl;

import dao.CompanyDao;
import entity.Company;
import entity.Job;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CompanyDaoImpl extends AbstractGenericDaoImpl<Company,String> implements CompanyDao {

    public CompanyDaoImpl() {
        super(Company.class);
    }

    public static void main(String[] args) {
        CompanyDao companyDao= new CompanyDaoImpl();
//        Company company = companyDao.findById("CP3");
//        System.out.println(company);
//
//        companyDao.loadAll().forEach(System.out::println);

        String companyName = "CloudNet";
        companyDao.countPerJobByCompany(companyName)
                .forEach(((job, aLong) ->{
                    System.out.println("Cong viec: "+job.getTitle()+" " +job.getId()+" "+aLong);
                } ));

    }

    @Override
    public Map<Job, Long> countPerJobByCompany(String companyName) {
        String query="select j, count(a) "+
                "from Job j "+
                "join j.applications a "+
                " where j.company.name=:companyName "+
                "group by j.id "+
                "order by count(a) desc";
        return doInTransaction(em->{
            List<Object[]> list=em.createQuery(query, Object[].class)
                    .setParameter("companyName",companyName)
                    .getResultList();
            Map<Job,Long> map= new LinkedHashMap<>();
            for (Object[] arr: list){
                Job job=(Job) arr[0];
                Long count= (Long)arr[1];
                map.put(job,count);
            }
            return map;
        });
    }
}
