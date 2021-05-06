package spring5_autowired.spring;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;

	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	// 자동주입할 대상이 필수가 아닌 경우에는 @Autowired 애노테이션의 required속성을 false로 지정한다
	// @Autowired(required = false)
	//
	// @Nullable을 넣어도 된다.
	//public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
	//	this.dateTimeFormatter = dateTimeFormatter;
	//}
//		Optional<DateTimeFormatter>
//		public void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt) {
//			if(formatterOpt.isPresent()) {
//				this.dateTimeFormatter = formatterOpt.get();
//			}else {
//				this.dateTimeFormatter = null;
//			}
//		}
	
	@Autowired /* (required = false) */
	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}

	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", member.getId(), member.getEmail(),
					member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}

}
