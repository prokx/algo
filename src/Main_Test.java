import java.util.*;
import java.io.*;

public class Main_Test {

  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());


    int arr[]  = new int[n];
    for(int i=0;i<n;i++){
       arr[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0;
    int end = n*10000;
    int answer = Integer.MAX_VALUE;

    while(start<=end){
      int mid = (start+end)/2;
      int cnt = 1;
      int sum = 0;
      boolean check = true;
      for(int i=0;i<n;i++){
        int l = arr[i];
        if(l>mid){
          check = false;
          break;
        }
        if(sum+l>mid){
          sum=0;
          cnt++;
          i--;
        }
        else{
          sum+=l;
        }
      }

      if(cnt>m || !check){
        start = mid+1;
      }
      else{
        answer = Math.min(answer,mid);
        end = mid-1;
      }
    }


    System.out.println(answer);
    // 블루레이 크기의 최소 N*10000 / M
    // 블루레이 크기의 최대 100000 * 10000


  }
}
