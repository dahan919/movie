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
import dto.MediaDTO;
import dto.WebtoonDTO;
import mapper.WebtoonMapper;

public class WebtoonService {
	
	private static WebtoonService instance = new WebtoonService();
	private WebtoonMapper mapper;

	public WebtoonService() {
		mapper= DBManager.getInstance().getSession().getMapper(WebtoonMapper.class);
	}
	
	public static WebtoonService getInstance() {
		if(instance == null)
			instance = new WebtoonService();
		return instance;
	}

	public List<WebtoonDTO> selectBySearch(String search) {
		return mapper.selectBySearch(search);
	}
	
	//API 받아오기
	/*
	 * public static String search(String searchTxt) {
	 * 
	 * String response = "";
	 * 
	 * // 1.URL setting String apiURL = "https://comic.naver.com/api/search/all";
	 * 
	 * // 1-1. convert parameter(query String) into UTF-8 form try { searchTxt =
	 * URLEncoder.encode(searchTxt, "UTF-8"); } catch (UnsupportedEncodingException
	 * e) { e.printStackTrace(); } // 1-2. add query String into URL apiURL +=
	 * "?keyword=" + searchTxt;
	 * 
	 * // 2.URL Verification setting // 2-1. HttpURLConnection object initialization
	 * HttpURLConnection conn = null;
	 * 
	 * // 2-2. apiURL: String -> url -> HttpURLConnection try { URL url = new
	 * URL(apiURL); conn = (HttpURLConnection) url.openConnection();
	 * 
	 * //2-3. Connection setting //2-3-1. Send method(Usually given in manual)
	 * conn.setRequestMethod("GET");
	 * 
	 * // 3.Request // 4.Request Verification // 3-1. InputStream object
	 * initialization InputStream is = null;
	 * 
	 * // 3-2., 4. Verify the connection as soon as it is connected
	 * if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) { is =
	 * conn.getInputStream(); }else { is = conn.getErrorStream(); }
	 * 
	 * // 5.Return data Requested BufferedReader br = new BufferedReader(new
	 * InputStreamReader(is)); response =
	 * br.lines().collect(Collectors.joining(System.lineSeparator()));
	 * 
	 * } catch (MalformedURLException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); } finally { if(conn != null) conn.disconnect(); }
	 * 
	 * return response; }
	 * 
	 * public List<WebtoonDTO> StringToJSON(String result) {
	 * 
	 * //1.String값: [{...}]형태이므로 JSONArray로 저장 JSONArray array = new
	 * JSONArray(result);
	 * 
	 * //2.JSON으로 변환된 값에서 key값으로 가져오기 List<WebtoonDTO> list = new ArrayList<>();
	 * 
	 * array.forEach(item -> { JSONObject obj = (JSONObject) item;
	 * 
	 * String titleName = obj.getString("titleName"); String titleId =
	 * obj.getString("titleId"); String thumbnailUrl =
	 * obj.getString("thumbnailUrl");
	 * 
	 * WebtoonDTO dto = new WebtoonDTO(titleName, titleId, thumbnailUrl);
	 * 
	 * list.add(dto); });
	 */
	/*
	 * return list;
	 * 
	 * }
	 */

	/*
	 * public int insertSearchResult(List<WebtoonDTO> list) { return
	 * mapper.insertSearchResult(list); }
	 */

	public List<MediaDTO> selectByPoster(String dramaImgUrl) {
		return mapper.selectByPoster(dramaImgUrl);
	}

	public List<WebtoonDTO> selectAll() {
		return mapper.selectAll();
	}

	public List<WebtoonDTO> selectByTitleName(String titleName) {
		return mapper.selectByTitleName(titleName);
	}
	
	
}
