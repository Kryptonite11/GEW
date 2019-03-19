package task3;

import org.junit.Before;
import java.util.List;
import java.util.Scanner;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;



public class task3_GuavaTableTest
{

    List<task3_guavaTable> distances;



    @Before
    public void setUp()
    {

    }


    public static int getDistance(String startLocation, String destinationLocation)
    {
        int distance = 0;


        // Map setup

        Table<String, String, Integer> distanceTable = HashBasedTable.create();


        distanceTable.put("Amsterdam", "Berlin", 365);
        distanceTable.put("Amsterdam", "Copenhagen", 381);
        distanceTable.put("Amsterdam", "London", 220);
        distanceTable.put("Amsterdam", "Moscow", 1325);
        distanceTable.put("Amsterdam", "Rome", 808);
        distanceTable.put("Amsterdam", "Warsaw", 673);


        distanceTable.put("Berlin", "Copenhagen", 225);
        distanceTable.put("Berlin", "London", 575);
        distanceTable.put("Berlin", "Moscow", 995);
        distanceTable.put("Berlin", "Rome", 730);
        distanceTable.put("Berlin", "Warsaw", 320);

        distanceTable.put("Copenhagen", "London", 590);
        distanceTable.put("Copenhagen", "Moscow", 970);
        distanceTable.put("Copenhagen", "Rome", 948);
        distanceTable.put("Copenhagen", "Warsaw", 415);

        distanceTable.put("London", "Moscow", 1540);
        distanceTable.put("London", "Rome", 890);
        distanceTable.put("London", "Warsaw", 890);

        distanceTable.put("Moscow", "Rome", 1462);
        distanceTable.put("Moscow", "Warsaw", 710);

        distanceTable.put("Rome", "Warsaw", 810);


        // Checks if entry is present in either order in table
        boolean entryIsPresent;
        if (distanceTable.contains(startLocation, destinationLocation)) {
            entryIsPresent = true;

            // Retrieves distance value
            distance = distanceTable.get(startLocation, destinationLocation);
        }
        else if (distanceTable.contains(destinationLocation, startLocation)) {
            entryIsPresent = true;

            // Retrieves distance value
            distance = distanceTable.get(destinationLocation, startLocation);
        }
        else {
            throw new Error("Incorrect locations entered");
        }

        return distance;
    }




    public static void main(String[] args)
    {

        // Allow user to enter locations
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter Start Location");
        String startLocation = reader.nextLine();

        System.out.println("Enter Destination Location");
        String destinationLocation = reader.nextLine();
        reader.close();


        int distance = getDistance(startLocation, destinationLocation);

        System.out.println(distance);

    }


}
