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

		ModelAndView view = null;
		
		String mediaImgUrl = request.getParameter("mediaImgUrl");
		String dramaImgUrl = request.getParameter("dramaImgUrl");
		String webtoonImgUrl = request.getParameter("webtoonImgUrl");

		if (mediaImgUrl != null) {

			// 1. 앞단에서 받은 데이터로 API 연결 후 검색: list로 받는걸로 바꾸기
			String result = MediaService.getInstance().search(mediaImgUrl);

			// 2. 받은 String 데이터 json으로 바꾼 후 값들 dto형식으로 바꿔서 저장
			List<MediaDTO> list = MediaService.getInstance().StringToJSON(result);

			// 3. 검색한 데이터 저장
			int n = MediaService.getInstance().insertSearchResult(list);

			if (n != 0) {

				// 4. 저장한 데이터 List형식으로 출력
				List<MediaDTO> mediaList = MediaService.getInstance().selectByPoster(mediaImgUrl);

				request.setAttribute("mediaList", mediaList);
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 있습니다.");
				
				view = new ModelAndView("main.jsp", false);
				

			} else {
				
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 없습니다.");
				view = new ModelAndView("main.jsp", false);
				
			}
		}

		if (dramaImgUrl != null) {

			// 1. 앞단에서 받은 데이터로 API 연결 후 검색
			String result = DramaService.getInstance().search(dramaImgUrl);

			// 2. 받은 String 데이터 json으로 바꾼 후 값들 dto형식으로 바꿔서 저장
			List<DramaDTO> list = DramaService.getInstance().StringToJSON(result);

			// 3. 검색한 데이터 저장
			int n = DramaService.getInstance().insertSearchResult(list);

			if (n != 0) {

				// 4. 저장한 데이터 List형식으로 출력
				List<MediaDTO> dramaList = DramaService.getInstance().selectByPoster(dramaImgUrl);
				
				request.setAttribute("dramaList", dramaList);
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 있습니다.");
				view = new ModelAndView("main.jsp", false);

			} else {
				
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 없습니다.");
				view = new ModelAndView("main.jsp", false);
				
			}

		}

		if (webtoonImgUrl != null) {

			String result = WebtoonService.getInstance().search(webtoonImgUrl);

			// 2. 받은 String 데이터 json으로 바꾼 후 값들 dto형식으로 바꿔서 저장
			List<WebtoonDTO> list = WebtoonService.getInstance().StringToJSON(result);

			// 3. 검색한 데이터 저장
			int n = WebtoonService.getInstance().insertSearchResult(list);

			if (n != 0) {

				// 4. 저장한 데이터 List형식으로 출력
				List<MediaDTO> webtoonList = WebtoonService.getInstance().selectByPoster(dramaImgUrl);

				request.setAttribute("webtoonList", webtoonList);
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 있습니다.");
				view = new ModelAndView("main.jsp", false);

			} else {
				
				request.setAttribute("msg", "해당 포스터에 해당하는 정보가 없습니다.");
				view = new ModelAndView("main.jsp", false);
				
			}

		}
		
		return view;
	}
}
