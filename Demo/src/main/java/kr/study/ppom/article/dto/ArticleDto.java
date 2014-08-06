package kr.study.ppom.article.dto;

import java.io.Serializable;

public class ArticleDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String content;
	private String lnb;
	private String creator;
	
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
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
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
		ArticleDto other = (ArticleDto) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
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
	@Override
	public String toString() {
		return "Article [title=" + title + ", content=" + content + ", lnb="
				+ lnb + ", creator=" + creator + "]";
	}
	
	
}
