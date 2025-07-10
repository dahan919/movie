package dto;

import java.sql.Date;

public class MediaDTO {
	private String u_num;
	private double score;
	private Date opendate;
	private String story;
	private String poster;
	private String highlight;
	private String title;
	
	public MediaDTO() {}
	
	public String getU_num() {
		return u_num;
	}
	public void setU_num(String u_num) {
		this.u_num = u_num;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getHighlight() {
		return highlight;
	}
	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "MediaDTO [u_num=" + u_num + ", score=" + score + ", opendate=" + opendate + ", story=" + story
				+ ", poster=" + poster + ", highlight=" + highlight + ", title=" + title + "]";
	}
	
	
}
