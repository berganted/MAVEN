package chap08;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public List<MemberVo> selectList(){
		return sessionTemplate.selectList("member.selectList");
	}
	
	public MemberVo login(MemberVo vo) {
		return sessionTemplate.selectOne("member.login",vo);
	}
	public MemberVo selectOne(MemberVo vo) {
		return sessionTemplate.selectOne("member.selectOne",vo);
	}
	public int update(MemberVo vo) {
		return sessionTemplate.update("member.update", vo);
	}

}
