package net.kang.maximum;

public class Example02 {
	// 3. 힙 자료구조를 통하여 정리를 해본다.
	static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void buildHeap(int[] a) {
        int end = a.length - 1;
        for (int i = end / 2; i >= 0; --i)
            heapify(a, i, end);
    }

    static void heapify(int[] a, int k, int end) {
        int left = 2 * k + 1, right = 2 * k + 2;
        int smaller;
        if (right <= end)
            smaller = (a[left] < a[right]) ? left : right;
        else if (left <= end) smaller = left;
        else return;
        if (a[smaller] < a[k]) {
            swap(a, smaller, k);
            heapify(a, smaller, end);
        }
    }

    static void heapSort(int[] a) {
        buildHeap(a);
        for (int end = a.length - 1; end >= 1; --end) {
            swap(a, 0, end);
            heapify(a, 0, end - 1);
        }
    }

    public static void main(String[] args) {
    	int[] arr={3, 29, 38, 12, 57, 74, 40, 85, 61};
        heapSort(arr);
        System.out.println(arr[0]);
    }
}
