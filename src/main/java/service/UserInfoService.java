package service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.UserInfoDTO;
import mapper.AdminMapper;
import mapper.UserInfoMapper;

public class UserInfoService {
	//singleton
	private static UserInfoService instance = new UserInfoService();
	private UserInfoMapper mapper;
	
	public UserInfoService() {
		mapper = DBManager.getInstance().getSession().getMapper(UserInfoMapper.class);
	}
	
	public static UserInfoService getInstance() {
		if(instance == null)
			instance = new UserInfoService();
		return instance;
	}

	public UserInfoDTO login(Map<String, Object> map) {
		return mapper.login(map);
	}

	public int insertMember(Map<String, Object> map) {
		return mapper.insertMember(map);
	}

	public UserInfoDTO findID(Map<String, Object> map) {
		return mapper.findID(map);
	}

	public UserInfoDTO findPasswd(Map<String, Object> map) {
		return mapper.findPasswd(map);
	}

	public int updatePasswd(UserInfoDTO user) {
		return mapper.updatePasswd(user);
	}




	
}
