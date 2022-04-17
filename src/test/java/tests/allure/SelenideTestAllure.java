package tests.allure;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Owner("kirillkatkov")
@Severity(SeverityLevel.NORMAL)
@Feature("Тесты Listener")
@Story("Выполнение тестов с помощью Selenide (с Listener)")
@DisplayName("Listener")
public class SelenideTestAllure {
    @Test
    @DisplayName("Успешный тест Listener")
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("kirill-katkov/demoqa-tests-12");
        $(".header-search-input").submit();

        $(linkText("kirill-katkov/demoqa-tests-12")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).click();
    }

    @Test
    @DisplayName("Неуспешный тест Listener")
    public void testGithubIssueError() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search55-input").sendKeys("kirill-katkov/demoqa-tests-12");
        $(".header-search-input").submit();

        $(linkText("kirill-katkov/demoqa-tests-12")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).click();
    }

    @AfterEach
    void close() {
        Selenide.closeWebDriver();
    }
}
