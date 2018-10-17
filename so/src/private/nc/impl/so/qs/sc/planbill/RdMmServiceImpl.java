package nc.impl.so.qs.sc.planbill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import nc.bs.bd.bp.utils.MDQueryUtil;
import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.bs.so.qs.sc.readyplan.bp.RdDeleteBP;
import nc.bs.so.qs.sc.readyplan.bp.RdInsertBP;
import nc.bs.so.qs.sc.readyplan.bp.RdMakePMOBP;
import nc.bs.so.qs.sc.readyplan.bp.RdReleaseBP;
import nc.bs.so.qs.sc.readyplan.bp.RdReturnPMOBP;
import nc.bs.so.qs.sc.readyplan.bp.RdUpdateBp;
import nc.hr.frame.persistence.AppendBeanArrayProcessor;
import nc.itf.so.qs.sc.planbill.service.IRdMmService;
import nc.bs.mmpac.pmo.pac0002.bp.PMOInsertBP;
import nc.bs.mmpac.pmo.pac0002.bp.util.PMOBPCalUtil;
import nc.util.mmf.framework.base.MMArrayUtil;
import nc.vo.bd.pub.sqlutil.BDSqlInUtil;
import nc.vo.mmpac.pmo.pac0002.entity.PMOAggVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.pubapp.pattern.pub.MapList;
import nc.vo.so.qs.sc.MmPlanBillVO;
import nc.vo.so.qs.sc.RdPorductDetailVO;
import nc.vo.so.qs.sc.planbill.readyplan.PmoViewVO;

public class RdMmServiceImpl implements IRdMmService{

	private BaseDAO dao;
	
	public BaseDAO getDao() {
		
		if(this.dao==null){
			
			this.dao=new BaseDAO();
		}
		
		return dao;
	}
	
	@Override
	public RdPorductDetailVO[] Insert(RdPorductDetailVO[] objs) throws BusinessException {
		// TODO 自动生成的方法存根
		
		try{
			
			RdInsertBP action=new RdInsertBP();
			
			return action.insert(objs);
			
		}catch(Exception e){
			throw new BusinessException(e);
		}
		

	}

	@Override
	public RdPorductDetailVO[] update(RdPorductDetailVO[] objs) throws BusinessException {
		// TODO 自动生成的方法存根
		try{
			
			RdPorductDetailVO[] oldVo=(RdPorductDetailVO[])MDQueryUtil.lockValidateToRetrieveVO(objs);
			
			RdUpdateBp action=new RdUpdateBp();
			
			return action.update(objs, oldVo);
			
		}catch(Exception e){
			throw new BusinessException(e);
		}
		
	}

	@Override
	public void delete(RdPorductDetailVO objs) throws BusinessException {
		// TODO 自动生成的方法存根
		
		try{
			
			RdDeleteBP action=new RdDeleteBP();
			
			action.delete(new RdPorductDetailVO[]{objs});
			
		}catch(Exception e){
			throw new BusinessException(e);
		}

	}

	@Override
	public RdPorductDetailVO[] DoRelease(RdPorductDetailVO[] objs) throws BusinessException {
		// TODO 自动生成的方法存根
		
		try{
			
			RdPorductDetailVO[] oldVo=(RdPorductDetailVO[])MDQueryUtil.lockValidateToRetrieveVO(objs);
			
			RdReleaseBP action=new RdReleaseBP();

			return action.doRelease(objs);
			
		}catch(Exception e){
			
			throw new BusinessException(e);
			
		}
		

	}

