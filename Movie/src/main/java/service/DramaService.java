package service;

public class DramaService {
	
	private static DramaService instance = new DramaService();

	public DramaService() {}
	
	public static DramaService getInstance() {
		if(instance == null)
			instance = new DramaService();
		return instance;
	}
}
