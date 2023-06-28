package domain.order;

import java.util.ArrayList;

public class OrderLineItem {
    private Long id;
    private Menu menu;
    private String name;
    private int count;
    private List<OrderOptionGroup> groups = new ArrayList<>();

    public Money calculatePrice() {

    }

    public void validate() {

    }

    // 주문 항목을 옵션 그룹으로 변환한다.
    private List<OptionGroup> convertToOptionGroups() {

    }
}
