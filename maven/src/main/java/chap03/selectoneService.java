package chap03;

import org.springframework.beans.factory.annotation.Autowired;

public class selectoneService {
	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public Member selectone(String email) {
		
		
		return memberDao.selectbyEmail(email);
		
	}
}
