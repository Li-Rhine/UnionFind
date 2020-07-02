/**
 * @Description：
 * @Author： Rhine
 * @Date： 2020/7/2 22:03
 **/
public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;   // sz[i] 表示以i为根的集合中元素的个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // 查找过程，查找元素p所对应的集合编号
    // O(h)复杂度， h为树的高度
    private int find(int p) {
        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    // 查看元素p和元素q是否属于一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(p);
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度， h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(p);

        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            parent[qRoot] = pRoot;
        }
    }
}