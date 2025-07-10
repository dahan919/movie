package dto;

import java.sql.Date;

public class CommentaryDTO {
	
	private String c_num;
	private String u_num;
	private String criticism;
	private double score_c;
	private Date writedate;
	
	public CommentaryDTO() {}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getU_num() {
		return u_num;
	}

	public void setU_num(String u_num) {
		this.u_num = u_num;
	}

	public String getCriticism() {
		return criticism;
	}

	public void setCriticism(String criticism) {
		this.criticism = criticism;
	}

	public double getScore_c() {
		return score_c;
	}

	public void setScore_c(double score_c) {
		this.score_c = score_c;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "CommentaryDTO [c_num=" + c_num + ", u_num=" + u_num + ", criticism=" + criticism + ", score_c="
				+ score_c + ", writedate=" + writedate + "]";
	}
	
}
