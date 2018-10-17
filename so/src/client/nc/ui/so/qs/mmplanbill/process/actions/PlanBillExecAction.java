package nc.ui.so.qs.mmplanbill.process.actions;

import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.KeyStroke;
import nc.ui.so.qs.mmplanbill.view.PlanListView;
import nc.bs.framework.common.NCLocator;
import nc.bs.uif2.BusinessExceptionAdapter;
import nc.bs.uif2.validation.IValidationService;
import nc.bs.uif2.validation.ValidationException;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.ui.so.qs.mmplanbill.process.model.PlanBillAppModel;
import nc.ui.uif2.CheckDataPermissionUtil;
import nc.ui.uif2.IShowMsgConstant;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.UIState;
import nc.ui.uif2.actions.EnableAction;
import nc.ui.uif2.editor.IEditor;
import nc.ui.uif2.model.AbstractAppModel;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.so.qs.sc.MmPlanBillVO;

public class PlanBillExecAction extends NCAction {

	public PlanBillExecAction(){
		
		this.setCode("expend");
		this.setBtnName("չ��");
		this.putValue("AcceleratorKey", KeyStroke.getKeyStroke((int)'E', Event.ALT_MASK));
		this.putValue(Action.SHORT_DESCRIPTION, "��������BOMչ�� (ALT+E)");
		
	}
	
	private IPlanBillSerive PlanService;
	private AbstractAppModel model;
	private IEditor editor;
	private IValidationService validationService;
	
	public IValidationService getValidationService() {
		return validationService;
	}


	public void setValidationService(IValidationService validationService) {
		this.validationService = validationService;
	}


	public AbstractAppModel getModel() {
		return model;
	}


	public void setModel(AbstractAppModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}


	public IEditor getEditor() {
		return editor;
	}


	public void setEditor(IEditor editor) {
		this.editor = editor;
	}


	public IPlanBillSerive getPlanService() {
		
		if(this.PlanService==null){
			this.PlanService=NCLocator.getInstance().lookup(IPlanBillSerive.class);
		}
		return PlanService;
	}
	
	

	public void doExpend() throws Exception {
		// TODO �Զ����ɵķ������
		
		Object value = this.getEditor().getValue();
		
		MmPlanBillVO pbVo=(MmPlanBillVO)value;
		
		pbVo.setSfexand(UFBoolean.TRUE);
		
		MmPlanBillVO[] ret=this.getPlanService().Expend(new MmPlanBillVO[]{pbVo});
		
		if(ret!=null && ret.length==1){
			
			MmPlanBillVO pdvo=ret[0];
			
			PlanBillAppModel model=((PlanBillAppModel)this.getModel());
			
			model.directlyUpdate(pdvo);
			
			model.getParentModel().directlyUpdate(pdvo);
			
			InitPlanBillDetail(pdvo.getPk_planbill());
			
			
		}
		
		ShowStatusBarMsgUtil.showStatusBarMsg("�������ȵ���"+pbVo.getVbillcode()+"��չ������BOM�ɹ������Կ�ʼ�Ų���", model.getContext());

	}
	
	public void InitPlanBillDetail(String pk_planbill) throws Exception{
		
		PlanBillAppModel model=((PlanBillAppModel)this.getModel());
		
		
		
		SuperVO[] plandetails=this.getPlanService().quyerPlanDetailVOs("pk_planbill='"+pk_planbill+"'");
		
		if(plandetails!=null && plandetails.length>0){
			((PlanListView)model.getParentForm()).getPlanDetailModel().initModel(plandetails);
		}else{
			((PlanListView)model.getParentForm()).getPlanDetailModel().initModel(null);
		}
		
		
	}
	

	@Override
	protected boolean isActionEnable() {
		// TODO �Զ����ɵķ������
		
		//���ɱ߽�״̬������δչ��ʱ����ִ��
		
		return (getModel().getUiState() == UIState.NOT_EDIT) && (this.getModel().getSelectedData() != null) && (isCurrentDataEnable());
	}


	public boolean isCurrentDataEnable(){
		// TODO �Զ����ɵķ������
		
		try{
			
			MmPlanBillVO vo = (MmPlanBillVO)getModel().getSelectedData();
			
			if(vo!=null){
				
				Boolean newflag=this.getPlanService().QueryPlanBillIsExists(vo.getPk_planbill());
				
				if(UFBoolean.FALSE.equals(vo.getSfexand()) && newflag){
					return true;
				}else if(UFBoolean.TRUE.equals(vo.getSfexand())){
					return false;
				}
				
				
			}else{
				return false;
			}
			
			
		}catch(Exception e){
			getExceptionHandler().handlerExeption(e);
		}
		

		return false;	
		
		
	}


	@Override
	public void doAction(ActionEvent event) throws Exception {
		// TODO �Զ����ɵķ������
		
		validate();
		
		doExpend();
		
	}


	private void validate() {
		// TODO �Զ����ɵķ������
		
		SuperVO vo = (SuperVO)getModel().getSelectedData();
		
		if (this.validationService != null) {
		  try {
		    this.validationService.validate(vo);
		  } catch (ValidationException e) {
		    throw new BusinessExceptionAdapter(e);
		  }
		}
		
	}

	
	
	
	

}