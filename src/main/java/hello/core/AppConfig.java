package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    // AppConfig는 실제 동작에 필요한 '구현 객체를 생성'한다
    // AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 '생성자를 통해서 주입(연결)'해준다

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // new MemoryMemberRepository() 부분이 중복제거되었다. 이제 MemoryMemberRepository를 다른 구현체로 변경할때 한 부분만 변경하면 된다.
    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
