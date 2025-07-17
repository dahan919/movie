package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.AnnouncementDTO;
import dto.CommentaryDTO;
import dto.DramaDTO;
import dto.MediaDTO;
import dto.UserInfoDTO;
import dto.WebtoonDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AnnouncementService;
import service.CommentaryService;
import service.DramaService;
import service.MediaService;
import service.UserInfoService;
import service.WebtoonService;
import view.ModelAndView;

public class AdminController implements Controller {

	//통합 검색기능을 구현하는 controller
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;

		String search = request.getParameter("search");

		Map<String, Object> map = new HashMap<String, Object>();

		List<CommentaryDTO> commentaryList = CommentaryService.getInstance().selectBySearch(map);
		List<AnnouncementDTO> announcementList = AnnouncementService.getInstance().selectBySearch(map);
		List<DramaDTO> dramaList = DramaService.getInstance().selectBySearch(map);
		List<MediaDTO> mediaList = MediaService.getInstance().selectBySearch(map);
		List<WebtoonDTO> webtoonList = WebtoonService.getInstance().selectBySearch(map);
		List<UserInfoDTO> userInfoList = UserInfoService.getInstance().selectBySearch(map);

		// 관리자 페이지가 일단 하나인 것으로 간주하고 작업
		// AJAX 사용
		// JSON 파일로 변환해서 주려고 함

		// Array는 크게 4개를 쓰려고 함.
		// 1.commentaryArray: 댓글정보를 받아오는 JSONArray
		// 2.announcementArray: 공지정보를 받아오는 JSONArray
		// 3.contentArray: 드라마, 웹툰, 영화등 API로 저장한 정보를 받아오는 JSONArray
		// contentArray에 세 테이블의 정보를 받아오는 건
		// JSONArray가 put을 사용해 넣는 정보 순서대로 저장을 하고 있기 때문
		// 순서대로 저장한다는 것이 매우 중요함
		// dramaList -> mediaList -> webtoonList 순서대로 넣을 것이고
		// 저장 역시 drama 정보, media정보, webtoon 정보 순으로 되어있을 것.
		// 물론 u_num이 다 달라서 u_num으로 로직을 처리해서 구분해도 됨
		// 4.userInfoArray: 회원정보를 받아오는 JSONArray

		// commentaryList 작업
		// commentaryList -> commentaryArray
		JSONArray commentaryArray = new JSONArray(commentaryList);
		

		// announcementList 작업
		// announcementList -> announcementArray
		JSONArray announcementArray = new JSONArray(announcementList);

		// dramaList 작업
		// dramaList -> dramaArray
		JSONArray dramaArray = new JSONArray(dramaList);

		// mediaList 작업
		// mediaList -> mediaArray
		JSONArray mediaArray = new JSONArray(mediaList);

		// webtoonList 작업
		// webtoonList -> webtoonArray
		JSONArray webtoonArray = new JSONArray(webtoonList);
		
		// userInfoList 작업
		// userInfoList -> userInfoArray
		JSONArray userInfoArray = new JSONArray(userInfoList);
		
		//JSONObject에 모든 array 객체들을 다 담아서 앞단으로 보내줌
		JSONObject arrayObject = new JSONObject();
		arrayObject.put("commentaryArray", commentaryArray);
		arrayObject.put("announcementArray", announcementArray);
		arrayObject.put("announcementArray", dramaArray);
		arrayObject.put("announcementArray", mediaArray);
		arrayObject.put("announcementArray", webtoonArray);
		arrayObject.put("userInfoArray", userInfoArray);
		
		response.getWriter().println(arrayObject.toString());

		return view;
	}

}
