import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class new_demo {
    public static void main(String[] args) {
int[] num={3,2,4};
        System.out.println(twoSum(num,6));
}

    public static int[] twoSum(int[] nums, int target) {
        int[] n=new int[2];
                int size=nums.length;
                int sum = 0;
                int count=0;
        if(size>=2 && size<=10000){
            for(int i=0;i<size;i++){
                sum=sum+nums[i];
                if(i!=0){
                    if(sum<target && sum!=target){
                        count=count+1;
                    }
                }

            }
            n= new int[]{count, count+1};
        }

        return n;
    }
}

