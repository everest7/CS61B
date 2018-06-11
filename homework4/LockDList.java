package com.homework4;


public class LockDList extends DList {

    @Override
    protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
        return new LockDListNode(item,prev,next);
    }

    public  LockDList() {
        head = new LockDListNode(null,null,null);
        head.next = head;
        head.prev = head;
        ((LockDListNode) head).locked = true;
        size = 0;
    }

    public void lockNode(DListNode node){

        ((LockDListNode) node).locked = true;


    }


    @Override
    public void remove(DListNode node) {
        if(((LockDListNode) node).locked){
            return;
        }
        super.remove(node);
    }
}
