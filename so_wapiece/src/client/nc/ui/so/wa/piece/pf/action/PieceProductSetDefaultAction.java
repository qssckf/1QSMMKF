package nc.ui.so.wa.piece.pf.action;

import java.awt.event.ActionEvent;

import nc.bs.framework.common.NCLocator;
import nc.itf.so.wa.piece.IPieceWaMaintain;
import nc.itf.so.wa.piece.pf.IPieceProductVOMaintain;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.model.BatchBillTableModel;

public class PieceProductSetDefaultAction extends NCAction{
	
	private IPieceProductVOMaintain service;
	
	public IPieceProductVOMaintain getService() {
		
		if(this.service==null){
			this.service=NCLocator.getInstance().lookup(IPieceProductVOMaintain.class);
		}
		
		return this.service;
	}

	public PieceProductSetDefaultAction(){
		this.setBtnName("设为默认");
		this.setCode("SetDefault");
	}

	private BatchBillTableModel model = null;
	
	public BatchBillTableModel getModel() {
		return model;
	}

	public void setModel(BatchBillTableModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO 自动生成的方法存根
		
		
		
	}

}
