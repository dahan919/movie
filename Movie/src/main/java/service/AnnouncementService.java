package service;

public class AnnouncementService {

	private static AnnouncementService instance = new AnnouncementService();

	public AnnouncementService() {}
	
	public static AnnouncementService getInstance() {
		if(instance == null)
			instance = new AnnouncementService();
		return instance;
	}
	
}
