package studytest;

public abstract class Animal {
  private String name;
  private int age;

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public abstract void speak();

  public final void isOnlyAnimalMethod() {
    System.out.println("This is Final Method!!");
  }

  public final void isOnlyAnimalMethod(String str) {
    System.out.println("This is Final Method!!");
  }

  public void move() {
    System.out.println("Move");
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
//