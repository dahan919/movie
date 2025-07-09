package mapper;

import java.util.List;

import dto.CommentaryDTO;

public interface CommentaryMapper {

	List<CommentaryDTO> selectAllCommentary();

}
