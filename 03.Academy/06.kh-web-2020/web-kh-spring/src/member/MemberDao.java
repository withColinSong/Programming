package member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.MemberFactory;

public class MemberDao implements Dao{
	SqlSession sqlSession;
	
	public MemberDao() {
		
	}
	
	public MemberDao(MemberFactory factory) {
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
		
		Map<String, Object> map = new HashMap<>();
	
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
		
		List<MemberVo> list = sqlSession.selectList("member.select", page);
		
		System.out.println("list.size " + list.size());
		map.put("list", list);
		map.put("page", page);
		
		return map;
	}

	@Override
	public String insert(MemberVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(MemberVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(MemberVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo view(String mid) {
		// TODO Auto-generated method stub
		return null;
	}

}
