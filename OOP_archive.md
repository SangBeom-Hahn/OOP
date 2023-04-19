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
    
    int calcPrice(int price){
        bonusPoint += price * (bonusRatio + 1);
        return 0;
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


<ul>
  <li><h3>클래스 분리하고 분리한 객체를 많이 생성하면 ArrayList</h3></li>
</ul>

```java
import java.util.ArrayList;

public class Student {
    int studentId;
    String studentName;
    ArrayList arrayList;
    public Student(){
        arrayList = new ArrayList<Subject>();
    }

    //메서드
    void addSubject(String subjectName, int score){
        Subject subject = new Subject(subjectName);
        subject.setScore(score);

        arrayList.add(subject);
    }
}

```

<ul>
  <li><h3>객체의 협력</h3></li>
</ul>

```java
// 학생 클래스
package take_a_bus;

public class Student {
    //필르
    String name;
    int money;

    //생성자
    public Student(String name, int money){
        this.name = name;
        this.money = money;
    }

    //메서드
    void takeBus(Bus bus){
        bus.take(1000);
        money -= 1000;
    }

    void showInfo(){
        System.out.println(money);
    }
}


// 
public class Bus {
    //필드
    int passengerCount;
    int money;
    int su;

    //생성자
    public Bus(int su){
        this.su = su;
        money = 0;
        passengerCount = 0;
    }

    //메서드
    public void take(int money){
        passengerCount++;
        this.money += money;
    }

    void showInfo(){
        System.out.println(money+su+passengerCount);
    }
}

//main 함수
public class TestBus {
    public static void main(String[] args) {
        Student student = new Student("james", 5000);
        Bus bus = new Bus(100);

        student.takeBus(bus);
        student.showInfo();
        bus.showInfo();
    }
}
```

<ul>
  <li><h3>static으로 기준 잡기</h3></li>
</ul>

```java
package statictest;

public class Student {
    private static int studentId = 10000;
    int studentNum;

    public Student(){
        studentNum = studentId++;
    }
}

```


<ul>
  <li><h3>템플릿 메서드 활용</h3></li>
</ul>

```java
// player 일반 클래스

package gamelevel;

public class Player {
    private PlayerLevel level;

    public Player(){
        level = new BeginnerPlayer();
        level.showLevelMessage();
    }

    //메서드
    public void upgradeLevel(PlayerLevel level){
        this.level = level;
        this.level.showLevelMessage();
    }

    public void play(int count){
        level.go(count);
    }

    public static void main(String[] args) {
        Player player = new Player();
        player.play(5);
        player.upgradeLevel(new SuperPlayer());
        player.play(2);
    }
}

// PlayerLevel에 따른 추상 클래스
public abstract class PlayerLevel {
    public abstract void run();
    public abstract void jump();
    public abstract void turn();
    public abstract void showLevelMessage();

    public final void go(int count){
        run();
        for(int i = 0; i < count; i++){
            jump();
        }
        turn();
    }
}


// PlayerLevel에 따른 추상 클래스 하위 구현 클래스
public class SuperPlayer extends PlayerLevel {
    @Override
    public void run() {
        System.out.println("매우 빽세게 뜁니다.");
    }

    @Override
    public void jump() {
        System.out.println("매우 빽세게 점프합니다.");
    }

    @Override
    public void turn() {
        System.out.println("매우 빽세게 돕니다.");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("슈퍼레벨입니다.");
    }
}

```

<ul>
  <li><h3>클래스 상속과 인터페이스 구현 동시에</h3></li>
</ul>

```java
// Shelf 클래스
public class Shelf {
    //필드
    protected ArrayList shelf;

    //생성자
    public Shelf(){
        shelf = new ArrayList<String>();
    }

    //메서드
    int getCount(){
        return shelf.size();
    }
}

// 큐 인터페이스
public interface Queue {
    void enQueue(String title);
    String deQueue();
    int getSize();
}

// 상속받고 구현하는 클래스
public class BookShelf extends Shelf implements Queue{
    @Override
    public void enQueue(String title) {
        shelf.add(title);
    }

    @Override
    public String deQueue() {
        return (String) shelf.remove(0);
    }

    @Override
    public int getSize() {
        return getCount();
    }
}
```


<ul>
  <li><h3>컬렉션 프레임워크 제네릭 활용</h3></li>
</ul>

```java
package Doit;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArray {
    //필드
    private ArrayList<Member> arrayList;

    //생성자
    public MemberArray(){
        arrayList = new ArrayList<>();
    }

    //메서드
    public void addMember(Member member){ // 특징1 : 컬렉션을 사용하는 메서드의 매개변수는 그 컬렉션의 제네릭을 받는다.
        arrayList.add(member);
    }

    // id를 받아서 동일한 id의 요소를 제거
    public boolean removeMember(int memberId){
        for(int i=0; i<arrayList.size(); i++){
            Member member = arrayList.get(i); // 특징2 : 받으면 제네릭 타입의 레퍼런스로 받아야겠네
            if(member.getMemberId() == memberId){
                arrayList.remove(i);
                return true;
            }
        }
        System.out.println("없습니다.");
        return false;
    }
    
    // iterator로 순회
    public boolean removeMember2(int memberId){
        Iterator<Member> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Member member = iterator.next(); 특징3 : iterator는 순회할 요소를 제네릭으로 받습니다.
            if(member.getMemberId() == memberId){
                arrayList.remove(member);
                return true;
            }
        }
        return false;
    }
}
```

<ul>
  <li><h3>throws 예외처리</h3></li>
</ul>

```java
package Except;
public class Exception {
    public Class loadClass(String className) throws ClassNotFoundException {
        Class c = Class.forName(className);
        return c;
    }
    public static void main(String[] args) {
        Exception exception = new Exception();
        try{
            exception.loadClass("java.lang.string");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

```
