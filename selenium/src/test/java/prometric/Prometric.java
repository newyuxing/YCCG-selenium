package prometric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Prometric {


    WebDriver webDriver;
    String keyWorld;
    Boolean switchType = true;

    @BeforeTest
    public void beforeTest(){
        System.out.println("测试开始前创建浏览器-开始");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        System.out.println("测试开始前创建浏览器-结束");
    }

    public void wateElement(String Xpath) throws InterruptedException {

        switchType=true;
        while (switchType){
//            switchType = webDriver.findElement(By.xpath("/html/body/app-root/app-loader/div/div")).isDisplayed();
            Thread.sleep(300);
            System.out.println(switchType?"显示遮盖页":"未显示遮盖页");
            if (switchType){
                switchType=!webDriver.findElement(By.xpath(Xpath)).isDisplayed();
                System.out.println(switchType?"元素不可用":"元素可用");
            }
        }

    }

    @Test
    public void mainTest() throws InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        打开网站
        webDriver.get("https://proscheduler.prometric.com/");
        //选择语言
        WebElement languageSelect = webDriver.findElement(By.xpath("/html/body/app-root/app-header/nav/div[4]/label/select"));
        Select select = new Select(languageSelect);
        select.selectByValue("Chinese");//根据value值

//进入第二页
        wateElement("/html/body/app-root/home/div[2]/div[2]/a[2]/div");
        webDriver.findElement(By.xpath("/html/body/app-root/home/div[2]/div[2]/a[2]/div")).click();
        Thread.sleep(3000);

//        等待Sponsor可用
        wateElement("//*[@id=\"selectClient\"]");
//        webDriver.findElement(By.xpath("//*[@id=\"selectClient\"]")).click();
//        new Select(webDriver.findElement(By.xpath("//*[@id=\"selectClient\"]"))).selectByValue("College Board - AP Exams");

        List<WebElement> SponsorOption = webDriver.findElements(By.xpath("//*[@id=\"selectClient\"]/option"));
        keyWorld="";
        for(int i=0;i<SponsorOption.size();i++){
            keyWorld=SponsorOption.get(i).getText();
            System.out.println(keyWorld);
            if ("College Board - AP Exams".equals(keyWorld.trim())) {
                SponsorOption.get(i).click();
                break;
            }
        }

        //        等待Program可用
        wateElement("//*[@id=\"selectProgram\"]");
//        new Select(webDriver.findElement(By.xpath("//*[@id=\"selectProgram\"]"))).selectByValue("College Board - AP Exams");
        List<WebElement> ProgramOption = webDriver.findElements(By.xpath("//*[@id=\"selectProgram\"]/option"));
        keyWorld="";
        for(int i=0;i<ProgramOption.size();i++){
            keyWorld=ProgramOption.get(i).getText();
            System.out.println(keyWorld);
            if ("College Board - AP Exams".equals(keyWorld.trim())) {
                ProgramOption.get(i).click();
                break;
            }
        }



        Thread.sleep(3000);

        //进入下一页
        System.out.println("进入第三页");
        wateElement("//*[@id=\"nextBtn\"]");
        webDriver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
        //进入下一页
        Thread.sleep(3000);
        System.out.println("进入下一页");
        wateElement("//*[@id=\"nextBtn\"]");
        webDriver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
        Thread.sleep(3000);


        webDriver.findElement(By.xpath("/html/body/app-root/app-scheduling/div/div[1]/app-agreement/div[2]/div[2]/app-content/div/div/div[2]/label[1]")).click();
        webDriver.findElement(By.xpath("/html/body/app-root/app-scheduling/div/div[1]/app-agreement/div[2]/div[2]/app-content/div/div/div[2]/label[2]")).click();


        //进入下一页
        System.out.println("进入下一页");
        webDriver.findElement(By.xpath("//*[@id=\"nextBtn\"]/em")).click();
        Thread.sleep(3000);

        wateElement("//*[@id=\"ELIGIBILITY_NUMBER\"]");
        webDriver.findElement(By.xpath("//*[@id=\"ELIGIBILITY_NUMBER\"]")).sendKeys("423582YV");
        webDriver.findElement(By.xpath("//*[@id=\"LAST_NAME\"]")).sendKeys("CAO");
        webDriver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();

        //进入下一页
        System.out.println("进入下一页");
        wateElement("//*[@id=\"nextBtn\"]");
        webDriver.findElement(By.xpath("//*[@id=\"nextBtn\"]/em")).click();
        Thread.sleep(3000);

        webDriver.findElement(By.xpath("//*[@id=\"google-maps\"]/div/app-geo-locator/input")).sendKeys("Chengdu");
        webDriver.findElement(By.xpath("//*[@id=\"google-maps\"]/div/app-geo-locator")).click();


        System.out.println("进入下一页");
        switchType=true;
        while (switchType){
            Thread.sleep(1000);
            switchType=!webDriver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).isEnabled();
        }
        webDriver.findElement(By.xpath("//*[@id=\"nextBtn\"]/em")).click();
        Thread.sleep(3000);


        webDriver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[3]/div[2]/div/div[1]/div/div/fieldset/div/div[1]/div[2]/div/div[1]/div/div/div[1]/div")).click();
        webDriver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[3]/div[2]/div/div[1]/div/div/fieldset/div/div[1]/div[2]/div/app-slot-card-detail/div/div/div/div[1]")).click();

        System.out.println("进入下一页");
        switchType=true;
        while (switchType){
            Thread.sleep(1000);
            switchType=!webDriver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).isEnabled();
        }
        webDriver.findElement(By.xpath("//*[@id=\"nextBtn\"]/em")).click();
        Thread.sleep(3000);



        //* 政府 ID
        webDriver.findElement(By.xpath("//*[@id=\"GOV_ID\"]")).sendKeys("510107200303060075");
        //* 政府 ID 签发国家/地区
        webDriver.findElement(By.xpath("//*[@id=\"GOV_ID_COUNTRY\"]")).sendKeys("Chian");
        //Legal Last (Family) Name
        webDriver.findElement(By.xpath("//*[@id=\"Legal Last (Family) Name\"]")).sendKeys("Cao");
        //Legal First (Given) Name
        webDriver.findElement(By.xpath("//*[@id=\"Legal First (Given) Name\"]")).sendKeys("Shushen");
        // Legal Last (Family) Name in Chinese
        webDriver.findElement(By.xpath("//*[@id=\"Legal Last (Family) Name in Chinese\"]")).sendKeys("曹");
        //Legal First (Given) Name in Chinese
        webDriver.findElement(By.xpath("//*[@id=\"Legal First (Given) Name in Chinese\"]")).sendKeys("树珅");
        //出生日期
        webDriver.findElement(By.xpath("/html/body/app-root/app-scheduling/div/div[1]/app-candidate-profile/div/form/div[1]/app-candidate/div/div[3]/dynamic-form/div/form/div[13]/dynamic-control/form/div/div[1]/div/datepicker-demo/div/input"))
                .sendKeys("Chengdu");
        //性别
        new Select(webDriver.findElement(By.xpath("//*[@id=\"GENDER\"]"))).selectByValue("Male");//根据value值
        //电子邮件地址
        webDriver.findElement(By.xpath("//*[@id=\"EMAIL\"]")).sendKeys("2821636860@qq.com");
        //确认电邮
        webDriver.findElement(By.xpath("//*[@id=\"VALIDATE_EMAIL\"]")).sendKeys("2821636860@qq.com");
        //家庭（晚上）电话
        webDriver.findElement(By.xpath("//*[@id=\"H_PHONE\"]")).sendKeys("");
        //手机
        webDriver.findElement(By.xpath("//*[@id=\"M_PHONE\"]")).sendKeys("13094425555");
        //街道地址行 1
        webDriver.findElement(By.xpath("//*[@id=\"ADDRESS1\"]")).sendKeys("温江区森宇音乐花园");
        //街道地址行 2
        webDriver.findElement(By.xpath("//*[@id=\"ADDRESS2\"]")).sendKeys("");
        //街道地址行 3
        webDriver.findElement(By.xpath("//*[@id=\"ADDRESS3\"]")).sendKeys("");
        //城市
        webDriver.findElement(By.xpath("//*[@id=\"CITY\"]")).sendKeys("成都");
        //州/省
        webDriver.findElement(By.xpath("//*[@id=\"STATE\"]")).sendKeys("");
        //邮政编码
        webDriver.findElement(By.xpath("//*[@id=\"ZIPCODE\"]")).sendKeys("");

        //国家/地区
        new Select(webDriver.findElement(By.xpath("//*[@id=\"COUNTRY\"]"))).selectByValue("CHINA");//根据value值
        //Grade
        new Select(webDriver.findElement(By.xpath("//*[@id=\"Grade\"]"))).selectByValue("12th Grade");//根据value值
        //Preferred Language
        new Select(webDriver.findElement(By.xpath("//*[@id=\"Preferred Language\"]"))).selectByValue("Another language");//根据value值
        //Parent/Guardian 1 Education Level
        new Select(webDriver.findElement(By.xpath("//*[@id=\"Parent/Guardian 1 Education Level\"]"))).selectByValue("Bachelor's or four-year degree");//根据value值
        //Parent/Guardian 2 Education Level
//        new Select(webDriver.findElement(By.xpath("//*[@id=\"Parent/Guardian 2 Education Level\"]"))).selectByValue("Bachelor's or four-year degree");//根据value值



    }



}
