package chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	private static AnnotationConfigApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력해주세요");
			String cmd = reader.readLine();
			if(cmd.equals("exit")) {
				System.out.println("꺼저");
				break;
			}else if(cmd.startsWith("new")) {
				processNewCommand(cmd.split(" "));
			}else if(cmd.startsWith("change")) {
				processChangeCommand(cmd.split(" "));
			}else if(cmd.startsWith("list")) {
				processListCommand();
			}else if (cmd.startsWith("info")) {
				processSelectCommand(cmd.split(" "));
			}
			
		}
	}
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			return;
		}
		MemberRegisterService regSvc = ctx.getBean("regSvc",MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if(!req.isPasswordEqualtoConfirmPassword()) {
			System.out.println("비번틀림");
			return;
		}
		try {
		regSvc.regist(req);
		System.out.println("ㅇㅋ");
		} catch (DuplicateMemberException e) {
			System.out.println("겹침");
		}
	}
	private static void processChangeCommand(String[] arg) {
		if(arg.length !=4) {
			return;
		}
		ChangePasswordService pwdSvc = (ChangePasswordService)ctx.getBean("pwdSvc");
		try {
		pwdSvc.changePassword(arg[1], arg[2], arg[3]);
		System.out.println("비번바꿈");
		}catch(MemberNotFoundException e) {
			System.out.println("아이디없다");
		}catch(WrongIdPasswordException e) {
			System.out.println("아이디랑비번노일치");
		}
	}
	private static void processListCommand() {
		Map<String,Member>map = ctx.getBean("listSvc",ListService.class).selectList();
		for(String key:map.keySet()) {
			Member m = map.get(key);
			System.out.println(m.getEmail()+"\t"+m.getName()+"\t"+m.getPassword()+"\t"+m.getRegisterDateTime());
		}
	}
	private static void processSelectCommand(String[] arg) {
		if(arg.length !=2) {
			return;
		}
		Member member = ((selectoneService)ctx.getBean("selectSvc")).selectone(arg[1]);
		if(member == null) {
			System.out.println("등록x");
		}else {
			System.out.println("id:" + member.getId() + " email:"+member.getEmail()+" name:" + member.getName() + " date:"+member.getRegisterDateTime());
		}
		
	}
}
