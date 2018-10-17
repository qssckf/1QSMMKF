package nc.itf.so.qs.sc.planbill.service;

import nc.vo.mmpac.pmo.pac0002.entity.PMOAggVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.so.qs.sc.RdPorductDetailVO;

public interface IRdMmService {
	
	public RdPorductDetailVO[] Insert(RdPorductDetailVO[] objs) throws BusinessException;
	
	public RdPorductDetailVO[] update(RdPorductDetailVO[] objs) throws BusinessException;
	
	public void delete(RdPorductDetailVO objs) throws BusinessException;
	
	public RdPorductDetailVO[] DoRelease(RdPorductDetailVO[] objs) throws BusinessException;
	
	public RdPorductDetailVO[] DoRdPMO(RdPorductDetailVO[] objs) throws BusinessException;
	
	public RdPorductDetailVO[] DoRePMO(RdPorductDetailVO[] objs) throws BusinessException;
	
	public PMOAggVO[] pushPMO(PMOAggVO[] pmo) throws BusinessException;
	
	public abstract SuperVO[] queryPmoVObyPks(String[] maids) throws BusinessException;

}
