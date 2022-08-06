package com.interview.hackerrank;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {

    final var namesList =
        List.of(
            "aaryanna",
            "aayanna",
            "airianna",
            "alassandra",
            "allanna",
            "allannah",
            "allessandra",
            "allianna",
            "allyanna",
            "anastaisa",
            "anastashia",
            "anastasia",
            "annabella",
            "annabelle",
            "annebelle");

    namesList.stream()
        .filter(Filter.nameStartingWithPrefix("al"))
        .map(Mapper.getDistinctCharactersCount())
        .forEach(System.out::println);
  }
}

class CharactersCount {

  String name;
  int distinctCharacterCount;

  CharactersCount(String name, int distinctCharacterCount) {
    this.name = name;
    this.distinctCharacterCount = distinctCharacterCount;
  }

  @Override
  public String toString() {
    return "CharactersCount{"
        + "name='"
        + name
        + '\''
        + ", distinctCharacterCount="
        + distinctCharacterCount
        + '}';
  }
}

class Filter {

  static Predicate<String> nameStartingWithPrefix(String prefix) {

    return name -> name.startsWith(prefix);
  }
}

class Mapper {

  static Function<String, CharactersCount> getDistinctCharactersCount() {

    return name -> new CharactersCount(name, (int) name.chars().distinct().count());
  }
}
