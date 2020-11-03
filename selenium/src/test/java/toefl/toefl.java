package toefl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class toefl {

    WebDriver webDriver;
    String keyWorld;
    Boolean switchType = true;

    @BeforeTest
    public void beforeTest(){
        System.out.println("测试开始前创建浏览器-开始");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        //最大化窗口
        webDriver.manage().window().maximize();
        //清除cookies
        webDriver.manage().deleteAllCookies();
        System.out.println("测试开始前创建浏览器-结束");
    }

    @Test
    public void mainTest() throws Exception {
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //打开网站
        webDriver.get("https://toefl.neea.cn/login");
//        Future

    }

}
