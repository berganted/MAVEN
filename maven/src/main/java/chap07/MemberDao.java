package chap07;

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

}
