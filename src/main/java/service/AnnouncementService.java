package service;

import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.AnnouncementDTO;
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

	public List<AnnouncementDTO> selectBySearch(Map<String, Object> map) {
		return mapper.selectBySearch(map);
	}

	public int insertAnnouncement(Map<String, Object> map) {
		return mapper.insertAnnouncement(map);
	}
	
	public String deleteAnnouncement(Map<String, Object> map) {
		return mapper.deleteAnnouncement(map);
	}

	public List<AnnouncementDTO> selectAll() {
		return mapper.selectAll();
	}
	
}
