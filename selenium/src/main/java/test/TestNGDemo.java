package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestNGDemo {

    @BeforeTest
    public void beforeTest(){
        System.out.println("这是BeforeTest注解");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是BeforeMeyhod注解");
    }
    @Test
    public void testDemo1(){
        System.out.println("这是TestDemo1,case1");
    }
    @Test
    public void testDemo2(){
        System.out.println("这是TestDemo2,case2");
    }


    @AfterTest
    public void afterTest(){
        System.out.println("这是AfterTest注解");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是AfterMwthod注解");
    }





        //启动谷歌浏览器
        @Test
        public void openChrome() throws IOException, InterruptedException {
            //设置chromedriver路径
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            WebDriver webDriver = new ChromeDriver();


            webDriver.get("https://proscheduler.prometric.com/");
            webDriver.findElement(By.xpath("/html/body/app-root/home/div[2]/div[2]/a[2]/div")).click();
            /**
             * By.id(id)：通过ID 属性查找
             * By.name(name)：通过name属性查找
             * By.className(className) ：通过classname属性查找
             * By.linkText(链接文本)：通过链接文本
             * By.partialLinkText(部分链接文本)：通过部分链接文本
             * By.cssSelector(Css路径)：通过CSS路径
             * By.tagName(name)：通过tagname查找
             * By.xpath(XPath路径)：通过XPath查找
             */
            /**
             * 1. 点击：click()
             * 2. 文本框输入文本：sendkeys()
             * 清空文本框：clear()
             * 获取文本：getText()
             * 获取title：getTitle()
             * 判断元素是否展示：isDisplayed()
             * 判断选择框是否选取：isSelected()
             * 判断元素是否激活：isEnabled()
             */

//            File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            //复制一份截图到另一个文件夹
//            FileHandler.copy(file,new File("D:\\testing\\baidu.png"));

            WebElement moreSelect = webDriver.findElement(By.id("moreSelect"));
            Thread.sleep(2000);
            //new一个select对象
            Select select = new Select(moreSelect);
            select.selectByIndex(3); //根据索引值
            Thread.sleep(1000);
            select.selectByValue("huawei");//根据value值
            Thread.sleep(1000);
            select.selectByVisibleText("vivo");//根据文本值

        }


}
