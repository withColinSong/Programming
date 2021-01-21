package mvc.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {

	
	@RequestMapping(value="test.do" , method= RequestMethod.GET)
	public ModelAndView test(ModelAndView mv) {
		
		// hello-servlet.xml -> prefix + /WEB-INT/test/setViewName("myname") + suffix + .jsp 
		mv.setViewName("myname"); 
		mv.addObject("message", "addObject message"); // request.setAttribute("", "");
		return mv;
	}
	
	@RequestMapping(value="gugudan.do", method= RequestMethod.GET)
	public ModelAndView gugudan() {
		ModelAndView mv = new ModelAndView();
		
		
		StringBuffer sb = new StringBuffer();
		
		int dan = 9;
		for(int i=1; i<10; i++) {
			String str = String.format("%d * %d = %d<br/>", dan, i, (dan*i));
			sb.append(str);
		}
		
		mv.setViewName("gugudan_result");
		mv.addObject("gugudan", sb.toString());
		
		return mv;
		
	}
	
	@RequestMapping(value="sum.do", method= RequestMethod.GET) 
	public ModelAndView sum() {
		ModelAndView mv = new ModelAndView();
		
		
		
		int a = (int)(Math.random()*10)+1;
		int b = (int)(Math.random()*10)+1;
		
		int result = a+b;
		
		mv.addObject("a", a);
		mv.addObject("b", b);
		
		mv.setViewName("sum_result");
		mv.addObject("sum", result);
		return mv;
	
	}
}
