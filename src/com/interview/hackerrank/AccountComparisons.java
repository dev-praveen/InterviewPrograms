package com.interview.hackerrank;

import java.util.ArrayList;
import java.util.Collections;

interface OnlineAccount {

  int basePrice = 120;
  int regularMoviePrice = 45;
  int exclusiveMoviePrice = 80;
}

public class AccountComparisons {

  public static void main(String[] args) {

    final var account1 = new Account("Frank", 12, 6);
    final var account2 = new Account("David", 7, 19);
    final var account3 = new Account("Karen", 14, 4);

    final var accounts = new ArrayList<Account>();
    accounts.add(account1);
    accounts.add(account2);
    accounts.add(account3);

    Collections.sort(accounts);
    System.out.println("Most valuable account details:");
    System.out.println(accounts.get(accounts.size() - 1));
  }
}

class Account implements OnlineAccount, Comparable<Account> {

  Integer noOfRegularMovies, noOfExclusiveMovies;
  String ownerName;

  Account(String ownerName, Integer noOfRegularMovies, Integer noOfExclusiveMovies) {
    this.noOfRegularMovies = noOfRegularMovies;
    this.noOfExclusiveMovies = noOfExclusiveMovies;
    this.ownerName = ownerName;
  }

  @Override
  public int compareTo(Account account) {

    if (this.monthlyCost() > account.monthlyCost()) return 1;
    return -1;
  }

  int monthlyCost() {

    return basePrice
        + noOfRegularMovies * regularMoviePrice
        + noOfExclusiveMovies * exclusiveMoviePrice;
  }

  @Override
  public String toString() {
    return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD";
  }
}
