package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LogicsImpl implements Logics {

	private List<Integer>values;

	public LogicsImpl(int size) {
		this.values= new ArrayList<>(Collections.nCopies(size, 0));
	}

	@Override
	public int size() {
		
		return this.values.size();
	}

	@Override
	public List<Integer> values() {
		
		return List.copyOf(values);
	}

	@Override
	public List<Boolean> enablings() {
		
		return values.stream().map(a -> a < values.size()).toList();
	}

	@Override
	public int hit(int elem) {
		int n = this.values.get(elem);
		this.values.set(elem, ++n);
		return n;
	}

	@Override
	public String result() {
		
		return "<<" + String.join("|", this.values.stream().map(String::valueOf).toArray(String[]::new)) + ">>";
	}

	@Override
	public boolean toQuit() {
		
		return this.values.stream().allMatch(i -> i == this.values.get(0));
	}
}
