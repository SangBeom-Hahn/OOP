package domain.shop;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Long id;
    private String name;
    private desc;
    private Shop shop;
    private List<OptionGroupSpecification> optionGroupSpecs = new ArrayList<>();

    public Money getBasePrice() {

    }

    public void validateOrder(String menuName, List<OptionGroup> optionGroups) {
        if (!this.name.equals(menuName)) {
            throw new IllegalArgumentException("기본 상품이 변경됐습니다.");
        }

        if (!isSatisfiedBy(optionGroups)) {
            throw new IllegalArgumentException("메뉴가 변경됐습니다.");
        }
    }

    private boolean isSatisfiedBy(List<OptionGroup> cartOptionGroups) {
        return cartOptionGroups.stream().anyMatch(this::isSatisfiedBy);
    }

    private boolean isSatisfiedBy(OptionGroup group) {
        return optionGroupSpecs.stream().anyMatch(
                spec -> spec.isSatisfiedBy(group)
        );
    }
}
