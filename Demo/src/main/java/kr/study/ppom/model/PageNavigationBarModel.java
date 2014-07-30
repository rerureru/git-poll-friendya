package kr.study.ppom.model;

import java.util.List;

import kr.study.ppom.dto.CDDto;

public class PageNavigationBarModel {
	private List<CDDto> globalNavigationBar;
	private List<CDDto> localNavigationBar;
	private SelectedMenu selectedMenu;

	public List<CDDto> getGlobalNavigationBar() {
		// TODO Auto-generated method stub
		return globalNavigationBar;
	}
	public void setGlobalNavigationBar(List<CDDto> globalNavigationBar) {
		this.globalNavigationBar = globalNavigationBar;
	}

	public List<CDDto> getLocalNavigationBar() {
		// TODO Auto-generated method stub
		return localNavigationBar;
	}
	public void setLocalNavigationBar(List<CDDto> localNavigationBar) {
		this.localNavigationBar = localNavigationBar;
	}

	public SelectedMenu getSelectedMenu() {
		// TODO Auto-generated method stub
		return selectedMenu;
	}
	public void setSelectedMenu(SelectedMenu selectedMenu) {
		this.selectedMenu = selectedMenu;
	}
	
}
