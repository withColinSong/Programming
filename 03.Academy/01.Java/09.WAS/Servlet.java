package example_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServelt
 */
@WebServlet("/HelloServelt")
public class HelloServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServelt() { // 상대적 경로
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
        HttpServletRequest request, // 톰캣이 만든 구현체
        HttpServletResponse response // 톰캣이 만든 구현체 
        ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter()
        .append(""
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>Helo Servlet!</title>"
                + "</head>"
                + "<body>"
                + "<h1>test</h1>"
                + "</body>"
                + "</html>"
            );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}