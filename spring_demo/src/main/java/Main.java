import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("bean.xml");
		Bank bank=(Bank) c.getBean("bank");
		bank.printBankDetails();
	}

}
