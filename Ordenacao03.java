import java.util.*;
import java.math.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Ordenacao03{

     public static void countingSort(int arr[], int menor){
        //int n = arr.length;

        int maior = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maior) {
                maior = arr[i];
            }
        }

        int[] count = new int[maior];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] -1] ++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        // O array de saída que terá os valores ordenados
        int[] back = new int[arr.length];

        for (int i = 0; i < back.length; i++) {
            back[count[arr[i] -1] -1] = arr[i];
            count[arr[i] -1]--;
        }

        // Copia o array de saída(back[]) para o array inicial(arr[])
        for (int i = 0; i < back.length; i++) {
            arr[i] = back[i];
        }

        for(int i = 0; i < arr.length; i++)
                    arr[i] -= menor;

        //printa o array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

    public static void bucketSort(int[] , int menor) {
          int maxvalor = arr[0];
        for(int j = 1 ; j < arr.length;j++){
           if(arr[j]> maxvalor)
           maxvalor = arr[j];
        }

          int [] balde = new int[maxvalor+1];


          for (int i=0; i < balde.length; i++)
             balde[i]=0;


          for (int i=0; i < arr.length; i++)
             balde[arr[i]]++;


          int outPos=0;
          for (int i=0; i < balde.length; i++) {
             for (int j=0; j<balde[i]; j++) {
                arr[outPos++]=i;
             }
          }

          for(int i = 0; i < arr.length; i++)
                    arr[i] -= menor;

          for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    /* HadixSort*/
    public static int maxValue(int arr[], int n){
            int max = arr[0];
            for (int i = 1; i < n; i++)
                if (arr[i] > max)
                    max = arr[i];
            return max;
    }

    public static void countSort(int arr[], int n, int exp){
            int output[] = new int[n];
            int i;
            int count[] = new int[10];
            Arrays.fill(count,0);

            for (i = 0; i < n; i++)
                count[ (arr[i]/exp)%10 ]++;


            for (i = 1; i < 10; i++)
                count[i] += count[i - 1];

            for (i = n - 1; i >= 0; i--){
                output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
                count[ (arr[i]/exp)%10 ]--;
            }

            for (i = 0; i < n; i++)
                arr[i] = output[i];
            }


    public static void radixSort(int arr[], int n, int menor){
            int max = maxValue(arr, n);

            for (int exp = 1; max/exp > 0; exp *= 10)
                countSort(arr, n, exp);

            for(int i = 0; i < n; i++)
                    arr[i] -= menor;

            for (int i=0; i<n; i++)
                System.out.println(arr[i]);
    }

/** InsertionSort
*/

    public static void insertionSort(int[] vetor){

        for (int i = 1; i < vetor.length; i++){

            int key = vetor[i];
            int j;

            for (j = i - 1; j >= 0 && key < vetor[j]; j--){
                vetor[j + 1] = vetor[j];
            }
            vetor[j + 1] = key;
        }
        /*
        for(int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }*/
    }

    /** MergeSort - particiona o vetor ao meio varias vezes, transformando em subproblemas
    */
        private static int[] numbers;
        private static int[] helper;

        private static int number;

        public static void sort(int[] vetor) {
                numbers = vetor;
                number = vetor.length;
                helper = new int[number];
                mergesort(0, number - 1);
                /*
                for(int i = 0; i < vetor.length; i++){
                    System.out.println(vetor[i]);
                }*/
        }

        private static void mergesort(int low, int high) {

                if (low < high) {
                        int middle = low + (high - low) / 2;
                        mergesort(low, middle);
                        mergesort(middle + 1, high);
                        merge(low, middle, high);
                }

        }

        private static void merge(int low, int middle, int high) {

                for (int i = low; i <= high; i++) {
                        helper[i] = numbers[i];
                }

                int i = low;
                int j = middle + 1;
                int k = low;

                while (i <= middle && j <= high) {
                        if (helper[i] <= helper[j]) {
                                numbers[k] = helper[i];
                                i++;
                        } else {
                                numbers[k] = helper[j];
                                j++;
                        }
                        k++;
                }

                while (i <= middle) {
                        numbers[k] = helper[i];
                        k++;
                        i++;
                }

        }

        /**QuickSort - Se assemelha com o pensamento do merge, mas usufrui da particição através de um pivô
        */
        public static int[] quickSort(int vetor[], int inicio, int fim){

            if( inicio < fim){
                int pivo = separa(vetor, inicio, fim);
                quickSort(vetor, inicio, pivo - 1);
                quickSort(vetor, pivo + 1, fim);
            }
            return vetor;
        }

        public static int separa(int vetor[], int inicio, int fim){
            int pivo = vetor[inicio];
            int i = inicio;
            int f = fim;

            while(i < f){
                while(vetor[i] <= pivo){
                    i++;
                    if(i == fim) break;
                }
                while( pivo < vetor[f]){
                    f--;
                    if(f == inicio) break;
                }
                if(i < f){
                    swap(vetor, i, f);
                }
            }
                vetor[inicio] = vetor[f];
                vetor[f] = pivo;
            return f;
        }

        public static void swap(int vetor[], int i, int f){
            int aux = vetor[i];
            vetor[i] = vetor[f];
            vetor[f] = aux;
        }

        /*  HeapSort */

        private static int[] vector;
        private static int n;
        private static int left;
        private static int right;
        private static int largest;

        public static void buildheap(int []vector){
            n=vector.length-1;
            for(int i=n/2;i>=0;i--){
                maxheap(vector,i);
            }
        }

        public static void maxheap(int[] vector, int i){
            left=2*i;
            right=2*i+1;
            if(left <= n && vector[left] > vector[i]){
                largest=left;
            } else{
                largest=i;
            }

            if(right <= n && vector[right] > vector[largest]){
                largest=right;
            }
            if(largest!=i){
                exchange(i,largest);
                maxheap(vector, largest);
            }
        }

        public static void exchange(int i, int j){
            int t = vector[i];
            vector[i] = vector[j];
            vector[j] = t;
        }

        public static void sortHeap(int []vetor){
            vector = vetor;
            buildheap(vector);

            for(int i = n; i > 0; i--){
                exchange(0, i);
                n = n - 1;
                maxheap(vector, 0);
            }
            /*
            for(int i = 0; i < vetor.length; i++){
                System.out.println(vetor[i]);
            }*/
        }

        public static boolean less(String s1, String s2) {
        if (s1.compareTo(s2) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void swap(ArrayList<String> ar, int i, int j) {
        String aux = ar.get(i);
        ar.set(i, ar.get(j));
        ar.set(j, aux);
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

    public static void quick_sort(ArrayList<String> ar, int lo, int hi) {
         if (hi <= lo) return;
        int j = partition(ar, lo, hi);
        quick_sort(ar, lo, j-1);
        quick_sort(ar, j+1, hi);
    }

    public static void quick_sort(ArrayList<String> list) {
        quick_sort(list, 0, list.size() - 1);
    }

     public static void main(String[] args){

            String k = args[0];
            Scanner scan = new Scanner(System.in);

            String linha = scan.nextLine();

            int n = Integer.parseInt(linha);
            int x = 0,  menor = 0;

            int vetor[] = new int[n];
            for(int i = 0; i < n; i++){
                linha = scan.nextLine();
                x = Integer.parseInt(linha);
                vetor[i] = x;
                if(menor > x){
                    menor = x;
                }
            }
            
            if(vetor.length <= 8){
                insertionSort(vetor);
                System.out.println("Executou o Insertion");
            } else if(menor >= 0){
                countingSort(vetor, menor);
                System.out.println("Executou o Counting");
            } else {
                     /* Trecho para algoritmos lineares funcionarem com números negativos **/
                menor *= (-1);
                for(int i = 0; i < vetor.length; i++)
                    vetor[i] += menor;

                if(vetor.length <= 100000){
                    bucketSort(vetor, menor);
                    System.out.println("Executou o Bucket");
                } else {
                    quickSort(vetor,0,vetor.length - 1);
                    System.out.println("Executou o Quick");
                }
            }


        }
}
