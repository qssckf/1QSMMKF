package nc.impl.so.qs.appinterface.mobileapprove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.lang.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.pub.pf.PfUtilTools;
import nc.bs.wfengine.engine.ActivityInstance;
import nc.impl.pubapp.pattern.database.DataAccessUtils;
import nc.itf.org.IOrgUnitQryService;
import nc.itf.scmpub.reference.uap.para.SysParaInitQuery;
import nc.itf.so.qs.appinterface.MobileApprove.IMobileApproveService;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.itf.uap.pf.IWorkflowDefine;
import nc.itf.uap.pf.IWorkflowMachine;
import nc.itf.uap.pf.IplatFormEntry;
import nc.itf.uap.pf.metadata.IFlowBizItf;
import nc.md.MDBaseQueryFacade;
import nc.md.model.IBusinessEntity;
import nc.md.model.MetaDataException;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.md.persist.framework.MDPersistenceService;
import nc.ui.pf.multilang.PfMultiLangUtil;
import nc.ui.pubapp.pub.common.context.PFlowContext;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.ml.NCLangRes4VoTransl;
import nc.vo.org.OrgVO;
import nc.vo.pf.mobileapp.ITaskType;
import nc.vo.pf.mobileapp.MobileAppUtil;
import nc.vo.pf.mobileapp.TaskMetaData;
import nc.vo.pf.mobileapp.query.TaskQuery;
import nc.vo.pf.mobileapp.query.UserMatcher;
import nc.vo.pf.mobileapp.query.UserQuery;
import nc.vo.pf.pub.util.ArrayUtil;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pub.para.SysInitVO;
import nc.vo.pub.pf.AssignableInfo;
import nc.vo.pub.pf.Pfi18nTools;
import nc.vo.pub.workflownote.WorkflownoteVO;
import nc.vo.pubapp.pattern.data.IRowSet;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;
import nc.vo.pubapp.pattern.model.transfer.bill.ClientBillToServer;
import nc.vo.pubapp.pattern.pub.Constructor;
import nc.vo.sm.UserVO;
import nc.vo.so.m38.entity.PreOrderBVO;
import nc.vo.so.m38.entity.PreOrderHVO;
import nc.vo.so.m38.entity.PreOrderVO;
import nc.vo.so.qs.appinterface.query.AbstractRefDataQuery;
import nc.vo.so.qs.appinterface.query.BomChinfoQuery;
import nc.vo.so.qs.appinterface.query.BomVerinfoQuery;
import nc.vo.so.qs.appinterface.query.ExApproveDetailQuery;
import nc.vo.so.qs.appinterface.query.PaginationQueryFacade;
import nc.vo.so.qs.appinterface.util.BillQuery;
import nc.vo.so.qs.appinterface.util.ExMobileAppUtil;
import nc.vo.so.qs.appinterface.util.IBillType;
import nc.vo.so.qs.appinterface.vostaticinfo.MoblieVoStatic;
import nc.vo.uap.pf.OrganizeUnit;
import nc.vo.uap.wfmonitor.ProcessRouteRes;
import nc.vo.wfengine.core.activity.Activity;
import nc.vo.wfengine.core.activity.GenericActivityEx;
import nc.vo.wfengine.core.activity.SubFlow;
import nc.vo.wfengine.core.parser.UfXPDLParser;
import nc.vo.wfengine.core.participant.Participant;
import nc.vo.wfengine.core.workflow.WorkflowProcess;
import nc.vo.wfengine.definition.WorkflowTypeEnum;
import nc.vo.wfengine.pub.WfTaskOrInstanceStatus;
import nc.vo.wfengine.pub.WfTaskType;

public class MobileApproveServiceImpl implements IMobileApproveService {

	private DataAccessUtils dao;
	private IPlanBillSerive PlanService;
	private IMDPersistenceQueryService mdservice;
	
	private IMDPersistenceQueryService getMDQueryService() {
		
		if(this.mdservice==null){
			this.mdservice=MDPersistenceService.lookupPersistenceQueryService();
		}
		
		return this.mdservice;
	}
 
	 
	public IPlanBillSerive getPlanService() {
		
		if(this.PlanService==null){
			this.PlanService=NCLocator.getInstance().lookup(IPlanBillSerive.class);
		}
		return PlanService;
	}
	
	public DataAccessUtils getDao() {
    	
    	if(dao==null){
    		dao=new DataAccessUtils();
    	}
		return dao;
	}
	
	
	@Override
	public List<Map<String, Object>> getPFTaskList(String pk_group,String userid, String date, String statuskey, String statuscode,String cond, int startline, int count, int pagenum) throws BusinessException {
		// TODO 自动生成的方法存根
		
		ITaskType taskType = ExMobileAppUtil.getTaskType(statuskey, statuscode);
		TaskQuery query = taskType.createNewTaskQuery();
		
		query.setPk_group(pk_group);
		query.setCuserid(userid);
		query.setDate(date);
		query.setTaskType(taskType);

		
		List<Map<String, Object>> list = PaginationQueryFacade.getInstance().query(query,startline,count,pagenum);
		
		return list;
	}

	@Override
	public Map<String, Object> getTaskBill(String groupid, String userid,String taskid, String statuskey, String statuscode) throws BusinessException {
		// TODO 自动生成的方法存根
		
		ITaskType taskType = ExMobileAppUtil.getTaskType(statuskey, statuscode);
		TaskQuery query = taskType.createNewTaskQuery();
		
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
			InvocationInfoProxy.getInstance().setGroupId(groupid);
		}
     
 
		Object obj = query.queryTaskBill(taskid);
     
		TaskMetaData tmd = query.queryTaskMetaData(taskid);
     
		String pk_billtype = tmd.getBillType();
		String billTypeName = Pfi18nTools.i18nBilltypeName(pk_billtype);
     
		Map<String, Object> map = ExMobileAppUtil.createHashMap();
		map.put("taskbill", obj);
		map.put("billtypename", billTypeName);
     
