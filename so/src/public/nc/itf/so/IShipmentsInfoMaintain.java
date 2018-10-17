package nc.itf.so;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.so.qs.sc.AggShipmentsVO;
import nc.vo.pub.BusinessException;

public interface IShipmentsInfoMaintain {

    public void delete(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException;

    public AggShipmentsVO[] insert(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException;
  
    public AggShipmentsVO[] update(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException;

    public String[] queryPKs(IQueryScheme queryScheme) throws BusinessException;
   
    public AggShipmentsVO[] queryBillByPK(String[] pks) throws BusinessException ;

    public AggShipmentsVO[] save(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException ;

    public AggShipmentsVO[] unsave(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException ;

    public AggShipmentsVO[] approve(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException ;

    public AggShipmentsVO[] unapprove(AggShipmentsVO[] clientFullVOs,AggShipmentsVO[] originBills) throws BusinessException ;
}
