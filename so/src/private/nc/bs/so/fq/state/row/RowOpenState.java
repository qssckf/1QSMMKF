package nc.bs.so.fq.state.row;
 
 import java.util.ArrayList;
 import java.util.List;

import nc.bs.so.fq.plugin.StatePlugInPoint;
import nc.bs.so.fq.state.pub.BillStateUtil;
import nc.bs.so.fq.state.pub.StateCalculateUtil;
import nc.impl.pubapp.bill.state.AbstractRowState;
import nc.impl.pubapp.bill.state.IState;
import nc.impl.pubapp.bill.state.ITransitionState;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pubapp.pattern.log.TimeLog;
import nc.vo.so.m38.entity.PreOrderViewVO;
import nc.vo.so.qs.sc.AggShipmentsVO;
import nc.vo.so.qs.sc.AggShipmentsVOMeta;
import nc.vo.so.qs.sc.DeliverReViewVO;
import nc.vo.so.qs.sc.ShipmentsBVO;

 

 public class RowOpenState extends AbstractRowState<DeliverReViewVO> implements ITransitionState<DeliverReViewVO, AggShipmentsVO>
 {
   private StateCalculateUtil stateCalculateUtil;
   
   public RowOpenState()
   {
     super(ShipmentsBVO.class, "blineclose", UFBoolean.FALSE);
   }
   
 

   
   public boolean isAutoTransitable(DeliverReViewVO vo)
   {
     if ((isThisState(vo)) || (!isPrevStateValid(vo))) {
       return false;
     }
     return getStateCalculateUtil().isAutoTransitRowOpen(vo);
   }
   
 
   public boolean isPrevStateValid(DeliverReViewVO vo)
   {
     BillStateUtil statePriority = new BillStateUtil();
     return statePriority.canBeExecuteState(vo);
   }
   
 
 
   public boolean isRowOpen(DeliverReViewVO vo)
   {
     if ((isThisState(vo)) || (!isPrevStateValid(vo))) {
       return false;
     }
     return getStateCalculateUtil().isRowOpen(vo);
   }
   
   public List<IState<DeliverReViewVO>> next()
   {
     List<IState<DeliverReViewVO>> list = new ArrayList();
     
     return list;
   }
   
   public void setState(DeliverReViewVO[] views)
   {
     AroundProcesser<DeliverReViewVO> processer = new AroundProcesser(StatePlugInPoint.RowOpenState);
     
     TimeLog.logStart();
     DeliverReViewVO[] vos = (DeliverReViewVO[])processer.before(views);
     TimeLog.info("行打开前执行业务规则");
     
     TimeLog.logStart();
     super.setState(vos);
     TimeLog.info("修改表体状态为行打开");
     
     TimeLog.logStart();
     processer.after(vos);
     
     TimeLog.info("行打开后执行业务规则");
   }
   
   private StateCalculateUtil getStateCalculateUtil() {
     if (this.stateCalculateUtil == null) {
       this.stateCalculateUtil = new StateCalculateUtil();
     }
     return this.stateCalculateUtil;
   }




   @Override
   public IState<AggShipmentsVO> getTransitTargetState() {
	// TODO 自动生成的方法存根
	   return null;
   }






   
}

