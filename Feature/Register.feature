Feature: Registration on TestMeApp

Scenario: To register successfully
Given Navigate to TestMeApp home page 
When User click on signup should insert all the data
And insert username as "NVS09"
And insert Firstname as "Namit"
And insert Lastname as "Shastri"
And insert password as "nnnnnnnn"
And insert confirm password as "nnnnnnnn"
And select gender as "Female"
And insert email as "nnn1@gmail.com"
And insert Phno as "9999999999"
And insert dob as "09/09/1997"
And insert adress as "KharadiPuneMaharashtraIndia"
And select security question as "What is your Nick Name?"
And enter answer as "Gandhinagar"
Then User should click on register

@login
Scenario: To login
Given Navigate to TestMeApp home page 
When user enter registered credentials
     |lalitha|
     |Password123|
Then User should login successfully

 


