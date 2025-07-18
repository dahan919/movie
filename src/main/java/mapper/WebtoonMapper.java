package mapper;

import java.util.List;
import java.util.Map;

import dto.MediaDTO;
import dto.WebtoonDTO;

public interface WebtoonMapper {

	List<WebtoonDTO> selectBySearch(String search);

	int insertSearchResult(List<WebtoonDTO> list);

	List<MediaDTO> selectByPoster(String dramaImgUrl);

	List<WebtoonDTO> selectAll();

	List<WebtoonDTO> selectByTitleName(String titleName);

}
