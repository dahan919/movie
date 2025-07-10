package service;

public class CommentaryService {
	
	private static CommentaryService instance = new CommentaryService();

	public CommentaryService() {}
	
	public static CommentaryService getInstance() {
		if(instance == null)
			instance = new CommentaryService();
		return instance;
	}
	
}
