package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //할인 정책에 회원을 넘길까~ 그레이드만 넘길까? 고민해보자
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //주문생성해서 리턴
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
