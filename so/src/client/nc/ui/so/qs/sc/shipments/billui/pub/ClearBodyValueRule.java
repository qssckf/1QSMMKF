package nc.ui.so.qs.sc.shipments.billui.pub;
/*    */ 
/*    */ import nc.vo.so.pub.keyvalue.IKeyValue;

/*    */ public class ClearBodyValueRule
/*    */ {
/* 7 */   private static final String[] DEMANDCLEAR_KEY = {"vfree1", "vfree2", "vfree3", "vfree4", "vfree5", "vfree6", "vfree7", "vfree8", "vfree9", "vfree10", "blargessflag", "norigprice", "norigtaxprice", "nqtorigtaxprice", "nqtorigprice", "norigtaxmny", "norigmny", "ntax"};
/*    */ 
/*    */   private IKeyValue keyValue;
/*    */   
/*    */   public ClearBodyValueRule(IKeyValue keyValue)
/*    */   {
/* 13 */     this.keyValue = keyValue;
/*    */   }
/*    */ 
/*    */   public void clearBodyValue(int[] rows)
/*    */   {
/* 18 */     for (int row : rows) {
/* 19 */       for (String key : DEMANDCLEAR_KEY) {
/* 20 */         this.keyValue.setBodyValue(row, key, null);
/*    */       }
/*    */     }
/*    */   }
/*    */ }
