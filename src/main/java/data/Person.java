package data;

public class Person {

    private final String name;
    private final boolean employed;
    private final float salary;
    private Address address;
    private Company company;
    public Person(String name, boolean employed, float salary,Address address,Company company) {
        this.name = name;
        this.employed = employed;
        this.salary = salary;
        this.address = address;
        this.company = company;
    }




}
