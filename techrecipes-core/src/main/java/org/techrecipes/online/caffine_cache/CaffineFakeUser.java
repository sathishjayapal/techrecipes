package org.techrecipes.online.caffine_cache;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;
public class CaffineFakeUser {
    private Long id;
    private String name;
    private Address address;
    public CaffineFakeUser(Long input) {
        Faker faker = new Faker();
        this.name = faker
          .name()
          .fullName();
        this.address = faker.address();
        this.id = input;
    }
    public CaffineFakeUser returnMe() {
        return this;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "CaffineFakeUser{" + "id=" + id + ", name='" + name + '\'' + ", address=" + address.toString() + '}';
    }
}
