package sat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sat.dao.SatDao;
import util.SatUtil;

import java.util.concurrent.TimeUnit;

//@PropertySource("classpath:application.yml")
//@SpringBootTest
public class sat {
    WebDriver webDriver;
    String keyWorld;
    Boolean switchType = true;

//    @Autowired
//    private Environment env;
//    @Autowired
//    private SatDao satDao;
//    @Value("${url}")
//    String url;


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

    @AfterTest
    public void AfterTest(){
        webDriver.quit();
        System.out.println("测试-结束");
    }

    @Test
    public void mainTest() throws Exception {
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //打开网站
        System.out.println("请求网址为："+ SatUtil.getProperty("url"));
        System.out.println("用户名为："+ SatUtil.getProperty("username"));
        System.out.println("用户密码为："+ SatUtil.getProperty("password"));

//        System.out.println("请求网址为："+env.getProperty("url"));
        webDriver.get(SatUtil.getProperty("url"));
//        输入用户名密码并且登录
        webDriver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys(SatUtil.getProperty("username"));
        webDriver.findElement(By.xpath("//*[@id=\"view10_password\"]")).sendKeys(SatUtil.getProperty("password"));
        webDriver.findElement(By.xpath("//*[@id=\"profile\"]/div/div[5]/div/div[2]/div/div/div/div/div[1]/form/div[3]/div[2]/button")).click();
        System.out.println("登录成功");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"cb-atlas-header-1\"]/div[1]/div/div[2]/div/a[1]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"cb-atlas-identity-1\"]/div/div/div/div/div[2]/div/ul/li[1]/a/div/p")).click();
        task2();


//        webDriver.findElement(By.xpath("")).click();

    }

    public void task2() throws InterruptedException {

        try {
            webDriver.findElement(By.xpath("//*[@id=\"finishMyRegistration1\"]")).click();

            webDriver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
            Thread.sleep(3000);

            System.out.println("选择考点位置");
            WebElement languageSelect = webDriver.findElement(By.xpath("//*[@id=\"selectCountryName\"]"));
            Select select = new Select(languageSelect);
            select.selectByValue("250");//根据value值

            webDriver.findElement(By.xpath("//*[@id=\"searchByZipOrCountry\"]")).click();


            webDriver.findElement(By.xpath("//*[@id=\"newyuxing\"]")).click();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("异常重新开始");
            webDriver.get("https://nsat.collegeboard.org/");
            Thread.sleep(2000);
            task2();
        }

    }
}
