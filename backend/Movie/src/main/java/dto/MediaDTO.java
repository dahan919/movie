package dto;

import java.sql.Date;
import java.util.Arrays;

public class MediaDTO {
	
	private String m_num;
	private double score;
	private Date opendate;
	private String story;
	private byte[] poster;
	private byte[] highlight;
	private String title;
	
	
	
	public MediaDTO() {}
	
	public MediaDTO(String m_num, double score, Date opendate, String story, byte[] poster, byte[] highlight,
			String title) {
		super();
		this.m_num = m_num;
		this.score = score;
		this.opendate = opendate;
		this.story = story;
		this.poster = poster;
		this.highlight = highlight;
		this.title = title;
	}
	
	public String getM_num() {
		return m_num;
	}
	public void setM_num(String m_num) {
		this.m_num = m_num;
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
	public byte[] getPoster() {
		return poster;
	}
	public void setPoster(byte[] poster) {
		this.poster = poster;
	}
	public byte[] getHighlight() {
		return highlight;
	}
	public void setHighlight(byte[] highlight) {
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
		return "MediaDTO [m_num=" + m_num + ", score=" + score + ", opendate=" + opendate + ", story=" + story
				+ ", poster=" + Arrays.toString(poster) + ", highlight=" + Arrays.toString(highlight) + ", title="
				+ title + "]";
	}
	
	
}
