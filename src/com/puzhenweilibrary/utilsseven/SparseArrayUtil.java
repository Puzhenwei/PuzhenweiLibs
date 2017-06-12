package com.puzhenweilibrary.utilsseven;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * SparseArrayUtil helps to manage SparseArray conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class SparseArrayUtil {
    
    public static <C> List<C> asArrayList(SparseArray<C> sparseArray) {
        if (sparseArray == null) {
            return new ArrayList<C>();
        }
        
        ArrayList<C> arrayList = new ArrayList<C>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.valueAt(i));
        }
        return arrayList;
    }
    
    public static <T> List<T> asArrayListT(SparseArray<T> sparseArray) {
        if (sparseArray == null) {
            return new ArrayList<T>();
        }
        
        ArrayList<T> arrayList = new ArrayList<T>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.valueAt(i));
        }
        return arrayList;
    }
}