public class InsertionSort {
    private int[] inputArray;

    public int[] getInputArray() {
        return inputArray;
    }

    public InsertionSort(int[] inputArray) {
        int[] inputArray1 = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++){
            inputArray1[i] = inputArray[i];
        }
        this.inputArray = inputArray1;
    }

    public void insertionSortArray(){
        int n = inputArray.length;
        for (int i = 1; i < n; ++i) {
            int key = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > key) {
                inputArray[j + 1] = inputArray[j];
                j = j - 1;
            }
            inputArray[j + 1] = key;
        }
    }
}
