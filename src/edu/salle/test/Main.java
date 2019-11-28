package edu.salle.test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        /*Predicate<Transaction> predicate = new Predicate<Transaction>() {

            @Override
            public boolean test(Transaction transaction) {
                return transaction.getYear() == 2011;
            }
        };*/


        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparingInt(Transaction::getValue).reversed().thenComparing(Transaction::getValue))
                .collect(toList());
    }
}
