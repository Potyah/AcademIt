package ru.atademit.potyanikhin.lambdas_main;

import ru.atademit.potyanikhin.lambdas_persons.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Александр", 27);
        Person person2 = new Person("Олег", 5);
        Person person3 = new Person("Екатерина", 46);
        Person person4 = new Person("Светлана", 3);
        Person person5 = new Person("Георгий", 34);
        Person person6 = new Person("Вероника", 20);
        Person person7 = new Person("Ростислав", 17);
        Person person8 = new Person("Сергей", 42);
        Person person9 = new Person("Анна", 33);
        Person person10 = new Person("Светлана", 37);
        Person person11 = new Person("Олег", 43);
        Person person12 = new Person("Вероника", 1);
        Person person13 = new Person("Александр", 57);
        Person person14 = new Person("Вероника", 34);

        List<Person> persons = new ArrayList<>(Arrays.asList(person1, person2,
                person3, person4, person5, person6, person7, person8, person9, person10,
                person11, person12, person13, person14));

        //Получить список уникальных имен.
        List<String> uniqueName = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        //Вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.
        String allNames = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(allNames);

        //Получить список людей младше 18, посчитать для них средний возраст.
        List<Person> personsYoungerEighteen = persons.stream()
                .filter(x -> x.getAge() < 18)
                .collect(Collectors.toList());

        OptionalDouble personsYoungerEighteenAgeAverage = personsYoungerEighteen.stream()
                .mapToInt(Person::getAge)
                .average();

        //При помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст.
        Map<String, Double> groupPersons = persons.stream()
                .collect(Collectors.groupingBy(Person::getName,
                        Collectors.averagingDouble(Person::getAge)));

        //Получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста.
        persons.stream()
                .filter(x -> x.getAge() > 20 && x.getAge() < 45)
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(x -> System.out.println(x.getName() + ", age = " + x.getAge()));
    }
}