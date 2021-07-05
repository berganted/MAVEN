package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberRegisterService regSvc() {
		return new MemberRegisterService(memberDao());
	}
	@Bean
	public ChangePasswordService pwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	@Bean
	public ListService listSvc() {
		return new ListService(memberDao());		
	}
	@Bean
	public selectoneService selectSvc() {
		selectoneService selectSvc = new selectoneService();
		selectSvc.setMemberDao(memberDao());
		return selectSvc;

	}
}
