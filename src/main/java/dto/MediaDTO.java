package dto;

import java.sql.Date;

public class MediaDTO {
	private String title;
	private double voteAverage;
	private String overview;
	private String posterPath;
	private Date releaseDate;
	
	public MediaDTO() {}

	public MediaDTO(String title, double voteAverage, String overview, String posterPath, Date releaseDate) {
		super();
		this.title = title;
		this.voteAverage = voteAverage;
		this.overview = overview;
		this.posterPath = posterPath;
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "MediaDTO [title=" + title + ", voteAverage=" + voteAverage + ", overview=" + overview + ", posterPath="
				+ posterPath + ", releaseDate=" + releaseDate + "]";
	}

	
}
