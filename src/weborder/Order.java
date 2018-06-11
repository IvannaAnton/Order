package weborder;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/ivka/Documents/selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Order")).click();

		Random rand = new Random();
		int n = rand.nextInt(100) + 1;
		String str = "" + n;

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).clear();
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(str);
		Thread.sleep(2000);

		Random ran = new Random();
		int top = 3;
		char data = ' ';
		String middleName = "";

		for (int i = 0; i <= top; i++) {
			data = (char) (ran.nextInt(25) + 97);
			middleName = data + middleName;
		}

		// name + ramdon middle name
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"))
				.sendKeys("Jhon " + middleName.toUpperCase() + " Smith");
		Thread.sleep(2000);

		// street
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Main st");
		Thread.sleep(2000);

		// city
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Vienna");
		Thread.sleep(2000);

		// state
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		Thread.sleep(2000);

		// random zipcode
		Random rand1 = new Random();
		int n1 = rand1.nextInt(99999) + 10000;
		String str1 = "" + n1;

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(str1);
		Thread.sleep(2000);

		// random credit card

		Random randn = new Random();
		int nn = randn.nextInt(2) + 0;
		String strn = "" + nn;
		String local = "";

		Random randCardN = new Random();
		long[] vN = new long[16];
		vN[0] = 4;
		String vn2 = new String("");

		for (int i = 1; i < vN.length - 1; i++) {
			vN[i] = randCardN.nextInt(9);
		}
		for (long c : vN) {
			String s = "";
			s = s + c;
			vn2 = vn2 + s;

		}
		long[] mc = new long[16];
		mc[0] = 5;
		String mc2 = new String("");

		for (int i = 1; i < mc.length - 1; i++) {
			mc[i] = randCardN.nextInt(9);
		}
		for (long c : mc) {
			String s = "";
			s = s + c;
			mc2 = mc2 + s;

		}
		long[] am = new long[15];
		am[0] = 3;
		String am2 = new String("");

		for (int i = 1; i < mc.length - 1; i++) {
			am[i] = randCardN.nextInt(9);
		}
		for (long c : mc) {
			String s = "";
			s = s + c;
			am2 = am2 + s;

		}

		// Choice of cards

		switch (strn) {
		case "1":
			local = "//input[@ id='ctl00_MainContent_fmwOrder_cardList_0']";
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(vn2);

			break;
		case "2":
			local = "//input[@ id='ctl00_MainContent_fmwOrder_cardList_1']";
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(am2);
			break;

		default:
			local = "//input[@ id='ctl00_MainContent_fmwOrder_cardList_2']";
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(mc2);
		}
		driver.findElement(By.xpath(local)).click();

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("10/20");
		Thread.sleep(2000);

		// click on process
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		Thread.sleep(2000);

		// Verify than the page contains text New order has been successfully added.*/
		String expected = "New order has been successfully added.";
		String actual = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"))
				.getText();
		if (expected.equals(actual))
			System.out.println("Expected result matches the actual result.");
		else
			System.out.println("Expected result does not match the actual result.");

		driver.close();
	}
}
