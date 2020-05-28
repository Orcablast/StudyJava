package company.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class CompanyDao {

	public List selectAllCompany(SqlSession session) {
		return session.selectList("company.selectAllCompany");
	}

}
