package net.nice19.smboard.login.service;

import net.nice19.smboard.login.model.LoginSessionModel;




public interface LoginService {
	
	LoginSessionModel checkUserId(String userId);

}
