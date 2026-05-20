package service.impl;

import dao.CompanyDao;
import dao.impl.CompanyDaoImpl;
import dto.CompanyDto;
import dto.JobDto;
import entity.Company;
import mapper.Mapper;
import service.CompanyService;

import java.util.List;
import java.util.Map;

public class CompanyServiceImpl implements CompanyService {

    private CompanyDao companyDao;

    public CompanyServiceImpl(){
        companyDao= new CompanyDaoImpl();
    }


    @Override
    public CompanyDto create(CompanyDto companyDto) {
        return null;
    }

    @Override
    public CompanyDto update(CompanyDto companyDto) {
        return null;
    }

    @Override
    public boolean delete(String companyId) {
        return companyDao.delete(companyId);
    }

    @Override
    public CompanyDto findById(String companyId) {
         Company company=companyDao.findById(companyId);
        return Mapper.map(company,CompanyDto.class);
    }

    @Override
    public List<CompanyDto> loadAll() {
        List<Company> companies = companyDao.loadAll();
        return companies
                .stream()
                .map(company -> Mapper.map(company,CompanyDto.class))
                .toList();
    }

    @Override
    public Map<JobDto, Long> countPerJobByCompany(String companyName) {

        return Mapper.map(companyDao.countPerJobByCompany(companyName));
    }

    public static void main(String[] args) {
        CompanyService companyService= new CompanyServiceImpl();
        companyService
                .loadAll().forEach(System.out::println);
    }

}
