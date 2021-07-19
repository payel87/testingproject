@smoke
Feature: Borrowing Calculator

  Scenario Outline: Borrowing Calculator validation for verifying Borrowing Capacity and Start Over button
    Given I am on the Borrower Calculator Page
    When I enter application type as <applicationType>
    And I enter number of dependants as <noOfDependants>
    And I enter property you would like to buy as <propertyType>
    And I enter my income before tax as <incomeBeforeTax>
    And I enter my other income as <otherIncome>
    And I enter my living expenses as <livingExpenses>
    And I enter current HomeLoan repayments as <homeLoanRepayments>
    And I enter other loan repayments as <otherLoanRepayments>
    And I enter other commitments as <otherCommitments>
    And I enter total Credit Card limits as <ccLimits>
    And I click on Work out how much I could borrow button
    Then I validate that correct borrowing capacity <borrowingCapacity> is displayed
    And I click on Start over button
    Then The form should be refreshed

    Examples:
      |applicationType |noOfDependants |propertyType    |incomeBeforeTax|otherIncome|livingExpenses|homeLoanRepayments|otherLoanRepayments|otherCommitments|ccLimits|borrowingCapacity|
      |Single          |0              |home to live in |80000           |10000      |500           |0                 |100                |0               |10000   |$507,000           |

  Scenario: Borrowing Calculator error scenario validation
    Given I enter my living expenses as 1
    And I click on Work out how much I could borrow button
    Then I should see the borrowing error text
