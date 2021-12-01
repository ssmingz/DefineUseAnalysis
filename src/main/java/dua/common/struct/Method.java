package dua.common.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Method {
    private static String _name = "@Method ";

    private static String _methodSig;

    /**
     * This method inputs a string in the format of NAME(P1,P2...)
     * e.g. linearCombination(double[],double[])
     * @param methodSig
     */
    public Method(String methodSig) {
        _methodSig = methodSig;
    }

    public String getName() {
        String name = _methodSig.substring(0, _methodSig.indexOf("("));
        return name;
    }

    public List<String> getParaTypes() {
        List<String> paras = new ArrayList<>();
        String paraStr = _methodSig.substring(_methodSig.indexOf("(")+1, _methodSig.indexOf(")"));
        if(paraStr.contains(",")) {
            paras = Arrays.asList(paraStr.split(","));
        }
        return paras;
    }
}
