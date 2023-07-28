
package javatestpracticum;

import org.testng.annotations.Test;

public class JavaMethodsTest {

    // a > b, a < b, a >= b, a == b, != is not equal;
    // && and, || or

    @Test                 //@test -java Annotation
    public void testJavaMethods() {

        boolean access = true;
        int age = 20;  // int -data variable (type), age - variable name, 20 - value, = assigning operator
        boolean registered = true;
        boolean gardian = true;

        String accessGranted = "Congrats, you are a full access";
        String partialGranted = "Congrats, you are granted a partial access";
        String accessIsNotGranted = "I'm sorry, you are not granted an access";


        //logical statement AND &&
        //logical statement OR ||

            if (age >= 21 && registered == true) {
            System.out.println(accessGranted);
        }
            else if (((age >= 18 && age < 21) && gardian) == true) {
            System.out.println(partialGranted);
        }
            else {
            System.out.println(accessIsNotGranted);
        }

            if (age >= 21 || registered == true) {

            access = true;
        }

        else if (age >= 18 && age < 21) {
            access = false;
        }
        else {
            access = false;
        }

        System.out.println(access);
    }

    @Test
    public void condStatements() {

        int Income = 89076;

        String Tax10Interest = "your tax will be 10%";
        String Tax12Interest = "your tax will be 12%";
        String Tax22Interest = "your tax will be 22%";
        String TaxHigherInterest ="please call your CPA";

        if (Income <= 10275){
            System.out.println(Tax10Interest);
        }
        else if (Income >10275 && Income <= 41775){
            System.out.println(Tax12Interest);
        }
        else if (Income >41775 && Income <=89075){
            System.out.println(Tax22Interest);
        }

        else {
            System.out.println(TaxHigherInterest);
        }

    }
    @Test
    public void conditionalstatementstwo () {
        String month = "January";
        int monthNumber = 4;

        if (month.contains ("ary")) {
            System.out.println("it is cold");
        }
        else if(month.equals("March")) {
            System.out.println("it is fresh");
        }
        else if(month.equals("April") || monthNumber == 4) {
            System.out.println("it is beautiful");

        }
        else {
            System.out.println("Please provide a correct month or number");
        }
    }

    @Test
    public void testSwitch() {
        int day = 4;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }
    }
    @Test
    public void SwitchDepartments() {
        String department = "marketing";
        switch (department){
            case "sales" :
                System.out.println("Sales department works from 8am to 12pm.");
                break;
            case "operations":
                System.out.println("Operations department works from 8am to 9pm.");
                break;
            case "marketing":
                System.out.println("marketing department works from 10am to 7pm.");
                break;
            case "human resources":
                System.out.println("human resources department works from 9am to 6pm.");
                break;
            case "finance":
                System.out.println("finance department works from 9am to 6pm.");
                break;
            case "IT":
                System.out.println("IT department works from 10am to 7pm.");
                break;
        }
    }


    //int i = 15; i < 10; i--   15,14,13,12,11
    @Test
    public void forLoop(){
        for (int age = 77; age < 100; age++) {
            System.out.println("You will receive your pension at "+ age+ "age");
            age++;

        }

    }

    @Test
    public void forLoop2() {
        for (int hour = 0; hour <24;  hour++) {
            System.out.println(hour);
            hour++;
            
        }
    }
}

