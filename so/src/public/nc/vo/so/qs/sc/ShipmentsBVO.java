package nc.vo.so.qs.sc;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class ShipmentsBVO extends SuperVO {
/**
*赠品
*/
public UFBoolean blargessflag;
/**
*是否行关闭
*/
public UFBoolean blineclose;
/**
*应收组织最新版本
*/
public String carorgid;
/**
*应收组织
*/
public String carorgvid;
/**
*最后安排人
*/
public String carrangeid;
/**
*辅单位
*/
public String castunitid;
/**
*产品编码
*/
public String cateralvid;
/**
*源头单据子表
*/
public String cfirstbid;
/**
*源头单据主表
*/
public String cfirstid;
/**
*物料档案
*/
public String cmaterialid;
/**
*价格项目
*/
public String cpriceitemid;
/**
*价格表
*/
public String cpriceitemtableid;
/**
*价格政策
*/
public String cpricepolicyid;
/**
*利润中心最新版本
*/
public String cprofitcenterid;
/**
*利润中心
*/
public String cprofitcentervid;
/**
*收货地址
*/
public String creceiveaddrid;
/**
*收货地区
*/
public String creceiveareaid;
/**
*收货客户
*/
public String creceivecustid;
/**
*收货地点
*/
public String creceivesiteid;
/**
*料比
*/
public String csbomversionid;
/**
*发货库存组织最新版本
*/
public String csendstockorgid;
/**
*发货库存组织
*/
public String csendstockorgvid;
/**
*发货仓库
*/
public String csendstordocid;
/**
*结算财务组织最新版本
*/
public String csettleorgid;
/**
*结算财务组织
*/
public String csettleorgvid;
/**
*来源单据附表
*/
public String csrcbid;
/**
*来源单据主表
*/
public String csrcid;
/**
*物流组织最新版本
*/
public String ctrafficorgid;
/**
*物流组织
*/
public String ctrafficorgvid;
/**
*主单位
*/
public String cunitid;
/**
*剖布类型
*/
public String cutcloth;
/**
*最后安排日期
*/
public UFDate darrdate;
/**
*自定义项1
*/
public String def1;
/**
*自定义项10
*/
public String def10;
/**
*自定义项11
*/
public String def11;
/**
*自定义项12
*/
public String def12;
/**
*自定义项13
*/
public String def13;
/**
*自定义项14
*/
public String def14;
/**
*自定义项15
*/
public String def15;
/**
*自定义项16
*/
public String def16;
/**
*自定义项17
*/
public String def17;
/**
*自定义项18
*/
public String def18;
/**
*自定义项19
*/
public String def19;
/**
*自定义项2
*/
public String def2;
/**
*自定义项20
*/
public String def20;
/**
*自定义项3
*/
public String def3;
/**
*自定义项4
*/
public String def4;
/**
*自定义项5
*/
public String def5;
/**
*自定义项6
*/
public String def6;
/**
*自定义项7
*/
public String def7;
/**
*自定义项8
*/
public String def8;
/**
*自定义项9
*/
public String def9;
/**
*要求到货日期
*/
public UFDate dreceivedate;
/**
*计划发货日期
*/
public UFDate dsenddate;
/**
*定金
*/
public UFDouble earnestmoney;
/**
*扣税类别
*/
public Integer ftaxtypeflag;
/**
*订价
*/
public UFDouble listprice;
/**
*产品分类编码
*/
public String marbasclassid;
/**
*备注
*/
public String memo;
/**
*混合料价
*/
public UFDouble mixtureprice;
/**
*累计安排数量
*/
public UFDouble narrnum;
/**
*辅数量
*/
public UFDouble nastnum;
/**
*主数量
*/
public UFDouble nnum;
/**
*无税金额
*/
public UFDouble norigmny;
/**
*无税单价
*/
public UFDouble norigprice;
/**
*价税合计
*/
public UFDouble norigtaxmny;
/**
*含税单价
*/
public UFDouble norigtaxprice;
/**
*辅无税单价
*/
public UFDouble nqtorigprice;
/**
*辅含税单价
*/
public UFDouble nqtorigtaxprice;
/**
*税额
*/
public UFDouble ntax;
/**
*税率
*/
public UFDouble ntaxrate;
/**
*其他生产要求
*/
public String otherproduction;
/**
*单包重(KG)
*/
public String packageweight;
/**
*批次档案
*/
public String pk_batchcode;
/**
*集团
*/
public String pk_group;
/**
*销售组织
*/
public String pk_org;
/**
*发货申请行主键
*/
public String pk_shipments_b;
/**
*行号
*/
public String rowno;
/**
*上层单据主键
*/
public String so_shipmentsb;
/**
*标识线
*/
public String tagline;
/**
*时间戳
*/
public UFDateTime ts;
/**
*批次号
*/
public String vbatchcode;
/**
*换算率
*/
public String vchangerate;
/**
*源头单据号
*/
public String vfirstcode;
/**
*源头单据行号
*/
public String vfirstrowno;
/**
*源头交易类型
*/
public String vfirsttrantype;
/**
*源头单据类型
*/
public String vfirsttype;
/**
*自由辅助属性1
*/
public String vfree1;
/**
*自由辅助属性10
*/
public String vfree10;
/**
*自由辅助属性2
*/
public String vfree2;
/**
*自由辅助属性3
*/
public String vfree3;
/**
*自由辅助属性4
*/
public String vfree4;
/**
*自由辅助属性5
*/
public String vfree5;
/**
*自由辅助属性6
*/
public String vfree6;
/**
*自由辅助属性7
*/
public String vfree7;
/**
*自由辅助属性8
*/
public String vfree8;
/**
*自由辅助属性9
*/
public String vfree9;
/**
*来源单据号
*/
public String vsrccode;
/**
*来源单据行号
*/
public String vsrcrowno;
/**
*来源交易类型
*/
public String vsrctrantype;
/**
*来源单据类型
*/
public String vsrctype;
/** 
* 获取赠品
*
* @return 赠品
*/
public UFBoolean getBlargessflag () {
return this.blargessflag;
 } 

/** 
* 设置赠品
*
* @param blargessflag 赠品
*/
public void setBlargessflag ( UFBoolean blargessflag) {
this.blargessflag=blargessflag;
 } 

/** 
* 获取是否行关闭
*
* @return 是否行关闭
*/
public UFBoolean getBlineclose () {
return this.blineclose;
 } 

/** 
* 设置是否行关闭
*
* @param blineclose 是否行关闭
*/
public void setBlineclose ( UFBoolean blineclose) {
this.blineclose=blineclose;
 } 

/** 
* 获取应收组织最新版本
*
* @return 应收组织最新版本
*/
public String getCarorgid () {
return this.carorgid;
 } 

/** 
* 设置应收组织最新版本
*
* @param carorgid 应收组织最新版本
*/
public void setCarorgid ( String carorgid) {
this.carorgid=carorgid;
 } 

/** 
* 获取应收组织
*
* @return 应收组织
*/
public String getCarorgvid () {
return this.carorgvid;
 } 

/** 
* 设置应收组织
*
* @param carorgvid 应收组织
*/
public void setCarorgvid ( String carorgvid) {
this.carorgvid=carorgvid;
 } 

/** 
* 获取最后安排人
*
* @return 最后安排人
*/
public String getCarrangeid () {
return this.carrangeid;
 } 

/** 
* 设置最后安排人
*
* @param carrangeid 最后安排人
*/
public void setCarrangeid ( String carrangeid) {
this.carrangeid=carrangeid;
 } 

/** 
* 获取辅单位
*
* @return 辅单位
*/
public String getCastunitid () {
return this.castunitid;
 } 

/** 
* 设置辅单位
*
* @param castunitid 辅单位
*/
public void setCastunitid ( String castunitid) {
this.castunitid=castunitid;
 } 

/** 
* 获取产品编码
*
* @return 产品编码
*/
public String getCateralvid () {
return this.cateralvid;
 } 

/** 
* 设置产品编码
*
* @param cateralvid 产品编码
*/
public void setCateralvid ( String cateralvid) {
this.cateralvid=cateralvid;
 } 

/** 
* 获取源头单据子表
*
* @return 源头单据子表
*/
public String getCfirstbid () {
return this.cfirstbid;
 } 

/** 
* 设置源头单据子表
*
* @param cfirstbid 源头单据子表
*/
public void setCfirstbid ( String cfirstbid) {
this.cfirstbid=cfirstbid;
 } 

/** 
* 获取源头单据主表
*
* @return 源头单据主表
*/
public String getCfirstid () {
return this.cfirstid;
 } 

/** 
* 设置源头单据主表
*
* @param cfirstid 源头单据主表
*/
public void setCfirstid ( String cfirstid) {
this.cfirstid=cfirstid;
 } 

/** 
* 获取物料档案
*
* @return 物料档案
*/
public String getCmaterialid () {
return this.cmaterialid;
 } 

/** 
* 设置物料档案
*
* @param cmaterialid 物料档案
*/
public void setCmaterialid ( String cmaterialid) {
this.cmaterialid=cmaterialid;
 } 

/** 
* 获取价格项目
*
* @return 价格项目
*/
public String getCpriceitemid () {
return this.cpriceitemid;
 } 

/** 
* 设置价格项目
*
* @param cpriceitemid 价格项目
*/
public void setCpriceitemid ( String cpriceitemid) {
this.cpriceitemid=cpriceitemid;
 } 

/** 
* 获取价格表
*
* @return 价格表
*/
public String getCpriceitemtableid () {
return this.cpriceitemtableid;
 } 

/** 
* 设置价格表
*
* @param cpriceitemtableid 价格表
*/
public void setCpriceitemtableid ( String cpriceitemtableid) {
this.cpriceitemtableid=cpriceitemtableid;
 } 

/** 
* 获取价格政策
*
* @return 价格政策
*/
public String getCpricepolicyid () {
return this.cpricepolicyid;
 } 

/** 
* 设置价格政策
*
* @param cpricepolicyid 价格政策
*/
public void setCpricepolicyid ( String cpricepolicyid) {
this.cpricepolicyid=cpricepolicyid;
 } 

/** 
* 获取利润中心最新版本
*
* @return 利润中心最新版本
*/
public String getCprofitcenterid () {
return this.cprofitcenterid;
 } 

/** 
* 设置利润中心最新版本
*
* @param cprofitcenterid 利润中心最新版本
*/
public void setCprofitcenterid ( String cprofitcenterid) {
this.cprofitcenterid=cprofitcenterid;
 } 

/** 
* 获取利润中心
*
* @return 利润中心
*/
public String getCprofitcentervid () {
return this.cprofitcentervid;
 } 

/** 
* 设置利润中心
*
* @param cprofitcentervid 利润中心
*/
public void setCprofitcentervid ( String cprofitcentervid) {
this.cprofitcentervid=cprofitcentervid;
 } 

/** 
* 获取收货地址
*
* @return 收货地址
*/
public String getCreceiveaddrid () {
return this.creceiveaddrid;
 } 

/** 
* 设置收货地址
*
* @param creceiveaddrid 收货地址
*/
public void setCreceiveaddrid ( String creceiveaddrid) {
this.creceiveaddrid=creceiveaddrid;
 } 

/** 
* 获取收货地区
*
* @return 收货地区
*/
public String getCreceiveareaid () {
return this.creceiveareaid;
 } 

/** 
* 设置收货地区
*
* @param creceiveareaid 收货地区
*/
public void setCreceiveareaid ( String creceiveareaid) {
this.creceiveareaid=creceiveareaid;
 } 

/** 
* 获取收货客户
*
* @return 收货客户
*/
public String getCreceivecustid () {
return this.creceivecustid;
 } 

/** 
* 设置收货客户
*
* @param creceivecustid 收货客户
*/
public void setCreceivecustid ( String creceivecustid) {
this.creceivecustid=creceivecustid;
 } 

/** 
* 获取收货地点
*
* @return 收货地点
*/
public String getCreceivesiteid () {
return this.creceivesiteid;
 } 

/** 
* 设置收货地点
*
* @param creceivesiteid 收货地点
*/
public void setCreceivesiteid ( String creceivesiteid) {
this.creceivesiteid=creceivesiteid;
 } 

/** 
* 获取料比
*
* @return 料比
*/
public String getCsbomversionid () {
return this.csbomversionid;
 } 

/** 
* 设置料比
*
* @param csbomversionid 料比
*/
public void setCsbomversionid ( String csbomversionid) {
this.csbomversionid=csbomversionid;
 } 

/** 
* 获取发货库存组织最新版本
*
* @return 发货库存组织最新版本
*/
public String getCsendstockorgid () {
return this.csendstockorgid;
 } 

/** 
* 设置发货库存组织最新版本
*
* @param csendstockorgid 发货库存组织最新版本
*/
public void setCsendstockorgid ( String csendstockorgid) {
this.csendstockorgid=csendstockorgid;
 } 

/** 
* 获取发货库存组织
*
* @return 发货库存组织
*/
public String getCsendstockorgvid () {
return this.csendstockorgvid;
 } 

/** 
* 设置发货库存组织
*
* @param csendstockorgvid 发货库存组织
*/
public void setCsendstockorgvid ( String csendstockorgvid) {
this.csendstockorgvid=csendstockorgvid;
 } 

/** 
* 获取发货仓库
*
* @return 发货仓库
*/
public String getCsendstordocid () {
return this.csendstordocid;
 } 

/** 
* 设置发货仓库
*
* @param csendstordocid 发货仓库
*/
public void setCsendstordocid ( String csendstordocid) {
this.csendstordocid=csendstordocid;
 } 

/** 
* 获取结算财务组织最新版本
*
* @return 结算财务组织最新版本
*/
public String getCsettleorgid () {
return this.csettleorgid;
 } 

/** 
* 设置结算财务组织最新版本
*
* @param csettleorgid 结算财务组织最新版本
*/
public void setCsettleorgid ( String csettleorgid) {
this.csettleorgid=csettleorgid;
 } 

/** 
* 获取结算财务组织
*
* @return 结算财务组织
*/
public String getCsettleorgvid () {
return this.csettleorgvid;
 } 

/** 
* 设置结算财务组织
*
* @param csettleorgvid 结算财务组织
*/
public void setCsettleorgvid ( String csettleorgvid) {
this.csettleorgvid=csettleorgvid;
 } 

/** 
* 获取来源单据附表
*
* @return 来源单据附表
*/
public String getCsrcbid () {
return this.csrcbid;
 } 

/** 
* 设置来源单据附表
*
* @param csrcbid 来源单据附表
*/
public void setCsrcbid ( String csrcbid) {
this.csrcbid=csrcbid;
 } 

/** 
* 获取来源单据主表
*
* @return 来源单据主表
*/
public String getCsrcid () {
return this.csrcid;
 } 

/** 
* 设置来源单据主表
*
* @param csrcid 来源单据主表
*/
public void setCsrcid ( String csrcid) {
this.csrcid=csrcid;
 } 

/** 
* 获取物流组织最新版本
*
* @return 物流组织最新版本
*/
public String getCtrafficorgid () {
return this.ctrafficorgid;
 } 

/** 
* 设置物流组织最新版本
*
* @param ctrafficorgid 物流组织最新版本
*/
public void setCtrafficorgid ( String ctrafficorgid) {
this.ctrafficorgid=ctrafficorgid;
 } 

/** 
* 获取物流组织
*
* @return 物流组织
*/
public String getCtrafficorgvid () {
return this.ctrafficorgvid;
 } 

/** 
* 设置物流组织
*
* @param ctrafficorgvid 物流组织
*/
public void setCtrafficorgvid ( String ctrafficorgvid) {
this.ctrafficorgvid=ctrafficorgvid;
 } 

/** 
* 获取主单位
*
* @return 主单位
*/
public String getCunitid () {
return this.cunitid;
 } 

/** 
* 设置主单位
*
* @param cunitid 主单位
*/
public void setCunitid ( String cunitid) {
this.cunitid=cunitid;
 } 

/** 
* 获取剖布类型
*
* @return 剖布类型
*/
public String getCutcloth () {
return this.cutcloth;
 } 

/** 
* 设置剖布类型
*
* @param cutcloth 剖布类型
*/
public void setCutcloth ( String cutcloth) {
this.cutcloth=cutcloth;
 } 

/** 
* 获取最后安排日期
*
* @return 最后安排日期
*/
public UFDate getDarrdate () {
return this.darrdate;
 } 

/** 
* 设置最后安排日期
*
* @param darrdate 最后安排日期
*/
public void setDarrdate ( UFDate darrdate) {
this.darrdate=darrdate;
 } 

/** 
* 获取自定义项1
*
* @return 自定义项1
*/
public String getDef1 () {
return this.def1;
 } 

/** 
* 设置自定义项1
*
* @param def1 自定义项1
*/
public void setDef1 ( String def1) {
this.def1=def1;
 } 

/** 
* 获取自定义项10
*
* @return 自定义项10
*/
public String getDef10 () {
return this.def10;
 } 

/** 
* 设置自定义项10
*
* @param def10 自定义项10
*/
public void setDef10 ( String def10) {
this.def10=def10;
 } 

/** 
* 获取自定义项11
*
* @return 自定义项11
*/
public String getDef11 () {
return this.def11;
 } 

/** 
* 设置自定义项11
*
* @param def11 自定义项11
*/
public void setDef11 ( String def11) {
this.def11=def11;
 } 

/** 
* 获取自定义项12
*
* @return 自定义项12
*/
public String getDef12 () {
return this.def12;
 } 

/** 
* 设置自定义项12
*
* @param def12 自定义项12
*/
public void setDef12 ( String def12) {
this.def12=def12;
 } 

/** 
* 获取自定义项13
*
* @return 自定义项13
*/
public String getDef13 () {
return this.def13;
 } 

/** 
* 设置自定义项13
*
* @param def13 自定义项13
*/
public void setDef13 ( String def13) {
this.def13=def13;
 } 

/** 
* 获取自定义项14
*
* @return 自定义项14
*/
public String getDef14 () {
return this.def14;
 } 

/** 
* 设置自定义项14
*
* @param def14 自定义项14
*/
public void setDef14 ( String def14) {
this.def14=def14;
 } 

/** 
* 获取自定义项15
*
* @return 自定义项15
*/
public String getDef15 () {
return this.def15;
 } 

/** 
* 设置自定义项15
*
* @param def15 自定义项15
*/
public void setDef15 ( String def15) {
this.def15=def15;
 } 

/** 
* 获取自定义项16
*
* @return 自定义项16
*/
public String getDef16 () {
return this.def16;
 } 

/** 
* 设置自定义项16
*
* @param def16 自定义项16
*/
public void setDef16 ( String def16) {
this.def16=def16;
 } 

/** 
* 获取自定义项17
*
* @return 自定义项17
*/
public String getDef17 () {
return this.def17;
 } 

/** 
* 设置自定义项17
*
* @param def17 自定义项17
*/
public void setDef17 ( String def17) {
this.def17=def17;
 } 

/** 
* 获取自定义项18
*
* @return 自定义项18
*/
public String getDef18 () {
return this.def18;
 } 

/** 
* 设置自定义项18
*
* @param def18 自定义项18
*/
public void setDef18 ( String def18) {
this.def18=def18;
 } 

/** 
* 获取自定义项19
*
* @return 自定义项19
*/
public String getDef19 () {
return this.def19;
 } 

/** 
* 设置自定义项19
*
* @param def19 自定义项19
*/
public void setDef19 ( String def19) {
this.def19=def19;
 } 

/** 
* 获取自定义项2
*
* @return 自定义项2
*/
public String getDef2 () {
return this.def2;
 } 

/** 
* 设置自定义项2
*
* @param def2 自定义项2
*/
public void setDef2 ( String def2) {
this.def2=def2;
 } 

/** 
* 获取自定义项20
*
* @return 自定义项20
*/
public String getDef20 () {
return this.def20;
 } 

/** 
* 设置自定义项20
*
* @param def20 自定义项20
*/
public void setDef20 ( String def20) {
this.def20=def20;
 } 

/** 
* 获取自定义项3
*
* @return 自定义项3
*/
public String getDef3 () {
return this.def3;
 } 

/** 
* 设置自定义项3
*
* @param def3 自定义项3
*/
public void setDef3 ( String def3) {
this.def3=def3;
 } 

/** 
* 获取自定义项4
*
* @return 自定义项4
*/
public String getDef4 () {
return this.def4;
 } 

/** 
* 设置自定义项4
*
* @param def4 自定义项4
*/
public void setDef4 ( String def4) {
this.def4=def4;
 } 

/** 
* 获取自定义项5
*
* @return 自定义项5
*/
public String getDef5 () {
return this.def5;
 } 

/** 
* 设置自定义项5
*
* @param def5 自定义项5
*/
public void setDef5 ( String def5) {
this.def5=def5;
 } 

/** 
* 获取自定义项6
*
* @return 自定义项6
*/
public String getDef6 () {
return this.def6;
 } 

/** 
* 设置自定义项6
*
* @param def6 自定义项6
*/
public void setDef6 ( String def6) {
this.def6=def6;
 } 

/** 
* 获取自定义项7
*
* @return 自定义项7
*/
public String getDef7 () {
return this.def7;
 } 

/** 
* 设置自定义项7
*
* @param def7 自定义项7
*/
public void setDef7 ( String def7) {
this.def7=def7;
 } 

/** 
* 获取自定义项8
*
* @return 自定义项8
*/
public String getDef8 () {
return this.def8;
 } 

/** 
* 设置自定义项8
*
* @param def8 自定义项8
*/
public void setDef8 ( String def8) {
this.def8=def8;
 } 

/** 
* 获取自定义项9
*
* @return 自定义项9
*/
public String getDef9 () {
return this.def9;
 } 

/** 
* 设置自定义项9
*
* @param def9 自定义项9
*/
public void setDef9 ( String def9) {
this.def9=def9;
 } 

/** 
* 获取要求到货日期
*
* @return 要求到货日期
*/
public UFDate getDreceivedate () {
return this.dreceivedate;
 } 

/** 
* 设置要求到货日期
*
* @param dreceivedate 要求到货日期
*/
public void setDreceivedate ( UFDate dreceivedate) {
this.dreceivedate=dreceivedate;
 } 

/** 
* 获取计划发货日期
*
* @return 计划发货日期
*/
public UFDate getDsenddate () {
return this.dsenddate;
 } 

/** 
* 设置计划发货日期
*
* @param dsenddate 计划发货日期
*/
public void setDsenddate ( UFDate dsenddate) {
this.dsenddate=dsenddate;
 } 

/** 
* 获取定金
*
* @return 定金
*/
public UFDouble getEarnestmoney () {
return this.earnestmoney;
 } 

/** 
* 设置定金
*
* @param earnestmoney 定金
*/
public void setEarnestmoney ( UFDouble earnestmoney) {
this.earnestmoney=earnestmoney;
 } 

/** 
* 获取扣税类别
*
* @return 扣税类别
* @see String
*/
public Integer getFtaxtypeflag () {
return this.ftaxtypeflag;
 } 

/** 
* 设置扣税类别
*
* @param ftaxtypeflag 扣税类别
* @see String
*/
public void setFtaxtypeflag ( Integer ftaxtypeflag) {
this.ftaxtypeflag=ftaxtypeflag;
 } 

/** 
* 获取订价
*
* @return 订价
*/
public UFDouble getListprice () {
return this.listprice;
 } 

/** 
* 设置订价
*
* @param listprice 订价
*/
public void setListprice ( UFDouble listprice) {
this.listprice=listprice;
 } 

/** 
* 获取产品分类编码
*
* @return 产品分类编码
*/
public String getMarbasclassid () {
return this.marbasclassid;
 } 

/** 
* 设置产品分类编码
*
* @param marbasclassid 产品分类编码
*/
public void setMarbasclassid ( String marbasclassid) {
this.marbasclassid=marbasclassid;
 } 

/** 
* 获取备注
*
* @return 备注
*/
public String getMemo () {
return this.memo;
 } 

/** 
* 设置备注
*
* @param memo 备注
*/
public void setMemo ( String memo) {
this.memo=memo;
 } 

/** 
* 获取混合料价
*
* @return 混合料价
*/
public UFDouble getMixtureprice () {
return this.mixtureprice;
 } 

/** 
* 设置混合料价
*
* @param mixtureprice 混合料价
*/
public void setMixtureprice ( UFDouble mixtureprice) {
this.mixtureprice=mixtureprice;
 } 

/** 
* 获取累计安排数量
*
* @return 累计安排数量
*/
public UFDouble getNarrnum () {
return this.narrnum;
 } 

/** 
* 设置累计安排数量
*
* @param narrnum 累计安排数量
*/
public void setNarrnum ( UFDouble narrnum) {
this.narrnum=narrnum;
 } 

/** 
* 获取辅数量
*
* @return 辅数量
*/
public UFDouble getNastnum () {
return this.nastnum;
 } 

/** 
* 设置辅数量
*
* @param nastnum 辅数量
*/
public void setNastnum ( UFDouble nastnum) {
this.nastnum=nastnum;
 } 

/** 
* 获取主数量
*
* @return 主数量
*/
public UFDouble getNnum () {
return this.nnum;
 } 

/** 
* 设置主数量
*
* @param nnum 主数量
*/
public void setNnum ( UFDouble nnum) {
this.nnum=nnum;
 } 

/** 
* 获取无税金额
*
* @return 无税金额
*/
public UFDouble getNorigmny () {
return this.norigmny;
 } 

/** 
* 设置无税金额
*
* @param norigmny 无税金额
*/
public void setNorigmny ( UFDouble norigmny) {
this.norigmny=norigmny;
 } 

/** 
* 获取无税单价
*
* @return 无税单价
*/
public UFDouble getNorigprice () {
return this.norigprice;
 } 

/** 
* 设置无税单价
*
* @param norigprice 无税单价
*/
public void setNorigprice ( UFDouble norigprice) {
this.norigprice=norigprice;
 } 

/** 
* 获取价税合计
*
* @return 价税合计
*/
public UFDouble getNorigtaxmny () {
return this.norigtaxmny;
 } 

/** 
* 设置价税合计
*
* @param norigtaxmny 价税合计
*/
public void setNorigtaxmny ( UFDouble norigtaxmny) {
this.norigtaxmny=norigtaxmny;
 } 

/** 
* 获取含税单价
*
* @return 含税单价
*/
public UFDouble getNorigtaxprice () {
return this.norigtaxprice;
 } 

/** 
* 设置含税单价
*
* @param norigtaxprice 含税单价
*/
public void setNorigtaxprice ( UFDouble norigtaxprice) {
this.norigtaxprice=norigtaxprice;
 } 

/** 
* 获取辅无税单价
*
* @return 辅无税单价
*/
public UFDouble getNqtorigprice () {
return this.nqtorigprice;
 } 

/** 
* 设置辅无税单价
*
* @param nqtorigprice 辅无税单价
*/
public void setNqtorigprice ( UFDouble nqtorigprice) {
this.nqtorigprice=nqtorigprice;
 } 

/** 
* 获取辅含税单价
*
* @return 辅含税单价
*/
public UFDouble getNqtorigtaxprice () {
return this.nqtorigtaxprice;
 } 

/** 
* 设置辅含税单价
*
* @param nqtorigtaxprice 辅含税单价
*/
public void setNqtorigtaxprice ( UFDouble nqtorigtaxprice) {
this.nqtorigtaxprice=nqtorigtaxprice;
 } 

/** 
* 获取税额
*
* @return 税额
*/
public UFDouble getNtax () {
return this.ntax;
 } 

/** 
* 设置税额
*
* @param ntax 税额
*/
public void setNtax ( UFDouble ntax) {
this.ntax=ntax;
 } 

/** 
* 获取税率
*
* @return 税率
*/
public UFDouble getNtaxrate () {
return this.ntaxrate;
 } 

/** 
* 设置税率
*
* @param ntaxrate 税率
*/
public void setNtaxrate ( UFDouble ntaxrate) {
this.ntaxrate=ntaxrate;
 } 

/** 
* 获取其他生产要求
*
* @return 其他生产要求
*/
public String getOtherproduction () {
return this.otherproduction;
 } 

/** 
* 设置其他生产要求
*
* @param otherproduction 其他生产要求
*/
public void setOtherproduction ( String otherproduction) {
this.otherproduction=otherproduction;
 } 

/** 
* 获取单包重(KG)
*
* @return 单包重(KG)
*/
public String getPackageweight () {
return this.packageweight;
 } 

/** 
* 设置单包重(KG)
*
* @param packageweight 单包重(KG)
*/
public void setPackageweight ( String packageweight) {
this.packageweight=packageweight;
 } 

/** 
* 获取批次档案
*
* @return 批次档案
*/
public String getPk_batchcode () {
return this.pk_batchcode;
 } 

/** 
* 设置批次档案
*
* @param pk_batchcode 批次档案
*/
public void setPk_batchcode ( String pk_batchcode) {
this.pk_batchcode=pk_batchcode;
 } 

/** 
* 获取集团
*
* @return 集团
*/
public String getPk_group () {
return this.pk_group;
 } 

/** 
* 设置集团
*
* @param pk_group 集团
*/
public void setPk_group ( String pk_group) {
this.pk_group=pk_group;
 } 

/** 
* 获取销售组织
*
* @return 销售组织
*/
public String getPk_org () {
return this.pk_org;
 } 

/** 
* 设置销售组织
*
* @param pk_org 销售组织
*/
public void setPk_org ( String pk_org) {
this.pk_org=pk_org;
 } 

/** 
* 获取发货申请行主键
*
* @return 发货申请行主键
*/
public String getPk_shipments_b () {
return this.pk_shipments_b;
 } 

/** 
* 设置发货申请行主键
*
* @param pk_shipments_b 发货申请行主键
*/
public void setPk_shipments_b ( String pk_shipments_b) {
this.pk_shipments_b=pk_shipments_b;
 } 

/** 
* 获取行号
*
* @return 行号
*/
public String getRowno () {
return this.rowno;
 } 

/** 
* 设置行号
*
* @param rowno 行号
*/
public void setRowno ( String rowno) {
this.rowno=rowno;
 } 

/** 
* 获取上层单据主键
*
* @return 上层单据主键
*/
public String getSo_shipmentsb () {
return this.so_shipmentsb;
 } 

/** 
* 设置上层单据主键
*
* @param so_shipmentsb 上层单据主键
*/
public void setSo_shipmentsb ( String so_shipmentsb) {
this.so_shipmentsb=so_shipmentsb;
 } 

/** 
* 获取标识线
*
* @return 标识线
*/
public String getTagline () {
return this.tagline;
 } 

/** 
* 设置标识线
*
* @param tagline 标识线
*/
public void setTagline ( String tagline) {
this.tagline=tagline;
 } 

/** 
* 获取时间戳
*
* @return 时间戳
*/
public UFDateTime getTs () {
return this.ts;
 } 

/** 
* 设置时间戳
*
* @param ts 时间戳
*/
public void setTs ( UFDateTime ts) {
this.ts=ts;
 } 

/** 
* 获取批次号
*
* @return 批次号
*/
public String getVbatchcode () {
return this.vbatchcode;
 } 

/** 
* 设置批次号
*
* @param vbatchcode 批次号
*/
public void setVbatchcode ( String vbatchcode) {
this.vbatchcode=vbatchcode;
 } 

/** 
* 获取换算率
*
* @return 换算率
*/
public String getVchangerate () {
return this.vchangerate;
 } 

/** 
* 设置换算率
*
* @param vchangerate 换算率
*/
public void setVchangerate ( String vchangerate) {
this.vchangerate=vchangerate;
 } 

/** 
* 获取源头单据号
*
* @return 源头单据号
*/
public String getVfirstcode () {
return this.vfirstcode;
 } 

/** 
* 设置源头单据号
*
* @param vfirstcode 源头单据号
*/
public void setVfirstcode ( String vfirstcode) {
this.vfirstcode=vfirstcode;
 } 

/** 
* 获取源头单据行号
*
* @return 源头单据行号
*/
public String getVfirstrowno () {
return this.vfirstrowno;
 } 

/** 
* 设置源头单据行号
*
* @param vfirstrowno 源头单据行号
*/
public void setVfirstrowno ( String vfirstrowno) {
this.vfirstrowno=vfirstrowno;
 } 

/** 
* 获取源头交易类型
*
* @return 源头交易类型
*/
public String getVfirsttrantype () {
return this.vfirsttrantype;
 } 

/** 
* 设置源头交易类型
*
* @param vfirsttrantype 源头交易类型
*/
public void setVfirsttrantype ( String vfirsttrantype) {
this.vfirsttrantype=vfirsttrantype;
 } 

/** 
* 获取源头单据类型
*
* @return 源头单据类型
*/
public String getVfirsttype () {
return this.vfirsttype;
 } 

/** 
* 设置源头单据类型
*
* @param vfirsttype 源头单据类型
*/
public void setVfirsttype ( String vfirsttype) {
this.vfirsttype=vfirsttype;
 } 

/** 
* 获取自由辅助属性1
*
* @return 自由辅助属性1
*/
public String getVfree1 () {
return this.vfree1;
 } 

/** 
* 设置自由辅助属性1
*
* @param vfree1 自由辅助属性1
*/
public void setVfree1 ( String vfree1) {
this.vfree1=vfree1;
 } 

/** 
* 获取自由辅助属性10
*
* @return 自由辅助属性10
*/
public String getVfree10 () {
return this.vfree10;
 } 

/** 
* 设置自由辅助属性10
*
* @param vfree10 自由辅助属性10
*/
public void setVfree10 ( String vfree10) {
this.vfree10=vfree10;
 } 

/** 
* 获取自由辅助属性2
*
* @return 自由辅助属性2
*/
public String getVfree2 () {
return this.vfree2;
 } 

/** 
* 设置自由辅助属性2
*
* @param vfree2 自由辅助属性2
*/
public void setVfree2 ( String vfree2) {
this.vfree2=vfree2;
 } 

/** 
* 获取自由辅助属性3
*
* @return 自由辅助属性3
*/
public String getVfree3 () {
return this.vfree3;
 } 

/** 
* 设置自由辅助属性3
*
* @param vfree3 自由辅助属性3
*/
public void setVfree3 ( String vfree3) {
this.vfree3=vfree3;
 } 

/** 
* 获取自由辅助属性4
*
* @return 自由辅助属性4
*/
public String getVfree4 () {
return this.vfree4;
 } 

/** 
* 设置自由辅助属性4
*
* @param vfree4 自由辅助属性4
*/
public void setVfree4 ( String vfree4) {
this.vfree4=vfree4;
 } 

/** 
* 获取自由辅助属性5
*
* @return 自由辅助属性5
*/
public String getVfree5 () {
return this.vfree5;
 } 

/** 
* 设置自由辅助属性5
*
* @param vfree5 自由辅助属性5
*/
public void setVfree5 ( String vfree5) {
this.vfree5=vfree5;
 } 

/** 
* 获取自由辅助属性6
*
* @return 自由辅助属性6
*/
public String getVfree6 () {
return this.vfree6;
 } 

/** 
* 设置自由辅助属性6
*
* @param vfree6 自由辅助属性6
*/
public void setVfree6 ( String vfree6) {
this.vfree6=vfree6;
 } 

/** 
* 获取自由辅助属性7
*
* @return 自由辅助属性7
*/
public String getVfree7 () {
return this.vfree7;
 } 

/** 
* 设置自由辅助属性7
*
* @param vfree7 自由辅助属性7
*/
public void setVfree7 ( String vfree7) {
this.vfree7=vfree7;
 } 

/** 
* 获取自由辅助属性8
*
* @return 自由辅助属性8
*/
public String getVfree8 () {
return this.vfree8;
 } 

/** 
* 设置自由辅助属性8
*
* @param vfree8 自由辅助属性8
*/
public void setVfree8 ( String vfree8) {
this.vfree8=vfree8;
 } 

/** 
* 获取自由辅助属性9
*
* @return 自由辅助属性9
*/
public String getVfree9 () {
return this.vfree9;
 } 

/** 
* 设置自由辅助属性9
*
* @param vfree9 自由辅助属性9
*/
public void setVfree9 ( String vfree9) {
this.vfree9=vfree9;
 } 

/** 
* 获取来源单据号
*
* @return 来源单据号
*/
public String getVsrccode () {
return this.vsrccode;
 } 

/** 
* 设置来源单据号
*
* @param vsrccode 来源单据号
*/
public void setVsrccode ( String vsrccode) {
this.vsrccode=vsrccode;
 } 

/** 
* 获取来源单据行号
*
* @return 来源单据行号
*/
public String getVsrcrowno () {
return this.vsrcrowno;
 } 

/** 
* 设置来源单据行号
*
* @param vsrcrowno 来源单据行号
*/
public void setVsrcrowno ( String vsrcrowno) {
this.vsrcrowno=vsrcrowno;
 } 

/** 
* 获取来源交易类型
*
* @return 来源交易类型
*/
public String getVsrctrantype () {
return this.vsrctrantype;
 } 

/** 
* 设置来源交易类型
*
* @param vsrctrantype 来源交易类型
*/
public void setVsrctrantype ( String vsrctrantype) {
this.vsrctrantype=vsrctrantype;
 } 

/** 
* 获取来源单据类型
*
* @return 来源单据类型
*/
public String getVsrctype () {
return this.vsrctype;
 } 

/** 
* 设置来源单据类型
*
* @param vsrctype 来源单据类型
*/
public void setVsrctype ( String vsrctype) {
this.vsrctype=vsrctype;
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("so.ShipmentsBVO");
  }
}