package mapper;

import java.util.List;
import java.util.Map;

import dto.WebtoonDTO;

public interface WebtoonMapper {

	List<WebtoonDTO> selectBySearch(Map<String, Object> map);

}
