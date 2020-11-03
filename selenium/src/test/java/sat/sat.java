package sat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Component
public class sat {

    WebDriver webDriver;
    String keyWorld;
    Boolean switchType = true;

    @Autowired
    private Environment env;
//    @Value("${sat.url}")
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

    @Test
    public void mainTest() throws Exception {
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //打开网站
        System.out.println("请求网址为："+env.getProperty("sat.url"));
        webDriver.get(env.getProperty("sat.url"));
//        Future

    }

}