		return map;
		

	}

	@Override
	public Map<String, Object> getUserInfo(String usercode, String date) throws Exception {
		// TODO 自动生成的方法存根
		
		Map<String, Object> retobj=new HashMap();
		
		String sql="select us.pk_group,us.cuserid,us.user_code,us.user_name,us.pk_base_doc,job.pk_hrorg,dept.pk_dept,dept.name from sm_user us left join hi_psnjob job on us.pk_base_doc=job.pk_psndoc and job.ismainjob='Y' and job.poststat='Y' left join org_dept dept on job.pk_dept=dept.pk_dept where us.user_code='"+usercode+"' and us.abledate<='"+date+"'";
		
		IRowSet rs=this.getDao().query(sql);
		
		JSONArray jsonarry=new JSONArray();
		
		if(rs.next()){
			
			JSONObject json1=new JSONObject();
			
			json1.put("pk_group", rs.getString(0));
			json1.put("userid", rs.getString(1));
			json1.put("user_code", rs.getString(2));
			json1.put("user_name", rs.getString(3));
			if(rs.getString(4)!=null){
				json1.put("pk_psndoc", rs.getString(4));
			}
			if(rs.getString(5)!=null){
				json1.put("pk_org", rs.getString(5));
			}
			if(rs.getString(6)!=null){
				json1.put("pk_dept", rs.getString(6));
			}
			if(rs.getString(7)!=null){
				json1.put("deptname", rs.getString(7));
			}
			
			retobj.put("psninfo", json1);
			
			String user=rs.getString(1);
			
			sql="select func.funcode,func.fun_name from sm_user_role ur inner join sm_perm_func pfunc on ur.pk_role=pfunc.subjectid inner join (select pk_responsibility,busi_pk from sm_resp_func group by pk_responsibility,busi_pk) rfunc on pfunc.ruleid=rfunc.pk_responsibility inner join sm_funcregister func on rfunc.busi_pk=func.funcode where func.funcode like '%400630%' and cuserid='"+user+"'";
			
			IRowSet rs1=this.getDao().query(sql);
			
			while(rs1.next()){
				
				JSONObject json=new JSONObject();
				
				json.put("funcode", rs1.getString(0));
				json.put("funname", rs1.getString(1));
				
				jsonarry.put(json);
				
			}

		}else{
			throw new BusinessException("没有找到用户信息！");
		}
		
		retobj.put("perminfo", jsonarry);
		
		return retobj;

	}

	@Override
	public Map<String, Object> getApprovedDetail(String groupid, String userid,String taskid, String statuskey, String statuscode, int startline,int count) throws Exception {
		// TODO 自动生成的方法存根
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
			InvocationInfoProxy.getInstance().setGroupId(groupid);
		}
		
		TaskMetaData tmd =  ExMobileAppUtil.queryTaskMetaData(statuskey, statuscode, taskid);
		
		ExApproveDetailQuery query = new ExApproveDetailQuery(tmd);
		List<Map<String, Object>> detailList = PaginationQueryFacade.getInstance().query(query, startline, count,1);
		
			
		Map<String, Object> resultMap = ExMobileAppUtil.createHashMap();
		
		JSONObject json=new JSONObject();
		
		json.put("billname", tmd.getBillNo());
		json.put("billtypename", Pfi18nTools.i18nBilltypeName(tmd.getBillType()));
		json.put("flowhistory", ((Map)detailList.get(0)).get("flowhistory"));
		
		resultMap.put("ApproveDetail", json);
		
		return resultMap;
		

	}

	@Override
	public Map<String, Object> getUserList(String groupid, String userid,String taskid, int startline, int count, String condition) throws BusinessException {
		// TODO 自动生成的方法存根
		
		
		List<Map<String, Object>> list = null;
	    
	    if (StringUtil.isEmptyWithTrim(condition)) {
	      UserQuery query = new UserQuery(groupid);
	      list = PaginationQueryFacade.getInstance().query(query, startline, count,1);
	    }
	    else {
	      UserMatcher matcher = new UserMatcher();
	      List<UserVO> matched = matcher.matchAll("pk_group='" + groupid + "'", condition);
	      List<UserVO> paginated = MobileAppUtil.subList(matched, startline, count);
	      
	      list = MobileAppUtil.createArrayList();
	      
	      for (UserVO uvo : paginated) {
	        Map<String, Object> map = MobileAppUtil.createHashMap();
	        
	        map.put("id", uvo.getCuserid());
	        map.put("code", uvo.getUser_code());
	        map.put("name", PfMultiLangUtil.getSuperVONameOfCurrentLang(uvo, "user_name"));
	        
	        list.add(map);
	      }
	    }
	    
	    Map<String, Object> result = MobileAppUtil.createHashMap();
	    result.put("psnstructlist", list);
	    
	    return result;
		
	}

	@Override
	public Map<String, Object> doAgree(String groupid, String userid,String taskid, String note, String cuserids) throws BusinessException {
		// TODO 自动生成的方法存根
		
		List<String> AssignUser=new ArrayList();
		  
		  if(cuserids != null){
			  
			  String[] users=cuserids.split(",");
			  
			  for(String user:users){
				  
				  if(!"nvl".equals(user)){
					  AssignUser.add(user);
				  }

			  }
			  
		  }
		  
		  
		  if(InvocationInfoProxy.getInstance().getGroupId()==null){
				InvocationInfoProxy.getInstance().setGroupId(groupid);
		  }
		  
		  InvocationInfoProxy.getInstance().setUserId(userid);
		  
		  
		  TaskMetaData tmd = ExMobileAppUtil.queryTaskMetaData("ishandled", "unhandled", taskid);
	 
	     
		  String billtype = tmd.getBillType();
		  String billid = tmd.getBillId();
		  String result = "Y";
	     
		  String[] assigned = null;
		  if (!ArrayUtil.isNull(AssignUser)) {
			  assigned = (String[])AssignUser.toArray(new String[0]);
		  }
		  
		  try{
	       PfUtilTools.approveSilently(billtype, billid, result, note, userid, assigned);
	     } catch (Exception e) {
	    	 ExMobileAppUtil.handleException(e);
	     }
		  
		  HashMap<String, Object> retobj=ExMobileAppUtil.createHashMap();
		  
		  retobj.put("appresult", "successed");
	     
		  return retobj;
	}

	@Override
	public Map<String, Object> getAssignPsnList(String groupid, String userid,String taskid, String isagree, int startline, int count,String condition) throws Exception {
		// TODO 自动生成的方法存根
		
		 if(InvocationInfoProxy.getInstance().getGroupId()==null){
				InvocationInfoProxy.getInstance().setGroupId(groupid);
		  }
		  
		  InvocationInfoProxy.getInstance().setUserId(userid);
			
		  WorkflownoteVO note = ExMobileAppUtil.checkWorkflow(taskid);
		  Vector<AssignableInfo> assignInfos = note.getTaskInfo().getAssignableInfos();
	    

		  List<Map<String, Object>> resultList = ExMobileAppUtil.createArrayList();
		  Map<String, String> useridDispatchIdMap = new HashMap();
		  String strCriterion;
		  Iterator i$; 
		  if ((assignInfos != null) && (assignInfos.size() > 0)) {
	      strCriterion = null;
	      for (i$ = assignInfos.iterator(); i$.hasNext();) 
	      { 
	    	  AssignableInfo ai = (AssignableInfo)i$.next();
	    	  strCriterion = ai.getCheckResultCriterion();
	        
	    	  if (((UFBoolean.valueOf(isagree).booleanValue()) && ((AssignableInfo.CRITERION_NOTGIVEN.equals(strCriterion)) || (AssignableInfo.CRITERION_PASS.equals(strCriterion)))) || ((!UFBoolean.valueOf(isagree).booleanValue()) && ((AssignableInfo.CRITERION_NOTGIVEN.equals(strCriterion)) || (AssignableInfo.CRITERION_NOPASS.equals(strCriterion)))))
	    	  {

	    		  Vector<OrganizeUnit> vt = ai.getOuUsers();
	          
	    		  if ((vt != null) && (vt.size() > 0)) {
	    		  for (OrganizeUnit ou : vt) {
	    			  Map<String, Object> map = ExMobileAppUtil.createHashMap();

	    			  String id = ou.getPk() + "#" + ai.getActivityDefId();

	    			  useridDispatchIdMap.put(ou.getPk(), id);
	              
	    			  map.put("id", id);
	    			  map.put("code", ou.getCode());
	    			  map.put("name", ou.getName());
	              
	    			  resultList.add(map);
	    		  }
	    		 }
	        }
	      }
	    }
	    AssignableInfo ai;
	    if (!StringUtil.isEmptyWithTrim(condition))
	    {
	      Map<Object, Map<String, Object>> converted = ExMobileAppUtil.convertToMap(resultList, "id");
	      
	      UserMatcher matcher = new UserMatcher();
	      
	      Set<String> cuseridSet = new HashSet();
	      
	      Iterator<Object> it = converted.keySet().iterator();
	      while (it.hasNext()) {
	        String id = (String)it.next();
	        id = id.substring(0, id.indexOf("#"));
	        
	        cuseridSet.add(id);
	      }
	      
	      List<UserVO> matched = matcher.matchWithin((String[])cuseridSet.toArray(new String[0]), condition);
	      

	      resultList = ExMobileAppUtil.createArrayList();
	      
	      for (UserVO uvo : matched) {
	        Map<String, Object> map = ExMobileAppUtil.createHashMap();
	        
	        map.put("id", useridDispatchIdMap.get(uvo.getCuserid()));
	        map.put("code", uvo.getUser_code());
	        map.put("name", PfMultiLangUtil.getSuperVONameOfCurrentLang(uvo, "user_name"));
	        

	        resultList.add(map);
	      }
	    }
	    
	    if ((resultList != null) && (resultList.size() > 0)) {
	      try {
	        Map<String, Object>[] array = (Map[])resultList.toArray(new Map[0]);
	        
	        Arrays.sort(array, new Comparator()
	        {
	          public int compare(Object o1, Object o2)
	          {
	            if (((o1 instanceof Map)) && ((o2 instanceof Map))) {
	              Object name1 = ((Map)o1).get("name");
	              Object name2 = ((Map)o2).get("name");
	              
	              if (((name1 instanceof String)) && ((name2 instanceof String)))
	              {
	                return ((String)name1).compareToIgnoreCase((String)name2);
	              }
	            }
	            

	            return 0;
	          }
	          

	        });
	        List<Map<String, Object>> tempList = ExMobileAppUtil.createArrayList();
	        

	        for (Map<String, Object> row : array) {
	          tempList.add(row);
	        }
	        
	        resultList = tempList;
	      } catch (Exception e) {
	        Logger.error(e.getMessage(), e);
	      }
	    }
	    
	    resultList = ExMobileAppUtil.subList(resultList, startline, count);
	    
	    
		  
		JSONArray jsons=new JSONArray();
		    
		for(Map<String,Object> map:resultList){
		    	
			JSONObject json=new JSONObject();
		    	
		    json.put("id", map.get("id"));
		    json.put("code", map.get("code"));
		    json.put("name", map.get("name"));
		    	
		    jsons.put(json);
		    	
		    	
	   }
	    
	    Map<String, Object> resultMap = ExMobileAppUtil.createHashMap();
	    resultMap.put("psnstructlist", jsons);
	    
	    return resultMap;
		

	}

	@Override
	public Map<String, Object> doDisAgree(String groupid, String userid,String taskid, String note, String cuserids) throws BusinessException {
		// TODO 自动生成的方法存根

		  if(InvocationInfoProxy.getInstance().getGroupId()==null){
				InvocationInfoProxy.getInstance().setGroupId(groupid);
		  }
		  
		  InvocationInfoProxy.getInstance().setUserId(userid);
			 
		  List<String> AssignUser=new ArrayList();
		  
		  if(cuserids != null){
			  
			  String[] users=cuserids.split(",");
			  
			  for(String user:users){
				  
				  if(!"nvl".equals(user)){
					  AssignUser.add(user);
				  }
				  


			  }
			  
		  } 
		  
		  TaskMetaData tmd = ExMobileAppUtil.queryTaskMetaData("ishandled", "unhandled", taskid);
	    

		  String billtype = tmd.getBillType();
		  String billid = tmd.getBillId();
		  String result = "N";
	    
		  String[] assigned = null;
		  if (!ArrayUtil.isNull(AssignUser)) {
			  assigned = (String[])AssignUser.toArray(new String[0]);
		  }
	    
		  try
		  {
			  PfUtilTools.approveSilently(billtype, billid, result, note, userid, assigned);
		  } catch (Exception e) {
			  ExMobileAppUtil.handleException(e);
		  }
		  
		  HashMap<String, Object> retobj=ExMobileAppUtil.createHashMap();
		  
		  retobj.put("appresult", "successed");
		     
		  return retobj;
	}

	@Override
	public Map<String, Object> doReject(String groupid, String userid,String taskid, String note, String nodeid) throws BusinessException {

		// TODO 自动生成的方法存根
		
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
			
			  InvocationInfoProxy.getInstance().setGroupId(groupid);
		}
		  
		InvocationInfoProxy.getInstance().setUserId(userid);
		
		
	    TaskMetaData tmd = ExMobileAppUtil.queryTaskMetaData("ishandled", "unhandled", taskid);
		
		String billtype = tmd.getBillType();
		String billid = tmd.getBillId();
		AggregatedValueObject billvo = ExMobileAppUtil.queryBillEntity(billtype, billid);
		
		IWorkflowMachine srv = (IWorkflowMachine)NCLocator.getInstance().lookup(IWorkflowMachine.class);
		WorkflownoteVO worknoteVO = srv.checkWorkFlow("APPROVE", tmd.getBillType(), billvo, null);
		
		
		worknoteVO.setChecknote(note);
		worknoteVO.setApproveresult("R");
		worknoteVO.getTaskInfo().getTask().setTaskType(WfTaskType.Backward.getIntValue());
		worknoteVO.getTaskInfo().getTask().setSubmit2RjectTache(false);
		
		if (StringUtil.isEmptyWithTrim(nodeid)) {
		  worknoteVO.getTaskInfo().getTask().setBackToFirstActivity(true);
		  worknoteVO.getTaskInfo().getTask().setJumpToActivity(null);
		} else {
		  worknoteVO.getTaskInfo().getTask().setBackToFirstActivity(false);
		  worknoteVO.getTaskInfo().getTask().setJumpToActivity(nodeid);
		}
		
		
		
		IplatFormEntry entry = (IplatFormEntry)NCLocator.getInstance().lookup(IplatFormEntry.class);
		entry.processAction("APPROVE", billtype, worknoteVO, billvo, null, ExMobileAppUtil.createHashMap());
		
		HashMap<String, Object> retobj=ExMobileAppUtil.createHashMap();
		  
		retobj.put("appresult", "successed");
	     
		return retobj;
		
	
	}

	@Override
	public Map<String, Object> getRejectNodeList(String pk_group,String userid, String taskid, int startline,int count, String condition) throws Exception {
		// TODO 自动生成的方法存根
		

		// TODO 自动生成的方法存根
		
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
				
			  InvocationInfoProxy.getInstance().setGroupId(pk_group);
		}
		  
		InvocationInfoProxy.getInstance().setUserId(userid);
		
		
		TaskMetaData tmd = ExMobileAppUtil.queryTaskMetaData("ishandled", "unhandled", taskid);
		WorkflownoteVO worknoteVO = ExMobileAppUtil.checkWorkflow(taskid);
		
		IWorkflowDefine srv = (IWorkflowDefine)NCLocator.getInstance().lookup(IWorkflowDefine.class);
		
		List<ProcessRouteRes> prrList = new ArrayList();
		     
		String billid = tmd.getBillId();
		String billtype = tmd.getBillType();
		     
		int workflowType = worknoteVO.getWorkflow_type().intValue();
		if (workflowType == WorkflowTypeEnum.SubWorkApproveflow.getIntValue()) {
		  String pk_wf_instance = worknoteVO.getTaskInfo().getTask().getWfProcessInstancePK();
		  ProcessRouteRes prr = srv.queryProcessRoute(tmd.getBillId(), tmd.getBillType(), pk_wf_instance, workflowType);
		  
		  prrList.add(prr);
		} else if (workflowType == WorkflowTypeEnum.SubApproveflow.getIntValue()) {
		  ProcessRouteRes prr = srv.queryProcessRoute(tmd.getBillId(), tmd.getBillType(), null, WorkflowTypeEnum.Approveflow.getIntValue());
		  prrList.add(prr);
		  
		  String pk_wf_instance = worknoteVO.getTaskInfo().getTask().getWfProcessInstancePK();
		  prr = srv.queryProcessRoute(billid, billtype, pk_wf_instance, workflowType);
		  prrList.add(prr);
		} else {
		  ProcessRouteRes prr = srv.queryProcessRoute(tmd.getBillId(), tmd.getBillType(), null, WorkflowTypeEnum.Approveflow.getIntValue());
		  prrList.add(prr);
		}
		
		
		try
		{
		  List<Map<String, Object>> resultList = getCheckedActivities((ProcessRouteRes[])prrList.toArray(new ProcessRouteRes[0]), condition);
		  
		
		  resultList = ExMobileAppUtil.subList(resultList, startline, count);
		  
		  
		  JSONArray jsons=new JSONArray();
		    
			for(Map<String,Object> map:resultList){
			    	
				JSONObject json=new JSONObject();
			    	
			    json.put("id", map.get("id"));
			    json.put("code", map.get("code"));
			    json.put("name", map.get("name"));
			    	
			    jsons.put(json);
			    	
			    	
		   }
		  
		  Map<String, Object> map = ExMobileAppUtil.createHashMap();
		  map.put("psnstructlist", jsons);
		  
		  return map;
		  
		} catch (Exception e) {
		 
			ExMobileAppUtil.handleException(e); 
		  
		}
		
		return null;

	
	}
	
	private List<Map<String, Object>> getCheckedActivities(ProcessRouteRes[] prs, String matchString) throws Exception{
		
	     List<Map<String, Object>> resultList = ExMobileAppUtil.createArrayList();
	     
	     if (prs != null) {
	       for (ProcessRouteRes p : prs) {
	         ActivityInstance[] ais = p.getActivityInstance();
	         WorkflowProcess wp = null;
	         if (p.getXpdlString() != null) {
	           String def_xpdl = p.getXpdlString().toString();
	           wp = UfXPDLParser.getInstance().parseProcess(def_xpdl);
	         }
	         
	         if (wp != null) {
	           for (ActivityInstance inst : ais) {
	             if (inst.getStatus() == WfTaskOrInstanceStatus.Finished.getIntValue())
	             {
	 
	 
	               Activity act = wp.findActivityByID(inst.getActivityID());
	               
	               if ((act instanceof GenericActivityEx)) {
	                 
	            	   GenericActivityEx gae = (GenericActivityEx)act;
	            	   Participant parti = wp.findParticipantByID(gae.getPerformer());
	                 
	            	   String name = parti.getName();
	                 
	 
	            	   if ((StringUtil.isEmptyWithTrim(matchString)) || (name.contains(matchString)))
	            	   {
	 
	 
	            		   String id = gae.getId();
	                   
	 
	            		   Map<String, Object> actEntry = ExMobileAppUtil.createHashMap();
	                   
	            		   actEntry.put("id", id);
	                   
	            		   actEntry.put("code", "");
	                   
	            		   actEntry.put("name", name);
	                   
	            		   resultList.add(actEntry);
	            	   } 
	               } else if ((act.getImplementation() instanceof SubFlow)) {
	            	   
	            	   		String id = act.getId();
	            	   		String code = act.getId();
	            	   		String name = act.getName();
	                 
	            	   		Map<String, Object> actEntry = ExMobileAppUtil.createHashMap();
	                 
	            	   		actEntry.put("id", id);
	                 
	            	   		actEntry.put("code", "");
	            	   		actEntry.put("name", name);
	                 
	            	   		resultList.add(actEntry);
	               }
	             }
	           }
	         }
	       }
	     }
	     
	     return resultList;
	   }

	@Override
	public List<Map<String, Object>> getRefDataList(String pk_group,String cond, String voclass, String entityname, String field,int startline, int count, int pagenum) throws BusinessException {
		// TODO 自动生成的方法存根
		 if(InvocationInfoProxy.getInstance().getGroupId()==null){
			  
			  if(pk_group==null || "~".equals(pk_group)){
				  InvocationInfoProxy.getInstance().setGroupId("0001E410000000000PM2");
			  }else{
				  InvocationInfoProxy.getInstance().setGroupId(pk_group);
			  }
			
			  
		  }
		
		  AbstractRefDataQuery refquery=new AbstractRefDataQuery();
		
		  refquery.setPk_group(pk_group);
		  if("nvl".equals(cond)){
			  refquery.setCondition(null);
		  }else{
			  refquery.setCondition(cond);
		  }
		  
		  if("nvl".equals(field)){
			  refquery.setFiled(null);
		  }else{
			  String[] dfileds=field.split(",");
			  for(String dfiled:dfileds){
				  refquery.getFiled().add(dfiled);
			  }
		  }
		  
		  refquery.setVoClassName(voclass);
		  refquery.setEntityname(entityname);
		  
		  List<Map<String, Object>> list;
		  
		  try {
				
			  refquery.setVoClass(Class.forName(voclass));
			  
			  refquery.MakeBasicSql();
				
			  list = PaginationQueryFacade.getInstance().query(refquery,startline,count,pagenum);
		
		  } catch (Exception e) {
				// TODO 自动生成的 catch 块
			throw new BusinessException(e.getMessage());
		  }

		  
		
		  return list;
	}


	@Override
	public List<Map<String, Object>> getBillList(String pk_group,String userid, String date, String statuskey, String statuscode,String cond, int startline, int count, int pagenum) throws BusinessException {
		// TODO 自动生成的方法存根
		
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
			InvocationInfoProxy.getInstance().setGroupId(pk_group);
		}
		InvocationInfoProxy.getInstance().setUserId(userid);
		
		IBillType BillType=ExMobileAppUtil.getBillType(statuskey, statuscode);
		
		BillQuery query=BillType.createNewTaskQuery();
		

		query.setPk_group(pk_group);
		query.setCuserid(userid);
		query.setDate(date);
		query.setBillType(BillType);
		query.setCondition(cond);
		
		List<Map<String, Object>> list = PaginationQueryFacade.getInstance().query(query,startline,count,pagenum);

		
		return list;
	}


	@Override
	public Map<String, Object> getBillCardInfo(String pk_group, String userid,String billid, String billtype, String statuskey, String statuscode) throws BusinessException {
		// TODO 自动生成的方法存根
		
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
			InvocationInfoProxy.getInstance().setGroupId(pk_group);
		}
		InvocationInfoProxy.getInstance().setUserId(userid);
		
		IBillType taskType = ExMobileAppUtil.getBillType(statuskey, statuscode);
		BillQuery query = taskType.createNewTaskQuery();
		
		Object obj = query.queryBillInfo(pk_group, userid, billtype, billid);
		
		Map<String, Object> map = ExMobileAppUtil.createHashMap();
		map.put("taskbill", obj);
		
		return map;
		
	}


	@Override
	public Map<String, Object> PreOrderSave(String pk_group, String userid,JSONObject prejson, String billstatus) throws BusinessException {
		// TODO 自动生成的方法存根
		
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
				
			InvocationInfoProxy.getInstance().setGroupId(pk_group);
		
		}
		  
		InvocationInfoProxy.getInstance().setUserId(userid);
		
		PreOrderVO pre=ConvertJson2VO(prejson,billstatus);
		
		PFlowContext pfcontext=new PFlowContext();
		  
		pfcontext.setActionName("WRITE");
		
		pfcontext.setBillType("38");
		
		Object ret=procFlow(pfcontext,billstatus,pre);
		
		if(ret instanceof PreOrderVO[]){
			
			PreOrderVO[] orders=(PreOrderVO[])ret;
			
			if(orders!=null && orders.length==1){
				
				Map<String,Object> retmsg=new HashMap();
				
				retmsg.put("billid",orders[0].getPrimaryKey());
				  
				return retmsg;
			}else{
				throw new BusinessException("没有返回保存后数据，保存失败！");
			}
			
		}else{
			 throw new BusinessException("返回类型错误，请检查！");
		}

	}
	
	
	public Object procFlow(PFlowContext context,String billstatus,AbstractBill sale) throws BusinessException {
		  
		  Object retObj=null;
		  
		  fillUpContext(context,billstatus,sale);
		  
		  if (context.getBillVos() == null) {
			  throw new BusinessException("没有获取到保存对象，保存失败！");
		  }
		  
		  HashMap eParam=context.getEParam()!=null?new HashMap(context.getEParam()):new HashMap();
		  
		  eParam.put("notechecked", "notechecked");
		  
		  IplatFormEntry iIplatFormEntry = (IplatFormEntry)NCLocator.getInstance().lookup(IplatFormEntry.class.getName());
		  
		  retObj=iIplatFormEntry.processAction(context.getActionName() + context.getUserId(), context.getTrantype() == null ? context.getBillType() : context.getTrantype(), null, context.getBillVo(), context.getUserObj(), eParam);
		  
		  if(retObj == null){
			  throw new BusinessException("订单返回对象为空，保存失败");
		  }
		  
		  return retObj;
	}
	
	  protected void fillUpContext(PFlowContext context,String billstatus,AbstractBill sale) throws BusinessException{
			
		  if("ADD".equals(billstatus)){
			  
			  AbstractBill[] data = new AbstractBill[] { (AbstractBill)sale };
			  data = (AbstractBill[])processBefore(getRealArray(data));
			  
			  extractTrantype(context,data);
			  setNewVOStatus(data);
			  
			  context.setBillVos(data);
			  
		  }else if("EDIT".equals(billstatus)){
			
			  AbstractBill[] data = new AbstractBill[] { (AbstractBill)sale };
			  data = (AbstractBill[])processBefore(getRealArray(data));
			  
			  extractTrantype(context,data);
			  
			  data = produceLightVO(data,billstatus);
			  
			  context.setBillVos(data);
		  }else if("DELETE".equals(billstatus)){
			  
			  AbstractBill[] data = new AbstractBill[] { (AbstractBill)sale };
			  data = (AbstractBill[])processBefore(getRealArray(data));
			  
			  extractTrantype(context,data);
			  
			  data = produceLightVO(data,billstatus);
			  
			  context.setBillVos(data);
			  
		  }else{
			  
			  AbstractBill[] data = new AbstractBill[] { (AbstractBill)sale };
			  data = (AbstractBill[])processBefore(getRealArray(data));
			  
			  extractTrantype(context,data);
			  
			  data = produceLightVO(data,billstatus);
			  
			  context.setBillVos(data);
			  
		  }
		  
		  

	}
	  
	protected AbstractBill[] produceLightVO(AbstractBill[] newVO,String billstatus) throws BusinessException {
		  
		  IMDPersistenceQueryService qservice=NCLocator.getInstance().lookup(IMDPersistenceQueryService.class);
		  
		  PreOrderVO oldVO=qservice.queryBillOfVOByPK(PreOrderVO.class, newVO[0].getParent().getAttributeValue("cpreorderid").toString(), false);
		  
		  ClientBillToServer<IBill> tool = new ClientBillToServer();
		  
		  IBill[] lightVOs=null;
		  
		  if("EDIT".equals(billstatus)){
			  
			  lightVOs=tool.construct(new AbstractBill[]{oldVO}, newVO);
			  
		  }else if("DELETE".equals(billstatus)){
			  
			  lightVOs = tool.construct(new AbstractBill[]{oldVO});
			  
		  }else{
			  
			  lightVOs = tool.construct(new AbstractBill[]{oldVO});
		  }
		  
		  
		  fillInfoAfterLight((AbstractBill[])lightVOs,newVO);
		  
		  return (AbstractBill[])lightVOs;
	}
	
	protected void fillInfoAfterLight(AbstractBill[] lightVOs,AbstractBill[] newVO){
	    if (ArrayUtils.isEmpty(lightVOs)) {
	      return;
	    }
	    
	    fillBusitypeAfterLight(lightVOs,newVO);
	}
	
	
	protected void fillBusitypeAfterLight(AbstractBill[] lightVOs,AbstractBill[] newVO) {
		     
		String busitypeKey = getIFlowBizItfMapKey(lightVOs[0], "busitype");
		     
		     if (StringUtil.isEmptyWithTrim(busitypeKey)) {
		       return;
		     }
		     Map<String, AbstractBill> fullVOMap = createfullVOMap(newVO);
		     for (AbstractBill bill : lightVOs) {
		       String pk = bill.getPrimaryKey();
		       if (!StringUtil.isEmpty(pk))
		       {
			  
		         AbstractBill fullBill = (AbstractBill)fullVOMap.get(pk);
		         if (null != fullBill)
		         {
			  
		           String pk_busitype_light = (String)bill.getParentVO().getAttributeValue(busitypeKey);
		           
		           if (StringUtil.isEmptyWithTrim(pk_busitype_light))
		           {
			  
		             String pk_busitype = (String)fullBill.getParentVO().getAttributeValue(busitypeKey);
		             
		             bill.getParentVO().setAttributeValue(busitypeKey, pk_busitype);
		           }
		         }
		       }
		     }
	} 
	
	
	protected Map<String, AbstractBill> createfullVOMap(AbstractBill[] newVO) {
	    Map<String, AbstractBill> retMap = new HashMap();
	    if (ArrayUtils.isEmpty(newVO)) {
	      return retMap;
	    }
	    for (AbstractBill bill : newVO) {
	      String pk = bill.getPrimaryKey();
	      if (!StringUtil.isEmptyWithTrim(pk))
	      {
		
	        retMap.put(pk, bill); }
	    }
	    return retMap;
	  }
	  
	protected void setNewVOStatus(AggregatedValueObject[] vos) {
		  
		  for (AggregatedValueObject vo : vos) {
			    vo.getParentVO().setStatus(2);
			    if (vo.getChildrenVO() == null) {
			      return;
			    }
			    for (CircularlyAccessibleValueObject item : vo.getChildrenVO()) {
			      item.setStatus(2);
			    }
			  }
	  }
	  
	private void extractTrantype(PFlowContext context,AbstractBill[] data){
	    
		if (ArrayUtils.isEmpty(data)) {
	      return;
	    }
	    String ttKey = getIFlowBizItfMapKey(data[0], "transtype");
	    
	    if (StringUtil.isEmptyWithTrim(ttKey)) {
	      return;
	    }
	    String tt = (String)data[0].getParentVO().getAttributeValue(ttKey);
	    
	  
	    if (StringUtil.isContainChinese(tt)) {
	      return;
	    }
	    context.setTrantype(tt);
	}
	
	protected String getIFlowBizItfMapKey(AggregatedValueObject vo, String key) {
		  if (null == vo) {
			  return null;
		  }
	  	IBusinessEntity entity = null;
	  	try {
	  		entity = MDBaseQueryFacade.getInstance().getBusinessEntityByFullName(((SuperVO) vo.getParentVO()).getMetaData().getEntityName());
		
	  	}catch (MetaDataException ex){
	  		ExceptionUtils.unmarsh(ex);
	  	}
	  	
	  	if (null != entity) {
	     
	  		Map<String, String> map = entity.getBizInterfaceMapInfo(IFlowBizItf.class.getName());
	     
	  		return (String)map.get(key);
	  	}
	  	
	  	return null;
	 }
	
	protected Object[] processBefore(Object[] vos){
	    
		for (Object vo : vos) {
			
			AbstractBill saleordervo = (AbstractBill)vo;
			CircularlyAccessibleValueObject[] bvos = saleordervo.getChildrenVO();
			if ((bvos == null) || (bvos.length == 0)){
				
				ExceptionUtils.wrappBusinessException(NCLangRes4VoTransl.getNCLangRes().getStrByID("4006011_0", "04006011-0020"));
			}
		}
		
		return vos;
	}
	
	private Object[] getRealArray(Object[] vos) {
		  
		  if ((null == vos) || (0 == vos.length)) {
		    return vos;
		  }
		  Object[] nvos = Constructor.declareArray(vos[0].getClass(), vos.length);
		  System.arraycopy(vos, 0, nvos, 0, vos.length);
		  return nvos;
	}



	private PreOrderVO ConvertJson2VO(JSONObject prejson, String billstatus) throws BusinessException {
		// TODO 自动生成的方法存根

		if(prejson==null){
			throw new BusinessException("传入对象为空，不能完成保存动作！");
		}
		
		PreOrderVO prevo=new PreOrderVO();
		
		try{
			
			JSONObject jsonData = prejson;
			
			JSONObject headinfo=jsonData.getJSONObject("head");
			
			JSONArray bodyinfos=jsonData.getJSONArray("body");
			
			PreOrderHVO parent=new PreOrderHVO();
			
			List<PreOrderBVO> bodys=new ArrayList();
			
			String[] headfield=MoblieVoStatic.premap.get("head");
			
			for(int i=0;i<headfield.length;i++){
				
				if("status".equals(headfield[i])){
					
					if(headinfo.get(headfield[i]).equals("nvl")){
						parent.setStatus(0);
					}else{
						parent.setStatus(Integer.valueOf(headinfo.get(headfield[i]).toString()));
					}
					
				}else{
					
					if(headinfo.get(headfield[i]).equals("nvl")){
						parent.setAttributeValue(headfield[i],null);
					}else{
						parent.setAttributeValue(headfield[i], headinfo.get(headfield[i]));

					}
					
					
				}
				
			}
			
			String[] bodyfield=MoblieVoStatic.premap.get("body");
			
			for(int i=0;i<bodyinfos.length();i++){
				
				PreOrderBVO body=new PreOrderBVO();
				
				for(int j=0;j<bodyfield.length;j++){
					
					if("status".equals(bodyfield[j])){
						
						if(bodyinfos.getJSONObject(i).get(bodyfield[j]).equals("nvl")){
							body.setStatus(0);
						}else{
							body.setStatus(Integer.valueOf(bodyinfos.getJSONObject(i).get(bodyfield[j]).toString()));
						}
						
					}else{
						
						if(bodyinfos.getJSONObject(i).get(bodyfield[j]).equals("nvl")){
							body.setAttributeValue(bodyfield[j],null);
						}else{
							body.setAttributeValue(bodyfield[j], bodyinfos.getJSONObject(i).get(bodyfield[j]));

						}
						
					}
					
				}
				bodys.add(body);
			}
			
			prevo.setParentVO(parent);
			prevo.setChildren(PreOrderBVO.class, bodys.toArray(new PreOrderBVO[bodys.size()]));
			
			
			return prevo;
			
		}catch(Exception e){
			 throw new BusinessException("错误的单据实体类");
		}
		
		
	}
	
	public List<Map<String, Object>> queryBomVerInfo(String pk_group,String user, String mat,String pk_org, int startline, int count, int pagenum) throws BusinessException {
		// TODO 自动生成的方法存根
		
		BomVerinfoQuery query=new BomVerinfoQuery();
		
		query.setPk_group(pk_group);
		query.setCuserid(user);
		query.setMaterial(mat);
		query.setPk_org(pk_org);
		
		List<Map<String, Object>> list = PaginationQueryFacade.getInstance().query(query,startline,count,pagenum);
		
		return list;
		
	}


	@Override
	public List<Map<String, Object>> queryBomChInfo(String pk_group,String user, String bomid, String pk_org, int startline, int count,int pagenum) throws BusinessException {
		// TODO 自动生成的方法存根
		
		BomChinfoQuery query=new BomChinfoQuery();
		
		query.setPk_group(pk_group);
		query.setCuserid(user);
		query.setBomid(bomid);
		query.setPk_org(pk_org);
		
		List<Map<String, Object>> list = PaginationQueryFacade.getInstance().query(query,startline,count,pagenum);
		
		return list;
	}
	
	public Map<String, Object> queryHfPrice(String pk_group,String user,String pk_org,String mat,String bomid,String pk_cus,double num) throws BusinessException{
		
		Map<String, Object> retmap=new HashMap();
		Set<String> cuspk=new HashSet();
		Set<String> matpks=new HashSet();
		IOrgUnitQryService orgservice=NCLocator.getInstance().lookup(IOrgUnitQryService.class);
		
		if(pk_org==null || mat==null || bomid==null || pk_cus==null ){
			throw new BusinessException("组织、物料、bom主键、客户不能为空！");
		}
		
		OrgVO org=orgservice.getOrg(pk_org);
		
		SysInitVO defcus=SysParaInitQuery.queryByParaCode(pk_org, "SO66");
		
		SysInitVO defratio=SysParaInitQuery.queryByParaCode(pk_org, "SO68");
		
		SysInitVO deftax=SysParaInitQuery.queryByParaCode(pk_org, "SO70");
		
		if(defratio.getValue()==null || deftax.getValue()==null){
			throw new BusinessException("组织【("+org.getCode()+")"+org.getName()+"】没有维护SO68/SO70参数值，不能完成计算！");
		}
		
		if(defcus.getValue()!=null){
			cuspk.add(defcus.getValue());
		}
		
		matpks.add(mat+"#"+bomid);
		cuspk.add(pk_cus);
		
		Map<String,Map<String,UFDouble>> bominfomap=this.getPlanService().querBominfoByHybridPrice(pk_org, matpks);
		Map<String,Map<String,UFDouble>> cusmap = this.getPlanService().querCusPriceByHybridPrice(pk_org, cuspk);
		
		
		Map<String,UFDouble> cusdjmap=new HashMap();
		
		if(cusmap.containsKey(pk_cus)){
			cusdjmap=cusmap.get(pk_cus);
		}else{
			cusdjmap=cusmap.get(defcus.getValue());
		}
		
		String key=mat+"#"+bomid;
		List<String> memo=new ArrayList();
		
		UFDouble o=new UFDouble(defratio.getValue()).multiply(new UFDouble(deftax.getValue())).add(1);
		String Oformula="(1+"+defratio.getValue()+"%*"+deftax.getValue()+")";
		
		if(bominfomap.containsKey(key)){
			
			Map<String,UFDouble> NumMap=bominfomap.get(key);
			
			UFDouble p=UFDouble.ZERO_DBL;
			
			for(String hhfl:NumMap.keySet()){
				
				if(cusdjmap.containsKey(hhfl)){
					
					p=p.add(NumMap.get(hhfl).multiply(cusdjmap.get(hhfl)).multiply(new UFDouble(num)));
					
					String formula="[Num]"+num+"*[HfPrice]"+NumMap.get(hhfl)+"*[CusDj]"+cusdjmap.get(hhfl);
					
					memo.add(formula);
					
				}else{
					
					p=p.add(NumMap.get(hhfl).multiply(UFDouble.ZERO_DBL).multiply(new UFDouble(num)));
					
					String formula="[Num]"+num+"*[HfPrice]"+NumMap.get(hhfl)+"*[CusDj]0";
					
					memo.add(formula);
					
				}
				
			}
			
			UFDouble hfprice=p.multiply(o);
			
			String[] formulas=memo.toArray(new String[memo.size()]);
			
			String hfformula="";
			
			for(int i1=0;i1<formulas.length;i1++){
				
				if(i1==0){
					
					hfformula=hfformula+formulas[i1];
					
				}else{
					
					hfformula=hfformula+"+"+formulas[i1];
				}
			}
			
			retmap.put("hfprice", hfprice);
			retmap.put("formula", "("+hfformula+")*"+Oformula);
					
			
		}else{
			
			retmap.put("hfprice", 0);
			retmap.put("formula", "根据BOM信息没有找到匹配的混合料信息");
		
			
		}
		
		return retmap;
	}
	
	public Map<String, Object> PreOrderDelete(String pk_group, String userid,String bid) throws BusinessException {
		// TODO 自动生成的方法存根
		
		  if(InvocationInfoProxy.getInstance().getGroupId()==null){
				
			  InvocationInfoProxy.getInstance().setGroupId(pk_group);
		  }
		  
		  InvocationInfoProxy.getInstance().setUserId(userid);
		  
		  PreOrderVO prevo=this.getMDQueryService().queryBillOfVOByPK(PreOrderVO.class,bid,false);
		  
		  if(prevo!=null){
			  			  
			  PFlowContext pfcontext=new PFlowContext();
			  pfcontext.setActionName("DELETE");
			  pfcontext.setBillType("38");
			  
			  procFlowDelete(pfcontext,prevo);
			  
		  }else{
			  throw new BusinessException("没有找到待删除的订单数据！");
		  }
		  
		  Map<String,Object> retobj=new HashMap();
		  
		  retobj.put("remsg", "删除成功");

		  return retobj;
	}
	
	private void procFlowDelete(PFlowContext context,PreOrderVO salevo) throws BusinessException {
		// TODO 自动生成的方法存根
		
		fillUpContext(context,"DELETE",salevo);
		
		if (context.getBillVos() == null) {
			  throw new BusinessException("没有获取到删除对象，删除失败！");
		}
		
		HashMap eParam=context.getEParam()!=null?new HashMap(context.getEParam()):new HashMap();
		  
		eParam.put("notechecked", "notechecked");
		
		IplatFormEntry iIplatFormEntry = (IplatFormEntry)NCLocator.getInstance().lookup(IplatFormEntry.class.getName());
		  
		iIplatFormEntry.processAction(context.getActionName() + context.getUserId(), context.getTrantype() == null ? context.getBillType() : context.getTrantype(), null, context.getBillVo(), context.getUserObj(), eParam);
		
	}
	
	public Map<String, Object> PreOrderApprove(String pk_group, String userid,String bid) throws BusinessException {
		// TODO 自动生成的方法存根
		
		  if(InvocationInfoProxy.getInstance().getGroupId()==null){
				
			  InvocationInfoProxy.getInstance().setGroupId(pk_group);
		  }
		  
		  InvocationInfoProxy.getInstance().setUserId(userid);
		  
		  PreOrderVO salevo=this.getMDQueryService().queryBillOfVOByPK(PreOrderVO.class,bid,false);
		  
		  if(salevo!=null){
			  			  
			  PFlowContext pfcontext=new PFlowContext();
			  pfcontext.setActionName("APPROVE");
			  pfcontext.setBillType("38");
			  
			  Object ret=procFlow(pfcontext,"APPROVE",salevo);
			  
			  Map<String,Object> retmsg=new HashMap();
			  
			  if(ret instanceof PreOrderVO[]){
				  
				  PreOrderVO[] sovos=(PreOrderVO[])ret;
				  
				  if(sovos!=null && sovos.length==1){
					  retmsg.put("billid", sovos[0].getParentVO().getCpreorderid());
				  }else{
					  throw new BusinessException("返回数据错误，不能保存！");
				  }
				  
				  
			  }else{
				  throw new BusinessException("返回数据类型错误！");
			  }
			
			  return retmsg;
			  
		  }else{
			  throw new BusinessException("没有找到待审批的订单数据！");
		  }
		  		  
	}

}
