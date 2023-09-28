package javatestpracticum;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStoragePractice {
    public static void main(String[] args) {    //public static  void method pstvm + tab
        int [] array = new int[3]; //[3] - index
        array[0] = 10;
        array[1] = 20;
        array[2] = 30;
        System.out.println(array.length); // sout + tab

        String[] cars = new String[2];
        cars[0] = "BMW";
        cars[1] = "Ford";
        System.out.println(cars[0]);

        List<Object> shoppingList = new ArrayList<>();
        shoppingList.add("Apple");
        shoppingList.add("Bananas");
        shoppingList.add("Strawberries");
        System.out.println(shoppingList);

        List<Object> abc = new ArrayList<>();
        abc.add("String");
        abc.add("100");
        abc.add(false);
        System.out.println(abc);
        System.out.println(abc.size());
        abc.remove(1);
        System.out.println(abc);
        System.out.println(abc.get(0));
        System.out.println(abc.contains(false));
        System.out.println(abc.contains(100));

        Map<String, String> friendsWithProfessions = new HashMap<>();
        friendsWithProfessions.put("Adam", "Plumber"); //where Adam -key, Plumber - value
        friendsWithProfessions.put("Alice", "Driver"); // put - adding
        friendsWithProfessions.put("Dan", "Painter");
        System.out.println(friendsWithProfessions);
        System.out.println(friendsWithProfessions.get("Dan"));
        friendsWithProfessions.remove("Adam");
        System.out.println(friendsWithProfessions);
        System.out.println(friendsWithProfessions.size());

        Map<String, Integer> teammatesAge = new HashMap<>();
        teammatesAge.put("Nick", 5);
        teammatesAge.put("Mikhael", 6);
        teammatesAge.put("Luca", 7);
        System.out.println(teammatesAge);
        System.out.println(teammatesAge.get("Nick"));
    }


}
