package fr.noether.testception;

public class Main {

    public static void main(String[] args) {
        var suite = new TestSuite();

        suite.add(new TestCaseTest(TestCaseTest::testTemplate));
        suite.add(new TestCaseTest(TestCaseTest::testSuccessResult));
        suite.add(new TestCaseTest(TestCaseTest::testFailureResult));
        suite.add(new TestCaseTest(TestCaseTest::testSuite));

        TestResult run = suite.run();

        System.out.println(run.summary());
    }

}
