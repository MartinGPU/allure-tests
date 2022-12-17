package com.marat.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AnnotatedAttachmentTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 92;

    @Test
    public void testGitHub() {
        step("Открываем главную страницу", () -> {
            open("http://github.com");
            takeScreenShot();
            takePageSource();
        });

        step("ищем репо " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            takeScreenShot();
            takePageSource();
        });

        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
            takeScreenShot();
            takePageSource();
        });

        step("Открываем Issues", () -> {
            $(partialLinkText("Issues")).click();
            takeScreenShot();
            takePageSource();
        });

        step("Проверяем наличие Issues" + ISSUE_NUMBER, () -> {
            $(byText("#" + ISSUE_NUMBER)).should(Condition.visible);
            takeScreenShot();
            takePageSource();
        });
    }

    @Attachment(value = "Страница", type = "text/html")
    public byte[] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "СкринШот", type = "image/png")
    public byte[] takeScreenShot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}