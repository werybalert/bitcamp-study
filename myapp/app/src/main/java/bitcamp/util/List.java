package bitcamp.util;

public interface List {

  boolean add(Object value); // public

  Object get(int index);

  Object[] toArray();

  Object remove(int index);

  boolean remove(Object value);

  int size();

}
