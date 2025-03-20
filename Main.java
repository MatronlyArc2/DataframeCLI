import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
public class Main {
  public static void main(String[] args) throws Exceptions {
  
     System.out.println("Checking import:");
     if (checkImport("PEdata-multiYear") == true){
       System.out.println("VALID FILE PASSED");
     }
    else {
      System.out.println("VALID FILE FAILED");
    }
     if (checkImport("INVALID-FILE-NAME") != true){
       System.out.println("INVALID FILE PASSED");
     }
    else {
      System.out.println("INVALID FILE FAILED");
    }

    System.out.println("\nChecking average:");
    if (checkAverageNonNumber("PEdata-multiYear","Age") == true){
       System.out.println("VALID COLUMN DATA TYPE PASSED");
    }
    else {
      System.out.println("VALID COLUMN DATA TYPE FAILED");
    }

    if (checkAverageNonNumber("PEdata-multiYear","gender") != true){
      System.out.println("INVALID COLUMN DATA TYPE PASSED");
    }
    else{
      System.out.println("INVALID COLUMN DATA TYPE FAILED");
    }
    if (checkAverageNonNumber("PEdata-multiYear","Age") == true){
      System.out.println("VALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("VALID COLUMN NAME FAILED");
    }
    if (checkAverageNonNumber("PEdata-multiYear","INVALID_COLUMN") != true){
      System.out.println("INVALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("INVALID COLUMN NAME FAILED");
    }

    System.out.println("\nChecking minimum:");
    if (checkMin("PEdata-multiYear","Age") == true){
       System.out.println("VALID COLUMN DATA TYPE PASSED");
    }
    else {
      System.out.println("VALID COLUMN DATA TYPE FAILED");
    }

    if (checkMin("PEdata-multiYear","gender") != true){
      System.out.println("INVALID COLUMN DATA TYPE PASSED");
    }
    else{
      System.out.println("INVALID COLUMN DATA TYPE FAILED");
    }
 
    if (checkMin("PEdata-multiYear","Age") == true){
      System.out.println("VALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("VALID COLUMN NAME FAILED");
    }
    if (checkMin("PEdata-multiYear","INVALID_COLUMN") != true){
      System.out.println("INVALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("INVALID COLUMN NAME FAILED");
    }

    System.out.println("\nChecking maximum:");
    if (checkMax("PEdata-multiYear","Age") == true){
       System.out.println("VALID COLUMN DATA TYPE PASSED");
    }
    else {
      System.out.println("VALID COLUMN DATA TYPE FAILED");
    }

    if (checkMax("PEdata-multiYear","gender") != true){
      System.out.println("INVALID COLUMN DATA TYPE PASSED");
    }
    else{
      System.out.println("INVALID COLUMN DATA TYPE FAILED");
    }

    if (checkMax("PEdata-multiYear","Age") == true){
      System.out.println("VALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("VALID COLUMN NAME FAILED");
    }
    if (checkMax("PEdata-multiYear","INVALID_COLUMN") != true){
      System.out.println("INVALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("INVALID COLUMN NAME FAILED");
    }

    System.out.println("\nChecking frequency table:");
    if (checkFreq("PEdata-multiYear","Age") == true){
       System.out.println("VALID COLUMN DATA TYPE PASSED");
    }
    else {
      System.out.println("VALID COLUMN DATA TYPE FAILED");
    }

    if (checkFreq("PEdata-multiYear","gender") != true){
      System.out.println("INVALID COLUMN DATA TYPE PASSED");
    }
    else{
      System.out.println("INVALID COLUMN DATA TYPE FAILED");
    }

    if (checkFreq("PEdata-multiYear","Age") == true){
      System.out.println("VALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("VALID COLUMN NAME FAILED");
    }
    if (checkFreq("PEdata-multiYear","INVALID_COLUMN") != true){
      System.out.println("INVALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("INVALID COLUMN NAME FAILED");
    }
    System.out.println("\nChecking subset:");
    if (checkSubset("PEdata-multiYear","Age") == true){
       System.out.println("VALID COLUMN DATA TYPE PASSED");
    }
    else {
      System.out.println("VALID COLUMN DATA TYPE FAILED");
    }

    if (checkSubset("PEdata-multiYear","gender") != true){
      System.out.println("INVALID COLUMN DATA TYPE PASSED");
    }
    else{
      System.out.println("INVALID COLUMN DATA TYPE FAILED");
    }

    if (checkSubset("PEdata-multiYear","Age") == true){
      System.out.println("VALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("VALID COLUMN NAME FAILED");
    }
    if (checkSubset("PEdata-multiYear","INVALID_COLUMN") != true){
      System.out.println("INVALID COLUMN NAME PASSED");
    }
    else {
      System.out.println("INVALID COLUMN NAME FAILED");
    }




    DataframeMenu menu = new DataframeMenu();
    
}
 
  
    

public static boolean checkImport(String filePath) {
    File file = new File(filePath + ".csv");
    if (file.exists() && file.isFile()) {
        return true; 
        } 
    else {
        return false; 
    }}

  public static boolean checkAverageNonNumber(String filePath,String columnName) {
      Dataframe data = new Dataframe();
      boolean test = false;
      try {
          data.loadDataFromCSV(filePath + ".csv");
          if (data.getColumnDataType(columnName).equals("int") || data.getColumnDataType(columnName).equals("double")) {
              test = true;
          } else {
              test = false;
          }
      } catch (Exceptions e) {
        System.out.println("Exception for Column found");
      }
      return test;
  }

  


  public static boolean checkMin(String filePath,String columnName) {
      Dataframe data = new Dataframe();
      boolean test = false;
      try {
          data.loadDataFromCSV(filePath + ".csv");
          if (data.getColumnDataType(columnName).equals("int") || data.getColumnDataType(columnName).equals("double")) {
              test = true;
          } else {
              test = false;
          }
      } catch (Exceptions e) {
        System.out.println("Exception for Column found");
      }
      return test;
  }

  


  public static boolean checkMax(String filePath,String columnName) {
      Dataframe data = new Dataframe();
      boolean test = false;
      try {
          data.loadDataFromCSV(filePath + ".csv");
          if (data.getColumnDataType(columnName).equals("int") || data.getColumnDataType(columnName).equals("double")) {
              test = true;
          } else {
              test = false;
          }
      } catch (Exceptions e) {
          System.out.println("Exception for Column found");
      }
      return test;
  }

  


  public static boolean checkFreq(String filePath,String columnName) {
      Dataframe data = new Dataframe();
      boolean test = false;
      try {
          data.loadDataFromCSV(filePath + ".csv");
          if (data.getColumnDataType(columnName).equals("int") || data.getColumnDataType(columnName).equals("double")) {
              test = true;
          } else {
              test = false;
          }
      } catch (Exceptions e) {
        System.out.println("Exception for Column found");
      }
      return test;
  }

  public static boolean checkSubset(String filePath,String columnName) {
      Dataframe data = new Dataframe();
      boolean test = false;
      try {
          data.loadDataFromCSV(filePath + ".csv");
          if (data.getColumnDataType(columnName).equals("int") || data.getColumnDataType(columnName).equals("double")) {
              test = true;
          } else {
              test = false;
          }
      } catch (Exceptions e) {
        System.out.println("Exception for Column found");
      }
      return test;
  }

  }




