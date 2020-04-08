package com.logixode.rk.doublylinkedlist;

/** Simulasi kerja Doubly Linked List
 * @author Rohmad Kurniadi
 */
public class Node {
    public int data;
    public Node next;
    public Node previous;
    
    /** Method untuk menampilkan satuan data List
     * @return void
     */
    public void displayNode() {
        System.out.print("[ " + data + " ] ");
    }
}
// EOF