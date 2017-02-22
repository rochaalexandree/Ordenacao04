import java.util.*;
import java.math.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Ordenacao03{

	public static void swap(double ar[], int i, int j){
		double aux = ar[i];
		ar[i] = ar[j];
		ar[j] = aux;
	}

	public static void swap(int ar[], int i, int j){
		int aux = ar[i];
		ar[i] = ar[j];
		ar[j] = aux;
	}

	public static void swap(ArrayList<String> ar, int i, int j) {
		String aux = ar.get(i);
		ar.set(i, ar.get(j));
		ar.set(j, aux);
	}

	public static boolean less(String s1, String s2) {
		return s1.compareTo(s2) < 0;
	}

	public static boolean less(double x, double y) {
		return x - y < 0;
	}

	public static void countingSort(int[] ar) {                
		int min = ar[0];
		int max = ar[0];

		int i;
		for (i = 1; i < ar.length; ++i) {
			if (ar[i] < min) min = ar[i];
			if (ar[i] > max) max = ar[i];
		}

		int range = max - min + 1;

		int[] count = new int[range];
		for(i = 0; i < range; i++) {
			count[i] = 0;
		}

		for (i = 0; i < ar.length; ++i) {
			++count[ar[i] - min];
		}

		int index = 0;
		for (i = min; i <= max; ++i) {
			for (int j = 0; j < count[i - min]; ++j){
				ar[index++] = i;
			}
		}

	}  

	public static void insertionSort(double[] ar) {
		for (int i = 0; i < ar.length; ++i)
			for (int j = i; j > 0 && ar[j] < ar[j-1]; --j) 
				swap(ar, j, j-1);
	}
	
	public static void quickSort(int[] ar, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(ar, lo, hi);
		quickSort(ar, lo, j-1);
		quickSort(ar, j+1, hi);
	}

	public static void quickSort(double[] ar, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(ar, lo, hi);
		quickSort(ar, lo, j-1);
		quickSort(ar, j+1, hi);
	}

	public static void quickSort(double[] ar) {
		quickSort(ar, 0, ar.length - 1);
	}

	public static void quickSort(int[] ar) {
		quickSort(ar, 0, ar.length - 1);
	}

	public static int partition(double[] ar, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		double p = ar[lo];

		while(true) {

			while(less(ar[++i], p)) 
				if (i == hi) break;

			while(less(p, ar[--j])) 
				if (j == lo) break;

			if (i >= j) break;

			swap(ar, i, j);
		}
		swap(ar, lo, j);

		return j;
	}

	public static int partition(int[] ar, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int p = ar[lo];

		while(true) {

			while(less(ar[++i], p)) 
				if (i == hi) break;

			while(less(p, ar[--j])) 
				if (j == lo) break;

			if (i >= j) break;

			swap(ar, i, j);
		}
		swap(ar, lo, j);

		return j;
	}

	public static int partition(ArrayList<String> ar, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		String p = ar.get(lo);

		while(true) {

			while(less(ar.get(++i), p)) 
				if (i == hi) break;

			while(less(p, ar.get(--j))) 
				if (j == lo) break;

			if (i >= j) break;

			swap(ar, i, j);
		}
		swap(ar, lo, j);

		return j;
	}

	public static void quickSort(ArrayList<String> ar, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(ar, lo, hi);
		quickSort(ar, lo, j-1);
		quickSort(ar, j+1, hi);
	}

	public static void quickSort(ArrayList<String> list) {
		quickSort(list, 0, list.size() - 1);
	}

	public static void sort(double[] ar, double max, double min) {
		if (ar.length < 8) {
			System.out.println("insertion");
			insertionSort(ar);
		}
		else if (max > Integer.MAX_VALUE || min < Integer.MIN_VALUE) {
			System.out.println("quick");
			quickSort(ar);
		}
		else if (max - min < 100000000) {
			System.out.println("counting");
			int[] temp = new int[ar.length];

			for (int i = 0; i < ar.length; ++i) {
				temp[i] = (int) ar[i];
			}

			countingSort(temp);

			for (int i = 0; i < ar.length; ++i) {
				ar[i] = temp[i];
			}
		}
		else {
			System.out.println("quick");
			quickSort(ar);	
		}
	}

	public static void sort(ArrayList<String> ar) {

	}

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		double[] ar = new double[n];    

		double max = 0, min = 0;

		for (int i = 0; i < n; ++i) {    
			ar[i] = in.nextDouble();

			if (min > ar[i]) min = ar[i];
			if (max < ar[i]) max = ar[i];
		}                                        		

		sort(ar, max, min);

		for (int i = 0; i < n; ++i) {
			System.out.println(ar[i]);
		}

	}
}
