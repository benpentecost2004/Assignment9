import java.util.*;

public class sortingGeneric {

    public static boolean isSorted(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> a) {
        for(int i = a.size(); i > 0; i --) {
            for(int j = 0; j < i-1; j ++) {
                if (a.get(j).compareTo(a.get(j+1)) > 0) {
                    E temp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, temp);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void mergeArray(ArrayList<E> a, int start, int middle, int end) {
        ArrayList<E> c = new ArrayList<>();
        int i = start;
        int j = middle;

        while(i < middle && j < end) {
            if(a.get(i).compareTo(a.get(j)) <= 0) {
                c.add(a.get(i));
                i ++;
            } else {
                c.add(a.get(j));
                j ++;
            }
        }

        while(i < middle) {
            c.add(a.get(i));
            i ++;
        }

        while(j < end) {
            c.add(a.get(j));
            j ++;
        }

        for(i = start; i < end; i ++) {
            a.set(i, c.get(i - start));
        }
    }

    public static <E extends Comparable<E>> void mergeSortt(ArrayList<E> a, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSortt(a, start, middle);
        mergeSortt(a, middle, end);
        mergeArray(a, start, middle, end);
    }
    

    public static <E extends Comparable<E>> void mergeSortt(ArrayList<E> a) {
        mergeSortt(a, 0, a.size());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Bubble Sort: ");
        ArrayList<Integer> arrayListBubble = new ArrayList<>();
        Random randomBubble = new Random();
        for (int i = 0; i < 30; i++) {
            arrayListBubble.add((randomBubble.nextInt(1000)));
        }

        System.out.println(arrayListBubble.toString());
        bubbleSort(arrayListBubble);
        System.out.println(arrayListBubble.toString());

        System.out.println(" ");

        System.out.println("Merge Sort: ");
        ArrayList<Integer> arrayListMerge = new ArrayList<>();
        Random randomMerge = new Random();
        for (int i = 0; i < 30; i++) {
            arrayListMerge.add(randomMerge.nextInt(1000));
        }
        System.out.println(arrayListMerge.toString());
        bubbleSort(arrayListMerge);
        System.out.println(arrayListMerge.toString());


    }
}
