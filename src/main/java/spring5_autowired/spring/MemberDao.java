package spring5_autowired.spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private static long nextId = 0;

	private Map<String, Member> map = new HashMap<>();
	
	//Email로 검색
	public Member selectByEmail(String email) {
		return map.get(email);
	}

	//멤버 추가
	public void insert(Member member) {
		//Id는 이전아이디에 1추가된다.
		member.setId(++nextId);
		//Map(해당이메일(키),(값))에 넣는다.
		map.put(member.getEmail(), member);
	}
	//업데이트 멤버
	public void update(Member member) {
		//Map(해당이메일(키),(값))에 넣는다.
		map.put(member.getEmail(), member);
	}

	public Collection<Member> selectAll() {
		return map.values();
	}
}
