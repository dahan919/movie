package mapper;

import java.util.List;
import java.util.Map;

import dto.MediaDTO;

public interface MediaMapper {

	List<MediaDTO> selectBySearch(Map<String, Object> map);

	int insertSearchResult(List<MediaDTO> mediaList);

	List<MediaDTO> selectByPoster(String mediaImgUrl);

	List<MediaDTO> selectAll();

}
