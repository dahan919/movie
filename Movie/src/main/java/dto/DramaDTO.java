package dto;

import java.sql.Date;

public class DramaDTO {
	private String u_num;
	private String name;
	private String overview;
	private String poster_path;
	private Date first_air_date;
	
	public DramaDTO() {}

	public String getU_num() {
		return u_num;
	}

	public void setU_num(String u_num) {
		this.u_num = u_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public Date getFirst_air_date() {
		return first_air_date;
	}

	public void setFirst_air_date(Date first_air_date) {
		this.first_air_date = first_air_date;
	}

	@Override
	public String toString() {
		return "DramaDTO [u_num=" + u_num + ", name=" + name + ", overview=" + overview + ", poster_path=" + poster_path
				+ ", first_air_date=" + first_air_date + "]";
	}
	
	
}
