package mapper;

import java.util.List;
import java.util.Map;

import dto.AnnouncementDTO;

public interface AnnouncementMapper {

	List<AnnouncementDTO> selectBySearch(String search);

	int insertAnnouncement(Map<String, Object> map);
	
	String deleteAnnouncement(Map<String, Object> map);

	List<AnnouncementDTO> selectAll();

}
