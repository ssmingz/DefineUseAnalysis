package dua.core;

import dua.common.struct.Line;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import java.util.List;

public class Analyzer {
    private static String _name = "@Analyzer ";

    private CompilationUnit _compUnit;
    private MethodDeclaration _methodDec;

    public Analyzer(CompilationUnit cu, MethodDeclaration md) {
        _compUnit = cu;
        _methodDec = md;
    }

    public List<Line> analyze() {
        DDGraph ddg = buildDDG();

    }

    public DDGraph buildDDG() {
        DDGraph ddg = new DDGraph();

        return ddg;
    }
}
