package member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberController {
	Dao dao;
	FileUpload fu;

	public MemberController() { }
	public MemberController(Dao dao) {
		this.dao = dao;
	}

	@RequestMapping(value="insert.member", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView insert() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("insert");
		return mv;
	}

	@RequestMapping(value="insertR.member", method=RequestMethod.POST)
	public ModelAndView insertR(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		fu = new FileUpload(req);
		MemberVo vo = fu.getMember();
		Page page = fu.getPage();
		
		System.out.println(vo.getMid());
		System.out.println(vo.getPwd());
		System.out.println(vo.getPhone());

		mv.setViewName("insert_result"); //WEB-INF/member/insert_result.jsp
		mv.addObject("msg", "회원정보가 정상적으로 저장되었습니다.");



		return mv;

	}

	@RequestMapping(value="select.member", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView select(Page page) {

		ModelAndView mv = new ModelAndView();	

		List<MemberVo> list = null;

		Map<String, Object> map = dao.select(page);
		System.out.println("Controller page : " + page);
		page = (Page)map.get("page");
		list = (List<MemberVo>)map.get("list");


		mv.addObject("page", page);
		mv.addObject("list", list);
		mv.setViewName("select");

		return mv;

	}
	
	
	@RequestMapping(value="view.member", method= RequestMethod.POST)
	public ModelAndView view(MemberVo vo) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("Controller.view()......");
		System.out.println(vo.getMid());
		
		vo = dao.view(vo.getMid());
		
		mv.addObject("vo", vo);
		mv.setViewName("view");
		
		return mv;
	}
	
}
