package net.zu.node;


/**
 * @Author zuyunbo
 * @Date 2021/4/25  2:25 下午
 **/
public interface Node {

    <T> T accept(NodeVisitor<T> visitor);

}
