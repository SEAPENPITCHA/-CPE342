
package MyUtil;

import java.util.ArrayList;
import java.util.Comparator;

   public class Stack<T> 
   {
         ArrayList<T> items;
         
      private int top;
      public Stack() 
      {
         items = new ArrayList<T>();
         top=0;
      }
      public void push(T x) {
        items.add(top++,x);
      }
      public T pop() {
        if (top>0) {
        return items.remove(--top);
        }
        return null;
      }
      
      public int size() {
        return top;
      }
       public boolean isEmpty() {
        return top==0;
      }
       public boolean isFull() {
        return false;
      }
      public void sort(Comparator<T>c) {
        items.sort(c);
    }
}
