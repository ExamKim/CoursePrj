package service;

import dto.CompanyDto;
import dto.JobDto;

import java.util.List;
import java.util.Map;

public interface CompanyService {
    CompanyDto create (CompanyDto companyDto);
    CompanyDto update (CompanyDto companyDto);
    boolean delete (String companyId);
    CompanyDto findById (String companyId);
    List<CompanyDto> loadAll ();
    Map<JobDto, Long> countPerJobByCompany(String companyName);
}
