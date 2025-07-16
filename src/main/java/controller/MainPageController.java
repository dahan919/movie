package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.DramaDTO;
import dto.MediaDTO;
import dto.WebtoonDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DramaService;
import service.MediaService;
import service.WebtoonService;
import view.ModelAndView;

public class MainPageController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		//1. 통합 검색 기능
		ModelAndView view = null;
		
		String search = request.getParameter("search");
		
		if (search != null) {
			//search 데이터
			String mediaResult = MediaService.getInstance().search(search);
			String dramaResult = DramaService.getInstance().search(search);
			String webtoonResult = WebtoonService.getInstance().search(search);
			
			//데이터 타입 변환: String -> JSON -> List(JSON까지만 변환?)
			List<MediaDTO> mList = MediaService.getInstance().StringToJSON(mediaResult);
			List<DramaDTO> dList = DramaService.getInstance().StringToJSON(dramaResult);
			List<WebtoonDTO> wList = WebtoonService.getInstance().StringToJSON(webtoonResult);
			
			//받은 데이터 삽입
			int mn = MediaService.getInstance().insertSearchResult(mList);
			int dn = MediaService.getInstance().insertSearchResult(mList);
			int wn = MediaService.getInstance().insertSearchResult(mList);
			
			//데이터 앞으로 보내주기
			if(mn != 0 || dn != 0 || wn != 0) {
				request.setAttribute("mList", mList);
				request.setAttribute("dList", dList);
				request.setAttribute("wList", wList);
				
				view = new ModelAndView("search.jsp", false);
			}
			
		}
		
		//2. 이미지 눌렀을 때 상세페이지로 이동
		String mediaUrl = request.getParameter("mediaUrl");
		String dramaUrl = request.getParameter("dramaUrl");
		String webtoonUrl = request.getParameter("webtoonUrl");

		if (mediaUrl != null) {

			// 1. 앞단에서 받은 데이터로 API 연결 후 검색: list로 받는걸로 바꾸기
			String mediaResult = MediaService.getInstance().searchByMediaUrl(mediaUrl);

			// 2. 받은 String 데이터 json으로 바꾼 후 값들 dto형식으로 바꿔서 저장
			List<MediaDTO> list = MediaService.getInstance().StringToJSON(mediaResult);

			// 3. 검색한 데이터 저장
			int n = MediaService.getInstance().insertSearchResult(list);

			if (n != 1) {

				// 4. 저장한 데이터 List형식으로 출력
				List<MediaDTO> mediaList = MediaService.getInstance().selectByPoster(search);
				
				// 5. 중복된 데이터는 지우기
				

				request.setAttribute("mediaList", mediaList);
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 있습니다.");
				
				view = new ModelAndView("detailPage.jsp", false);
				

			} else {
				
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 없습니다.");
				view = new ModelAndView("detailPage.jsp", false);
				
			}
		}

		if (dramaUrl != null) {

			// 1. 앞단에서 받은 데이터로 API 연결 후 검색
			String result = DramaService.getInstance().searchByDramaUrl(dramaUrl);

			// 2. 받은 String 데이터 json으로 바꾼 후 값들 dto형식으로 바꿔서 저장
			List<DramaDTO> list = DramaService.getInstance().StringToJSON(result);

			// 3. 검색한 데이터 저장
			int n = DramaService.getInstance().insertSearchResult(list);

			if (n != 0) {

				// 4. 저장한 데이터 List형식으로 출력
				List<MediaDTO> dramaList = DramaService.getInstance().selectByPoster(search);
				
				request.setAttribute("dramaList", dramaList);
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 있습니다.");
				view = new ModelAndView("detailPage.jsp", false);

			} else {
				
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 없습니다.");
				view = new ModelAndView("detailPage.jsp", false);
				
			}

		}

		if (webtoonUrl != null) {

			String result = WebtoonService.getInstance().searchByWebtoonUrl(webtoonUrl);

			// 2. 받은 String 데이터 json으로 바꾼 후 값들 dto형식으로 바꿔서 저장
			List<WebtoonDTO> list = WebtoonService.getInstance().StringToJSON(result);

			// 3. 검색한 데이터 저장
			int n = WebtoonService.getInstance().insertSearchResult(list);

			if (n != 0) {

				// 4. 저장한 데이터 List형식으로 출력
				List<MediaDTO> webtoonList = WebtoonService.getInstance().selectByPoster(search);

				request.setAttribute("webtoonList", webtoonList);
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 있습니다.");
				view = new ModelAndView("detailPage.jsp", false);

			} else {
				
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 없습니다.");
				view = new ModelAndView("detailPage.jsp", false);
				
			}

		}
		
		return view;
	}
}
