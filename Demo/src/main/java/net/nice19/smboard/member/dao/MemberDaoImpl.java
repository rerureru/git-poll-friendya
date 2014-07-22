package net.nice19.smboard.member.dao;

import net.nice19.smboard.member.dao.MemberDao;
import net.nice19.smboard.member.model.MemberModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

// TEST 
@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public boolean addMember(MemberModel memberModel) {
		sqlMapClientTemplate.insert("member.addMember", memberModel);
		MemberModel checkAddMember = findByUserId(memberModel.getUserId());
		
		//check addMember Process
		if(checkAddMember == null){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public MemberModel findByUserId(String userId) {
		return (MemberModel) sqlMapClientTemplate.queryForObject("member.findByUserId", userId);
	}

}
