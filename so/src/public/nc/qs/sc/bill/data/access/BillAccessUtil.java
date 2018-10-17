package nc.qs.sc.bill.data.access;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nc.ui.bd.ref.AbstractRefModel;
/*     */ import nc.ui.pub.beans.constenum.DefaultConstEnum;
/*     */ import nc.vo.pub.ISuperVO;
/*     */ import nc.vo.pub.bill.BillTabVO;
/*     */ import nc.vo.pub.bill.server.BillVO;
/*     */ import nc.vo.pub.bill.server.IBillItemMeta;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BillAccessUtil
/*     */ {
/*  20 */   private static BillAccessUtil instance = null;
/*  21 */   private Map<String, AbstractRefModel> refMap = new HashMap();
/*     */   
/*     */ 
/*     */   private BillAccessUtil() {}
/*     */   
/*     */   public static synchronized BillAccessUtil getInstance()
/*     */   {
/*  28 */     if (instance == null) {
/*  29 */       instance = new BillAccessUtil();
/*     */     }
/*  31 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Map<String, Object>> getTabDataMap(BillVO billVO, BillTabVO tabVO, ISuperVO[] vos)
/*     */   {
/*  37 */     if (vos == null) {
/*  38 */       return null;
/*     */     }
/*  40 */     List<Map<String, Object>> list = new ArrayList();
/*  41 */     for (int i = 0; i < vos.length; i++) {
/*  42 */       list.add(getTabDataMap(billVO, tabVO, vos[i]));
/*     */     }
/*     */     
/*  45 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<String, Object> getTabDataMap(BillVO billVO, BillTabVO tabVO, ISuperVO vo)
/*     */   {
/*  54 */     List<Map> recordList = new ArrayList();
/*  55 */     Map<String, Object> recordMap = new LinkedHashMap();
/*  56 */     List<IBillItemMeta> billItemList = billVO.getBillTItemMetasByTabCode(tabVO.getTabcode());
/*     */     
/*  58 */     for (Iterator iterator = billItemList.iterator(); iterator.hasNext();) {
/*  59 */       IBillItemMeta billItemMeta = (IBillItemMeta)iterator.next();

/*     */ 
/*  63 */         String key = billItemMeta.getKey();
/*  64 */         Object value = vo.getAttributeValue(billItemMeta.getKey());
/*  65 */         Map<String, Object> map = new LinkedHashMap();
/*     */         
/*  67 */         Object pk = null;
/*     */         
/*  69 */         switch (billItemMeta.getDataType())
/*     */         {
/*     */         case 6: 
/*  72 */           if (value != null)
/*     */           {
/*  74 */             value = ((DefaultConstEnum)value).getName();
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */           break;
/*     */         case 5: 
/*  81 */           if (value != null) {
/*  82 */             DefaultConstEnum refValue = (DefaultConstEnum)value;
/*  83 */             pk = refValue.getValue();
/*  84 */             value = refValue.getName();
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*  89 */         map.put(billItemMeta.getKey() + "itemShowName", billItemMeta.getCaption());
/*     */         
/*  91 */         map.put(billItemMeta.getKey(), value);
/*  92 */         if (pk != null)
/*     */         {
/*  94 */           map.put(billItemMeta.getKey() + "_ID", pk);
/*     */         }
/*  96 */         map.put("digest", Boolean.valueOf(billItemMeta.isRemarkItem()));
				  map.put("show", billItemMeta.isShow());
/*  97 */         recordList.add(map);
/*     */       
/*     */     }
/* 100 */     recordMap.put("billItemData", recordList);
/*     */     
/*     */ 
/*     */ 
/* 104 */     List<BillTabVO> grpTabList = billVO.getGroupTabVOByTabCode(tabVO.getTabcode());
/*     */     
/*     */ 
/* 107 */     if (grpTabList != null) {
/* 108 */       List<Map<String, Object>> grpList = new ArrayList();
/* 109 */       for (Iterator iterator = grpTabList.iterator(); iterator.hasNext();) {
/* 110 */         Map<String, Object> grpMap = new LinkedHashMap();
/* 111 */         BillTabVO billTabVO = (BillTabVO)iterator.next();
/* 112 */         grpMap.put("tabCode", billTabVO.getTabcode());
/* 113 */         grpMap.put("tabName", billTabVO.getTabname());
/* 114 */         grpMap.put("tabContent", getTabDataMap(billVO, billTabVO, vo));
/*     */         
/* 116 */         grpList.add(grpMap);
/*     */       }
/* 118 */       recordMap.put("group", grpList);
/*     */     }
/*     */     
/*     */ 
/* 122 */     return recordMap;
/*     */   }
/*     */   
/*     */   public void putRefMOdel(String refNodeName, AbstractRefModel model) {
/* 126 */     this.refMap.put(refNodeName, model);
/*     */   }
/*     */   
/* 129 */   public AbstractRefModel getRefModel(String refNodeName) { return (AbstractRefModel)this.refMap.get(refNodeName); }
/*     */ }

