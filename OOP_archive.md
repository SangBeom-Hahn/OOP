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
