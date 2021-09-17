package designmodel.statemachine;

import lombok.Getter;

/**
 * 新仓网选址服务状态
 *
 * @author shengweisong
 * @date 2021-07-27 5:49 PM
 **/
public enum WarehousePlanTaskStatusEnum {

    /**
     * 删除
     */
    DELETED("delete", 0),
    /**
     * 新建
     */
    INIT("init", 1),
    /**
     * 模型计算中
     */
    RUNNING("running", 1),
    /**
     * 执行成功
     */
    SUCCESS("success", 2),
    /**
     * 执行失败
     */
    FAILED("failed", 3),
    /**
     * 模型参数准备中
     */
    MODEL_PARAM_PERPARING("model_param_preparing", 4),
    /**
     * 等待执行
     */
    QUEUEING("queueing", 5),
    /**
     * 模型参数准备失败
     */
    MODEL_PARAM_PERPARING_FAILED("model_param_preparing_failed", 6);

    /**
     * code
     */
    @Getter
    private int code;

    /**
     * 状态
     */
    @Getter
    private String status;

    WarehousePlanTaskStatusEnum(String status, int code) {
        this.status = status;
        this.code = code;
    }
}