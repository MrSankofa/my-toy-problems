import java.util.Comparator;

public class Person implements Comparable<Person> {

  String name;
  int age;
  char gender;


  public Person(String name, int age, char gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  @Override
  public int compareTo(Person o) {
    return this.name.compareTo(o.name);
  }
}

