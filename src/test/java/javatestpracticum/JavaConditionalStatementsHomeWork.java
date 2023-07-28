package javatestpracticum;

import org.testng.annotations.Test;

public class JavaConditionalStatementsHomeWork {

    @Test
    public void condStatements() {

        int Income = 56007;

        String Tax10Interest = "your tax will be 10%";
        String Tax12Interest = "your tax will be 12%";
        String Tax22Interest = "your tax will be 22%";
        String TaxHigherInterest = "please call your CPA";

        if (Income <= 10275) {
            System.out.println(Tax10Interest);
        } else if (Income > 10275 && Income <= 41775) {
            System.out.println(Tax12Interest);
        } else if (Income > 41775 && Income <= 89075) {
            System.out.println(Tax22Interest);
        } else {
            System.out.println(TaxHigherInterest);
        }

    }

    @Test
    public void SwitchDepartments() {
        String department = "IT";
        switch (department) {
            case "sales":
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

    @Test
    public void forLoopHour() {
        for (int hour = 0; hour < 24; hour++) {
            System.out.println(hour);
            hour++;

        }

    }

}