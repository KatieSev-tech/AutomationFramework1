package javapracticum;

public class MainJavaBasicsHomeWork {

    public static void main(String[] args) {

        String firstName = "Kate";
        String lastName = "Sevriukova";
        String storeName = "'Marine'";
        String locationState = "California";
        String productName = "book";
        int age = 24;
        double price = 21.99;

        System.out.println("Dear " + firstName + " " + lastName + "! Welcome to our book store " + storeName + ". " +
                "Our data indicates that today you turn " + age + " years old. We offer you special gift! " +
                "With purchase on any book above $" + price + ", you will get additional " + productName + " for free. " +
                "Offer is available in all the local stores around " + locationState + " state.");

    }



}
