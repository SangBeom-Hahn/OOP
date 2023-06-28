package domain.shop;

import java.util.ArrayList;

public class Shop {
    private Long id;
    private String name;
    private boolean open;
    private Money minOrderAmount;
    private Ratio commissionRate;
    private Money commission = Money.ZERO;

    private List<Menu> menus = new ArrayList<>();

    // 생성자

    // 메서드
    public boolean isOpen() {
        return open;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public boolean isValidOrderAmount(Money amount) {
        return amount.isGreaterThanOrEqual(minOrderAmount);
    }

    public void open() {
        this.open = true;
    }

    public void close() {
        this.open = false;
    }
}
