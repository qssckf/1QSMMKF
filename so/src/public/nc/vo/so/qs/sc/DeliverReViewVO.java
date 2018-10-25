package nc.vo.so.qs.sc;
 
 import nc.vo.pubapp.pattern.model.entity.view.AbstractDataView;
 import nc.vo.pubapp.pattern.model.meta.entity.view.DataViewMetaFactory;
 import nc.vo.pubapp.pattern.model.meta.entity.view.IDataViewMeta;
 
 public class DeliverReViewVO extends AbstractDataView
 {
   private static final long serialVersionUID = 959689656644555165L;
   
   public DeliverReViewVO() {}
   
   public AggShipmentsVO changeToBill()
   {
     AggShipmentsVO bill = new AggShipmentsVO();
     bill.setParent(getHead());
     ShipmentsBVO[] items = { getItem() };
     
 
     bill.setChildrenVO(items);
     return bill;
   }
   
   public ShipmentsVO getHead() {
     return (ShipmentsVO)getVO(ShipmentsVO.class);
   }
   
   public ShipmentsBVO getItem() {
     return (ShipmentsBVO)getVO(ShipmentsBVO.class);
   }
   
   public IDataViewMeta getMetaData()
   {
     return DataViewMetaFactory.getInstance().getBillViewMeta(AggShipmentsVO.class);
   }
   
   public void setHead(ShipmentsVO head) {
     setVO(head);
   }
   
   public void setItem(ShipmentsVO item) {
     setVO(item);
   }
 }

