public class ThreeSmallestElements {
    //This algorithm is to find three smallest elements in one array.
    private static int[] findThreeSmallest(int[] arr) {
        if (arr == null || arr.length < 3) return null;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int thirdMin = Integer.MAX_VALUE;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < firstMin) {
                thirdMin = secondMin;
                secondMin = firstMin;

                firstMin = arr[i];
            } else if (arr[i] < secondMin) {
                thirdMin = secondMin;
                secondMin = arr[i];
            } else if (arr[i] < thirdMin) thirdMin = arr[i];

        }
        return new int[]{firstMin, secondMin, thirdMin};
    }


    public static void main(String[] args) {
        int []arr={15,93,58,13,5,87,67,22,36,32,73};
        int[]result=findThreeSmallest(arr);
        if (result==null){
            System.out.println("The result is invalid.");
            return;
        }
        System.out.println("The three lowest elements are:");
        for (int min:result) {
            System.out.print(min+", ");
        }
    }
}

