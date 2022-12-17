package com.marat.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;

public class DynamicLabelsTest {

    @Test
    public void testGitHub() {
        story("Searching by issue");
        link("Home page", "https://gitgub.com");
        label("DisplayName", "Searching issue");
        label("Severity", SeverityLevel.BLOCKER.toString());
        feature("Issue");
        label("Owner", "Tester name");

        step("Открываем главную страницу", () -> {
            open("http://github.com");
            addAttachment("Hello", "World");
        });
    }
}