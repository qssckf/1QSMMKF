package nc.ui.so.qs.sc.maschine.actions;

//import nc.bs.bd.service.ValueObjWithErrLog;
import nc.bs.bd.service.ValueObjWithErrLog;
import nc.ui.bd.pub.actions.BDEnableAction;
//import nc.ui.so.xlx.tran.driver.service.DriverAppModelService;
import nc.ui.so.qs.sc.maschine.service.MaschineMaintainService;
import nc.ui.uif2.UIState;
import nc.vo.jcom.lang.StringUtil;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;
import nc.vo.so.qs.sc.AggMaschineVO;
import nc.vo.so.qs.sc.MaschineVO;

public class MaschineEnableAction1 extends BDEnableAction {
	
	
	private String StatusField=null;
	private String StatusValue=null;
	
	public String getStatusField() {
		return StatusField;
	}

	public void setStatusField(String statusField) {
		StatusField = statusField;
	}

	public String getStatusValue() {
		return StatusValue;
	}

	public void setStatusValue(String statusValue) {
		StatusValue = statusValue;
	}

	public MaschineEnableAction1(){
		this.setStatusField("mstatus");
		this.setStatusValue("1");
	}
	
	@Override
	public Object doEnable(Object obj) throws Exception {
		// TODO 自动生成的方法存根
//		IBill[] reVoErrLog = getService().MaschineEnable(obj);
//		return reVoErrLog.getVos()[0];
		return null;
	}
	
	@Override
	protected boolean isActionEnable() {
		// TODO 自动生成的方法存根
		return (getModel().getUiState() == UIState.NOT_EDIT) && (this.getModel().getSelectedData() != null) && (isCurrentDataEnable());
	}

	@Override
	public boolean isCurrentDataEnable() {
		// TODO 自动生成的方法存根
//		CircularlyAccessibleValueObject vo = (CircularlyAccessibleValueObject)getModel().getSelectedData();
		
	
		AggMaschineVO v1 = (AggMaschineVO)getModel().getSelectedData();
		MaschineVO vo = v1.getParentVO();
		
		if(StringUtil.isEmpty(this.getStatusField())){
			this.setStatusField("enablestate");
		}
		
		return (vo.getAttributeValue(this.getStatusField()) != null) && ("0".toString().equals(vo.getAttributeValue(this.getStatusField()).toString()) || "2".equals(vo.getAttributeValue(this.getStatusField())));
	}

	
	
	public MaschineMaintainService getService() {
		
		MaschineMaintainService service=(MaschineMaintainService)((BillManageModel)getModel()).getService();
		return service;
	}
	
	

}
