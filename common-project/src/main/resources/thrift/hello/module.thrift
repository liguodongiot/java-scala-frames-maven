namespace java com.lgd.module.service
namespace rb ThriftService

struct QueryInfo{

    /*moduleId*/
    1:string moduleId

    /*起始日期，标准日期格式：yyyy-MM-dd*/
	2:string startDate

	/*结束日期，标准日期格式：yyyy-MM-dd*/
	3:string endDate

}

struct ModuleInfo{

    /*统计时间*/
	1:string statDate,

	/*模块id*/
	2:string moduleId,

	/*模块名称*/
    3:string moduleName,

	/*位置ID*/
	4:string locationId,

	/*位置名称*/
	5:string locationName,

	/*开始时间*/
	6:string beginTime,

	/*结束时间*/
	7:string endTime,

	/*PV*/
	8:i32 Pv,

	/*UV*/
	9:i32 Uv

}

struct Result{

    /*200为正常访问，404查询异常（目前404只会是日期传入错误），500为服务器异常，异常信息会存入errMsg中*/
    1:i32 statCode,

    2:string errMsg,

    /*返回结果数据*/
    3:list<ModuleInfo> moduleInfoList

}


service ModuleInfoService{

    /*根据条件查询结果*/
    Result queryModuleInfo(1:QueryInfo queryInfo);

}