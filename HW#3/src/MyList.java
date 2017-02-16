import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyList<E> extends ArrayList<E> {
	
	public MyList(){
		super();
	}
	public MyList(List<E> li){
		super();
		this.addAll(li);
	}
	
    @Override
	public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof List))
            return false;

        ListIterator<E> e1 = listIterator();
        ListIterator<?> e2 = ((List<?>) o).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            E o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1==null ? o2==null : o1.equals(o2)))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }
}
