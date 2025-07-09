package mapper;

import java.util.Map;

import dto.AdminDTO;

public interface AdminMapper {

	AdminDTO adminCheck(Map<String, Object> map);

}
