package fr.noether.testception;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private List<TestCase> testSuite;

    public TestSuite() {
        this.testSuite = new ArrayList<>();
    }

    public void add(TestCase test) {
        this.testSuite.add(test);
    }

    public TestResult run() {
        return testSuite.stream()
                .map(TestCase::run)
                .reduce(TestResult.empty(), TestResult::merge);
    }
}
