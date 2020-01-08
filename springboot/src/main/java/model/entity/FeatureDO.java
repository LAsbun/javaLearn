package model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.math.BigDecimal;
import lombok.Data;

/**
 * Created by louxiu
 *
 * 特征工程保存相关的值, iv...
 */
@Data
public class FeatureDO {

    /**
     * 特征id
     */
    private String featureId;

    /**
     * 特征iv值
     */
    private BigDecimal featureIv;

    /**
     * 特征实际所属节点id
     */
    private Long featureNodeId;

    /**
     * 特征实际所属数据集id
     */
    private Long featureDatasetId;

    /**
     * 特征所属数据集url
     */
    private String featureNodeUrl;

    /**
     * 特征所属虚拟融合数据集id
     */
    @JSONField(serialize = false)
    private Long featureVdatasetId;

}
