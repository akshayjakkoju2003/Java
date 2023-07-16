import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the rotation count: ");
        int rotationCount = scanner.nextInt();

        int[] rotatedArray = rotateArray(arr, rotationCount);
        System.out.println("Rotated array: ");
        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] rotateArray(int[] arr, int rotationCount) {
        int length = arr.length;
        rotationCount %= length;  // handle rotation counts larger than array length

        reverse(arr, 0, length - 1);  // Reverse the entire array
        reverse(arr, 0, rotationCount - 1);  // Reverse the first rotationCount elements
        reverse(arr, rotationCount, length - 1);  // Reverse the remaining elements

        return arr;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}