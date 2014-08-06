package kr.study.ppom.controller;

public class Article {
	private String title;
	private String content;
	private String lnb;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getLnb() {
		return lnb;
	}
	
	public void setLnb(String lnb) {
		this.lnb = lnb;
	}
	
	@Override
	public String toString() {
		return "Article [title=" + title + ", content=" + content + ", lnb="
				+ lnb + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((lnb == null) ? 0 : lnb.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Article other = (Article) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (lnb == null) {
			if (other.lnb != null)
				return false;
		} else if (!lnb.equals(other.lnb))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
