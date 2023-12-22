package org.lab5;
import org.lab5.source1.Interface1;
import org.lab5.source2.Interface2;

public class Wrapper {
    @AutoInjectable
    private Interface1 interface1;
    @AutoInjectable
    private Interface2 interface2;

    public String get1() {
        return interface1.getName();
    }

    public String get2() {
        return interface2.getType();
    }
}
