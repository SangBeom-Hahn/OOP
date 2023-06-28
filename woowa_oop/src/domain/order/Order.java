package domain.order;

import domain.shop.Shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    // 필드
    public enum OrderStatus { ORDERED, PAYED, DELIVERED }
    private Long id;
    private Long userId;
    private Shop shop;
    private List<OrderLineItem> orderLineItems = new ArrayList<>();
    private LocalDateTime orderedTime;
    private OrderStatus orderStatus;

    // 생성자

    // 메서드
    public void place() { // 주문하기
        validate();
        ordered();
    }

    private void validate() { // 주문할 때 검증
        if (orderLineItems.isEmpty()) {
            throw new IllegalStateException("주문 항목이 비어 있습니다.");
        }

        if (!shop.isOpen()) {
            throw new IllegalArgumentException("가게가 영업중이 아닙니다.");
        }

        if (!shop.isValidOrderAmount(calculateTotalPrice())) {
            throw new IllegalStateException(String.format("최소 주문 금액 %s 이상을 주문하세요.", shop.getMinOrderAmount()));
        }

        for (OrderLineItem orderLineItem : orderLineItems) {
            orderLineItem.validate();
        }
    }
    private void ordered() { // 주문 상태 변경(메서드 분리 완벽)
        this.orderStatus = OrderStatus.ORDERED;
    }

    private void payed() { // 주문 상태 변경
        this.orderStatus = OrderStatus.PAYED;
    }

    private void delivered() { // 주문 상태 변경
        this.orderStatus = OrderStatus.DELIVERED;
    }

    private Money calculateTotalPrice() {

    }
}
