package com.song.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.song.board.AttVo;
import com.song.board.BoardVo;
import com.song.mybatis.BoardService;

@Controller
public class FileUploadController {
	String saveDir = "C:\\Users\\user\\Desktop\\git\\Programming\\03.Academy\\07.kh-spring-boot\\spring-mybatis-example01-3\\src\\main\\webapp\\WEB-INF\\upload";


	@Autowired
	BoardService service;

	@RequestMapping(value="bInsertR", method=RequestMethod.POST)
	// insert.jsp <input type="file" name="attFile" multiple="multiple"/>
	public String upload(@RequestParam("attFile") List<MultipartFile> mul, 
			@ModelAttribute BoardVo vo) {

		// attFile에 들어온 파일명을 List<MultipartFile> mul 을 관리해줌.
		// @modelAttribute BoardVo vo -> insert.jsp form에 있는 name의 data들이 setter로 들어옴 `Vo에 있다면`

		String msg = "";
		List<AttVo> attFiles = new ArrayList<>();
		
		try {
			
			for(MultipartFile m : mul) { //MultipartFile 사용자가 선택한 파일

				File oriFile = new File(saveDir + m.getOriginalFilename());
				
				System.out.println(oriFile); // 사용자가 선택한 파일을 저장할 타켓

				// 파일 업로드
				m.transferTo(oriFile);
				
				AttVo v = new AttVo();
				v.setOriFile(m.getOriginalFilename());
				attFiles.add(v);
			}
			
			vo.setAttFiles(attFiles);
			
			msg = service.insert(vo);
			
			System.out.println("mid : " + vo.getMid());
			System.out.println("subject : " + vo.getSubject());
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;
	}
}


