package service;

import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.WebtoonDTO;
import mapper.WebtoonMapper;

public class WebtoonService {
	
	private static WebtoonService instance = new WebtoonService();
	private WebtoonMapper mapper;

	public WebtoonService() {
		mapper= DBManager.getInstance().getSession().getMapper(WebtoonMapper.class);
	}
	
	public static WebtoonService getInstance() {
		if(instance == null)
			instance = new WebtoonService();
		return instance;
	}

	public List<WebtoonDTO> selectBySearch(Map<String, Object> map) {
		return mapper.selectBySearch(map);
	}
}
