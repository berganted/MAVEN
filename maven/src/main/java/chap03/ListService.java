package chap03;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class ListService {
	@Autowired
	private MemberDao memberDao;
	
//	public ListService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	public Map<String, Member> selectList() {
		return memberDao.selectList();
	}
	
}
