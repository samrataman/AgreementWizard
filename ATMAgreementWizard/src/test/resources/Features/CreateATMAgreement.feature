#Author: Aman Kumar
Feature: Successfully create a ticket under Supoport -> Ticket page

  Background: 
    Given Browsere is "chrome"

  @CSGLogin
  Scenario: Successful Login with valid credentials
    Given user navigates to CSG Login page
    When user enters username and password
    Then page with title "Dashboard | Cook Command Center" should open

  @redirectAgreementDashboard
  Scenario: user must be redirected to Agreement-> Dashboard page
    When user clicks on Agreement->Dashboard
    Then page with title "Agreement Wizard | Cook Command Center" should open
    
  @NavigatetoCreateAgreement
  Scenario: User navigates to create an agreement on click of "Add Agreement"
  	When user clicks on Add Agreement
  	Then page with header "Customer Info" should open
  	
  @SelectCustomer
  Scenario: User can select customer from customer drop down in step-1;
  	When user select customer from customer Drop down
  	And  click on next
  	Then page with header "Agreement Details" should open
  	
  @SelectAgreementType
  Scenario: User can select any Agreement type out of four to create agreement.
  	When user select agreement type
  	Then Equipment categories list will be open
  
  @SelectEquipmentCategories
  Scenario: User can select one or more ATM equipment categories, inorder to create agreement.
  	When user selects given equipment categories
  	And  click on next
  	Then page with header "Location(s)" should open
  	
  @SelectLocation
  Scenario: User can select one or more location, inorder to create an agreement
  	When user search and selects a location
  	And  click on next
  	Then page with header "Equipment Info" should open
  	 
    

