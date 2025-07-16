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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import config.DBManager;
import dto.DramaDTO;
import dto.MediaDTO;
import mapper.DramaMapper;

public class DramaService {
	
	private static DramaService instance = new DramaService();
	private DramaMapper mapper;

	public DramaService() {
		mapper = DBManager.getInstance().getSession().getMapper(DramaMapper.class);
	}
	
	public static DramaService getInstance() {
		if(instance == null)
			instance = new DramaService();
		return instance;
	}

	public List<DramaDTO> selectBySearch(Map<String, Object> map) {
		return mapper.selectBySearch(map);
	}
	
	//API 받아오기
		public static String search(String searchTxt) {

			String response = "";

			// 1.URL setting
			String apiURL = "";

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
				conn.setRequestMethod("");
				conn.setRequestProperty("", );

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

		public List<DramaDTO> StringToJSON(String result) {
			
			JSONArray array = new JSONArray(result);
			
			List<DramaDTO> list = new ArrayList<DramaDTO>();
			
			array.forEach(item -> {
				JSONObject obj = (JSONObject) item;

				String name = obj.getString("name");
				String overview = obj.getString("overview");
				String poster_path = obj.getString("poster_path");
				
				String first_air_date_str = obj.getString("first_air_date");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date first_air_date = null;
				try {
					first_air_date = (Date) sdf.parse(first_air_date_str);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				DramaDTO dto = new DramaDTO(name, overview, poster_path, first_air_date);
				
				list.add(dto);
			});
			
			return list;
		}

		public int insertSearchResult(List<DramaDTO> list) {
			return mapper.insertSearchResult(list);
		}

		public List<MediaDTO> selectByPoster(String dramaImgUrl) {
			return mapper.selectByPoster(dramaImgUrl);
		}

		public List<DramaDTO> selectAll() {
			return mapper.selectAll();
		}

}
