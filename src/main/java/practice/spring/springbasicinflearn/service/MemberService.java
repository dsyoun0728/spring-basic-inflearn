package practice.spring.springbasicinflearn.service;

import org.springframework.transaction.annotation.Transactional;
import practice.spring.springbasicinflearn.domain.Member;
import practice.spring.springbasicinflearn.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    // MemberService에서 사용하는 repository를 외부에서 넣어줌 (DI, Dependency Injection)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입 (같은 이름이 있는 중복 회원은 안되는 기능을 넣을 것)
     * @param member
     * @return memberRepository에 저장된 멤버의 id
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     * @return memberRepository에 저장된 모든 회원
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 특정 멤버 찾기
     * @param memberId
     * @return memberRepository에 저장된 회원 중 id가 일치하는 멤버
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
