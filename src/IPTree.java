public class IPTree {
    IPTree[] child;
    String dns;
    int octet;
    boolean isEnd;

    IPTree() {
        child = new IPTree[255];
    }

    public static void main(String[] args) {

    }

    private void insert(IPTree tree, String ip) {
        String[] splits = ip.split(".");
        IPTree curr = null;
        for (String split : splits) {
            curr = tree.child[Integer.valueOf(split)];
            if (curr.octet == 1) {
                // already exists;
                curr = new IPTree();
            }
        }
        curr.dns = "abc.com";
        curr.isEnd = true;
    }
}
