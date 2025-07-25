package mapper;

import java.util.List;
import java.util.Map;

import dto.DramaDTO;
import dto.MediaDTO;

public interface DramaMapper {

	List<DramaDTO> selectBySearch(String search);

	int insertSearchResult(List<DramaDTO> list);

	List<MediaDTO> selectByPoster(String dramaImgUrl);

	List<DramaDTO> selectAll();

	List<DramaDTO> selectByName(String name);

}
