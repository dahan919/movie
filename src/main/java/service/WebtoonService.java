package service;

import config.DBManager;
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
}
