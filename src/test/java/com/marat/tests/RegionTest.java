package com.marat.tests;

import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;

@Feature("Issue")
@Owner("Tester name")
public class RegionTest {

    @ParameterizedTest
    @ValueSource(strings = {"Moscow", "NY"})
    public void testGitHub(String region) {
        parameter("Region", region);
        step("Открываем главную страницу в регионе " + region, () -> {
            open("http://github.com");
            addAttachment("Hello", "World");
        });
    }
}