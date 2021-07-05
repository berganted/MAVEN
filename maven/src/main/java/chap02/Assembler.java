package chap02;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	private ListService listSvc;
	private selectoneService selectSvc;
	

	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		listSvc = new ListService(memberDao);
		selectSvc= new selectoneService();
		selectSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}

	public ListService getListSvc() {
		return listSvc;
	}
	public selectoneService getSelectSvc() {
		return selectSvc;
	}
}
