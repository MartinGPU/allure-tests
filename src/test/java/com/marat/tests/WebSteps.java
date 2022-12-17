package com.marat.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("http://github.com");
    }

    @Step("ищем репо  {repo}")
    public void repoSearch(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repo}")
    public void goToRepo(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем Issues")
    public void openIssues() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем наличие Issues {number}")
    public void checkIssueExistingByNumber(int number) {
        $(byText("#" + number)).should(Condition.visible);
    }
}
