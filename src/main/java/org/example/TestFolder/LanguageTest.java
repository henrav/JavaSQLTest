package org.example.TestFolder;

import org.example.MainCode.SQLIntepreter.*;
import org.example.MainCode.SQLIntepreter.DataTypes.DataType;
import org.example.MainCode.SQLIntepreter.DataTypes.DataTypeNode;
import org.example.annotations.Before;
import org.example.annotations.Test;

public class LanguageTest {
    @Before
    public void tjena(){

    }

    @Test
    public void test2(){
        String minSträng = "SELECT * from users WHERE ";
        SQLParser parser = new SQLParser(new TokenGenerator(minSträng).tokenize());
        parser.parse();
    }

    @Test
    public void test4(){
        String minSträng = "SELECT tjena, minkolumn from users WHERE id > 4 ";
        SQLParser parser = new SQLParser(new TokenGenerator(minSträng).tokenize());
        parser.parse();
    }
    @Test
    public void test3(){
    }
}
