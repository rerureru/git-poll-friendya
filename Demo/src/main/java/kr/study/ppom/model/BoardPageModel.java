package kr.study.ppom.model;

import java.util.HashMap;
import java.util.Map;

import kr.study.ppom.common.BoardPagePartName;

public class BoardPageModel {
	private Map<BoardPagePartName, Object> map = new HashMap<BoardPagePartName, Object>();
	
	public void addModel(BoardPagePartName partName,Object model) {
		map.put(partName, model);		
	}

	public Object getModel(BoardPagePartName partName) {
		return map.get(partName);
	}

}
