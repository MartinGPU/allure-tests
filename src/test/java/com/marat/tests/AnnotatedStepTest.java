package com.marat.tests;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 92;

    @Test
    public void testGitHub() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.repoSearch(REPOSITORY);
        steps.goToRepo(REPOSITORY);
        steps.openIssues();
        steps.checkIssueExistingByNumber(ISSUE_NUMBER);
    }
}
