package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;




public class task1_update
{


    private JTextArea textAreaCsvData;
    private JButton loadCSVFileButton;
    private JButton daysToChristmasButton;
    private JPanel guiPanel;
    private JLabel daysToChristmasLabel;
    private JButton nextCsvButton;
    private JButton clearCsvButton;
    private JButton previousCsvButton;

    public int displayNextCount = 0;

    public task1_update()
    {
        daysToChristmasButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String numDaysToChristmas = Long.toString(getDaysToChristmas());

                daysToChristmasLabel.setText(numDaysToChristmas);

            }
        });
        loadCSVFileButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loadCsvData();
            }
        });
        nextCsvButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                displayNextCsvData();
            }
        });
        clearCsvButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clearCsvData();
            }
        });
        previousCsvButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                displayPreviousCsvData();
            }
        });
    }

    public long getDaysToChristmas()
    {


        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        Date date = new Date();

        String inputString1 = dateFormat.format(date); //07/03/2019
        String inputString2 = "25 12 2019";


        long diff = 0;
        long convertedDifference = 0;


        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            diff = date2.getTime() - date1.getTime();
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            convertedDifference = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        } catch (ParseException e) {

        }

        return convertedDifference;
    }


    public void loadCsvData()
    {
        String filename = "1500000 Sales Records.csv";

        // Clears the textArea
        textAreaCsvData.setText("");


        File file = new File(filename);
        try {
            Scanner inputStream = new Scanner(file);

            int incrementLine = 0;

            // Only display the first 50 record lines
            while (inputStream.hasNext() && incrementLine < 50) {

                String data = inputStream.nextLine();

                Object a = data.split(",");

                textAreaCsvData.append(data.replace(",", "\t\t\t\t") + "\n");

                incrementLine++;
            }
            inputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void displayNextCsvData()
    {
        displayNextCount++;

        String filename = "1500000 Sales Records.csv";

        // Clears the textArea
        textAreaCsvData.setText("");

        File file = new File(filename);
        try {
            Scanner inputStream = new Scanner(file);

            int incrementLine = 0;

            while (inputStream.hasNext() && (incrementLine < (50*displayNextCount+50))) {

                if (incrementLine < (50*displayNextCount)) {
                    String data = inputStream.nextLine();

                    incrementLine++;
                }

                else {
                    String data = inputStream.nextLine();

                    Object a = data.split(",");

                    textAreaCsvData.append(data.replace(",", "\t\t") + "\n");

                    incrementLine++;
                }
            }
            inputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }






    public void displayPreviousCsvData()
    {
        displayNextCount--;

        String filename = "1500000 Sales Records.csv";

        // Clears the textArea
        textAreaCsvData.setText("");

        File file = new File(filename);
        try {
            Scanner inputStream = new Scanner(file);

            int incrementLine = 0;

            while (inputStream.hasNext() && (incrementLine < (50*displayNextCount+50))) {

                if (incrementLine < (50*displayNextCount)) {
                    String data = inputStream.nextLine();

                    incrementLine++;
                }

                else {
                    String data = inputStream.nextLine();

                    Object a = data.split(",");

                    textAreaCsvData.append(data.replace(",", "\t\t") + "\n");

                    incrementLine++;
                }
            }
            inputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }








    public void clearCsvData()
    {
        // Clears the textArea
        textAreaCsvData.setText("");
    }





    public static void main(String[] arguments)
    {

        ClockLabel dateLabel = new ClockLabel("date");
        ClockLabel timeLabel = new ClockLabel("time");
        ClockLabel dayLabel = new ClockLabel("day");


        JFrame guiFrame = new JFrame("Task 1");
        guiFrame.setContentPane(new task1_update().guiPanel);
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setLayout(new GridLayout(6, 3));


        guiFrame.pack();
        guiFrame.setVisible(true);

        guiFrame.add(dateLabel);
        guiFrame.add(timeLabel);
        guiFrame.add(dayLabel);


        guiFrame.setSize(600, 500);


        new task1_update();
    }
}



class ClockLabel extends JLabel implements ActionListener
{

    String type;
    SimpleDateFormat simpleDateFormat;

    public ClockLabel(String type)
    {
        this.type = type;


        switch (type) {
            case "date":
                simpleDateFormat = new SimpleDateFormat("   MMMM dd yyyy");

                break;
            case "time":
                simpleDateFormat = new SimpleDateFormat("   hh:mm:ss a");

                break;
            case "day":
                simpleDateFormat = new SimpleDateFormat("   EEEE  ");

                break;
            default:
                simpleDateFormat = new SimpleDateFormat();
                break;
        }

        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae)
    {
        Date d = new Date();
        setText(simpleDateFormat.format(d));
    }
}
