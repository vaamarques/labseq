package altice.lab.common;

import java.util.Objects;

public class MyInteger{

    public Integer i;

    public MyInteger(final Integer i){
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInteger myInteger = (MyInteger) o;
        return Objects.equals(i, myInteger.i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
