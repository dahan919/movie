package service;

import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.MediaDTO;
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

	public List<MediaDTO> selectBySearch(Map<String, Object> map) {
		return mapper.selectBySearch(map);
	}
}
