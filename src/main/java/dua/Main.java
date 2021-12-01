package dua;

import dua.common.struct.Line;
import dua.common.struct.Method;
import dua.common.utils.ASTAux;
import dua.common.utils.JavaFile;
import dua.core.Analyzer;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author: Jazz
 * @date: 2021/12/01
 */
public class Main {
    /**
     * This tool is used for a specifically defined define-use analysis.
     * This method inputs a source file with a target method to analyze,
     * outputs define- and use- list for each statement.
     * @param args src_root_dir, src_file_path and target_method_sig
     */
    public static void main(String[] args) throws Exception {
        // check arguments if valid
        if(args.length != 3) {
            throw new IllegalArgumentException("Please check input format.");
        }
        String src_root_path = args[0];
        String src_path = args[1];
        Method target_method = new Method(args[2]);
        File target_file = new File(src_path);
        if(!target_file.exists()) {
            throw new FileNotFoundException("Input file doesn't exist : " + src_path);
        }

        String src = JavaFile.readFileToString(target_file);

        CompilationUnit cu = JavaFile.genASTFromSource(src, src_path, src_root_path);

        String methodName = target_method.getName();
        List<String> paraTypes = target_method.getParaTypes();
        MethodDeclaration md = ASTAux.getMethodDeclaration(cu, methodName, paraTypes);

        Analyzer analyzer = new Analyzer(cu, md);
        List<Line> result = analyzer.analyze();

    }
}
