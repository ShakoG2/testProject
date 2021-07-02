package tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class removeElement {
	HashMap<Integer, Integer> hash;
	ArrayList<Integer> arr;

	public removeElement(HashMap<Integer, Integer> hash, ArrayList<Integer> arr) {
		this.hash = hash;
		this.arr = arr;
	}


	void remove(int x)
	{
		Integer index = hash.get(x);
		if (index == null)
			return;

		hash.remove(x);

		int size = arr.size();
		Integer last = arr.get(size-1);
		Collections.swap(arr, index, size-1);

		arr.remove(size-1);

		hash.put(last, index);
	}
}
