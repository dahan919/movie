package dto;

import java.sql.Date;

public class AnnouncementDTO {
	
	private String aNum;
	private String aTitle;
	private String aContent;
	private Date aDate;
	
	public AnnouncementDTO() {}

	public AnnouncementDTO(String aNum, String aTitle, String aContent, Date aDate) {
		super();
		this.aNum = aNum;
		this.aTitle = aTitle;
		this.aContent = aContent;
		this.aDate = aDate;
	}

	public String getaNum() {
		return aNum;
	}

	public void setaNum(String aNum) {
		this.aNum = aNum;
	}

	public String getaTitle() {
		return aTitle;
	}

	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
	}

	public Date getaDate() {
		return aDate;
	}

	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}

	@Override
	public String toString() {
		return "AnnouncementDTO [aNum=" + aNum + ", aTitle=" + aTitle + ", aContent=" + aContent + ", aDate=" + aDate
				+ "]";
	}
	
	
	
}
