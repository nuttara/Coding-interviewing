import java.util.Arrays;

public class CodingInterview {

    public static void main(String args[]){

        int[] arr= new int[]{1,5,2,2,5,4,7,9};
        //function use helper function
        CodingInterview.solveArrayByHelperFunction(arr);
        //function use loop to resolve it
        CodingInterview.solveArrayByLoop(arr);
    }


    private static void solveArrayByLoop(int arr[]){
        System.out.println("######## Function solveArrayByLoop Start ##############");
        //selection sort
        for(int i=0 ;i< arr.length -1 ;i++){
            int temp=0;
            for(int j =i+1 ;j<arr.length-2;j++ ){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        int sum=0;
        System.out.println(Arrays.toString(arr));
        for(int i=0 ;i< arr.length ;i++){
            sum+=arr[i];
        }
        System.out.println(sum);
        Arrays.stream(findMidArray(arr)).average().ifPresent(System.out::println);
        System.out.println("######## Function solveArrayByLoop End ##############");
    }

    private static void solveArrayByHelperFunction(int arr[]){
        System.out.println("######## Function solveArrayByHelperFunction Start ##############");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
        Arrays.stream(findMidArray(arr)).average().ifPresent(System.out::println);
        System.out.println("######## Function solveArrayByHelperFunction End ##############");
        System.out.println();
    }

    private static int[] findMidArray(int[] arr) {
        int evenOrOdd = arr.length % 2 == 0? 1 : 0;

        int[] newArr = new int[1 + evenOrOdd];

        int startIdx = arr.length / 2 - evenOrOdd;
        int endIdx = arr.length / 2;

        for (int i = 0; i <= endIdx - startIdx; i++) {
            newArr[i] = arr[startIdx + i];
        }
        return newArr;
    }
}
