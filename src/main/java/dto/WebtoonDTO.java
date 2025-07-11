package dto;

public class WebtoonDTO {
	private String u_num;
	private String title;
	private String thumbnail;
	private String synopsis;
	private double starScoreAverage;
	private double readCount;
	private String linkUrl;
	private String writingAuthorName;
	
	public WebtoonDTO() {}
	
	public String getU_num() {
		return u_num;
	}
	public void setU_num(String u_num) {
		this.u_num = u_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public double getStarScoreAverage() {
		return starScoreAverage;
	}
	public void setStarScoreAverage(double starScoreAverage) {
		this.starScoreAverage = starScoreAverage;
	}
	public double getReadCount() {
		return readCount;
	}
	public void setReadCount(double readCount) {
		this.readCount = readCount;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getWritingAuthorName() {
		return writingAuthorName;
	}
	public void setWritingAuthorName(String writingAuthorName) {
		this.writingAuthorName = writingAuthorName;
	}
	@Override
	public String toString() {
		return "WebtoonDTO [u_num=" + u_num + ", title=" + title + ", thumbnail=" + thumbnail + ", synopsis=" + synopsis
				+ ", starScoreAverage=" + starScoreAverage + ", readCount=" + readCount + ", linkUrl=" + linkUrl
				+ ", writingAuthorName=" + writingAuthorName + "]";
	}
	
	
}
