public class LearnArrays{
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length-2);
        Print_Arr(arr2);
    }

    private static void Print_Arr(int[] a){
        for(int val : a){
            System.out.println(val);
        }
    }
}