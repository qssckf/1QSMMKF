package nc.ui.so.wa.piece.pf.action;

import nc.ui.pubapp.uif2app.actions.batch.BatchAddLineAction;
import nc.vo.so.wa.piece.PieceProductVO;

public class PieceProductVOAddLineAction extends BatchAddLineAction {

  private static final long serialVersionUID = 1L;
  
  @Override
  protected void setDefaultData(Object obj) {
    super.setDefaultData(obj);
    PieceProductVO baseDocVO = (PieceProductVO) obj;
    baseDocVO.setPk_group(this.getModel().getContext().getPk_group());
    baseDocVO.setPk_org(this.getModel().getContext().getPk_org());
  }


}
