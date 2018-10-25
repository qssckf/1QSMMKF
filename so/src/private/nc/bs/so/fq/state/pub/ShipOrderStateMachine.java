package nc.bs.so.fq.state.pub;

import nc.impl.pubapp.bill.state.IState;
import nc.vo.so.m38.entity.PreOrderVO;
import nc.vo.so.m38.entity.PreOrderViewVO;
import nc.vo.so.qs.sc.AggShipmentsVO;
import nc.vo.so.qs.sc.DeliverReViewVO;



public class ShipOrderStateMachine {
	
	private nc.impl.pubapp.bill.state.TwainStateMachine<AggShipmentsVO, DeliverReViewVO> machine;
	
	public ShipOrderStateMachine(){
		
		this.machine = new nc.impl.pubapp.bill.state.TwainStateMachine(AggShipmentsVO.class, DeliverReViewVO.class);
		
	}
	
	public void setState(IState<DeliverReViewVO> state, DeliverReViewVO[] vos){
		this.machine.setRowState(state, vos);
	}
	
	public void setState(IState<AggShipmentsVO> state, AggShipmentsVO[] vos) {
		this.machine.setBillState(state, vos);
	}

}
