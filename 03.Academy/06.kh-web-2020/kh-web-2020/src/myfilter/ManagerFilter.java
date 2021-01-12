package myfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/member.song" , "/sale.yeon"})
public class ManagerFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		
		// filter request는 ServletRequest 이기 때문에 request.getSession()을 바로 불러오지 못한다.
		HttpSession session = ((HttpServletRequest)request).getSession();
		RequestDispatcher dispatcher = null;
		
		
		// 요청 URL
		String url = ((HttpServletRequest)request).getRequestURL().toString();
		System.out.println(url);
		
		String mid = (String) session.getAttribute("mid");
		
		// mid의 값이 없거나 manager가 아니라면 로그인을 하지 않은 상태
		if(mid == null || !mid.equals("manager") ) {
			dispatcher = request.getRequestDispatcher("./filter/login_fail.jsp");
			
		}else { // manager 아이디로 로그인 한 경우
			if(url.lastIndexOf("member") >= 0) {
				dispatcher = request.getRequestDispatcher("./filter/member_select.jsp");
				
				// 콘솔창
				System.out.println("url.lastIndexOf(\"member\") : " + url.lastIndexOf("member"));
				
			}else if(url.lastIndexOf("sale") >= 0) {
				dispatcher = request.getRequestDispatcher("./filter/sale_select.jsp");
				
				// 콘솔창
				System.out.println("url.lastIndexOf(\"sale\") : " + url.lastIndexOf("sale"));
			}
		}
		
		dispatcher.forward(request, response);
		
	}
	
}
