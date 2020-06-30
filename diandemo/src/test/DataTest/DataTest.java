import java.sql.Date;

public class DataTest {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		System.out.println(date);
	}
}
