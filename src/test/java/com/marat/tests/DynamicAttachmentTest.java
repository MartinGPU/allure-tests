package com.marat.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

public class DynamicAttachmentTest {

    @Test
    public void testGitHub() {
        step("Открываем главную страницу", () -> {
            open("http://github.com");
            addAttachment("Hello", "World");
        });
    }
}
