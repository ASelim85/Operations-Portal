package Tests;

import APIS.P2P;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
//import io.qameta.allure.ConfigurationBuilder;
//import io.qameta.allure.Extension;
//import io.qameta.allure.ReportGenerator;
//import io.qameta.allure.allure1.Allure1Plugin;
//import io.qameta.allure.allure2.Allure2Plugin;
//import io.qameta.allure.category.CategoriesPlugin;
//import io.qameta.allure.category.CategoriesTrendPlugin;
//import io.qameta.allure.context.FreemarkerContext;
//import io.qameta.allure.context.JacksonContext;
//import io.qameta.allure.context.MarkdownContext;
//import io.qameta.allure.context.RandomUidContext;
//import io.qameta.allure.core.*;
//import io.qameta.allure.duration.DurationPlugin;
//import io.qameta.allure.duration.DurationTrendPlugin;
//import io.qameta.allure.environment.Allure1EnvironmentPlugin;
//import io.qameta.allure.executor.ExecutorPlugin;
//import io.qameta.allure.history.HistoryPlugin;
//import io.qameta.allure.history.HistoryTrendPlugin;
//import io.qameta.allure.idea.IdeaLinksPlugin;
//import io.qameta.allure.influxdb.InfluxDbExportPlugin;
//import io.qameta.allure.launch.LaunchPlugin;
//import io.qameta.allure.mail.MailPlugin;
//import io.qameta.allure.owner.OwnerPlugin;
//import io.qameta.allure.prometheus.PrometheusExportPlugin;
//import io.qameta.allure.retry.RetryPlugin;
//import io.qameta.allure.retry.RetryTrendPlugin;
//import io.qameta.allure.severity.SeverityPlugin;
//import io.qameta.allure.status.StatusChartPlugin;
//import io.qameta.allure.suites.SuitesPlugin;
//import io.qameta.allure.summary.SummaryPlugin;
//import io.qameta.allure.tags.TagsPlugin;
//import io.qameta.allure.timeline.TimelinePlugin;

import java.io.File;
import java.io.IOException;

import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.report.AllureReportBuilder;
import ru.yandex.qatools.allure.report.AllureReportBuilderException;

import java.util.ArrayList;

//import static com.github.automated-owl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class TestBase {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    loginTestCases login;
    P2P p2p;
    WalletProcessPage wallProPage;

    @BeforeSuite
    void setEnvironment() {
//        allureEnvironmentWriter(
//                ImmutableMap.<String, String>builder()
//                        .put("Browser", "Chrome")
//                        .put("Browser.Version", "97.0.4692.71")
//                        .put("URL", url)
//                        .build(), System.getProperty("user.dir")
//                        + "/allure-results/");
    }

    @BeforeMethod
    public void setUp() throws AllureReportBuilderException {
        String browserName = "chrome";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://agentportalsit.axispay.app:444/";
        driver.navigate().to(url);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        login = new loginTestCases();
        p2p = new P2P();
        wallProPage = new WalletProcessPage(driver);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
//        new AllureReportBuilder("1.5.4", new File("build/allure-report")).unpackFace();
//        new AllureReportBuilder("1.5.4", new File("build/allure-report")).processResults(new File("build/allure-results"));
    }

    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @AfterClass
    public void generateReport() throws IOException {
        //onGenerateAllureReport();
        FileUtils.deleteDirectory(new File("target/allure-results"));
    }

    public void switchTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void refresh() {
        driver.navigate().refresh();
    }



//    private void onGenerateAllureReport() {
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            public void run() {
//                try {
//                    final List<Extension> extensions;
//                    extensions = (List<Extension>) Arrays.asList(new JacksonContext(), new MarkdownContext(),
//                            new FreemarkerContext(), new RandomUidContext(), new MarkdownDescriptionsPlugin(),
//                            new RetryPlugin(), new RetryTrendPlugin(), new TagsPlugin(),
//                            new SeverityPlugin(), new OwnerPlugin(), new IdeaLinksPlugin(), new CategoriesPlugin(),
//                            new CategoriesTrendPlugin(), new HistoryPlugin(), new HistoryTrendPlugin(),
//                            new DurationPlugin(), new DurationTrendPlugin(), new StatusChartPlugin(),
//                            new TimelinePlugin(), new SuitesPlugin(), new TestsResultsPlugin(),
//                            new AttachmentsPlugin(), new MailPlugin(), new InfluxDbExportPlugin(),
//                            new PrometheusExportPlugin(), new SummaryPlugin(), new ExecutorPlugin(),
//                            new LaunchPlugin(), new Allure1Plugin(), new Allure1EnvironmentPlugin(),
//                            new Allure2Plugin(), new ReportWebPlugin());
//                    Configuration configuration = (new ConfigurationBuilder()).fromExtensions(extensions).build();
//                    Path resultDi = Paths.get("user.dir/allure-results");
//                    Path outDir = Paths.get("target/allure-report");
//                    new ReportGenerator(configuration).generate(outDir, resultDi);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

}