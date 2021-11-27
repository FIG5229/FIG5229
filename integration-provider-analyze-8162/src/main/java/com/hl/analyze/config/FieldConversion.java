package com.hl.analyze.config;

/**
 * @author hupg
 * @description 字段映射处理规则配置
 * @date 2021/11/5 16:27
 */
public class FieldConversion {
    /**
     * 线损列表出参映射
     */
    public static final String ABNORMAL_DETAILS = "{\"id\":\"id\",\"xh\":\"xh\",\"deptName\":\"dwmc\",\"deptId\":\"deptId\",\"teamName\":\"gds\",\"teamId\":\"teamId\",\"linesStandardRatio\":\"xlztdbl\",\"linesStandardScore\":\"xldbldf\",\"courtsStandardRatio\":\"tqztdbl\",\"courtsStandardScore\":\"tqdbdf\",\"lineLossRatio\":\"xldszb\",\"lineLossScore\":\"xldsdf\",\"courtsLossRatio\":\"tqdszb\",\"courtsLossScore\":\"tqdsdf\",\"linePackRatio\":\"xldbl\",\"linePackScore\":\"dbldf\",\"totalScore\":\"zf\",\"monthRank\":\"pm\",\"isStandard\":\"sfdb\",\"lastMonthRank\":\"sypm\",\"rankChange\":\"jwts\",\"dataUsed\":\"sjzt\",\"dataUsedCode\":\"dataUsedCode\",\"dataSerial\":\"dataSerial\",\"month\":\"month\"}";
    /**
     * description: 台账映射
     * create by: hwx
     * create time: 2021/11/11 9:31
     */
    public static final String STANDING_BOOK = "{\"id\":\"id\",\"county\":\"ssqx\",\"villages\":\"xz\",\"courtsName\":\"tqmc\",\"circuit\":\"ssxl\",\"date\":\"sj\",\"capacity\":\"rl\",\"generatingCapacity\":\"fdl\"}";
    /**
     * description: 用户明细映射
     * create by: hwx
     * create time: 2021/11/11 9:31
     */
    public static final String ASSESS_USER_DETAILS = "{\"id\":\"id\",\"doorNo\":\"hh\",\"geographicPosition\":\"dlwz\",\"courtsName\":\"tqmc\",\"date\":\"tyrq\",\"capacity\":\"rl\",\"generatingCapacity\":\"fdl\"}";
    /**
     * description: 新能源明细映射
     * create by: hwx
     * create time: 2021/11/11 9:30
     */
    public static final String CAPACITY = "{\"id\":\"id\"," +
            "\"city\":\"ssds\"," +
            "\"county\":\"ssqx\"," +
            "\"date\":\"sj\"," +
            "\"photovoltaicPowerDistributed\":\"fbszjrl\"," +
            "\"photovoltaicPowerCentralization\":\"jzszjrl\"," +
            "\"windPower\":\"fdzjrl\"}";
    /**
     * description: 分布式光伏映射
     * create by: hwx
     * create time: 2021/11/11 9:30
     */
    public static final String DISTRIBUTEDPHOTOVOLTAIC = "{\"id\":\"id\"," +
            "\"city\":\"ssds\"," +
            "\"county\":\"ssqx\"," +
            "\"doorNo\":\"yhbh\"," +
            "\"courtsName\":\"tc\"," +
            "\"village\":\"ssxz\"," +
            "\"circuit\":\"ss10kvxl\"," +
            "\"generatingCapacity\":\"fdl\"}";
    /**
     * description: 光伏补贴异常明细映射
     * create by: hwx
     * create time: 2021/11/11 9:58
     */
    public static final String SUBSIDIES = "{\"id\":\"id\"," +
            "\"city\":\"ssds\"," +
            "\"county\":\"ssqx\"," +
            "\"doorNo\":\"hh\"," +
            "\"managementUnitName\":\"ssgdgs\"," +
            "\"releaseDate\":\"sj\"," +
            "\"circuit\":\"ss10kvxl\"," +
            "\"accumulatedGeneratingCapacity\":\"ljfdl\"," +
            "\"generatingCapacity\":\"fdl\"," +
            "\"contractCapacity\":\"htrl\"}";

    /**
     * description: 光伏违约明细
     * create by: hwx
     * create time: 2021/11/11 9:58
     */
    public static final String DEFULT = "{\"id\":\"id\"," +
            "\"city\":\"ssds\"," +
            "\"county\":\"ssqx\"," +
            "\"doorNo\":\"yhbh\"," +
            "\"managementUnitName\":\"ssgdgs\"," +
            "\"date\":\"sj\"," +
            "\"status\":\"bq\"}";
    /**
     * description: 光伏超容明细
     * create by: hwx
     * create time: 2021/11/11 10:06
     */
    public static final String OVER_CAPACITY = "{\"id\":\"id\"," +
            "\"city\":\"ssds\"," +
            "\"county\":\"ssqx\"," +
            "\"doorNo\":\"yhbh\"," +
            "\"managementUnitName\":\"ssgdgs\"," +
            "\"date\":\"sj\"," +
            "\"capacityLoadRatio\":\"rzb\"," +
            "\"contractCapacity\":\"htrl\"}";
}
