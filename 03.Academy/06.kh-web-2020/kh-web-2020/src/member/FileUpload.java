package member;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.MemberVo;
import bean.Page;

public class FileUpload {
	public static final String saveDir = "C:\\Users\\user\\Desktop\\git\\Programming\\03.Academy\\06.kh-web-2020\\kh-web-2020\\WebContent\\upload";
	int maxSize = 1024 * 1024 * 100; // 100MB;
	String encoding = "utf-8";
	
	MultipartRequest mul;
	public HttpServletRequest req;
	
	String sysFile = "";
	String oriFile = "";
	
	public FileUpload(HttpServletRequest req) { 
		
		try {
			// 객체가 생성되는 순간 파일이 업로드 되고 있다.
			mul = new MultipartRequest(req, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
			
			// 업로드된 파일명
			Enumeration<String> en = mul.getFileNames();
			
			while(en.hasMoreElements()) {
				String tag = (String)en.nextElement();
				sysFile = mul.getFilesystemName(tag); // 수정된 파일명
				oriFile = mul.getOriginalFileName(tag); // 원본 파일명
				
				System.out.println("원본 파일 명 : " + oriFile);
				System.out.println("변경 파일 명 : " + sysFile);
			}
			
		}catch(Exception e) {
			
		}
	}
	
	public MemberVo getMember() {
		MemberVo vo = new MemberVo();
		vo.setAddress(mul.getParameter("address")); // vo.setAttress(request.getParameter("address")); -> enctype가 있을 시 사용할 수 없기 때문에
		vo.setEmail(mul.getParameter("email"));
		vo.setMdate(mul.getParameter("mdate"));
		vo.setMid(mul.getParameter("mid"));
		vo.setName(mul.getParameter("name"));
		vo.setPhone(mul.getParameter("phone"));
		vo.setPwd(mul.getParameter("pwd"));
		vo.setZipcode(mul.getParameter("zipcode"));
		vo.setPhoto(sysFile);
		
		return vo;
	}
	
	public Page getPage() {
		
		Page page = new Page();
		
		if(mul.getParameter("findStr") != null) {
			page.setFindStr(mul.getParameter("findStr"));
		}
		
		if(mul.getParameter("nowPage") != null && !mul.getParameter("nowPage").equals("")) {
			int nowPage = Integer.parseInt(mul.getParameter("nowPage"));
			page.setNowPage(nowPage);
		}else {
			page.setNowPage(1);
		}
		
		return page;
		
	}
}
