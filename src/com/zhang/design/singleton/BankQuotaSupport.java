package com.zhang.design.singleton;

import java.math.BigDecimal;
import java.util.Date;

//                   _ooOoo_
//                  o8888888o
//                  88" . "88
//                  (| -_- |)
//                  O\  =  /O
//               ____/`---'\____
//             .'  \\|     |//  `.
//            /  \\|||  :  |||//  \
//           /  _||||| -:- |||||-  \
//           |   | \\\  -  /// |   |
//           | \_|  ''\---/''  |   |
//           \  .-\__  `-`  ___/-. /
//         ___`. .'  /--.--\  `. . __
//      ."" '<  `.___\_<|>_/___.'  >'"".
//     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//     \  \ `-.   \_ __\ /__ _/   .-` /  /
// ======`-.____`-.___\_____/___.-`____.-'======
//                   `=---='
// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//         佛祖保佑       永无BUG
//  本模块已经经过开光处理，绝无可能再产生bug
// =============================================
/**
 * 银行给核心企业授信额度的封装类
 * <p>singleton model</p>
 * @author zhangdl
 * @version class v1.0
 * @date 2017/8/17 11:51
 */
public
class BankQuotaSupport {
//    public static
//    Logger log(){
//        return LogContext.getInstance().getLogger();
//    }
//
//    public static final int ROWVERSION = 1;
//
//    //交易账户DAO层
//    public static BankQuotaDao bankQuotaDao = null;
//    //交易账户余额DAO层
//    public static BankQuotaOpsDao bankQuotaOpsDao = null;
//
//    public static BankQuotaSupport  quotaInstance = null;
//
//    /**
//     * [BankQuotaSupport  support singleton BankQuotaSupport Object]
//     * <p>introduction  session , if session is null, create new session </p>
//     * @param  IDBSession session       [description]
//     * @return            [description]
//     */
//    public BankQuotaSupport(IDBSession session){
//        if(session==null){
//            session = DBSessionAdapter.getSession();
//        }
//        bankQuotaDao = new BankQuotaDao(session);
//        bankQuotaOpsDao = new BankQuotaOpsDao(session);
//    }
//
//    /**
//     * 获得唯一实例
//     * <p>
//     * signleton model ,support one object ,
//     *
//     * </p>
//     * @return
//     */
//    public static BankQuotaSupport getInstance(IDBSession session) {
//        if(quotaInstance==null){
//            quotaInstance = new BankQuotaSupport(session);
//        }
//        return quotaInstance;
//    }
//
//    /**
//     *
//     * @param userId
//     * @param orgId
//     * @param bankId
//     * @param coreCompanyId
//     * @param operateflag
//     * @param money
//     * @param sign
//     * @param description
//     * @throws Exception
//     */
//    public static void dealBankQuota(String userId, String orgId,String bankId,String coreCompanyId, String operateflag , BigDecimal money ,String sign,String description) throws Exception {
//        BankQuota bankQuota = bankQuotaDao.getBankQuota(bankId,coreCompanyId);
//        if(bankQuota == null){
//            throw new ServiceException("该核心企业没有设置银行给核心企业额度");
//        }
//        /**
//         * 操作标识
//         * 101 冻结额度  参数解冻的钱数
//         * 102 解冻额度  参数解冻的钱数
//         * 102 变更额度  参数总额度
//         */
//        int operate = Integer.valueOf(operateflag).intValue();
//        switch (operate) {
//            case 101:
//                if(bankQuota.getAvailableamount().compareTo(money) == 0){
//                    throw new ServiceException("银行分配企业额度不足");
//                }
//                bankQuota.setFreezeamount(FString.add(bankQuota.getFreezeamount(),money));
//                bankQuota.setAvailableamount(FString.subtract(bankQuota.getAvailableamount(),money));
//                break;
//            case 102:
//                bankQuota.setFreezeamount(FString.subtract(bankQuota.getFreezeamount(),money));
//                bankQuota.setAvailableamount(FString.add(bankQuota.getAvailableamount(),money));
//                break;
//            case 103:
//                bankQuota.setAmountlimits(money);
//                bankQuota.setAvailableamount(FString.subtract(money,bankQuota.getFreezeamount()));
//                break;
//        }
//        bankQuota.setLastmodifiedby(userId);
//        bankQuota.setLastmodifiedon(new Date());
//        bankQuota.setDescription(description);
//        bankQuotaDao.updateBankQuota(bankQuota);
//
//        BankQuotaOps bankQuotaOps = new BankQuotaOps(bankQuota.getUrid(),money,userId,orgId,new Date(),operateflag,sign,description);
//        bankQuotaOpsDao.saveOrgLimitOperation(bankQuotaOps);
//    }

}
