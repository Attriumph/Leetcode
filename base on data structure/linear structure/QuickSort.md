# Quick Sort

```java
Class Solution {
   public void quickSort(int[] arr, int low, int high) {
     if (low < high) {
       int pivot = partition(arr, low, high);

       quickSort(arr, low, pivot - 1);
       quickSort(arr, pivot + 1, high);
     }
   }

  private int partition(int[] arr, int low, int high) {
    int pivot = arr.length - 1;
    int j = low - 1;

    for (int i = low; i < pivot; i++ ) {
      if (arr[i] < arr[pivot]) {
        swap(arr[i], arr[++j]);
      }
    }

    swap(j + 1, pivot, arr);
    return j + 1;
  }

  private void swap(int j, int i, int[] arr) {
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
}
