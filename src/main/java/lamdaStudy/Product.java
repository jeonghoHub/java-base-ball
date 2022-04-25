package lamdaStudy;

public class Product {
    int age;
    String name;
    public Product(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
