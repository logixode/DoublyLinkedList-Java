package com.logixode.rk.doublylinkedlist;

/** Proses utama DoublyLinkedList
 * @author Rohmad Kurniadi
 */
public class DoublyLinkedList {
    private Node first;
    private Node last;
    
    /** Class Constructor
     *  reset first & last
     */
    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }
    
    /** Method untuk menambahkan data ke awal List
     * @param data int  value untuk ditambahkan
     * @return void
     */
    public void insertFirst( int data ) {
        Node newNode = new Node();
        newNode.data = data;
        
        if( isEmpty() ) {
            // merepresentasikan Node baru di akhir list
            last = newNode;
        }
        else
            first.previous = newNode;
        
        newNode.next = first;
        this.first = newNode;
    }
    
    /** Method untuk menambahkan data ke akhir list
     * @param data int  value untuk ditambahkan
     * @return void
     */
    public void insertLast( int data ) {
        Node newNode = new Node();
        newNode.data = data;
        
        if( isEmpty() ) {
            // merepresentasikan Node baru di awal list
            first = newNode;
        }
        else {
            last.next = newNode;
            newNode.previous = last;
        }
        
        last = newNode;
    }
    
    /** Function untuk manghapus data yang berada di awal List(tidak kosong)
     * @return temp int  value data node yg telah terhapus
     */
    public int deleteFirst() {
        int temp = first.data; // jika pakai Node yg keluar alamat memory
        
        // jika value list hanya 1
        if( first.next == null ) { 
            last = null;
        }
        else
            first.next.previous = null;
        
        // shifting / geser list node kedepan
        first = first.next;
        return temp;
    }
    
    /** Function untuk manghapus data yang berada di akhir List(tidak kosong)
     * @return temp int  value data node yg telah terhapus
     */
    public int deleteLast() {
        int temp = last.data;
        
        // jika value list hanya 1
        if( first.next == null) { 
            first = null;
        }
        else 
            last.previous.next = null;
        
        last = last.previous; // geser last
        return temp;
    }
    
    /** Method untuk menambahkan data ke diantara 2 node ke list
     * @param key int  letak value node tertentu
     * @param data int  value untuk ditambahkan
     * @return true
     */
    public boolean insertAfter( int key, int data ) {
        Node current = first;
        
        // mencari value key didalam list
        while( current.data != key ) {
            current = current.next;
            
            if( current == null ) {
                return false;
            }
        }
        
        Node newNode = new Node();
        newNode.data = data;
        
        // jika node ditemukan di akhir list
        if( current == last ) { 
            // insert data diantara diakhir node
            current.next = null;
            last = newNode;
        }
        else {
            newNode.next = current.next;
            current.next.previous = newNode;
        }
        
        newNode.previous = current;
        current.next = newNode;
        
        return true;
    }
    
    /** Function untuk manghapus data berdasarkan value nya
     * @param key int  letak value node tertentu
     * @return current Node  lokasi memory data yang telah terhapus
     */
    public Node deleteKey( int key ) {
        Node current = first;
        
        // mencari value key didalam list
        while(current.data != key ) {
            current = current.next;
            
            if( current == null ) {
                return null;
            }
        }
        
        // jika node ditemukan di awal list
        if( current == first ) {
            first = current.next;
        }
        else 
            current.previous.next = current.next;
        
        // jika node ditemukan di akhir list
        if( current == last ) {
            last = current.previous;
        }
        else
            current.next.previous = current.previous;
        
        return current;
    }
    
    /** Method untuk menampilkan List secara urut
     * @return void
     */
    public void displayForward() {
        System.out.print("List (first --> last) : ");
        Node current = first;
        
        while( current != null ) {
            current.displayNode();
            current = current.next;
        }
        
        System.out.println();
    }
    
    /** Method untuk menampilkan List secara terbalik
     * @return void
     */
    public void displayBackward() {
        System.out.print("List (last --> first) : ");
        Node current = last; 
        
        while( current != null ) {
            current.displayNode();
            current = current.previous;
        }
        
        System.out.println();
    }
    
    /** Function untuk cek kondisi jika first kosong
     * @return boolean true atau false
     */
    public boolean isEmpty() {
        return first == null;
    }
}
// EOF