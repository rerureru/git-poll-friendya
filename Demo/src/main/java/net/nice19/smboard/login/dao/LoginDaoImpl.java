package net.nice19.smboard.login.dao;

import net.nice19.smboard.login.dao.LoginDao;
import net.nice19.smboard.login.model.LoginSessionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public LoginSessionModel checkUserId(String userId) {
		return (LoginSessionModel) sqlMapClientTemplate.queryForObject("login.loginCheck", userId);

	}	
}
