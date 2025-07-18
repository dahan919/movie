package dto;

public class UserInfoDTO {
	private String name;
	private String nickNm;
	private String passwd;
	private String id;
	private String phNum;

	public UserInfoDTO() {}

	public UserInfoDTO(String name, String nickNm, String passwd, String id, String phNum) {
		super();
		this.name = name;
		this.nickNm = nickNm;
		this.passwd = passwd;
		this.id = id;
		this.phNum = phNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickNm() {
		return nickNm;
	}

	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhNum() {
		return phNum;
	}

	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [name=" + name + ", nickNm=" + nickNm + ", passwd=" + passwd + ", id=" + id + ", phNum="
				+ phNum + "]";
	}

	
	
}
