package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ExamAjax
 */
@WebServlet(urlPatterns = "/exam/searchKH")
public class ExamAjax extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		KH kh = new KH();
		
		kh.setKh_no(100);
		kh.setKh_name("당산지원");
		kh.setAddr("선유도");
		kh.setFax("02-1234-1234");
		
		Gson gson = new Gson();
		String result = gson.toJson(kh);

		out.print(result);
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
