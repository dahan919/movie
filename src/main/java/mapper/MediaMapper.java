package mapper;

import java.util.List;
import java.util.Map;

import dto.DramaDTO;
import dto.MediaDTO;

public interface MediaMapper {

	List<MediaDTO> selectBySearch(String search);

	int insertSearchResult(List<MediaDTO> mList);

	List<MediaDTO> selectByPoster(String mediaImgUrl);

	List<MediaDTO> selectAll();

	List<MediaDTO> selectByTitle(String title);

	List<MediaDTO> selectByUNum(String uNum);

}
