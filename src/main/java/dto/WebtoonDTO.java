package dto;

public class WebtoonDTO {
	private String title;
	private String thumbnail;
	private String synopsis;
	private double starScoreAverage;
	private double readCount;
	private String linkUrl;
	private String writingAuthorName;
	
	public WebtoonDTO() {}
	
	public WebtoonDTO(String title, String thumbnail, String synopsis, double starScoreAverage, double readCount,
			String linkUrl, String writingAuthorName) {
		super();
		this.title = title;
		this.thumbnail = thumbnail;
		this.synopsis = synopsis;
		this.starScoreAverage = starScoreAverage;
		this.readCount = readCount;
		this.linkUrl = linkUrl;
		this.writingAuthorName = writingAuthorName;
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
		return "WebtoonDTO [title=" + title + ", thumbnail=" + thumbnail + ", synopsis=" + synopsis
				+ ", starScoreAverage=" + starScoreAverage + ", readCount=" + readCount + ", linkUrl=" + linkUrl
				+ ", writingAuthorName=" + writingAuthorName + "]";
	}

	
}
