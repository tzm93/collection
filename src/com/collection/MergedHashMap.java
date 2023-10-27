package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.commons.lang.math.NumberUtils;

public class MergedHashMap {

	private int mapSize;

	private ArrayList<String> arrayList;

	private HashMap<String, String> hashMap;

	private HashMap<String, String> mergedMap;

	public MergedHashMap(int mapSize, ArrayList<String> arrayList, HashMap<String, String> hashMap) {
		this.mapSize = mapSize;
		this.arrayList = arrayList;
		this.hashMap = hashMap;

		// check constraints
		if (mapSize < 0)
			throw new IllegalArgumentException("mapSize cannot be negative");

		if (arrayList == null)
			throw new IllegalArgumentException("arrayList cannot be null");

		if (hashMap == null)
			throw new IllegalArgumentException("hashMap cannot be null");

		if (arrayList.size() > mapSize)
			throw new IllegalArgumentException("size of arrayList cannot exceed mapSize");

		if (hashMap.size() > mapSize)
			throw new IllegalArgumentException("size of hashMap cannot exceed mapSize");

		int nowKey = -1;
		int previous = -1;
		int diff = -1;
		for (String key : hashMap.keySet()) {
			if (!NumberUtils.isNumber(key))
				throw new IllegalArgumentException("hashMap key must be a number");

			int now = Integer.parseInt(key);
			if (previous == -1) {
				previous = now;
				nowKey = now;
				continue;
			}

			if (now <= previous)
				throw new IllegalArgumentException("hashMap key must be follow a numberic sequence");

			if (previous != -1 && diff == -1) {
				diff = now - previous;
				continue;
			}

			int nowdiff = now - previous;
			if (diff != nowdiff)
				throw new IllegalArgumentException("hashMap key must be follow a numberic sequence");

		}

		// merging

		// mean HashMap is empty
		if (nowKey == -1) {
			nowKey = 1;
			diff = 1;
		}

		// LinkedList is most efficient to perform "remove" than ArrayList
		LinkedList<String> list = new LinkedList<String>(arrayList);
		mergedMap = new HashMap<String, String>();
		for (int i = 1; i <= mapSize; i++) {
			if (hashMap.containsKey(nowKey + "")) {
				String value = hashMap.get("" + nowKey);
				if (list.contains(value))
					list.remove(value);

				mergedMap.put("" + nowKey, value);
				nowKey = nowKey + diff;
				continue;
			}

			String value = list.get(0);
			mergedMap.put("" + nowKey, value);
			nowKey = nowKey + diff;
			list.remove(value);
		}
	}

	public int getMapSize() {
		return mapSize;
	}

	public ArrayList<String> getArrayList() {
		return arrayList;
	}

	public HashMap<String, String> getHashMap() {
		return hashMap;
	}

	public HashMap<String, String> getMergedMap() {
		return mergedMap;
	}

}
