package dto;

public class MovieuserDTO {
	private String u_num;
	private String name;
	private String nickNm;
	private String passwd;
	private String id;
	
	public MovieuserDTO() {}
	
	public MovieuserDTO(String u_num, String name, String nickNm, String passwd, String id) {
		super();
		this.u_num = u_num;
		this.name = name;
		this.nickNm = nickNm;
		this.passwd = passwd;
		this.id = id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "MovieuserDTO [u_num=" + u_num + ", name=" + name + ", nickNm=" + nickNm + ", passwd=" + passwd + ", id="
				+ id + "]";
	}
	
	
}
