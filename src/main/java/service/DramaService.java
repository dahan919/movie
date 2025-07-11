package service;

import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.DramaDTO;
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

	public List<DramaDTO> selectBySearch(Map<String, Object> map) {
		return mapper.selectBySearch(map);
	}
}
