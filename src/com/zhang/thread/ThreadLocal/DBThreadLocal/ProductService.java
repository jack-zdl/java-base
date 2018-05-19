package com.zhang.thread.ThreadLocal.DBThreadLocal;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/19 20:55<br>
 * <br>
 */
public interface ProductService {
    /**
     *
     * @param productId
     * @param price
     */
    void updateProductPrice(long productId,int price);
}
