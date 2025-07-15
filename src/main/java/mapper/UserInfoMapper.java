package mapper;

import java.util.List;
import java.util.Map;

import dto.UserInfoDTO;

public interface UserInfoMapper {

	UserInfoDTO login(Map<String, Object> map);

	int insertMember(Map<String, Object> map);

	UserInfoDTO findID(Map<String, Object> map);

	UserInfoDTO findPasswd(Map<String, Object> map);

	int updatePasswd(UserInfoDTO user);

	List<UserInfoDTO> selectBySearch(Map<String, Object> map);

	UserInfoDTO selectNicknmById(Map<String, Object> map);


}
