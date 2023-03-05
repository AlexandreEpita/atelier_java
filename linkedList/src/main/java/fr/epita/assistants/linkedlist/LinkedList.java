package fr.epita.assistants.linkedlist;

import java.util.List;

public class LinkedList<T extends Comparable<T>>{

    /**
     * Initializes the list
     **/
    public T obj;
    public LinkedList<T> next;
    public LinkedList() {
        this.next = null;
        this.obj = null;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T e) {

        if(this.obj == null) {
            this.obj = e;
            return;
        }

        LinkedList<T> elt = new LinkedList<T>();
        elt.obj = e;
        if (e.compareTo(this.obj) <= 0)
        {
            if (this.obj.compareTo(e) <= 0)
            {
                elt.next = null;
                this.next = elt;
            }
            else
            {
                T tmp = this.obj;
                LinkedList<T> next = this.next;
                this.obj = e;
                this.next = elt;
                elt.obj = tmp;
                elt.next = next;
            }
            return;
        }

        LinkedList<T> tmp = this;
        while (tmp.next != null)
        {
            if (e.compareTo(tmp.next.obj) <= 0)
            {
                elt.next = tmp.next;
                tmp.next = elt;
                return;
            }
            tmp = tmp.next;
        }
        elt.next = null;
        tmp.next = elt;
    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if there is no element at this
     *                                   index.
     **/
    public T get(int i) {
        if (i < 0 || this.obj == null)
            throw new IndexOutOfBoundsException();

        LinkedList<T> tmp = this;
        int cur = 0;
        while (tmp.next != null && cur != i)
        {
            tmp = tmp.next;
            cur++;
        }
        if (cur == i)
            return tmp.obj;
        throw new IndexOutOfBoundsException();
    }

    /**
     * Removes the first occurrence of the specified element in the list.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T e) {
        if (this.obj == null)
            return null;
        if (this.obj == e)
        {
            if (this.next == null)
            {
                this.obj = null;
            }
            else
            {
                this.obj = this.next.obj;
                this.next = this.next.next;
            }
            return e;
        }
        LinkedList<T> tmp = this;
        while (tmp.next != null)
        {
            if (tmp.next.obj == e)
            {
                tmp.next = tmp.next.next;
                return e;
            }
            tmp = tmp.next;
        }
        return null;
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        int res = 0;
        LinkedList<T> tmp = this;
        if (this.obj == null)
            return res;
        res++;
        while (tmp.next != null) {
            tmp = tmp.next;
            res++;
        }
        return res;
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        LinkedList<T> tmp = this;
        while (tmp != null)
        {
            tmp.obj = null;
            tmp = tmp.next;
        }
        this.obj = null;
        this.next = null;
    }
}
