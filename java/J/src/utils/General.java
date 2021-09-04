package utils;

import java.util.List;
import java.util.stream.Stream;

public class General {
  public static final RuntimeException bug(){throw new RuntimeException("bug");}
  public static final RuntimeException unreachable(){throw new RuntimeException("unreachable");}
  public static final RuntimeException todo(){throw new RuntimeException("todo");}
  public static final <T> List<T> popLeft(List<T>t){return t.subList(1,t.size());}
  public static final <T> List<T> popRight(List<T>t){return t.subList(0,t.size()-1);}
  public static final <T> List<T> push(T e,List<T>t){
    return Stream.concat(Stream.of(e),t.stream()).toList();
    }
  public static final <T> List<T> push(List<T>t,T e){
    return Stream.concat(t.stream(),Stream.of(e)).toList();
    }  
}
