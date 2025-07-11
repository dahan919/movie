package mapper;

import java.util.List;
import java.util.Map;

import dto.DramaDTO;

public interface DramaMapper {

	List<DramaDTO> selectBySearch(Map<String, Object> map);

}
