package pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BorrowingCalculatorPage {

        private WebDriver driver;

        public BorrowingCalculatorPage(WebDriver driver){
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

        @FindBy(id = "application_type_single")
         public WebElement applicationTypeSingle;

        @FindBy(id = "application_type_joint")
        public WebElement applicationTypeJoint;

        @FindBy(xpath ="//select[@title='Number of dependants']")
        public WebElement numberOfDependants;

        @FindBy(id = "borrow_type_home")
        public WebElement propertyTypeHome;

        @FindBy(id = "borrow_type_investment")
        public WebElement propertyTypeInvestment;

        @FindBy(xpath = "//span[@id='q2q1i1']/following-sibling::input")
        public WebElement incomeBeforeTax;

        @FindBy(xpath = "//span[@id='q2q2i1']/following-sibling::input")
        public WebElement otherIncome;

        @FindBy(id = "expenses")
        public WebElement livingExpenses;

        @FindBy(id = "homeloans")
        public WebElement currentHomeloanRepayments;

        @FindBy(id = "otherloans")
        public WebElement otherLoanRepayments;

        @FindBy(xpath = "//span[@id='q3q4i1']/following-sibling::input")
        public WebElement otherCommitments;

        @FindBy(id = "credit")
        public WebElement totalCreditCardLimit;

        @FindBy(id = "btnBorrowCalculater")
        public WebElement howMuchICanBorrowButton;

        @FindBy(id = "borrowResultTextAmount")
        public WebElement borrowingCapacity;

        @FindBy(className = "start-over")
        public WebElement startOverButton;

        @FindBy(className = "borrow__error__text")
        public WebElement borrowingErrorText;

        //methods

        public void setApplicationType(String type)
        {
            if(type.equalsIgnoreCase("single"))
                applicationTypeSingle.click();
            else
                applicationTypeJoint.click();
        }

        public void setNoOfDependants(String num)
        {
            Select selectDependants = new Select(numberOfDependants);

            selectDependants.selectByVisibleText(num);
        }

        public void setPropertyType(String propertyType)
        {
            if(propertyType.equalsIgnoreCase("Home to live in"))
                 propertyTypeHome.click();
            else
                propertyTypeInvestment.click();
        }

        public void setIncome(String income)
        {
            incomeBeforeTax.clear();
            incomeBeforeTax.sendKeys(income);
        }

        public void setOtherIncome(String otherInc)
        {
            otherIncome.clear();
            otherIncome.sendKeys(otherInc);
        }

        public void setExpenses(String expense)
        {
            livingExpenses.clear();
            livingExpenses.sendKeys(expense);
        }

        public void setHomeLoanRepayments(String hlRepayments)
        {
            currentHomeloanRepayments.clear();
            currentHomeloanRepayments.sendKeys(hlRepayments);
        }

        public void setOtherLoanRepayments(String otherRepayments)
        {
            otherLoanRepayments.clear();
            otherLoanRepayments.sendKeys(otherRepayments);
        }

        public void setOtherCommitments(String otherComm)
        {
            otherCommitments.clear();
            otherCommitments.sendKeys(otherComm);
        }

        public void setCcLimits(String ccLimit)
        {
            totalCreditCardLimit.clear();
            totalCreditCardLimit.sendKeys(ccLimit);
        }

        public void clickHowMuchCouldIBorrowButton()
        {
            howMuchICanBorrowButton.click();
        }
        public String getBorrowingCapacity()
        {
            scrollDownToElement(totalCreditCardLimit);
            return borrowingCapacity.getText().trim();
        }

        public void clickOnStartOverButton()
        {
            startOverButton.click();
        }

        public String validateBorrowerrorTextIsDisplayed()
        {
            return borrowingErrorText.getText().trim();
        }

        public void scrollDownToElement(WebElement element)
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
        }
}
