package calendar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node<T> {

    private T data = null;

    private List<Node<T>> children = new ArrayList<>();

    private Node<T> parent = null;

    private int size = 0;

    public Node(T data) {
        this.data = data;
        size += 1;
    }

    public Node<T> addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
        size += child.getSize();
        return child;
    }

    public void addChildren(List<Node<T>> children) {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
        for(Node c : children) {
        	size += c.getSize();
		}
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setSize(int size) {this.size = size;}

    public int getSize() {
        return size;
    }

    public Node find(String keyword)
    {
        Node node = this;
        LinkedList<Node> queue = new LinkedList<Node>();

        queue.add(node);

        while (queue.size() != 0)
        {
            node = queue.poll();
            if(node.getData().equals(keyword)) {
                return node;
            }
//            System.out.print(node.getData() + " ");
            List<Node> children = node.getChildren();
            if(children.size() != 0) {
                for(Node n : children) {
                    queue.add(n);
                }
            }
        }
        node = new Node("not found");
        return node;
    }

    public <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each -> printTree(each, appender + appender));
    }

}