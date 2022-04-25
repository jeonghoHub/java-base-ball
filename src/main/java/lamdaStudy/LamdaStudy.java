package lamdaStudy;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class LamdaStudy {
    public static void main(String[] args) {
//        Employee e1 = new Employee("Mangkye");
//        Employee e2 = new Employee("Mangkye");
//
//        List<Employee> employees = new ArrayList<>();
//
//        employees.add(e1);
//        employees.add(e2);
//
//        int size = employees.stream().distinct().collect(Collectors.toList()).size();
//        System.out.println(size);

//        OptionalInt min = IntStream.of(1,3,5,7,9).min();
//        int max = IntStream.of().max().orElse(0);
////        IntStream.of(1,3,5,7,9).average().ifPresent(System.out::println);
//
//        long count = IntStream.of(1, 3, 5, 7, 9).count();
//        long sum = LongStream.of(1, 3, 5, 7, 9).sum();
//
//        System.out.println(sum);

        List<Product> productList = Arrays.asList(
                new Product(23, "orange"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));

        String collect = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(",", "<", ">"));

//        System.out.println(collect);

        Double collect1 = productList.stream()
                .collect(Collectors.averagingDouble(Product::getAge));

        Integer collect2 = productList.stream()
                .collect(Collectors.summingInt(Product::getAge));

        int sum = productList.stream()
                .mapToInt(Product::getAge)
                .sum();

        IntSummaryStatistics collect3 = productList.stream()
                .collect(Collectors.summarizingInt(Product::getAge));
//        System.out.println(collect3);

        Map<Integer, List<Product>> collect4 = productList.stream()
                .collect(Collectors.groupingBy(Product::getAge));
//        System.out.println(collect4);

        Map<Boolean, List<Product>> collect5 = productList.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 15));
//        System.out.println(collect5);

        List<String> names = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");

        //java 8 Lambda
//        names.stream()
//                .map(name -> name.toUpperCase())
//                .forEach(System.out::println);

        // 0~1000까지의 값 중 500이상이며 짝수이면서 5의 배수인 수의 합을 구하라
//        System.out.println(
//                IntStream.range(0, 1001)
//                        .skip(500)
//                        .filter(i-> i%2==0)
//                        .filter(i-> i%5==0)
//                        .sum()
//        );
    }
}
