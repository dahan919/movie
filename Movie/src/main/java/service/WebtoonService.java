package service;

public class WebtoonService {
	
	private static WebtoonService instance = new WebtoonService();

	public WebtoonService() {}
	
	public static WebtoonService getInstance() {
		if(instance == null)
			instance = new WebtoonService();
		return instance;
	}
}
