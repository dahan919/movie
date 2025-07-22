package dto;

public class WebtoonDTO {

	//미완
	private String titleName;
	private String titleId;
	private String thumbnailUrl;

	public WebtoonDTO() {}

	public WebtoonDTO(String titleName, String titleId, String thumbnailUrl) {
		super();
		this.titleName = titleName;
		this.titleId = titleId;
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	@Override
	public String toString() {
		return "WebtoonDTO [titleName=" + titleName + ", titleId=" + titleId + ", thumbnailUrl=" + thumbnailUrl + "]";
	}
	
}
