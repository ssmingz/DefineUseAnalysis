package dua.core;

import dua.common.struct.ddg.Edge;
import dua.common.struct.ddg.Node;
import org.jgrapht.graph.DirectedMultigraph;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class DDGraph extends DirectedMultigraph<Node, Edge> {
    private int hash;

    public DDGraph() {
        super(Edge.class);
    }

    public int getEdgeSize() {
        return edgeSet().size();
    }

    public int getNodeSize() {
        return vertexSet().size();
    }

    public int getSize() {
        return getNodeSize() + getEdgeSize();
    }

    public Set<Node> incomingNodesOf(Node node) {
        return incomingEdgesOf(node).stream().map(DDGraph.this::getEdgeSource).collect(Collectors.toSet());
    }

    public Set<Node> outgoingNodesOf(Node node) {
        return outgoingEdgesOf(node).stream().map(DDGraph.this::getEdgeTarget).collect(Collectors.toSet());
    }

    @Override
    public boolean addEdge(Node sourceVertex, Node targetVertex, Edge edge) {
        return !hasEdge(sourceVertex, targetVertex) && super.addEdge(sourceVertex, targetVertex, edge);
    }

    @Override
    public Edge addEdge(Node sourceVertex, Node targetVertex) {
        return super.addEdge(sourceVertex, targetVertex);
    }

    @Override
    public boolean addVertex(Node node) {
        return super.addVertex(node);
    }

    @Override
    protected boolean removeAllEdges(Edge[] edges) {
        return super.removeAllEdges(edges);
    }

    @Override
    public boolean removeAllEdges(Collection<? extends Edge> edges) {
        return super.removeAllEdges(edges);
    }

    @Override
    public Set<Edge> removeAllEdges(Node sourceVertex, Node targetVertex) {
        return super.removeAllEdges(sourceVertex, targetVertex);
    }

    @Override
    public boolean removeAllVertices(Collection<? extends Node> vertices) {
        return super.removeAllVertices(vertices);
    }

    @Override
    public boolean removeEdge(Edge edge) {
        return super.removeEdge(edge);
    }

    @Override
    public Edge removeEdge(Node sourceVertex, Node targetVertex) {
        return super.removeEdge(sourceVertex, targetVertex);
    }

    @Override
    public boolean removeVertex(Node node) {
        return super.removeVertex(node);
    }

    @Override
    public int hashCode() {
        if (hash == -1) {
            hash = super.hashCode();
        }
        return hash;
    }

    private boolean hasEdge(Node edgeSource, Node edgeTarget) {
        for (Edge edge : outgoingEdgesOf(edgeSource)) {
            if (getEdgeTarget(edge) == edgeTarget) {
                return true;
            }
        }
        return false;
    }
}
