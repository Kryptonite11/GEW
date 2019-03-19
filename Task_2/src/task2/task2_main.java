package task2;

import java.util.Scanner;

public final class task2_main
{




    public static void main(String[] args)
    {

        Scanner reader = new Scanner(System.in);  // Reading from System.in


        // prompt user for input
        System.out.println("Enter Person Name: ");
        String name = reader.nextLine();


        System.out.println("Enter Person Surname: ");
        String surname = reader.nextLine();


        System.out.println("Enter Person Qualification: ");
        String workingHistory = reader.nextLine();

        System.out.println("Enter Person Working History: ");
        String qualification = reader.nextLine();

        System.out.println("Enter Person Age: ");
        int age = reader.nextInt();



        // More information can be collected per qualification or working history requirement
        task2_personDetails individualDetails = new task2_personDetails(name, surname, age);
        task2_personQualifications qualificationDetails = new task2_personQualifications(qualification);
        task2_perwonWorkingHistory workingHistoryDetails = new task2_perwonWorkingHistory(workingHistory);


        // Display collected information
        System.out.println("Enter Person Name: " + individualDetails.getName());
        System.out.println("Enter Person Surname: " + individualDetails.getSurname());
        System.out.println("Enter Person Qualification: " + qualificationDetails.getQualification());
        System.out.println("Enter Person Working History: " + workingHistoryDetails.getWorkingHistory());
        System.out.println("Enter Person Age: " + individualDetails.getAge());


        reader.close();




    }


}