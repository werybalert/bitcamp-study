package bitcamp.util;

public interface ResourcePool<T> {

  T getReource();

  void returnResource(T resource);


}
