package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class IntegerSet {

    public ArrayList<Integer> base_;

    public IntegerSet() {
        this.base_ = new ArrayList<>();
    }

    public void insert(Integer i)
    {
        base_.add(i);
        Collections.sort(this.base_);
    }

    public void remove(Integer i)
    {
        if(this.base_.contains(i))
            base_.remove(i);
    }

    public Boolean has(Integer i)
    {
        return base_.contains(i);
    }

    public Boolean isEmpty()
    {
        return base_.isEmpty();
    }

    public Integer min()
    {
        int len = base_.size();
        Integer min_val = base_.get(0);
        for (int i = 1; i < len; i++)
        {
            if (base_.get(i) < min_val)
                min_val = base_.get(i);
        }
        return min_val;
    }

    public Integer max()
    {
        int len = base_.size();
        Integer max_val = base_.get(0);
        for (int i = 1; i < len; i++)
        {
            if (base_.get(i) > max_val)
                max_val = base_.get(i);
        }
        return max_val;
    }

    public int size()
    {
        return base_.size();
    }

    public static IntegerSet intersection(IntegerSet a, IntegerSet b)
    {
        IntegerSet res = new IntegerSet();
        for (int i = 0; i < b.size(); i++)
        {
            if (a.has(b.base_.get(i)))
            {
                res.insert(b.base_.get(i));
            }
        }
        return res;
    }

    public static IntegerSet union(IntegerSet a, IntegerSet b)
    {
        IntegerSet res = new IntegerSet();
        for (int i = 0; i < b.size(); ++i)
        {
            res.insert(b.base_.get(i));
        }
        for (int i = 0; i < a.size(); i++)
        {
            if (!b.has(a.base_.get(i)))
            {
                res.insert(a.base_.get(i));
            }
        }
        return res;
    }
}
