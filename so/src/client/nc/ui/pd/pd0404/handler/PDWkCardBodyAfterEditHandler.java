/*    */ package nc.ui.pd.pd0404.handler;
/*    */ 
/*    */ import nc.ui.mmf.framework.handler.MMBaseHandler;
/*    */ import nc.ui.mmf.framework.handler.MMEventHandler;
/*    */ import nc.ui.pd.pd0404.handler.tab_prodinv.PDWkCardBodyCastunitidHandler;
/*    */ import nc.ui.pd.pd0404.handler.tab_prodinv.PDWkCardBodyCmaterialvidHandler;
/*    */ import nc.ui.pd.pd0404.handler.tab_prodinv.PDWkCardBodyCmatericlassidHandler;
/*    */ import nc.ui.pd.pd0404.handler.tab_prodinv.PDWkCardBodyNtimeHandler;
/*    */ import nc.ui.pd.pd0404.handler.tab_prodinv.PDWkProBodyVChangeRateHandler;
/*    */ import nc.ui.pd.pd0404.handler.tab_repltime.PDWkCardBodyCaftermatrelatshowHandler;
/*    */ import nc.ui.pd.pd0404.handler.tab_repltime.PDWkCardBodyCprematrelatshowHandler;
/*    */ import nc.ui.pd.pd0404.handler.tab_subst.PDWkCardBodyCsubstitutewkidHandler;
/*    */ import nc.ui.pd.pd0404.handler.tab_wip.PDWkCardBodyCstordocidHandler;
/*    */ import nc.ui.pd.pd0404.view.PDWkBillForm;
/*    */ import nc.ui.pubapp.uif2app.event.IAppEventHandler;
/*    */ import nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent;
/*    */ 
/*    */ public class PDWkCardBodyAfterEditHandler extends MMEventHandler implements IAppEventHandler<CardBodyAfterEditEvent>
/*    */ {
/*    */   private PDWkBillForm editor;
/*    */   
/*    */   public PDWkCardBodyAfterEditHandler() {}
/*    */   
/*    */   public void initMap()
/*    */   {
/* 26 */     putHandler("subst_itemscsubstitutewkid", PDWkCardBodyCsubstitutewkidHandler.class);
/*    */     
/* 28 */     putHandler("wip_itemscstordocid", PDWkCardBodyCstordocidHandler.class);
/*    */     
/*    */ 
/* 31 */     putHandler("prodinv_itemscastunitid", PDWkCardBodyCastunitidHandler.class);
/*    */     
/* 33 */     putHandler("prodinv_itemscmaterialclassid", PDWkCardBodyCmatericlassidHandler.class);
/*    */     
/* 35 */     putHandler("prodinv_itemsntime", PDWkCardBodyNtimeHandler.class);
/*    */     
/* 37 */     putHandler("replace_itemscprematrelatshow", PDWkCardBodyCprematrelatshowHandler.class);
/*    */     
/* 39 */     putHandler("replace_itemscaftermatrelatshow", PDWkCardBodyCaftermatrelatshowHandler.class);
/*    */     
///* 41 */     putHandler("prodinv_itemscmaterialvid", PDWkCardBodyCmaterialvidHandler.class);
/*    */     
/*    */ 
/*    */ 
/* 45 */     putHandler("prodinv_itemsvchangerate", PDWkProBodyVChangeRateHandler.class);
/*    */     
/* 47 */     putHandler("prodinv_itemsnnum", nc.ui.pd.pd0404.handler.tab_prodinv.PDWkProBodyNumHandler.class);
/*    */     
/* 49 */     putHandler("prodinv_itemsnastnum", nc.ui.pd.pd0404.handler.tab_prodinv.PDWkProBodyAstNumHandler.class);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void handleAppEvent(CardBodyAfterEditEvent e)
/*    */   {
/* 57 */     String tabCode = e.getTableCode();
/* 58 */     String key = e.getKey();
/* 59 */     MMBaseHandler handler = getHandler(tabCode + key);
/* 60 */     if ((handler instanceof PDWkCardBodyCmatericlassidHandler)) {
/* 61 */       ((PDWkCardBodyCmatericlassidHandler)handler).setEditor(getEditor());
/*    */     }
/* 63 */     if ((handler instanceof PDWkCardBodyCmaterialvidHandler)) {
/* 64 */       ((PDWkCardBodyCmaterialvidHandler)handler).setEditor(getEditor());
/*    */     }
/* 66 */     if (handler != null) {
/* 67 */       handler.afterEdit(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public PDWkBillForm getEditor()
/*    */   {
/* 73 */     return this.editor;
/*    */   }
/*    */   
/*    */   public void setEditor(PDWkBillForm editor) {
/* 77 */     this.editor = editor;
/*    */   }
/*    */ }
