package steps;


import config.EnvironmentConfig;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.BorrowingCalculatorPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.Messages;

public class BorrowingCalculatorSteps extends BaseSteps {

    public static EnvironmentConfig config;
    private RunContext rc;

    public BorrowingCalculatorSteps(RunContext rc) {
        super(rc);
        this.rc = rc;
    }

    @Given("^I am on the Borrower Calculator Page$")
    public void iNavigateToBorrowerCalculatorPage() {
        Assert.assertTrue(rc.driver.getTitle().equalsIgnoreCase("Home loan borrowing power calculator | ANZ"), "Landed on correct Borrowing Calculator Page");
    }

    @When("^I enter application type as ([^\"]*)$")
    public void iEnterApplicationType(String applicationType) {
        new BorrowingCalculatorPage(rc.driver).setApplicationType(applicationType);
    }

    @And("^I enter number of dependants as ([^\"]*)$")
    public void iEnterNumberOfDependants(String noOfDependants) {
        new BorrowingCalculatorPage(rc.driver).setNoOfDependants(noOfDependants);
    }

    @And("^I enter property you would like to buy as ([^\"]*)$")
    public void iEnterPropertyYouWouldLikeToBuyAs(String propertyType) throws Throwable {
        new BorrowingCalculatorPage(rc.driver).setPropertyType(propertyType);
    }

    @And("^I enter my income before tax as ([^\"]*)$")
    public void iEnterMyIncomeBeforeTaxAsIncomeBeforeTax(String income) {
        new BorrowingCalculatorPage(rc.driver).setIncome(income);
    }

    @And("^I enter my other income as ([^\"]*)$")
    public void iEnterMyOtherIncomeAsOtherIncome(String otherIncome) {
        new BorrowingCalculatorPage(rc.driver).setOtherIncome(otherIncome);
    }

    @And("^I enter my living expenses as ([^\"]*)$")
    public void iEnterMyLivingExpensesAsLivingExpenses(String expenses) {
        new BorrowingCalculatorPage(rc.driver).setExpenses(expenses);
    }

    @And("^I enter current HomeLoan repayments as ([^\"]*)$")
    public void iEnterCurrentHomeLoanRepaymentsAsHomeLoanRepayments(String hlRepayments) {
        new BorrowingCalculatorPage(rc.driver).setHomeLoanRepayments(hlRepayments);
    }

    @And("^I enter other loan repayments as ([^\"]*)$")
    public void iEnterOtherLoanRepaymentsAsOtherLoanRepayments(String otherRepayments) {
        new BorrowingCalculatorPage(rc.driver).setOtherLoanRepayments(otherRepayments);
    }

    @And("^I enter other commitments as ([^\"]*)$")
    public void iEnterOtherCommitmentsAsOtherCommitments(String otherCommitments) {
        new BorrowingCalculatorPage(rc.driver).setOtherCommitments(otherCommitments);
    }

    @And("^I enter total Credit Card limits as ([^\"]*)$")
    public void iEnterTotalCreditCardLimitsAsCcLimits(String ccLimits) {
        new BorrowingCalculatorPage(rc.driver).setCcLimits(ccLimits);
    }

    @And("^I click on Work out how much I could borrow button$")
    public void iClickOnHowMuchICouldBorroow(){
    new BorrowingCalculatorPage(rc.driver).clickHowMuchCouldIBorrowButton();

    }


    @Then("^I validate that correct borrowing capacity ([^\"]*) is displayed$")
    public void iValidateThatCorrectBorrowingCapacityBorrowingCapacityIsDisplayed(String capacity) throws Throwable{
        Thread.sleep(2000);
        Assert.assertEquals(new BorrowingCalculatorPage(rc.driver).getBorrowingCapacity(), capacity, "Correct Capacity Displayed");
    }

    @When("^I click on Start over button$")
    public void iClickOnStartOverButton() {
        new BorrowingCalculatorPage(rc.driver).clickOnStartOverButton();
    }


    @Then("^The form should be refreshed$")
    public void theFormShouldBeRefreshed() {
        boolean flag;
        flag=new BorrowingCalculatorPage(rc.driver).applicationTypeSingle.isSelected() &&
        new BorrowingCalculatorPage(rc.driver).propertyTypeHome.isSelected() &&
        new BorrowingCalculatorPage(rc.driver).numberOfDependants.getAttribute("value").equals("0") &&
        new BorrowingCalculatorPage(rc.driver).incomeBeforeTax.getAttribute("value").equals("0") &&
        new BorrowingCalculatorPage(rc.driver).otherIncome.getAttribute("value").equals("0") &&
        new BorrowingCalculatorPage(rc.driver).livingExpenses.getAttribute("value").equals("0")  &&
        new BorrowingCalculatorPage(rc.driver).currentHomeloanRepayments.getAttribute("value").equals("0")  &&
        new BorrowingCalculatorPage(rc.driver).otherLoanRepayments.getAttribute("value").equals("0")  &&
        new BorrowingCalculatorPage(rc.driver).otherCommitments.getAttribute("value").equals("0")  &&
        new BorrowingCalculatorPage(rc.driver).totalCreditCardLimit.getAttribute("value").equals("0")  &&
        new BorrowingCalculatorPage(rc.driver).howMuchICanBorrowButton.isEnabled();

        Assert.assertTrue(flag,"Page has been refreshed successfully");


    }

    @Then("^I should see the borrowing error text$")
    public void iSeeBorrowerrorText()
    {
        Assert.assertEquals(new BorrowingCalculatorPage(rc.driver).validateBorrowerrorTextIsDisplayed(),Messages.BORROWING_ERROR,"Correct Error Message displayed for incorrect borrowing details");
    }

}