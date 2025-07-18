package mapper;

import java.util.List;
import java.util.Map;

import dto.CommentaryDTO;

public interface CommentaryMapper {

	List<CommentaryDTO> select3(Map<String, Object> map);

	List<CommentaryDTO> selectBySearch(String search);

	int insertCommentary(Map<String, Object> map);

	List<CommentaryDTO> selectOrderByUnumDesc();

}
