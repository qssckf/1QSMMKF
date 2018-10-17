package nc.impl.so;

import nc.impl.pub.ace.AceShipmentsInfoPubServiceImpl;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
import nc.vo.so.qs.sc.AggShipmentsVO;
import nc.impl.pubapp.pattern.data.bill.BillLazyQuery;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.pubapp.query2.sql.process.QuerySchemeProcessor;
import nc.impl.pubapp.pattern.database.DataAccessUtils;
import nc.vo.pubapp.pattern.data.IRowSet;
import nc.vo.pubapp.bill.pagination.PaginationTransferObject;
import nc.vo.pubapp.bill.pagination.util.PaginationUtils;
import nc.impl.pubapp.pattern.data.bill.BillQuery;

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

}
