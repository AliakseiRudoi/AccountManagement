package com.epam.rudoi.accountManagementApi.entity;

public class Content {
	
	private long contentId; 
	
	private String contentTitle;
	
	private String contentText;

	public Content() {
		super();
	}
	
	public Content(long contentId, String contentTitle, String contentText) {
		super();
		this.contentId = contentId;
		this.contentTitle = contentTitle;
		this.contentText = contentText;
	}

	public long getContentId() {
		return contentId;
	}

	public void setContentId(long contentId) {
		this.contentId = contentId;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contentId ^ (contentId >>> 32));
		result = prime * result + ((contentText == null) ? 0 : contentText.hashCode());
		result = prime * result + ((contentTitle == null) ? 0 : contentTitle.hashCode());
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
		Content other = (Content) obj;
		if (contentId != other.contentId)
			return false;
		if (contentText == null) {
			if (other.contentText != null)
				return false;
		} else if (!contentText.equals(other.contentText))
			return false;
		if (contentTitle == null) {
			if (other.contentTitle != null)
				return false;
		} else if (!contentTitle.equals(other.contentTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", contentTitle=" + contentTitle + ", contentText=" + contentText
				+ "]";
	}
	
}
