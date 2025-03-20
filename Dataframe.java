import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedWriter;


public class Dataframe {
  private ArrayList<String> columns;
  private ArrayList<String> columnDataType;
  private ArrayList<ArrayList<String>> data;
  private String name;

  public Dataframe() {
    columns = new ArrayList<String>();
    data = new ArrayList<ArrayList<String>>();
      }

  public Dataframe(ArrayList<ArrayList<String>> data) {
      this.data = data;
      }

  public Dataframe subset(String condition) throws Exceptions {
    String[] parts = condition.split(" ");
    if (parts.length != 3) {
    throw new Exceptions("Invalid condition format, make sure it looks like, Column name < operator > value");
    }

    String columnName = parts[0];
    String operator = parts[1];
    String value = parts[2];
    
  if (!columns.contains(columnName)) {
    throw new Exceptions("Column '" + columnName + "' does not exist in the DataFrame.");
    }

  int columnIndex = columns.indexOf(columnName);
  ArrayList<ArrayList<String>> newData = new ArrayList<ArrayList<String>>();

     for (int i = 0; i < data.get(columnIndex).size(); i++) {
          String cellValue = data.get(columnIndex).get(i);
          boolean conditionMet = false;

          if ("<".equals(operator)) {
              conditionMet = cellValue.compareTo(value) < 0;
          } else if ("==".equals(operator)) {
              conditionMet = cellValue.equals(value);
          } else if (">".equals(operator)) {
              conditionMet = cellValue.compareTo(value) > 0;
          } else if ("!=".equals(operator)) {
              conditionMet = !cellValue.equals(value);
          } else {
       throw new Exceptions("Invalid operator: " + operator);
       }

    if (conditionMet) {
            if (newData.size() < data.size()) {
                for (int j = newData.size(); j < data.size(); j++) {
                    newData.add(new ArrayList<String>());
                }
            }
            for (int j = 0; j < data.size(); j++) {
                newData.get(j).add(data.get(j).get(i));
            }
        }
    }
      Dataframe subsetData = new Dataframe(newData);
      subsetData.setName(name + "("+condition+")");
      subsetData.setColumns(columns);
      subsetData.setColumnDataType(columnDataType);
      return subsetData;
  }

  public ArrayList<String> getColumns() {
      return columns;
  }

  public void setColumns(ArrayList<String> columns) {
      this.columns = columns;
  }
  public ArrayList<ArrayList<String>> getData() {
      return data;
  }

  public void setData(ArrayList<ArrayList<String>> data) {
      this.data = data;
  }
  

