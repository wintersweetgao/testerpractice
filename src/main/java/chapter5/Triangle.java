package chapter5;

/**
 * @author dongmei.gao
 * @date 2018/10/30 13:25
 */
public class Triangle {
    /**边a*/
    public int edgeA;
    /**边b*/
    public int edgeB;
    /**边c*/
    public int edgeC;

    /**
     * 构造体
     * @param edgeA
     * @param edgeB
     * @param edgeC
     */
    public Triangle(int edgeA, int edgeB, int edgeC) {
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }

    public int getEdgeA() {
        return edgeA;
    }

    public void setEdgeA(int edgeA) {
        this.edgeA = edgeA;
    }

    public int getEdgeB() {
        return edgeB;
    }

    public void setEdgeB(int edgeB) {
        this.edgeB = edgeB;
    }

    public int getEdgeC() {
        return edgeC;
    }

    public void setEdgeC(int edgeC) {
        this.edgeC = edgeC;
    }
}
