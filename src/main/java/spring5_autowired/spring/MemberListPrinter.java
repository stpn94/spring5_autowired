package spring5_autowired.spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	//기본생성자 추가
	public MemberListPrinter() {
	}
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

}
