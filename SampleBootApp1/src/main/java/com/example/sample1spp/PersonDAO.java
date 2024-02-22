package com.example.sample1app;

import java.io.Serializable;
import java.util.List;

public interface PersonDAO <T> extends Serializable {
	public List<T> getAll();
	public T findById(Long id);
	public List<T> findByName(String name);
	public List<T> find(String fstr);
	public List<T> findByAge(int min, int max);
}
