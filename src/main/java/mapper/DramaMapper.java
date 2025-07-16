package mapper;

import java.util.List;
import java.util.Map;

import dto.DramaDTO;
import dto.MediaDTO;

public interface DramaMapper {

	List<DramaDTO> selectBySearch(Map<String, Object> map);

	int insertSearchResult(List<DramaDTO> list);

	List<MediaDTO> selectByPoster(String dramaImgUrl);

	List<DramaDTO> selectAll();

}
