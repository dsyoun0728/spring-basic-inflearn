package practice.spring.springbasicinflearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.spring.springbasicinflearn.repository.*;
import practice.spring.springbasicinflearn.service.MemberService;

@Configuration
public class SpringConfig {

    // 순수 JDBC와 JdbcTemplate 사용 시 필요한 부분
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    // JPA 사용 시 필요한 부분
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//    @Bean
//    public MemberService memberService() {
//        // MemberService constructor에 @Autowired 한 것과 동일
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        // memory 기반의 MemberRepository 구현 클래스 사용
////        return new MemoryMemberRepository();
//
//        // JDBC 기반의 MemberRepository 구현 클래스 사용
////        return new JdbcMemberRepository(dataSource);
//
//        // JdbcTemplate 기반의 MemberRepository 구현 클래스 사용
////        return new JdbcTemplateMemberRepository(dataSource);
//
//        // JPA 기반의 MemberRepository 구현 클래스 사용
////        return new JpaMemberRepository(em);
//    }

    // --------------------------------------------------------------------- 아래는 스프링 데이터 JPA를 쓰는 경우 --------------------------------------------------------------------- //

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