	@Override
	public PMOAggVO[] pushPMO(PMOAggVO[] aggvos) throws BusinessException {
		// TODO 自动生成的方法存根
	
		
		try{
			
			if (MMArrayUtil.isEmpty(aggvos)) {
			     return null;
			}
			
			MapList<String, PMOAggVO> mapAggvo = new MapList();
			PMOBPCalUtil.fillNumberByNum(aggvos);
			
			for (PMOAggVO aggvo : aggvos) {
				
		       mapAggvo.put(aggvo.getParentVO().getPk_org(), aggvo);
		       
		    }
			
			List<PMOAggVO> returnobj=new ArrayList();
		     
		    for (Entry<String, List<PMOAggVO>> set : mapAggvo.entrySet()){
		    	
		    	PMOAggVO[] aggs=new PMOInsertBP().pushInsert((PMOAggVO[])((List)set.getValue()).toArray(new PMOAggVO[0]), false, "PPS");
		    	
		    	for(PMOAggVO agg:aggs){
		    		
		    		returnobj.add(agg);
		    		
		    	}
		       
		    }
		    
		    return returnobj.toArray(new PMOAggVO[returnobj.size()]);
		    
		}catch (Exception e) {
			
		     ExceptionUtils.marsh(e);
		     
		}
		
		return null;
		
	}

	@Override
	public RdPorductDetailVO[] DoRdPMO(RdPorductDetailVO[] objs) throws BusinessException {
		// TODO 自动生成的方法存根
		
		try{
			
			RdPorductDetailVO[] oldVo=(RdPorductDetailVO[])MDQueryUtil.lockValidateToRetrieveVO(objs);
			
			RdMakePMOBP action=new RdMakePMOBP();
			
			return action.MakeRdPMO(objs, oldVo);
			
		}catch(Exception e){
			throw new BusinessException(e);
		}

	}

	@Override
	public RdPorductDetailVO[] DoRePMO(RdPorductDetailVO[] objs) throws BusinessException {
		// TODO 自动生成的方法存根
		
		try{
			
			RdPorductDetailVO[] oldVo=(RdPorductDetailVO[])MDQueryUtil.lockValidateToRetrieveVO(objs);
			
			RdReturnPMOBP action=new RdReturnPMOBP();
			
			return action.ReturnPMO(objs, oldVo);
			
		}catch(Exception e){
			throw new BusinessException(e);
		}
	}

	@Override
	public SuperVO[] queryPmoVObyPks(String[] maids) throws BusinessException {
		// TODO 自动生成的方法存根
		
		String inSql = BDSqlInUtil.getInSql(maids, false);
		
		
		String sql="select ma.machcode machinecode,ma.machname machinename,a.cpmohid,billtype.billtypename ctrantypename,a.dbilldate,a.vbillcode,cus.code cuscode,cus.name cusname,dept.name dept,mat.code matcode,mat.name matname,mat.materialspec matspec,def.name splitstofftype,b.vdef4 silkwide,b.vdef5 elongation,b.vdef6 tension,nvl(b.vdef7,'N') spacer,b.vdef8 otherproduction,b.vdef9 tagline,b.vdef12 latitudedensity,b.vdef10 width,b.vdef11 length,zdw.name unit,b.nnum,fdw.name qunit,b.nastnum,b.tplanstarttime startdate,b.tplanendtime enddate from mm_pmo a";
		sql=sql+" left join mm_mo b on a.cpmohid=b.cpmohid";
		sql=sql+" left join bd_billtype billtype on a.ctrantypeid=billtype.pk_billtypeid";
		sql=sql+" left join bd_customer cus on b.vdef1=cus.pk_customer";
		sql=sql+" left join org_dept dept on b.cdeptid=dept.pk_dept";
		sql=sql+" left join so_machine ma on b.vdef2=ma.pk_maschine";
		sql=sql+" left join bd_material mat on b.cmaterialid=mat.pk_material";
		sql=sql+" left join bd_defdoc def on b.vdef3=def.pk_defdoc";
		sql=sql+" left join bd_measdoc zdw on b.cunitid=zdw.pk_measdoc";
		sql=sql+" left join bd_measdoc fdw on b.castunitid=fdw.pk_measdoc";
		sql=sql+" where a.dr=0 and b.dr=0 and b.vdef2 in "+inSql;
		
		PmoViewVO[] vos=(PmoViewVO[])executeQueryAppendableVOs(sql,PmoViewVO.class);
		
		return vos;
		
	}

	private <T> T[] executeQueryAppendableVOs(String sql,Class voclass) throws DAOException {
		
		return (T[])this.getDao().executeQuery(sql.toString(), new AppendBeanArrayProcessor(voclass));
	}

}
