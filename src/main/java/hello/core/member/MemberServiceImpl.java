package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //new 구현체
    //추상화와 구체화 모두에 의존한다. DIP 위반
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
