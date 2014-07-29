package kr.study.ppom.demo;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService(serviceName = "IdealTypeService")
public class IdealTypeServiceEndpoint {
	@Autowired
	private IdealTypeService idealTypeService;

	@WebMethod
	public boolean create(String creatorId, String topicId, int level) {
		return idealTypeService.create(creatorId, topicId, level);
	}

	@WebMethod
	public boolean submit(String topicId, String voterId, int opinionLevel) {
		return idealTypeService.submit(topicId, voterId, opinionLevel);
	}

	@WebMethod
	public List<IdealTypeScore> requestIdealType(String userId) {
		return idealTypeService.requestIdealType(userId);
	}
	
	@WebMethod
	public int requestTopicCount() {
		return idealTypeService.requestTopicCount();
	}
}
