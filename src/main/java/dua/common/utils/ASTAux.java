package dua.common.utils;

import dua.common.utils.visitor.MethodDecVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import java.util.List;

/**
 * This class contains some useful methods for AST operations.
 */
public class ASTAux {
    private static String _name = "@ASTAux ";

    /**
     * @param cu compilation unit
     * @param methodName method desired
     * @param paraTypes list of para types
     * @return corresponding MethodDeclaration node
     */
    public static MethodDeclaration getMethodDeclaration(CompilationUnit cu, String methodName, List<String> paraTypes) {
        MethodDecVisitor visitor = new MethodDecVisitor(cu, methodName, paraTypes);
        return visitor.traverse();
    }
}
