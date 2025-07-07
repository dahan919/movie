package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CommentaryService;
import service.MediaService;
import service.MovieuserService;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import dto.CommentaryDTO;
import dto.MediaDTO;
import dto.MovieuserDTO;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CommentaryDTO> commentaryList = CommentaryService.getInstance().selectAllCommentary();
		List<MovieuserDTO> movieuserList = MovieuserService.getInstance().selectAllMovieuser();
		List<MediaDTO> mediaList = MediaService.getInstance().selectAllMedia();
		
		request.setAttribute("commentaryList", commentaryList);
		request.setAttribute("movieuserList", movieuserList);
		request.setAttribute("mediaList", mediaList);
		
		request.getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
