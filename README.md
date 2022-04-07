Speedometer Project
Purpose: The purpose for this project is to help the intended user to better their driving       ability and overall gas usage efficiency.
How it works:
header.java file
This file computes data values from a speedometer and figures out statistical data such as Average speeds, ideal speeds, percent accuracy, and a few other components.
MemoryGameGUI.java
this file was previously used in another project, however its GUI components were just the thing I needed to help make the data displaying more aesthetically pleasing
Some extra items that I added include looped functions to take in multiple data values when adding inputs such as speed, speed limit changes, duration, etc.
plotMaker.java
This file actually runs the entire program.
This heavily uses javaFX library components to graph the user's data points from the drive that they had
additionally, this file also calls a file that it both writes new data into and reads previous data from to give the User their past history in previous drives and their driving details. 
The file gives the user the ability to clear it for a cleared template of new data if they would not want their data to be skewed by outliers.
Reader.java
This file reads data from a previously added data set from the bureau of transportation. 
Currently the reader file is specifically looking for road quality percentage by each state 
It will prompt the user to enter a state and then it will iterate through the entire data set to create two arraylists, one to hold all state names that have percentages, and the other to hold the actual percentages.
the lists are conveniently already in order by index, so all the Reader file has to do is call the functions one at a time to get to the state that the user inputs, and then promptly return a double value for percentage 
The file that actually calls for the reader file's properties is the memoryGameGUI.java file, which is then used through both plotmaker.java and header.java
Additions for the future:
Currently looking into datasets that can give a rough estimate for car gas mileage by each brand of car to better analyze how much a user has to pay per week for gas.


