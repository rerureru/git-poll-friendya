package kr.study.ppom.model;

import java.io.Serializable;

public class SelectedMenu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String selectedGNBMenuID;
	private String selectedLNBMenuID;
	
	public String getSelectedGNBMenuID() {
		return selectedGNBMenuID;
	}
	public void setSelectedGNBMenuID(String selectedGNBMenuID) {
		this.selectedGNBMenuID = selectedGNBMenuID;
	}
	public String getSelectedLNBMenuID() {
		return selectedLNBMenuID;
	}
	public void setSelectedLNBMenuID(String selectedLNBMenuID) {
		this.selectedLNBMenuID = selectedLNBMenuID;
	}
	@Override
	public String toString() {
		return "SelectedMenu [selectedGNBMenuID=" + selectedGNBMenuID
				+ ", selectedLNBMenuID=" + selectedLNBMenuID + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((selectedGNBMenuID == null) ? 0 : selectedGNBMenuID
						.hashCode());
		result = prime
				* result
				+ ((selectedLNBMenuID == null) ? 0 : selectedLNBMenuID
						.hashCode());
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
		SelectedMenu other = (SelectedMenu) obj;
		if (selectedGNBMenuID == null) {
			if (other.selectedGNBMenuID != null)
				return false;
		} else if (!selectedGNBMenuID.equals(other.selectedGNBMenuID))
			return false;
		if (selectedLNBMenuID == null) {
			if (other.selectedLNBMenuID != null)
				return false;
		} else if (!selectedLNBMenuID.equals(other.selectedLNBMenuID))
			return false;
		return true;
	}
}
