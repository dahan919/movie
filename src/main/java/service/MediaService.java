package service;

import config.DBManager;
import mapper.MediaMapper;

public class MediaService {
	
	private static MediaService instance = new MediaService();
	private MediaMapper mapper;

	public MediaService() {
		mapper = DBManager.getInstance().getSession().getMapper(MediaMapper.class);
	}
	
	public static MediaService getInstance() {
		if(instance == null)
			instance = new MediaService();
		return instance;
	}
}
