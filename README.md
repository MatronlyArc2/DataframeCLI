# DataframeMenu - Java Command Line Interface (CLI)

## Overview

`DataframeMenu` is a Java-based CLI program that allows users to interact with and manage dataframes. Users can import, manipulate, and export data from dataframes using various commands. The functionality includes calculating averages, finding the minimum and maximum values of columns, creating frequency tables, and more.

This application utilizes a list of `Dataframe` objects and allows for changing the active dataframe to perform operations on it.

## Features

- **Import New Dataframe:** Import a new dataframe from a `.csv` file.
- **Change Active Dataframe:** Switch between imported dataframes to perform operations.
- **Average a Column:** Calculate the average of a specified column.
- **Find Min/Max for a Column:** Find the minimum and maximum values of a specified column.
- **Frequency Table for a Column:** Generate a frequency table for a specified column.
- **Subset by Column Value:** Create a subset of the active dataframe based on a condition.
- **Export the Active Dataframe:** Save the active dataframe back to a `.csv` file.
- **Quit the Program:** Exit the application.

## Command Options

### Available Commands:
- **i**: Import a new dataframe (CSV file).
- **c**: Change the active dataframe.
- **a**: Calculate the average of a specified column.
- **m**: Find the minimum value of a specified column.
- **x**: Find the maximum value of a specified column.
- **f**: Generate a frequency table for a specified column.
- **s**: Create a subset of the dataframe based on a column value.
- **z**: Export the active dataframe to a `.csv` file.
- **q**: Quit the program.

## Usage

### 1. Import a New Dataframe
Use the `i` command to import a new dataframe from a `.csv` file. The user will be prompted to provide the dataframe name (without the `.csv` extension). If successful, the dataframe is added to the list of available dataframes.

### 2. Change Active Dataframe
Use the `c` command to switch the active dataframe to one from the list of imported dataframes. You will be prompted to enter the name of the dataframe you want to activate.

### 3. Perform Operations on Dataframe
After setting the active dataframe, you can use various commands to perform operations:
- **a**: Enter the name of the column you wish to average.
- **m**: Enter the name of the column you want to find the minimum value for.
- **x**: Enter the name of the column you want to find the maximum value for.
- **f**: Enter the name of the column for the frequency table.

### 4. Subset Dataframe
Use the `s` command to create a subset of the active dataframe based on a specified condition.

### 5. Export Dataframe
Use the `z` command to export the active dataframe back to a `.csv` file.

### 6. Quit the Program
Use the `q` command to exit the program.

### To Use:
Run the `Main.java` class to start the program and begin interacting with the dataframes.

### CSV Files:
I have added a CSV file in the repository if needed. You can import them using the `i` command by entering the filename without the `.csv` extension.
