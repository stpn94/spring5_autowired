package spring5_autowired.spring;

import org.springframework.beans.factory.annotation.Autowired;

//암호 변경 기능
public class ChangePasswordService {
	
	//자동주입기능
	@Autowired
	private MemberDao memberDao;
	
	//@Autowired 있으니까 ▼▼▼▼주입 안해도됨
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	//암호 변경
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		//만약 멤버가 null이면 멤버못찾음 예외
		if (member == null)
			throw new MemberNotFoundException();
		//찾으면 changePassword실행
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}


}