  public void loadDataFromCSV(String filename) throws Exceptions{
      BufferedReader br = null;
      int rowCount = 0; 
      try {
          br = new BufferedReader(new FileReader(filename));
          String line;
          boolean firstLine = true;
          boolean secondLine = true;
          while ((line = br.readLine()) != null) {
              rowCount++; 
              if (rowCount > 25000) {
                System.out.println("Data limit reached (25000 rows).");
                  break; }
              String[] values = line.split(",");
              if (firstLine) {
                  for (String value : values) {
                      columns.add(value);
                      data.add(new ArrayList<String>());
                  }
                  firstLine = false;
              } else if (secondLine) {
                  columnDataType = new ArrayList<String>(); 
                  for (String value : values) {
                      columnDataType.add(value);
                  }
                  secondLine = false;
              } else {
                  for (int i = 0; i < values.length; i++) {
                      data.get(i).add(String.valueOf(values[i]));
                  }
              }
          }
      } catch (IOException e) {
            throw new Exceptions("Error loading data from CSV: " + e.getMessage());
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        throw new Exceptions("Error closing BufferedReader: " + e.getMessage());
          }
      }
  }
  }

  
  public void getColumnNames() {
    System.out.println(columns);
    }

  

  public ArrayList<String> getColumnData(String columnName) throws Exceptions {
    if (!columns.contains(columnName)) {
        throw new Exceptions("Column '" + columnName + "' does not exist in the DataFrame.");
    }
    int columnIndex = columns.indexOf(columnName);
    return data.get(columnIndex);
      }
      
  
  
  public String getColumnDataType(String columnName) throws Exceptions{
    boolean notInArray = true;
    if (columns.contains(columnName)){
      notInArray = false;
    }
    if (notInArray) {
        throw new Exceptions("Column with name '" + columnName + "' not found");
    }
    int columnIndex = columns.indexOf(columnName);
    String dataType = columnDataType.get(columnIndex);
    if (dataType.equals("int")){
      return "int";
    }
    else if (dataType.equals("char")){
      return "char";
    }
    else if (dataType.equals("String")){
      return "String";
    }
    else {
      return "double";
    }
  }

  public String getColumnAverage(String columnName) throws Exceptions{
    String dataType = getColumnDataType(columnName);
    if (dataType.equals("int") || dataType.equals("double")){
      ArrayList<String> columnData = getColumnData(columnName);
      int sum = 0;
      int size = columnData.size();
      for (String value : columnData){
        if (Integer.parseInt(value) == -1){
          size = size -1;
        }
        else{
          sum += Integer.parseInt(value);
        }
      }
      double average = (double) sum / size;
      return String.valueOf(average);
    }
    else {throw new Exceptions("Not valid data type("+ columnName + ")");}
  }

  public String getColumnMax(String columnName) throws Exceptions{
    String dataType = getColumnDataType(columnName);
    if (dataType.equals("int") || dataType.equals("double")){
      ArrayList<String> columnData = getColumnData(columnName);
      int max = Integer.MIN_VALUE;
      for (String value : columnData){
        if (Integer.parseInt(value) == -1){
          continue;
        }
        else{
          if (Integer.parseInt(value) > max){
            max = Integer.parseInt(value);
          }
        }
      }
      return String.valueOf(max);
    }
    else {throw new Exceptions("Not valid data type("+ columnName + ")");}
  }

  public String getColumnMin(String columnName) throws Exceptions {
    String dataType = getColumnDataType(columnName);
    if (dataType.equals("int") || dataType.equals("double")){
      ArrayList<String> columnData = getColumnData(columnName);
      int min = Integer.MAX_VALUE;
      for (String value : columnData){
        if (Integer.parseInt(value) == -1){
          continue;
        }
        else{
          if (Integer.parseInt(value) < min){
            min = Integer.parseInt(value);
          }
        }
      }
      return String.valueOf(min);
    }
    else {throw new Exceptions("Not valid data type("+ columnName + ")");}
  }

  public void getFrequencyTable(String columnName) throws Exceptions {
    String dataType = getColumnDataType(columnName);
    if (dataType.equals("int") || dataType.equals("double")){
      ArrayList<String> columnData = getColumnData(columnName);
      int[] frequencyTable = new int[5];
      int[] frequencyBounds = new int[6];
      frequencyBounds[0] = Integer.parseInt(getColumnMin(columnName));
      double intervalRange = (Integer.parseInt(getColumnMax(columnName)) - Integer.parseInt(getColumnMin(columnName)));
      double intervalSize = intervalRange / 5;
      for (int i = 1; i < 5; i++){
      frequencyBounds[i] = (int) Math.round(frequencyBounds[i-1] + intervalSize);
      }
      
      int dataSize = columnData.size();
      for (String value : columnData){
        if (Integer.parseInt(value) == -1){
          dataSize = dataSize -1;
        }
        else {
          for (int i = 1; i < 5; i++){
            if(Integer.parseInt(value) <= (i)*intervalSize && Integer.parseInt(value) >= (i-1)*intervalSize){
              frequencyTable[i] += 1;
            }
          }
        }
        
      }
      for (int i = 0; i < 5; i++){
        System.out.println(frequencyBounds[i] + "-" + String.valueOf(frequencyBounds[i] + intervalSize - 1) + ":"+String.valueOf(frequencyTable[i]));
        
      }
  }
    else {throw new Exceptions("Not valid data type("+ columnName + ")");}
  }
  
    public void addRow(ArrayList<String> row) {
        data.add(row);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
      return getName();
    }

    public String getName() {
        return name;
    }

  public void setColumnNames(ArrayList<String> columnNames){
    this.columns = columnNames;
  }
  public void setColumnDataType(ArrayList<String> columnDataType) {
    this.columnDataType = columnDataType;
  }


  
  public void writeToCSV() throws Exceptions{
    String filename = getName() + ".csv";
      BufferedWriter bw = null;
      try {
          bw = new BufferedWriter(new FileWriter(filename));

          for (String column : columns) {
              bw.write(column);
              bw.write(",");
          }
          bw.newLine();

          for (String dataType : columnDataType) {
              bw.write(dataType);
              bw.write(",");
          }
          bw.newLine();

          int rowCount = data.get(0).size(); 
          for (int i = 0; i < rowCount; i++) {
              for (ArrayList<String> columnData : data) {
                  bw.write(columnData.get(i));
                  bw.write(",");
              }
              bw.newLine();
          }

          System.out.println("Data has been written to " + filename);
      } catch (IOException e) {
            throw new Exceptions("Error writing data to CSV: " + e.getMessage());
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        throw new Exceptions("Error closing BufferedWriter: " + e.getMessage());
                    }
          }
      }
  }

  
}

