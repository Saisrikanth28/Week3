package week3.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajiohomework {
	public static void main(String[] args) throws InterruptedException {
		//find no. of links
		
ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.ajio.com/");
		
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.findElement(By.name("searchVal")).sendKeys("bags",Keys.ENTER);
driver.findElement(By.xpath("//label[contains(@class,'facet-linkname-genderfilter facet-linkname-Men')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//label[contains(@class,'facet-linkname facet-linkname-l1l3nestedcategory facet-linkname-Men - Fashion Bags')]")).click();
Thread.sleep(2000);
System.out.println(driver.findElement(By.className("length")).getText());

List<WebElement> brands = driver.findElements(By.tagName("strong"));
int Brandnames = brands.size();
System.out.println("Total number of brands are"+ Brandnames);

List<String>list =new ArrayList<>();
for (WebElement eachBrand : brands) {
	String output = eachBrand.getText();
	
	list.add(output);	
}
	
Collections.sort(list);
System.out.println(list);

List<WebElement> bags = driver.findElements(By.className("nameCls"));
List<String> bagList = new ArrayList<>();
for (WebElement eachBag : bags) {
	bagList.add(eachBag.getText());
}
System.out.println("Bags listed in the page are " + bagList);
	}
}