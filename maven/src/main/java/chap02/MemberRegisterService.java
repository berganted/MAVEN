package chap02;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectbyEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("이메일중복 :"+req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
