package tkmybatis;

//import com.github.pagehelper.PageHelper;
import model.entity.Country;
import model.mapper.CountryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPageHelper {

//    @Resource
//    CountryMapper countryMapper;
//
//    @Test
//    public void teet() {
//        Example example = new Example(Country.class);
//        PageHelper.startPage(1, 1);
//        List<Country> countries = countryMapper.selectByExample(example);
//
//        System.out.println("xx");
//    }
}
