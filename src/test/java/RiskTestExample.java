import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RiskTestExample {

	protected Risk risk;
	
	@Before
	public void setUp() throws Exception {
		risk = new Risk();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test95th() {
		assertEquals(risk.computeRisk("2019-01-01", 12, 95, "src/test/resources/HISTORICAL_PnL_Example.csv"), new Double(-75342.83));
	}
	
	@Test
	public void test84th() {
		assertEquals(risk.computeRisk("2019-01-01", 12, 84, "src/test/resources/HISTORICAL_PnL_Example.csv"), new Double(-34754.23));
	}

}
