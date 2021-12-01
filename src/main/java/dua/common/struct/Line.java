package dua.common.struct;

import org.eclipse.jdt.core.dom.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static String _name = "@Line ";

    private int _lineNo;
    private ASTNode _astNode;
    private List<String> _defList = new ArrayList<>(), _useList = new ArrayList<>();

    public Line() {

    }
}
