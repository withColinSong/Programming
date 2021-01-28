package member;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.MemberFactory;

public class MemberDao implements Dao{
	SqlSession sqlSession;
	MemberFactory f;
	public MemberDao() {
		
	}
	
	public MemberDao(MemberFactory factory) {
		//this.f = f;
		//sqlSession = f.getFactory().openSession();
		sqlSession = factory.getFactory().openSession();
	}
	
	@Override
	public boolean login(String mid, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTotListSize(String findStr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> select(Page page) {
		sqlSession = f.getFactory().openSession();
		
		Map<String, Object> map = new HashMap<>();
		System.out.println("page " + page);
		if(page == null) {
			page = new Page();
			page.setNowPage(1);
		}else if (page.getNowPage() < 1) {
			page.setNowPage(1);
		}
		
		System.out.println("nowPage : " + page.getNowPage());
		// member.xml <select id="tot_list_size" parameterType="String" resultType="Integer">		
		int cnt = sqlSession.selectOne("member.tot_list_size", page);
		System.out.println("page.getFindStr : "+ page.getFindStr());
		
		page.setTotListSize(cnt);
		page.pageCompute();
		
		
		System.out.println("startNo " + page.getStartPage());
		System.out.println("endNo " + page.getEndNo());
		System.out.println("Page : " + page);
		
		List<MemberVo> list = sqlSession.selectList("member.select", page);
		
		System.out.println("list.size " + list.size());
		map.put("list", list);
		map.put("page", page);
		
		sqlSession.close();
		return map;
	}

	@Override
	public String insert(MemberVo vo) {
		String msg = "회원 정보가 정상적으로 저장되었습니다.";
		sqlSession = f.getFactory().openSession();
		int cnt = sqlSession.insert("member.insert", vo);
		
		if(cnt < 1) {
			msg = "회원 정보 저장 중 오류 발생";
			sqlSession.rollback();
		}
		sqlSession.commit();
		sqlSession.close();
		return msg;
	}

	@Override
	public String update(MemberVo vo) {
		
		sqlSession = f.getFactory().openSession();
		String msg = "회원 정보가 정상적으로 수정되었습니다.";
		int cnt = sqlSession.update("member.update", vo);
		
		if(cnt > 0) {
			sqlSession.commit();
			if(vo.getPhoto() != null && !vo.getPhoto().equals("")) {
				File file = new File(FileUpload.saveDir + vo.getDelFile());
				if(file.exists()) file.delete();
				
			}
			
		}else {
			msg = "회원 정보 수정 중 오류 발생";
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return msg;
		
	}

	@Override
	public String delete(MemberVo vo) {
		
		String msg = "회원 정보가 정상적으로 삭제되었습니다.";
		sqlSession = f.getFactory().openSession();
		
		int cnt = sqlSession.delete("member.delete", vo);
		
		if(cnt > 0) {
			File file = new File(FileUpload.saveDir + vo.getDelFile());
			System.out.println(vo.getDelFile());
			
			if(file.exists()) file.delete(); 
				sqlSession.commit();

		} else {
			msg = "회원 정보 삭제 중 오류 발생";
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return msg;
	}

	@Override
	public MemberVo view(String mid) {
		sqlSession = f.getFactory().openSession();
		MemberVo vo = sqlSession.selectOne("member.view", mid);
		System.out.println(vo.getName());
		sqlSession.close();
		return vo;
	}

}
