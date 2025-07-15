package service;

import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.UserInfoDTO;
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

	public List<UserInfoDTO> selectBySearch(Map<String, Object> map) {
		return mapper.selectBySearch(map);
	}

	public UserInfoDTO selectNicknmById(Map<String, Object> map) {
		return mapper.selectNicknmById(map);
	}




	
}
