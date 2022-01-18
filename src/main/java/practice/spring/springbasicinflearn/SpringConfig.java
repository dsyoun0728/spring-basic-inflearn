package practice.spring.springbasicinflearn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.spring.springbasicinflearn.repository.MemberRepository;
import practice.spring.springbasicinflearn.repository.MemoryMemberRepository;
import practice.spring.springbasicinflearn.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        // MemberService constructor에 @Autowired 한 것과 동일
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
