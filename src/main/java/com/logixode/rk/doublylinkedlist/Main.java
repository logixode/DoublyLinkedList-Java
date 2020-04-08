/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logixode.rk.doublylinkedlist;
/** Class utama dari package CircularLinkedList
 * @author Rohmad Kurniadi
 */
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertFirst(22);
        myList.insertFirst(44);
        myList.insertFirst(66);
        
        myList.insertLast(11);
        myList.insertLast(33);
        myList.insertLast(55);
        
        myList.displayForward();
        myList.displayBackward();
        
        myList.deleteFirst();
        myList.deleteLast();
        
        myList.deleteKey(11);
        
        myList.displayForward();
        
        myList.insertAfter(22, 77);
        myList.insertAfter(33, 88);
        
        myList.displayForward();
        
    }
}
// EOF