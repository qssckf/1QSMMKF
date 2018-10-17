package nc.ui.so.fq01.billref.m30;

import java.awt.Container;

import nc.itf.scmpub.reference.uap.setting.defaultdata.DefaultDataSettingAccessor;
import nc.ui.pubapp.billref.src.DefaultBillReferQuery;
import nc.ui.pubapp.uif2app.query2.QueryConditionDLGDelegator;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.querytemplate.TemplateInfo;

public class M30RefFQ01BillReferQuery extends DefaultBillReferQuery{

	public M30RefFQ01BillReferQuery(Container c, TemplateInfo info) {
		super(c, info);
		// TODO 自动生成的构造函数存根
	}
	
	public void initQueryConditionDLG(QueryConditionDLGDelegator dlgDelegator){
		
		setDefaultPk_org(dlgDelegator);
		
		
	}

	private void setDefaultPk_org(QueryConditionDLGDelegator dlgDelegator) {
		
		String defaultOrg = null;
		try{
			
			 defaultOrg = DefaultDataSettingAccessor.getDefaultSaleOrg();
			
		}catch (Exception ex) {
			ExceptionUtils.wrappException(ex);
		}
		
		if ((defaultOrg != null) && (defaultOrg.trim().length() > 0)) {
			
			dlgDelegator.setDefaultValue("pk_org", defaultOrg);
			
		}

	}
	
}
