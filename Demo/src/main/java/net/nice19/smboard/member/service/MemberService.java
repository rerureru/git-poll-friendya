package net.nice19.smboard.member.service;

import net.nice19.smboard.member.model.MemberModel;

public interface MemberService {
	boolean addMember(MemberModel memberModel);
	MemberModel findByUserId(String userId);
}
