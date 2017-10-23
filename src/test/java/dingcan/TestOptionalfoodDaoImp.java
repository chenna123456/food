package dingcan;

import java.util.List;

import org.junit.Test;

import com.oracleoaec.daoImp.OptionalfoodDaoImp;
import com.oracleoaec.entity.Optionalfood;

public class TestOptionalfoodDaoImp {
	
	public void testfindOptionalfoodByPrice() {
		OptionalfoodDaoImp dao = new OptionalfoodDaoImp();
		List<Optionalfood> list = dao.findOptionalfoodByPrice("营养主食", 1, 10, 1, 4);
		System.out.println(list);
	} 
	@Test
	public void TestfindOptionalfoodCount(){
		OptionalfoodDaoImp dao = new OptionalfoodDaoImp();
		Integer count = dao.findOptionalfoodCount("营养主食");
		System.out.println(count);
	}
}
