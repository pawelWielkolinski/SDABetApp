package sda.db.data;

public class Main {
    public static void main(String[] args) {
        DatabaseAccess databaseAccess = new DatabaseAccess();

        System.out.println(databaseAccess.findAllMatches());
    }
}
