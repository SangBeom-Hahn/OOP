<ul>
  <li><h3>클래스 분리</h3></li>
</ul>

```java
package hi;

class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // 메서드
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Circle {
    //필드
    private int radius;
    Point point;

    //생성자
    public Circle(int radius){
        this.radius = radius;
        point = new Point(5, 7);
    }

    //메서드
    public void showPoint(){
        System.out.println(point.getX()+point.getY());
    }
}

```

<ul>
  <li><h3>정보 은닉</h3></li>
</ul>

```java
package hi;

public class DayTime {
    //필드
    private int day;
    private int month;
    
    //생성자
    public DayTime(){}

    public void setDay(int day) {
        if(month == 2){
            if(day < 1 || day > 28){
                System.out.println("안돼요!!");
            }
            else{
                this.day = day;
            }
        }
    }

    //메서드
    public int getDay() {
        return day;
    }
}

```

<ul>
  <li><h3>this()로 생성자 오버로딩 코드 중복 제거</h3></li>
</ul>

```java
public class Person {
    private String name;
    private int age;
    public Person(){
        this("이름없음", 1);
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

```


<ul>
  <li><h3>상속</h3></li>
</ul>

```java

// 이렇게 하지 말고
package costomer;
public class Customer {
    protected int customerId;
    protected String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bonusRatio;
    private int saleRatio; // SILBER라면 안 쓰는데 VIP 때문에 넣은 멤버

    public Customer(int customerID, String customerName){
        this.customerId = customerID;
        this.customerName = customerName;
        customerGrade = "SILVER";
        bonusRatio = 0.01;
    }
    
    // 무자비한 if - else 문
    int calcPrice(int price){
        if(customerGrade == "SILBER"){
            bonusPoint += price * bonusRatio;
        }
        else if(customerGrade == "VIP"){
            bonusPoint += price * (bonusRatio + 1);
        }
        else if(customerGrade == "GOLD"){
            bonusPoint += price * (bonusRatio + 0.5);
        }
    }
}


// 상속을 쓰자
public class Customer {
    protected int customerId;
    protected String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bonusRatio;

    public Customer(int customerID, String customerName){
        this.customerId = customerID;
        this.customerName = customerName;
        customerGrade = "SILVER";
        bonusRatio = 0.01;
    }

    int calcPrice(int price){
        bonusPoint += price * bonusRatio;
        return 0;
    }
}


public class VIPCustomer extends Customer{
    private double saleRatio;

    public VIPCustomer(int customerId, String customerName){
        super(customerId, customerName);
        customerGrade = "VIP";
        bonusRatio = 0.05;
        saleRatio = 0.1;
    }
}
```

<ul>
  <li><h3>업케스팅과 상속</h3></li>
</ul>

```java
package costomer;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        
        Customer customerLee = new Customer(1, "이순신");
        Customer customerShin = new Customer(2, "신사임당");
        VIPCustomer customerHong = new VIPCustomer(3, "홍길동");
        VIPCustomer customerYul = new VIPCustomer(4, "이율곡");
        VIPCustomer customerKim = new VIPCustomer(5, "김유신");
        
        customerList.add(customerLee);
        customerList.add(customerShin);
        customerList.add(customerHong);
        customerList.add(customerYul);
        customerList.add(customerKim);
        
        for(Customer customer : customerList){
            System.out.println(customer.customerId);
        }
    }
}
```
