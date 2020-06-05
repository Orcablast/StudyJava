package kr.or.company.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.company.model.vo.Company;

@Repository("companyDao")
public class CompanyDao {
	
	@Autowired
	private SqlSessionTemplate session;

	public List selectAllCompany() {
		return session.selectList("company.selectAllCompany");
	}

	public Company selectOneCompany(int companyCode) {		
		return session.selectOne("company.selectOneCompany", companyCode);
	}

}
