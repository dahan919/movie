package service;

import config.DBManager;
import mapper.AnnouncementMapper;

public class AnnouncementService {

	private static AnnouncementService instance = new AnnouncementService();
	private AnnouncementMapper mapper;

	public AnnouncementService() {
		mapper = DBManager.getInstance().getSession().getMapper(AnnouncementMapper.class);
	}
	
	public static AnnouncementService getInstance() {
		if(instance == null)
			instance = new AnnouncementService();
		return instance;
	}
	
}
