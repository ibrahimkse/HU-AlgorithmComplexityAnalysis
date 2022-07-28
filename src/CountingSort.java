import java.util.Arrays;

public class CountingSort {
    private int[] inputArray;

    public int[] getInputArray() {
        return inputArray;
    }

    public CountingSort(int[] inputArray) {
        int[] inputArray1 = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++){
            inputArray1[i] = inputArray[i];
        }
        this.inputArray = inputArray1;
    }
    public void countingSortArray(){
        int max = Arrays.stream(this.inputArray).max().getAsInt();
        int min = Arrays.stream(this.inputArray).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[this.inputArray.length];
        for (int i = 0; i < this.inputArray.length; i++) {
            count[this.inputArray[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = this.inputArray.length - 1; i >= 0; i--) {
            output[count[this.inputArray[i] - min] - 1] = this.inputArray[i];
            count[this.inputArray[i] - min]--;
        }

        for (int i = 0; i < this.inputArray.length; i++) {
            this.inputArray[i] = output[i];
        }

    }
}
