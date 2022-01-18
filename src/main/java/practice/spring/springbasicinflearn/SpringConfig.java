package practice.spring.springbasicinflearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.spring.springbasicinflearn.repository.JdbcMemberRepository;
import practice.spring.springbasicinflearn.repository.MemberRepository;
import practice.spring.springbasicinflearn.repository.MemoryMemberRepository;
import practice.spring.springbasicinflearn.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        // MemberService constructor에 @Autowired 한 것과 동일
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // memory 기반의 MemberRepository 구현 클래스 사용
//        return new MemoryMemberRepository();

        // JDBC 기반의 MemberRepository 구현 클래스 사용
        return new JdbcMemberRepository(dataSource);
    }

}
