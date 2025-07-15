package dto;

public class UserInfoDTO {
	private String name;
	private String nickNm;
	private String passwd;
	private String Id;
	private String ph_num;

	public UserInfoDTO() {}

	public UserInfoDTO(String name, String nickNm, String passwd, String id, String ph_num) {
		this.name = name;
		this.nickNm = nickNm;
		this.passwd = passwd;
		Id = id;
		this.ph_num = ph_num;
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
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPh_num() {
		return ph_num;
	}

	public void setPh_num(String ph_num) {
		this.ph_num = ph_num;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [name=" + name + ", nickNm=" + nickNm + ", passwd=" + passwd + ", Id=" + Id + ", ph_num="
				+ ph_num + "]";
	}

	

	
}
