import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class DataframeMenu {
  private Dataframe activeDataframe;
  private ArrayList<Dataframe> dataframeLists;

  public DataframeMenu() throws Exceptions {
    dataframeLists = new ArrayList<Dataframe>();
    Scanner in = new Scanner(System.in);
    String command = "";
    while (!command.equals("q")){
    System.out.println("Dataframe Menu\n");
    System.out.println("Dataframes availiable- " + dataframeLists+ "\n");
    System.out.println("Active dataframe- " + activeDataframe + "\n");
    System.out.println("Command options- \nimport new dataframe: i \nchange active dataframe: c \naverage a column:  a\nfind min for a column: m \nfind max for a column: x \nfreq table for a column: f \nsubset by a column value: s \nexport the active dataframe: z \nquit: q");
      command = in.nextLine();
      if (command.equals("i")){
        System.out.println("Enter the name of the new dataframe (without .csv): ");
        try{ 
          String dataframeName = in.nextLine();
          activeDataframe = new Dataframe();
          activeDataframe.setName(dataframeName);
          activeDataframe.loadDataFromCSV(dataframeName + ".csv");
          dataframeLists.add(activeDataframe);}
        catch (Exceptions e){ 
          activeDataframe.setName("");
          System.out.println(e.getMessage() + " try again.");
    }}
      if (command.equals("c")) {
        System.out.println("Enter the name of the dataframe you want to change to (without .csv): ");
        String dataframeName = in.nextLine();
        for (Dataframe dataframe: dataframeLists){
          if (dataframe.getName().equals(dataframeName)) {
            activeDataframe = dataframe;
          }
          else {
            System.out.println("invalid name");
          }
        }
      }

      if (command.equals("a")) {
        System.out.println("Enter the name of the column you want to average: ");
        String columnName = in.nextLine();
        try {System.out.println(activeDataframe.getColumnAverage(columnName));
       } catch (Exceptions e){ 
          System.out.println(e.getMessage() + " try again.");
        }
      }
      if (command.equals("m")) {
        System.out.println("Enter the name of the column you want to find the min for: ");
        String columnName = in.nextLine();
        try {
            System.out.println(activeDataframe.getColumnMin(columnName));
        } catch (Exceptions e) {
          System.out.println(e.getMessage() + " try again.");
        }
      }
      if (command.equals("x")) {
        System.out.println("Enter the name of the column you want to find the max for: ");
        String columnName = in.nextLine();
      try {
          System.out.println(activeDataframe.getColumnMax(columnName));
      } catch (Exceptions e){ 
        System.out.println(e.getMessage() + " try again.");
      }
      }
      if (command.equals("f")) {
        System.out.println("Enter the name of the column you want to find the frequency table for: ");
        String columnName = in.nextLine();
      try {
          activeDataframe.getFrequencyTable(columnName);
      } catch (Exceptions e) {
      System.out.println(e.getMessage() + " try again.");
      }
      }
      if (command.equals("s")){
        System.out.println("Enter the condition: ");
        String condition = in.nextLine();
        try {
            Dataframe subsetData = activeDataframe.subset(condition);
            dataframeLists.add(subsetData);
        } catch (Exception e) {
        System.out.println(e.getMessage() + " try again.");
        }
      }

      if (command.equals("z")) {
      try {
          activeDataframe.writeToCSV();
      } catch (Exceptions e) {
          System.out.println(e.getMessage() + " try again.");
      }
    }

    
  }
  
}}