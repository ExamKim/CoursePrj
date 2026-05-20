package dao;

import java.util.Map;

import entity.Company;
import entity.Job;

public interface CompanyDao extends GenericDao<Company, String> {
    Map<Job, Long> countPerJobByCompany(String companyName);
}
