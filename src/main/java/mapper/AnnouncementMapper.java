package mapper;

import java.util.List;
import java.util.Map;

import dto.AnnouncementDTO;

public interface AnnouncementMapper {

	List<AnnouncementDTO> selectBySearch(Map<String, Object> map);

}
