package org.example.MainCode.SQLIntepreter.DataTypes;


import javax.lang.model.type.NullType;

public abstract class DataType<T> {
    public final T val;
    protected DataType(T val) { this.val = val; }

    public static final class INT extends DataType<Integer> {
        public INT(int v) { super(v); }
    }

    public static final class FLOAT extends DataType<Float> {
        public FLOAT(float v) { super(v); }
    }

    public static final class STRING extends DataType<String> {
        public STRING(String v) { super(v); }
    }

    public static final class BOOLEAN extends DataType<Boolean> {
        public BOOLEAN(boolean v) { super(v); }
    }
    public static final class DOUBLE extends DataType<Double> {
        public DOUBLE(double v) { super(v); }
    }

    public static final class LONG extends DataType<Long> {
        public LONG(long v) { super(v); }
    }

    public static final class CHAR extends DataType<Character> {
        public CHAR(char v) { super(v); }
    }

    public static final class NULL extends DataType<Void>{
        public NULL(){
            super(null);
        }
    }
}