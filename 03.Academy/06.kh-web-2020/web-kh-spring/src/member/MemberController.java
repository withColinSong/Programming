package member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	Dao dao;
	
	 public MemberController() { }
	 public MemberController(Dao dao) {
		 this.dao = dao;
	 }
	
	@RequestMapping(value="insert.member", method=RequestMethod.GET)
	public ModelAndView insert() {
			ModelAndView mv = new ModelAndView();
			
			mv.setViewName("insert");
			return mv;
	}
	
	@RequestMapping(value="insertR.member", method=RequestMethod.POST)
	public ModelAndView insertR(MemberVo vo) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println(vo.getMid());
		System.out.println(vo.getPwd());
		System.out.println(vo.getPhone());
		
		mv.setViewName("insert_result"); //WEB-INF/member/insert_result.jsp
		mv.addObject("msg", "회원정보가 정상적으로 저장되었습니다.");
		
		
		
		return mv;
		
	}
	
	@RequestMapping(value="select.member", method=RequestMethod.GET)
		public ModelAndView select(Page page) {
			
			ModelAndView mv = new ModelAndView();
			
			mv.setViewName("select");
			return mv;
			
		}
}
