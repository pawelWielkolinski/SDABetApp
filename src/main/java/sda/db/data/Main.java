package sda.db.data;

public class Main {
    public static void main(String[] args) {

        MatchRepository repository = new MatchRepository();

        System.out.println(repository.getByDate("2017-07-04"));

    }
}