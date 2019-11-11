import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RiskTest {
	
	protected Risk risk;

	@Before
	public void setUp() throws Exception {
		risk = new Risk();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(risk.computeRisk("2019-01-18", 20, 95, "src/test/resources/HISTORICAL_PnL_Test.csv"), new Double(-34754.23));
	}

}
