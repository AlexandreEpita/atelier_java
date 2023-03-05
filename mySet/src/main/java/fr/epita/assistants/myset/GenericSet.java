package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GenericSet<T extends Comparable<T>> {
    public ArrayList<T> base_;

    public GenericSet() {
        this.base_ = new ArrayList<T>();
    }

    public void insert(T i)
    {
        base_.add(i);
        Collections.sort(this.base_);
    }

    public void remove(T i)
    {
        if(this.base_.contains(i))
            base_.remove(i);
    }

    public Boolean has(T i)
    {
        return base_.contains(i);
    }

    public Boolean isEmpty()
    {
        return base_.isEmpty();
    }

    public T min()
    {
        int len = base_.size();
        T min_val = base_.get(0);
        for (int i = 1; i < len; i++)
        {
            if (base_.get(i).compareTo(min_val) < 0)
                min_val = base_.get(i);
        }
        return min_val;
    }

    public T max()
    {
        int len = base_.size();
        T max_val = base_.get(0);
        for (int i = 1; i < len; i++)
        {
            if (base_.get(i).compareTo(max_val) > 0)
                max_val = base_.get(i);
        }
        return max_val;
    }

    public int size()
    {
        return base_.size();
    }

    public static GenericSet intersection(GenericSet a, GenericSet b)
    {
        GenericSet res = new GenericSet();
        for (int i = 0; i < b.size(); i++)
        {
            if (a.has((Comparable) b.base_.get(i)))
            {
                res.insert((Comparable) b.base_.get(i));
            }
        }
        return res;
    }

    public static GenericSet union(GenericSet a, GenericSet b)
    {
        GenericSet res = new GenericSet<>();
        for (int i = 0; i < b.size(); ++i)
        {
            res.insert((Comparable) b.base_.get(i));
        }
        for (int i = 0; i < a.size(); i++)
        {
            if (!b.has((Comparable) a.base_.get(i)))
            {
                res.insert((Comparable) a.base_.get(i));
            }
        }
        return res;
    }
}
