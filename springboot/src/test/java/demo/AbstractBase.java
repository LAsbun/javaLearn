package demo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * Created by louxiu
 */
@Data
@Slf4j
public abstract class AbstractBase extends Base {

    public <T extends AbstractBase> T toAl(Class<T> tClass){

        String algorithmParam = super.getParam();
        if (null == algorithmParam || null == algorithmParam) {
            log.info("参数不存在");
        }

        T cls = JSONObject.parseObject(algorithmParam, tClass);
        BeanUtils.copyProperties(this, cls);
        return cls;
    }
}
