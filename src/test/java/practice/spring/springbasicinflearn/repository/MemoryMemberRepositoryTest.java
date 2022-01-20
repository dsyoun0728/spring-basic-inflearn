package practice.spring.springbasicinflearn.repository;

// import org.junit.jupiter.api.Assertions;             // 다양한 Assertions가 있으나 org.assertj.core.api.Assertions가 사용하기 편함
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import practice.spring.springbasicinflearn.domain.Member;

import java.util.List;

//  org.assertj.core.api.Assertions에서 제공하는 static method를 이용하겠다는 것
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    // AfterEach 기능을 이용해 Test 하나가 끝날 때마다 실행할 callback 함수를 지정할 수 있음
    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("dsyoun");

        memoryMemberRepository.save(member);

        Member saveResult = memoryMemberRepository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, saveResult);
        assertThat(saveResult).isEqualTo(member);                      // static method 이용
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        memoryMemberRepository.save(member2);

        Member findByNameResult = memoryMemberRepository.findByName("Spring1").get();

        assertThat(findByNameResult).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        memoryMemberRepository.save(member2);

        Member member3 = new Member();
        member3.setName("Spring3");
        memoryMemberRepository.save(member3);

        List<Member> findAllResultList = memoryMemberRepository.findAll();

        assertThat(findAllResultList.size()).isEqualTo(3);
    }
}