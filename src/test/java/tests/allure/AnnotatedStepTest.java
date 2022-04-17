package tests.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("kirillkatkov")
@Severity(SeverityLevel.NORMAL)
@Feature("Тесты @Step")
@Story("Выполнение тестов с аннотацией @Step")
@DisplayName("@Step")
public class AnnotatedStepTest {
    private static final String REPOSITORY = "kirill-katkov/demoqa-tests-12";
    private static final int ISSUE_NUMBER = 1;

    @Test
    @DisplayName("Успешный тест с аннотацией @Step")
    public void testGithubIssue() {
        Allure.parameter("Name", "Kirill Katkov");
        //SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
