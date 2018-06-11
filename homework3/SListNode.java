package com.homework3;/* com.homework3.SListNode.java */

/**
 *  com.homework3.SListNode is a class used internally by the com.homework3.SList class.  An com.homework3.SList object
 *  is a singly-linked list, and an com.homework3.SListNode is a node of a singly-linked
 *  list.  Each com.homework3.SListNode has two references:  one to an object, and one to
 *  the next node in the list.
 *
 *  @author Kathy Yelick and Jonathan Shewchuk
 */

class SListNode {
    Object item;
    SListNode next;

    /**
     *  com.homework3.SListNode() (with one parameter) constructs a list node referencing the
     *  item "obj".
     */

    SListNode(Object obj) {
        item = obj;
        next = null;
    }

    /**
     *  com.homework3.SListNode() (with two parameters) constructs a list node referencing the
     *  item "obj", whose next list node is to be "next".
     */

    SListNode(Object obj, SListNode next) {
        item = obj;
        this.next = next;
    }

}