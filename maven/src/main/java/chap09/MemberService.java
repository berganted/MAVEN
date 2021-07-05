package chap09;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {
	List<MemberVo> selectList();
	MemberVo login(MemberVo vo);
	MemberVo mypage(MemberVo vo);
	int update(MemberVo vo);
	int insert(MemberVo vo , HttpServletRequest req) throws Exception;

}
