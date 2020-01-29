package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class registerUser {
	
	WebDriver driver;
	PageObjects po;

	@Given("^Navigate to TestMeApp home page$")
	public void homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\NVS UFT\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://10.232.237.143:443/TestMeApp/");
		//po = new PageObjects(driver);
	}

	@When("^User click on signup should insert all the data$")
	public void signup1() {
	driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();	

	}

	@When("^insert username as \"([^\"]*)\"$")
	public void username(String u) {
      driver.findElement(By.id("userName")).sendKeys(u);
	}

	@When("^insert Firstname as \"([^\"]*)\"$")
	public void firstname(String fname) {
		 driver.findElement(By.id("firstName")).sendKeys(fname);
	}
	
	@When("^insert Lastname as \"([^\"]*)\"$")
	public void lastname(String Lname) {
		 driver.findElement(By.id("lastName")).sendKeys(Lname);
	}

	@When("^insert password as \"([^\"]*)\"$")
	public void password(String pwd) {
		 driver.findElement(By.id("password")).sendKeys(pwd);
	}

	

	@When("^insert confirm password as \"([^\"]*)\"$")
	public void confirmpassword(String cnfpwd) {
		 driver.findElement(By.id("pass_confirmation")).sendKeys(cnfpwd);
	}

	@When("^select gender as \"([^\"]*)\"$")
	public void gender(String g) {
		List <WebElement> allradiobuttons=  driver.findElements(By.id("gender"));	
    if (g.equalsIgnoreCase("Male")) {
    	allradiobuttons.get(0).click();
    }
    else if(g.equalsIgnoreCase("Female")){
    	allradiobuttons.get(1).click();
    }
	}

	@When("^insert email as \"([^\"]*)\"$")
	public void email(String eml) {
		driver.findElement(By.id("emailAddress")).sendKeys(eml);

	}
	

	@When("^insert Phno as \"([^\"]*)\"$")
	public void pnumber(String pnum) {
		driver.findElement(By.id("mobileNumber")).sendKeys(pnum);

	}
	
	@When("^insert dob as \"([^\"]*)\"$")
	public void birthDate(String bd) {
		driver.findElement(By.id("dob")).sendKeys(bd);

	}
	
	@When("^insert adress as \"([^\"]*)\"$")
	public void adress(String adr) {
		driver.findElement(By.id("address")).sendKeys(adr);

	}
	
	@When("select security question as \"([^\"]*)\"$")
	public void question( String q ) {
		WebElement dropdown = driver.findElement(By.id("securityQuestion"));
		Select s = new Select (dropdown);
		
		s.selectByIndex(3);
	}
	@When("^enter answer as \"([^\"]*)\"$")
	public void answer(String ans) {
		driver.findElement(By.id("answer")).sendKeys(ans);

	}
	
	@When("^User should click on register$")
	public void regButton() {
		driver.findElement(By.name("Submit")).click();
		System.out.println("User registered successfully");

	}
	
	       
	@When("^user enter registered credentials$")
	public void login(DataTable dt) {
		driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		List<String> cred= dt.asList(String.class);
		
		driver.findElement(By.name("userName")).sendKeys(cred.get(0));
		driver.findElement(By.name("password")).sendKeys(cred.get(1));
		driver.findElement(By.name("Login")).click();
	}

		@Then("^User should login successfully$")
		public void sucLogged() {
			System.out.println("User registered successfully");

	}
	
	

}
