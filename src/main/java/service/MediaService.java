package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import config.DBManager;
import dto.MediaDTO;
import mapper.MediaMapper;

public class MediaService {
	
	private static MediaService instance = new MediaService();
	private MediaMapper mapper;
	
	//API 변수
	private static String apiKey = "x-rapidapi-key";
	private static String apiHost = "imdb236.p.rapidapi.com";

	public MediaService() {
		mapper = DBManager.getInstance().getSession().getMapper(MediaMapper.class);
	}
	
	public static MediaService getInstance() {
		if(instance == null)
			instance = new MediaService();
		return instance;
	}

	public List<MediaDTO> selectBySearch(Map<String, Object> map) {
		return mapper.selectBySearch(map);
	}
	
	//API 받아오기: 미완
		public static String search(String searchTxt) {

			String response = "";

			// 1.URL setting
			String apiURL = "https://imdb236.p.rapidapi.com/api/imdb/search";

			// 1-1. convert parameter(query String) into UTF-8 form
			try {
				searchTxt = URLEncoder.encode(searchTxt, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			// 1-2. add query String into URL
			apiURL += "?query=" + searchTxt;

			// 2.URL Verification setting
			// 2-1. HttpURLConnection object initialization
			HttpURLConnection conn = null;

			// 2-2. apiURL: String -> url -> HttpURLConnection
			try {
				URL url = new URL(apiURL);
				conn = (HttpURLConnection) url.openConnection();
				
				//2-3. Connection setting
				//2-3-1. Send method(Usually given in manual)
				//2-3-2. header setting
				conn.setRequestMethod("GET");
				conn.setRequestProperty("x-rapidapi-key", apiKey);
				conn.setRequestProperty("x-rapidapi-host", apiHost);

				// 3.Request
				// 4.Request Verification
				// 3-1. InputStream object initialization
				InputStream is = null;
				
				// 3-2., 4. Verify the connection as soon as it is connected 
				if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					is = conn.getInputStream();
				}else {
					is = conn.getErrorStream();
				}
				
				// 5.Return data Requested
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				response = br.lines().collect(Collectors.joining(System.lineSeparator()));

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(conn != null)
					conn.disconnect();
			}

			return response;
		}

		public List<MediaDTO> StringToJSON(String result) {
			
			//1.String값: [{...}]형태이므로 JSONArray로 저장
			JSONArray array = new JSONArray(result);
			
			//2.JSON으로 변환된 값에서 key값으로 가져오기
			List<MediaDTO> list = new ArrayList<>();
			
			array.forEach(item -> {
				JSONObject obj = (JSONObject) item;
		
				Double score = obj.getDouble("score");
				
				//date format으로 받기
				String opendatestr = obj.getString("opendate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date opendate = null;
				try {
					opendate = (Date) sdf.parse(opendatestr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String story = obj.getString("story");
				String poster = obj.getString("poster");
				String highlight = obj.getString("highlight");
				String title = obj.getString("title");
				
				//DTO instance를 이 값들로 만들어주기
				MediaDTO dto = new MediaDTO(score, opendate, story, poster, highlight, title);
				
				list.add(dto);
			});
			
			return list;
		}

		public int insertSearchResult(List<MediaDTO> mediaList) {
			return mapper.insertSearchResult(mediaList);
		}

		public List<MediaDTO> selectByPoster(String mediaImgUrl) {			
			return mapper.selectByPoster(mediaImgUrl);
		}

		public List<MediaDTO> selectAll() {
			return mapper.selectAll();
		}
		
		
}
