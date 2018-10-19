package nc.ui.so.shipmentsinfo.ace.handler;

import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
//import nc.ui.so.shipmentsinfo.handler.AstNumEditHandler;
import nc.ui.so.m38.billui.editor.bodyevent.AstUnitEditHandler;
import nc.ui.so.m38.billui.editor.bodyevent.LargessFlagEditHandler;
import nc.ui.so.m38.billui.editor.bodyevent.NumEditHandler;
import nc.ui.so.pub.util.BodyEditEventUtil;
import nc.ui.so.shipmentsinfo.handler.MaterialEditHandler;
import nc.vo.so.qs.sc.ShipmentsBVO;
/**
 *单据表体字段编辑后事件
 * 
 * @since 6.0
 * @version 2011-7-12 下午08:17:33
 * @author duy
 */
public class AceBodyAfterEditHandler implements IAppEventHandler<CardBodyAfterEditEvent> {
	private ShowUpableBillForm editor;
	
	public AceBodyAfterEditHandler() {}
	
	public ShowUpableBillForm getEditor()
	{
	  return this.editor;
	}
	
	
    @Override
    public void handleAppEvent(CardBodyAfterEditEvent e) {
        
//    	String key = e.getKey();
//        if (key.equals("cateralvid")) {
//            nc.ui.so.shipmentsinfo.handler.MaterialHandler handler = new nc.ui.so.shipmentsinfo.handler.MaterialHandler();
//            handler.afterEdit(e);
//        }
    	
       int[] editrows = BodyEditEventUtil.getInstance().getAfterEditRow(e);
       if (null == editrows) {
         return;
       }
       
       BillCardPanel cardPanel = e.getBillCardPanel();
       boolean istotalshow = cardPanel.getBodyPanel().isTatolRow();
       cardPanel.getBodyPanel().setTotalRowShow(false);
       
       String editKey = e.getKey();
       
       if ("cmaterialvid".equals(editKey)) {
    	   MaterialEditHandler handler = new MaterialEditHandler();
    	   handler.afterEdit(e);
       }
       else if ("nastnum".equals(editKey)) {
//    	   AstNumEditHandler handler = new AstNumEditHandler();
//    	   handler.afterEdit(e);
       }
       else if ("nnum".equals(editKey)) {
    	   NumEditHandler handler = new NumEditHandler();
    	   handler.afterEdit(e);
       }
       else if ("castunitid".equals(editKey)) {
    	   AstUnitEditHandler handler = new AstUnitEditHandler();
    	   handler.afterEdit(e);
       }
       else if ("blargessflag".equals(editKey)) {
    	   LargessFlagEditHandler handler = new LargessFlagEditHandler();
    	   handler.afterEdit(e);
       }
       
    }
    
    public void setEditor(ShowUpableBillForm editor)
    {
      this.editor = editor;
    }
}
