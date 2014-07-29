package kr.study.ppom.demo;

import java.util.ArrayList;
import java.util.List;

public class OpinionUser {
	
	private String id;
	private List<OpinionTopic> topics = new ArrayList<OpinionTopic>(); 
	
	public OpinionUser(String creatorId) {
		id = creatorId;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void registTopic(OpinionTopic topic) {
		topics.add(topic);
	}

	public List<OpinionTopic> getTopics() {
		return topics;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpinionUser other = (OpinionUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
