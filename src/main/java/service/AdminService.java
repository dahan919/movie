package service;

import java.util.Map;

import config.DBManager;
import dto.AdminDTO;
import mapper.AdminMapper;

public class AdminService {
	
	private static AdminService instance = new AdminService();
	private AdminMapper mapper;

	public AdminService() {
		mapper = DBManager.getInstance().getSession().getMapper(AdminMapper.class);
	}
	
	public static AdminService getInstance() {
		if(instance == null)
			instance = new AdminService();
		return instance;
	}

	public AdminDTO adminCheck(Map<String, Object> map) {
		return mapper.adminCheck(map);
	}

}
