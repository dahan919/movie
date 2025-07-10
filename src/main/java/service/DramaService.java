package service;

import config.DBManager;
import mapper.DramaMapper;

public class DramaService {
	
	private static DramaService instance = new DramaService();
	private DramaMapper mapper;

	public DramaService() {
		mapper = DBManager.getInstance().getSession().getMapper(DramaMapper.class);
	}
	
	public static DramaService getInstance() {
		if(instance == null)
			instance = new DramaService();
		return instance;
	}
}
