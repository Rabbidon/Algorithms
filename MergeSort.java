//An implementation of mergesort

import java.util.List;
import java.util.Iterator;

public class mergeSort{

	public List<Integer> mergeSorted(List<Integer> list1, List<Integer> list2)
	{
		List<Integer> newList;
		if (list1.isEmpty){return list2;}
		if (list2.isEmpty){return list1;}
		Iterator<Integer> pointer1 = list1.listIterator();
		Iterator<Integer> pointer2 = list2.listIterator();
		value1 = pointer1.next();
		value2 = pointer2.next();
		while (pointer1.hasNext() & pointer2.hasNext())
		{
			if (value1<=value2 | !pointer2.hasNext())
			{
				newList.add(value1);
				value1 = pointer1.next;
			}
			else 
			{
				newList.add(value2);
				value1 = pointer2.next;
			}
		}
		return newList;
		
	public List<int> mergeSort(List<Integer> inputList)
	{
		if (inputList.size() == 1)
		{
			return inputList
		}
	    else{return mergeSorted(mergeSort(inputList.subList(0,inputList.size()/2)),mergeSort(inputList.subList(inputList.size()/2,inputList.size())));}
