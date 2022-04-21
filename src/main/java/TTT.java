import java.util.*;

public class TTT {
     List<Pair> pairs; // json中的pairs
     Set<Integer> selectedCoupon = new HashSet<>();

     public boolean couldSelect(Integer couponId) {
         if(selectedCoupon.isEmpty()) {//当前还没有选中的优惠券
             return true;
         }
         //TODO
         return false;
     }

}
class Pair{
    public Integer first;
    public Integer second;
}