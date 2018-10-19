package nc.vo.so.qs.sc;

import nc.vo.pub.ISuperVO;
import nc.vo.pubapp.pattern.model.entity.view.AbstractDataView;
import nc.vo.pubapp.pattern.model.meta.entity.view.DataViewMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.view.IDataViewMeta;
import nc.vo.so.m38.entity.PreOrderBVO;
import nc.vo.so.m38.entity.PreOrderHVO;
import nc.vo.so.m38.entity.PreOrderVO;

public class ShipmentsViewVO extends AbstractDataView{

	private static final long serialVersionUID = 8942183108453892591L;
	
	public ShipmentsViewVO(){};

	public AggShipmentsVO changeToBill()
	{
		AggShipmentsVO bill = new AggShipmentsVO();
		bill.setParent(getHead());
		ShipmentsBVO[] items = {getItem()};
		bill.setChildrenVO(items);
		return bill;
	}
	
	

	public ShipmentsBVO getItem() {
		// TODO 自动生成的方法存根
		return (ShipmentsBVO) this.getVO(ShipmentsBVO.class);
	}

	public ShipmentsVO getHead() {
		// TODO 自动生成的方法存根
		return (ShipmentsVO) this.getVO(ShipmentsVO.class);
	}

	@Override
	public IDataViewMeta getMetaData() {
		// TODO 自动生成的方法存根
		return DataViewMetaFactory.getInstance().getBillViewMeta(AggShipmentsVO.class);
	}
	
	public void setHead(ShipmentsVO head) {
		setVO(head);
	}
	
	public void setItem(ShipmentsBVO item) {
		setVO(item);
	}

}
