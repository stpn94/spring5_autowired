package spring5_autowired.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring5_autowired.spring.ChangePasswordService;
import spring5_autowired.spring.MemberDao;
import spring5_autowired.spring.MemberInfoPrinter;
import spring5_autowired.spring.MemberListPrinter;
import spring5_autowired.spring.MemberPrinter;
import spring5_autowired.spring.MemberRegisterService;
import spring5_autowired.spring.VersionPrinter;

@Configuration
public class AppCtx {
// Unsatisfied dependency erorr가 뜨면 @Bean생성 했는지 확인해라
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
//		return new MemberRegisterService(memberDao());
		//memberDao()를 빼도됨 그러면▼▼▼이렇게 됨
		return new MemberRegisterService();
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
//		자동 주입 기능을 사용하면@Bean 메서드에서 의존을 주입하지 않아도 의존 객제가 주입된다.
//		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
//  @Qualifier TEST를 위해 주석처리함.
//	@Bean
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}
	
	@Bean
	@Qualifier
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		//MemberInfoPrinter에 @Autowired를 붙여 놓아서 자동 주입된다.
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
