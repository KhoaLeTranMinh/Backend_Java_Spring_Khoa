package com.backend_springboot.demo.Model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;

    // public User() {

    // }

    // public User(int id, String name, int age) {
    // this.id = id;
    // this.name = name;
    // this.age = age;
    // }

    // public int getId() {
    // return this.id;
    // }

    // public void setId(int id) {
    // this.id = id;
    // }

    // public String getName() {
    // return this.name;
    // }

    // public void setName(String name) {
    // this.name = name;
    // }

    // public int getAge() {
    // return this.age;
    // }

    // public void setAge(int age) {
    // this.age = age;
    // }

    // public User id(int id) {
    // setId(id);
    // return this;
    // }

    // public User name(String name) {
    // setName(name);
    // return this;
    // }

    // public User age(int age) {
    // setAge(age);
    // return this;
    // }

    // @Override
    // public boolean equals(Object o) {
    // if (o == this)
    // return true;
    // if (!(o instanceof User)) {
    // return false;
    // }
    // User user = (User) o;
    // return id == user.id && Objects.equals(name, user.name) && age == user.age;
    // }

    // @Override
    // public int hashCode() {
    // return Objects.hash(id, name, age);
    // }

    // @Override
    // public String toString() {
    // return "{" +
    // " id='" + getId() + "'" +
    // ", name='" + getName() + "'" +
    // ", age='" + getAge() + "'" +
    // "}";
    // }

}
