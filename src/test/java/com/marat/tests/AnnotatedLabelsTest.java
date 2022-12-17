package com.marat.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

@Feature("Issue")
@Owner("Tester name")
public class AnnotatedLabelsTest {

    @Test
    @Story("Searching by issue")
    @Link(name = "Home page", url = "https://gitgub.com")
    @DisplayName("Searching issue")
    @Severity(SeverityLevel.BLOCKER)
    public void testGitHub() {
        step("Открываем главную страницу", () -> {
            open("http://github.com");
            addAttachment("Hello", "World");
        });
    }
}