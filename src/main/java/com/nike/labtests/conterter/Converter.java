package com.nike.labtests.conterter;

public interface Converter<T, V> {
    T convert(V v);
}
