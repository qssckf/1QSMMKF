package nc.impl.so;

import nc.impl.pub.ace.AceShipmentsInfoPubServiceImpl;
import nc.impl.pubapp.env.BSContext;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
import nc.vo.scmpub.res.billtype.SOBillType;
import nc.vo.so.m38.entity.PreOrderBVO;
import nc.vo.so.m38.entity.PreOrderHVO;
import nc.vo.so.m38.entity.PreOrderVO;
import nc.vo.so.m38.entity.PreOrderViewVO;
import nc.vo.so.pub.enumeration.BillStatus;
import nc.vo.so.qs.sc.AggShipmentsVO;
import nc.vo.so.qs.sc.ShipmentsBVO;
import nc.vo.so.qs.sc.ShipmentsVO;
import nc.vo.so.qs.sc.ShipmentsViewVO;
import nc.impl.pubapp.pattern.data.bill.BillLazyQuery;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pubapp.AppContext;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.pubapp.pattern.pub.SqlBuilder;
import nc.vo.pubapp.query2.sql.process.QuerySchemeProcessor;
import nc.vo.pubapp.util.CombineViewToAggUtil;
import nc.impl.pubapp.pattern.database.DataAccessUtils;
import nc.vo.pubapp.pattern.data.IRowSet;
import nc.vo.pubapp.bill.pagination.PaginationTransferObject;
import nc.vo.pubapp.bill.pagination.util.PaginationUtils;
import nc.impl.pubapp.pattern.data.bill.BillQuery;
import nc.impl.pubapp.pattern.data.view.SchemeViewQuery;

public class ShipmentsInfoMaintainImpl extends AceShipmentsInfoPubServiceImpl implements nc.itf.so.IShipmentsInfoMaintain {

      @Override
      public void delete(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException {
    	  super.pubdeleteBills(clientFullVOs,originBills);
      }
  
      @Override
      public AggShipmentsVO[] insert(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException {
    	  return super.pubinsertBills(clientFullVOs,originBills);
      }
    
      @Override
      public AggShipmentsVO[] update(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException {
    	  return super.pubupdateBills(clientFullVOs,originBills);    
      }

	  @Override
	  public String[] queryPKs(IQueryScheme queryScheme) throws BusinessException {
		  return super.pubquerypkbills(queryScheme);
	  }
	  @Override
	  public AggShipmentsVO[] queryBillByPK(String[] pks) throws BusinessException {
		  return super.pubquerybillbypkbills(pks);
	  }

	  @Override
	  public AggShipmentsVO[] save(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException {
		  return super.pubsendapprovebills(clientFullVOs,originBills);
	  }

	  @Override
	  public AggShipmentsVO[] unsave(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException {
		  return super.pubunsendapprovebills(clientFullVOs,originBills);
	  }

	  @Override
	  public AggShipmentsVO[] approve(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException {
	      return super.pubapprovebills(clientFullVOs,originBills);
	  }

	  @Override
	  public AggShipmentsVO[] unapprove(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException {
	      return super.pubunapprovebills(clientFullVOs,originBills);
	  }
	  
	  public AggShipmentsVO[] queryShipmentsFor30(IQueryScheme queryScheme) throws BusinessException{
		  
		  
		  QuerySchemeProcessor processor = new QuerySchemeProcessor(queryScheme);
		  
		  String maintablename = processor.getMainTableAlias();
		  SqlBuilder sqlbuild = new SqlBuilder();
		  
		  sqlbuild.append(" and ");
		  String pk_group = BSContext.getInstance().getGroupID();
		  sqlbuild.append(maintablename + ".pk_group", pk_group);
		  sqlbuild.append(" and ");
		  sqlbuild.append(maintablename + ".fstatusflag", BillStatus.AUDIT.getIntValue());
		  
		  String chidtable = processor.getTableAliasOfAttribute("so_shipments_b.blineclose");
		  sqlbuild.append(" and ");
		  sqlbuild.append(chidtable + "." + "blineclose", UFBoolean.FALSE);
		  
		  sqlbuild.append(" and ");
		  sqlbuild.append(" abs( " + chidtable + ".nnum ) > abs( isnull(" + chidtable + ".narrnum,0)) ");
		  
		  processor.appendWhere(sqlbuild.toString());
		  processor.appendRefTrantypeWhere("FQ01", SOBillType.Order.getCode(), "transtype");
		
		  String ordersql = createOrderSql(queryScheme);
		  
		  SchemeViewQuery<ShipmentsViewVO> query = new SchemeViewQuery(ShipmentsViewVO.class);
		  ShipmentsViewVO[] views=(ShipmentsViewVO[])query.query(queryScheme, ordersql);
		  
		  if (org.apache.commons.lang.ArrayUtils.isEmpty(views)) {
			  return null;
		  }
		  
		  for(ShipmentsViewVO view:views){
			  
			  ShipmentsVO headvo=view.getHead();
			  ShipmentsBVO bodyvo=view.getItem();
			  headvo.setPk_group(bodyvo.getPk_group());
			  headvo.setPk_org(bodyvo.getPk_org());
			  
		  }
		  
		  AggShipmentsVO[] queryVos = (AggShipmentsVO[])new CombineViewToAggUtil(AggShipmentsVO.class, ShipmentsVO.class, ShipmentsBVO.class).combineViewToAgg(views, "pk_shipments");
		  
		  return queryVos;
	  }

	private String createOrderSql(IQueryScheme queryScheme) {
		// TODO 自动生成的方法存根
		
		SqlBuilder order = new SqlBuilder();
		QuerySchemeProcessor processor = new QuerySchemeProcessor(queryScheme);
		order.append(" order by ");
		String tableName = processor.getTableAliasOfAttribute(ShipmentsVO.class, "vbillcode");
		
		order.append(tableName);
		order.append(".");
		order.append("vbillcode");
		
		return order.toString();
	}

}
