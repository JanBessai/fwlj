package caching;

import java.util.*;
import java.util.function.*;

import com.google.common.cache.*;

public final class Cache<Repr,T> {
  private final Function<Repr,T> k;
  public Cache(Function<Repr,T> k){ this.k=k; }
  public T of(Repr r){ return created.computeIfAbsent(r, k); }
  private final Map<Repr,T> created = CacheBuilder.newBuilder()
    .weakValues().<Repr,T>build().asMap();
  }
