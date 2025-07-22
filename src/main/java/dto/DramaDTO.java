package dto;

import java.sql.Date;

public class DramaDTO {

	//변수명 CamelToe로 수정
	private String name;
	private String overview;
	private String posterPath;
	private Date firstAirDate;
	private double voteAverage;
	
	public DramaDTO() {}

	public DramaDTO(String name, String overview, String posterPath, Date firstAirDate, double voteAverage) {
		super();
		this.name = name;
		this.overview = overview;
		this.posterPath = posterPath;
		this.firstAirDate = firstAirDate;
		this.voteAverage = voteAverage;
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

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public Date getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(Date firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	@Override
	public String toString() {
		return "DramaDTO [name=" + name + ", overview=" + overview + ", posterPath=" + posterPath + ", firstAirDate="
				+ firstAirDate + ", voteAverage=" + voteAverage + "]";
	}
		
	
}
