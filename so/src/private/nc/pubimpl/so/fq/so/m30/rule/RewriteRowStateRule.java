package nc.pubimpl.so.fq.so.m30.rule;
 
import java.util.ArrayList;
import java.util.List;

import nc.bs.so.fq.state.pub.ShipOrderStateMachine;
import nc.bs.so.fq.state.row.RowCloseState;
import nc.bs.so.fq.state.row.RowOpenState;
import nc.impl.pubapp.bill.state.IState;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.so.qs.sc.DeliverReViewVO;

 
 
 
 
 
 
 
 public class RewriteRowStateRule implements IRule<DeliverReViewVO>
 {
   public RewriteRowStateRule() {}
   
   public void process(DeliverReViewVO[] vos)
   {
     RowOpenState openState = new RowOpenState();
     RowCloseState closeState = new RowCloseState();
     
     List<DeliverReViewVO> closeList = new ArrayList();
     List<DeliverReViewVO> openList = new ArrayList();
     for (DeliverReViewVO vo : vos) {
       if (openState.isRowOpen(vo)) {
         openList.add(vo);
       }
       if (closeState.isRowClose(vo)) {
         closeList.add(vo);
       }
     }
     setState(openList, openState);
     setState(closeList, closeState);
   }
   
   private void setState(List<DeliverReViewVO> list, IState<DeliverReViewVO> state) {
     int size = list.size();
     if (size <= 0) {
       return;
     }
     DeliverReViewVO[] views = new DeliverReViewVO[size];
     views = (DeliverReViewVO[])list.toArray(views);
     ShipOrderStateMachine bo = new ShipOrderStateMachine();
     bo.setState(state, views);
   }

   
 }

