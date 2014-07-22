package net.nice19.smboard.login.service;

import net.nice19.smboard.login.dao.LoginDao;
import net.nice19.smboard.login.model.LoginSessionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public LoginSessionModel checkUserId(String userId) {
		return loginDao.checkUserId(userId);

	}	
}
