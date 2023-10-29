package com.backend_springboot.demo.Model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int id;
    private String title;

    // public Movie(int id, String title) {
    // this.id = id;
    // this.title = title;
    // }

    // public Movie() {
    // }

    // public int getId() {
    // return this.id;
    // }

    // public void setId(int id) {
    // this.id = id;
    // }

    // public String getTitle() {
    // return this.title;
    // }

    // public void setTitle(String title) {
    // this.title = title;
    // }

    // public Movie id(int id) {
    // setId(id);
    // return this;
    // }

    // public Movie title(String title) {
    // setTitle(title);
    // return this;
    // }

    // @Override
    // public boolean equals(Object o) {
    // if (o == this)
    // return true;
    // if (!(o instanceof Movie)) {
    // return false;
    // }
    // Movie movie = (Movie) o;
    // return Objects.equals(id, movie.id) && Objects.equals(title, movie.title);
    // }

    // @Override
    // public int hashCode() {
    // return Objects.hash(id, title);
    // }

    // @Override
    // public String toString() {
    // return "{" +
    // " id='" + getId() + "'" +
    // ", title='" + getTitle() + "'" +
    // "}";
    // }

}
