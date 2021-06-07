import java.util.ArrayList;
import java.util.List;

public class Kata {

  public static int[] arrayDiff(int[] arrIn, int[] arrCorr) {
    
    if ((arrIn.length==0)||(arrCorr.length==0)){
      return arrIn;
    }
    
    ArrayList<Integer> arrOut = new ArrayList<>();
    loop:
    for (int num : arrIn){
      for (int corr: arrCorr){ 
        if (num == corr) {
            continue loop;
          }
      }
       arrOut.add(num);
    }

    return arrOut.stream().mapToInt(Integer::intValue).toArray();
  }

}