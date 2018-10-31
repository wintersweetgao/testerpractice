package chaper5;

/**
 * @author dongmei.gao
 * @date 2018/10/30 13:25
 */
public class Triangle {
    int edge_a;
    int edge_b;
    int edge_c;

    public Triangle(int edge_a, int edge_b, int edge_c) {
        this.edge_a = edge_a;
        this.edge_b = edge_b;
        this.edge_c = edge_c;
    }

    public int getEdge_a() {
        return edge_a;
    }

    public void setEdge_a(int edge_a) {
        this.edge_a = edge_a;
    }

    public int getEdge_b() {
        return edge_b;
    }

    public void setEdge_b(int edge_b) {
        this.edge_b = edge_b;
    }

    public int getEdge_c() {
        return edge_c;
    }

    public void setEdge_c(int edge_c) {
        this.edge_c = edge_c;
    }
}
