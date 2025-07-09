package dto;

import java.sql.Date;

public class AnnouncementDTO {
	
	private String a_num;
	private String a_title;
	private String a_content;
	private Date a_date;
	
	public AnnouncementDTO() {}
	
	public String getA_num() {
		return a_num;
	}
	public void setA_num(String a_num) {
		this.a_num = a_num;
	}
	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public Date getA_date() {
		return a_date;
	}
	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
	@Override
	public String toString() {
		return "AnnouncementDTO [a_num=" + a_num + ", a_title=" + a_title + ", a_content=" + a_content + ", a_date="
				+ a_date + "]";
	}
	
	
}
