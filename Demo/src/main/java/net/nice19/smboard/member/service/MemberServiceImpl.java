package net.nice19.smboard.member.service;

import net.nice19.smboard.member.dao.MemberDao;
import net.nice19.smboard.member.model.MemberModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TEST 
@Repository
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean addMember(MemberModel memberModel) {
		return memberDao.addMember(memberModel);
	}

	@Override
	public MemberModel findByUserId(String userId) {
		return memberDao.findByUserId(userId);
	}

}
