package javapracticum;

 public class Main {
    public static void main(String[] args) {

        //String -data variable
        //firstName - variable name
        //"Kate" -value

        String firstName = "Kate";
        String lastName = "Sevriukova";
        String storeName = "'Marine'";
        String locationState = "California";
        String productName = "book";
        int age = 24;
        double price = 21.99;

       /* int JanSalary = 500;
        int FebSalary = 450;
        int MarchSalary = 200;
        int TotalSalary = JanSalary + FebSalary + MarchSalary;
        System.out.println (TotalSalary);
        System.out.println (JanSalary + FebSalary + MarchSalary);

        int one = 1;
        int two = 2;
        String two2 = "2";

        System.out.println (one + two2); */


        System.out.println("Dear "+ firstName +" "+ lastName+"! Welcome to our book store "+ storeName +". " +
                "Our data indicates that today you turn "+ age +" years old. We offer you special gift! " +
                "With purchase on any book above $"+ price +", you will get additional "+ productName +" for free. " +
                "Offer is available in all the local stores around "+ locationState +" state.");


    }
}
