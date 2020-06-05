package kr.or.company.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.company.model.dao.CompanyDao;
import kr.or.company.model.vo.Company;


@Service("companyService")
public class CompanyService {

	@Autowired
	@Qualifier("companyDao")
	private CompanyDao dao;
	
	public List selectAllCompany() {
		return dao.selectAllCompany();
	}

	public Company selectOneCompany(int companyCode) {		
		return dao.selectOneCompany(companyCode);
	}

}
