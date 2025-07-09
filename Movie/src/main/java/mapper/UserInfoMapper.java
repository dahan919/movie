package mapper;

import java.util.Map;

import dto.UserInfoDTO;

public interface UserInfoMapper {

	UserInfoDTO login(Map<String, Object> map);

}
