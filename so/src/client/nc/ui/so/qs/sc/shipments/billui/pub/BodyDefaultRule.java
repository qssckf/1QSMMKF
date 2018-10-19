package nc.ui.so.qs.sc.shipments.billui.pub;
/*    */ 
/*    */ import nc.ui.pubapp.AppUiContext;
/*    */ import nc.vo.pub.lang.UFDate;
/*    */ import nc.vo.pub.lang.UFDouble;
/*    */ import nc.vo.pubapp.AppContext;
/*    */ import nc.vo.so.pub.SOConstant;
/*    */ import nc.vo.so.pub.keyvalue.IKeyValue;
/*    */ 
/*    */ 
/*    */ public class BodyDefaultRule
/*    */ {
/*    */   private IKeyValue keyValue;
/*    */   
/*    */   public BodyDefaultRule(IKeyValue keyValue)
/*    */   {
/* 17 */     this.keyValue = keyValue;
/*    */   }
/*    */   
/*    */   public void setBodyDefaultValue(int[] rows)
/*    */   {
/* 22 */     UFDate busidate = AppUiContext.getInstance().getBusiDate();
/* 23 */     busidate = busidate.asLocalEnd();
/*    */     
/* 25 */     for (int row : rows)
/*    */     {     
/*    */ 
/* 28 */       this.keyValue.setBodyValue(row, "dsenddate", busidate);
/* 29 */       this.keyValue.setBodyValue(row, "dreceivedate", busidate);
/*    */       
/*    */ 
/* 32 */       this.keyValue.setBodyValue(row, "nnum", null);
/* 33 */       this.keyValue.setBodyValue(row, "nastnum", null);
/*    */     }
/*    */   }
/*    */ }
