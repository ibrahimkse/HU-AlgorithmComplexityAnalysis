import java.util.Arrays;

public class pigeonHoleSort {
    private int[] inputArray;

    public int[] getInputArray() {
        return inputArray;
    }

    public pigeonHoleSort(int[] inputArray) {
        int[] inputArray1 = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++){
            inputArray1[i] = inputArray[i];
        }
        this.inputArray = inputArray1;
    }
    public void pigeonHoleSortArray(){
        int n = this.inputArray.length;
        int min = this.inputArray[0];
        int max = this.inputArray[0];
        int range, i, j, index;

        for(int a=0; a<n; a++)
        {
            if(this.inputArray[a] > max)
                max = this.inputArray[a];
            if(this.inputArray[a] < min)
                min = this.inputArray[a];
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for(i = 0; i<n; i++)
            phole[this.inputArray[i] - min]++;


        index = 0;

        for(j = 0; j<range; j++)
            while(phole[j]-->0)
                this.inputArray[index++]=j+min;
    }
}
