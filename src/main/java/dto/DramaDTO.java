package dto;

import java.sql.Date;

public class DramaDTO {

	private String name;
	private String overview;
	private String poster_path;
	private Date first_air_date;
	
	public DramaDTO() {}

	public DramaDTO(String name, String overview, String poster_path, Date first_air_date) {
		super();
		this.name = name;
		this.overview = overview;
		this.poster_path = poster_path;
		this.first_air_date = first_air_date;
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
		return "DramaDTO [name=" + name + ", overview=" + overview + ", poster_path=" + poster_path
				+ ", first_air_date=" + first_air_date + "]";
	}
	
}
