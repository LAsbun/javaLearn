package demo;

/**
 * Created by louxiu
 */

public enum JobEnum {

    DATA_SOURCE("data_source", ""),
    DATA_UPLOAD("data_upload", ""),
    DATA_FUSION("data_fusion", "-c"),
    FEATURE_ENGINEERING("feature_engineering", "-c"),
    // 特征工程 vif
    FEATURE_VIF("feature_vif", "-c"),
    MODEL_LOGISTIC_REGRESSION("logit_model", "-c"),
    MODEL_TEST("model_test", "-c");

    JobEnum(String jobPrefix, String subCommand) {
        this.jobPrefix = jobPrefix;
        this.subCommand = subCommand;
    }

    private String jobPrefix;
    private String subCommand;

    public String getJobPrefix() {
        return jobPrefix;
    }

    public String getSubCommand() {
        return subCommand;
    }
}
