package service;

public class MediaService {
	
	private static MediaService instance = new MediaService();

	public MediaService() {}
	
	public static MediaService getInstance() {
		if(instance == null)
			instance = new MediaService();
		return instance;
	}
}
