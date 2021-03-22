package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }
}
class myLinkedList<T>{
    node head;
    class node{
        T data;
        node next;
        node(T data){
            this.data=data;
        }
    }
    void add(T data){
        node newNode = new node(data);
        if(head==null) head=newNode;
        else{
            node temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next = newNode;
        }
    }
    void add(int index,T data){
        if(index==0){
            addFirst(data);
        }
        else if(index==size()) addLast(data);
        else{
            node newNode = new node(data);
            node temp = head;
            while(temp.next!=null && index!=1){
                temp = temp.next;
                index-=1;
            }
            newNode.next=temp.next;
            temp.next = newNode;
        }
    }
    void addFirst(T data){
        node newNode = new node(data);
        if(head==null)head=newNode;
        else{
            node temp = head;
            newNode.next = temp;
            head  = newNode;
        }
    }
    void addLast(T data){
        add(data);
    }
    void print(){
        node temp = head;
        if(head==null) System.out.println("LinkedList is Empty.");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    void remove(){
        if(head==null || head.next==null) head=null;
        else if(head.next.next==null) head.next=null;
        else {
            node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }
    T get(int i){
        node temp = head;
        while(temp!=null && i!=0){
            temp=temp.next;
            i-=1;
        }
        if(i!=0) return null;
        return temp.data;
    }
    T getFirst(){
        if(head==null)return null;
        return head.data;
    }
    T getLast(){
        if(head==null) return null;
        node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp.data;
    }
    boolean contains(T data){
        node temp = head;
        while(temp!=null){
            if(temp.data==data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    void clear(){
        head=null;
    }
    int size(){
        node temp = head;
        int count=0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}
