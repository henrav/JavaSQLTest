package org.example.TestFolder;

import org.example.Failure;
import org.example.MainCode.HenkeDB.Config;
import org.example.MainCode.HenkeDB.HenrikDBCore;
import org.example.MainCode.SQLIntepreter.SQLParser;
import org.example.MainCode.SQLIntepreter.TokenGenerator;
import org.example.TestCore;
import org.example.TestResult;

public class TestMain {
    public static void main(String[] args) {
        //TestResult result = TestCore.runTests(createFileTest.class);

        TestResult result = TestCore.runTests(LanguageTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.getDescription());
        }

        if (result.getFailures().size() < 1){
            System.out.println("All tests passed");

        }

    }
}
