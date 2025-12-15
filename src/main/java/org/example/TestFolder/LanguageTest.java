package org.example.TestFolder;

import org.example.MainCode.SQLIntepreter.SQLParser;
import org.example.MainCode.SQLIntepreter.TokenGenerator;
import org.example.annotations.Before;
import org.example.annotations.Order;
import org.example.annotations.Test;

public class LanguageTest {
    @Before
    public void tjena(){

    }

    @Test
    @Order(1)
    public void test2(){
        String minSträng = "SELECT * from users WHERE ";
        SQLParser parser = new SQLParser(new TokenGenerator(minSträng).tokenize());
        parser.parse();
        System.out.println("\n");

    }

    @Test
    @Order(2)
    public void test4(){
        String minSträng = "SELECT * , COUNT(id.minkolumn) as hej from users WHERE id > 4 ";
        SQLParser parser = new SQLParser(new TokenGenerator(minSträng).tokenize());
        parser.parse();
        System.out.println("\n");
    }
    @Test
    @Order(3)
    public void test5(){


    }
    @Test
    public void test3(){


    }



}
