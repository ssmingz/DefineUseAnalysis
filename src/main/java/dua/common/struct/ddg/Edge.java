package dua.common.struct.ddg;

import java.io.Serializable;

public class Edge implements Serializable{
    private Node source;
    private Node target;

    public Edge(Node source, Node target) {
        this.source = source;
        this.target = target;
    }

    public Node getSource() {
        return source;
    }

    public Node getTarget() {
        return target;
    }
}
