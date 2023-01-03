package Stack;
import java.util.Stack;
public class Max_Area_In_Histogram {
    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nr[] = new int[arr.length];
        int nl[] = new int[arr.length];
        // Next Samller Right
        Stack<Integer> list = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!list.isEmpty() && arr[list.peek()] >= arr[i]) {
                list.pop();
            }
            if (list.isEmpty()) {

            nr[i] = arr.length;
        }else{
                nr[i] = list.peek();
        }
        list.push(i);
    }
        // Next Samller left
        list = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[list.peek()] >= arr[i]) {
                list.pop();
            }
            if (list.isEmpty()) {

                nl[i] = -1;
            }else{
                nl[i] = list.peek();
            }
            list.push(i);
        }
        // Current Area : width = j-i-1 = nr[i]-nl[i]-1
        for(int i =0; i<arr.length; i++){
            int height = arr[i];
            int width = nr[i] - nl[i]-1;
            int currentArea = height * width;
            maxArea = Math.max(maxArea,currentArea);
        }

        System.out.println("Maximum area in my histogram = "+maxArea);

}

    public static void main(String args []){
        int height [] = {2,1,5,6,2,3};
        maxArea(height);
    }
}
