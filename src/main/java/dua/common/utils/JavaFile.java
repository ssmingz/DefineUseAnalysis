package dua.common.utils;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.io.*;
import java.util.Map;

public class JavaFile {
    private static String _name = "@JavaFile ";

    private static final int AST_JLS = AST.JLS8;
    private static final String JAVACORE_VERSION = JavaCore.VERSION_1_8;


    /**
     * return string from file
     */
    public static String readFileToString(File f) {
        String result = "";
        try {
            FileReader reader = new FileReader(f);
            BufferedReader bReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            String tmp = "";
            while((tmp = bReader.readLine()) != null) {
                builder.append(tmp + '\n');
            }
            result = builder.toString();
            bReader.close();
        } catch (FileNotFoundException e) {
            Printer.out(_name + "#readFileToString File not found : " + f.getAbsolutePath());
            e.printStackTrace();
        } catch (IOException e) {
            Printer.out(_name + "#readFileToString IO exception : " + f.getAbsolutePath());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * generate compilation unit from the given source code string
     * @param source
     * @param fileName
     * @param dirPath sources root path
     * @return
     */
    public static CompilationUnit genASTFromSource(String source, String fileName, String dirPath) {
        ASTParser parser = ASTParser.newParser(AST.JLS8);
        parser.setResolveBindings(true);
        parser.setSource(source.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        //parser.setEnvironment(null, null, null, true);
        String property = System.getProperty("java.class.path", ".");
        parser.setEnvironment(property.split(File.pathSeparator), new String[]{dirPath}, null, true);
        System.out.println(property);
        parser.setUnitName(fileName.substring(fileName.lastIndexOf(File.separator)));
        Map<?, ?> options = JavaCore.getOptions();
        JavaCore.setComplianceOptions(JavaCore.VERSION_1_7, options);
        parser.setCompilerOptions(options);
        CompilationUnit unit = (CompilationUnit) parser.createAST(null);
        unit.recordModifications();
        return unit;
    }
}
