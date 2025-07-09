package dto;

public class UserInfoDTO {
	private String u_num;
	private String name;
	private String nickNm;
	private String passwd;
	private String ID;
	private String ph_num;

	public UserInfoDTO() {}

	public UserInfoDTO(String u_num, String name, String nickNm, String passwd, String iD, String ph_num) {
		super();
		this.u_num = u_num;
		this.name = name;
		this.nickNm = nickNm;
		this.passwd = passwd;
		ID = iD;
		this.ph_num = ph_num;
	}
	
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPh_num() {
		return ph_num;
	}
	public void setPh_num(String ph_num) {
		this.ph_num = ph_num;
	}

	//관리자 확인
	private boolean isAdmin;
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
