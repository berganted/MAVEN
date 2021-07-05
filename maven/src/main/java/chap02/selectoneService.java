package chap02;


public class selectoneService {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public Member selectone(String email) {
		
		
		return memberDao.selectbyEmail(email);
		
	}
}
