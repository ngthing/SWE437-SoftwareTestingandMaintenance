import java.util.List;

public class Min {
  public static <E extends Comparable<? super E>> E min(List<? extends E> list) {
      if (list==null) throw 
          new NullPointerException("list cannot be null");
      if (list.size()==0) 
          throw new IllegalArgumentException("list cannot be empty");
      
      E min = list.get(0);
      for (E e : list){
          if (e==null) throw 
              new NullPointerException("list cannot contain null element");
          try {
              if (min.compareTo(e) > 0)  min  = e;
          } catch (ClassCastException ex) {
              throw new ClassCastException("list's elements must be comparable");
          }
      }
      return min;
  }
}