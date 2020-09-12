#Please Do not change Feature Templet
Feature: To test the application to calculate college fee for different type of student
#Please Do not change Scenario Outline Templet
Scenario Outline: To calculate college fee for different type of student
#Please Do not change Given Templet
Given Browser is launched and user is on application page
#Please fill the required code as per the problem statement
When User Enters student name,"<student_type>","<no_of_rooms>"
When User clicks on the calculate fee button
Then "<college_fee>","<hostel_fee>","<additional_fee>","<total_fee>" should be correctly displayed
Examples:
| student_type | no_of_rooms | college_fee | hostel_fee | additional_fee | total_fee |
| Day Scholar  |    0        |   120000    |     --     |     --         |   120000  |
| Hosteller    |    1        |   120000    |   75750    |   30300        |   226050  |    
| Hosteller    |    2        |   120000    |   75750    |   15150        |   210900  |
| Hosteller    |    3        |   120000    |   75750    |     --         |   195750  |