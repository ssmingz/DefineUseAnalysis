package dua.common.struct.ddg;

import dua.core.DDGraph;

import java.io.Serializable;

public class Node implements Serializable{
    private final int sourceLineNumber;
    private DDGraph ddg;

    public Node() {
        this(-1);
    }

    public Node(int sourceLineNumber) {
        this.sourceLineNumber = sourceLineNumber;
    }

    public DDGraph getDDGraph() {
        return ddg;
    }

    public int getSourceLineNumber() {
        return sourceLineNumber;
    }
}
