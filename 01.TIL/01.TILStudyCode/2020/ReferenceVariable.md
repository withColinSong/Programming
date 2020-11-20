# 참조변수 형변환

### 1. 개요
Java의정석 참조변수의 형변환을 공부하다가 참조변수의 형변환을 왜 하는걸까? 하고 고민이 들었다.😮 
정확한 활용법은 아직 알 수 없었기에 혼자 고민하다 이렇게도 사용할 수 있겠다 생각이 들었고
기억에 더 잘 남았으면 싶기도 해서 작성해봤다!!
 
책에 있는 예제는 너무 많은 사람들의 블로그에 있는 거 같아 색다른 예제를 생각해보다가 아래 코드를 짜게 되었다.😁


### Food class
```java

class Food {
    String koreanFood;
    String italianFood;
}
```
- Food의 클래스 안에는 한국음식과, 이탈리안음식으로 멤버필드를 정했다.

### FoodIngredients class
```java
class FoodIngredients extends Food {
    void List() {
        System.out.println("식자재 리스트입니다.");
    }
}
```
- FoodIngredients 클래스 안에는 Food 클래스를 상속받으며, 해당 필드에 해당하는 식자재 리스트를 정리하는 메서드를 만들었다.

### Main 메서드
```java
public class Main {
    public static void main(String[] args) {

        Food food = new Food();
        FoodIngredients foodList = new FoodIngredients();
        foodList.italianFood = "바질";
        System.out.println("foodList.italianFood : "+foodList.italianFood);
        food = foodList; 
        // food = (FoodIngredients)foodList; 자손 <- 조상 형변환 생략가능
        System.out.println("food.italianFood : "+ food.italianFood);
         
    }
}
```
### Console
```java
foodList.italianFood : 바질
food.italianFood : 바질
```
![](https://images.velog.io/images/withcolinsong/post/5995c43c-3f92-4066-8766-278cae2fbd1c/image.png)



### 형변환 문제점
```java 
FoodIngredients koreanFDList = (FoodIngredients) new Food(); 
```
#### 1. 컴파일은 가능. 대신 runtime시 classCastException 에러
![](https://images.velog.io/images/withcolinsong/post/862266da-59a3-45fb-a032-b2a42c6475a6/image.png)

#### 2. food는 foodList의 List 메서드를 사용할 수 없다.
![](https://images.velog.io/images/withcolinsong/post/c2c3af60-bcfa-4745-a27c-abd4d505dafa/image.png)



