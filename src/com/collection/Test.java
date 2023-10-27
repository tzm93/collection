package com.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		int mapSize = 4;

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("ELEMENT1");
		arrayList.add("ELEMENT4");
		arrayList.add("ELEMENT2");
		arrayList.add("ELEMENT7");

		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("1", "ELEMENT1");
		hashMap.put("3", "ELEMENT6");

		MergedHashMap merge = new MergedHashMap(mapSize, arrayList, hashMap);
		System.out.println(merge.getMergedMap());
	}

}
