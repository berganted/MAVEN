package chap02;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId= 0;
	private Map<String,Member> map = new HashMap<String,Member>();
	
	public Member selectbyEmail(String email) {
		return map.get(email);
	}
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	public Map<String,Member> selectList(){
	
		return map;
			
	}
	
	
	}


