package chap02;

import java.util.Map;

public class ListService {
	private MemberDao memberDao;
	
	public ListService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public Map<String, Member> selectList() {
		return memberDao.selectList();
	}
	
}
