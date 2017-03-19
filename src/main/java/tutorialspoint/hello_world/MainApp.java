package tutorialspoint.hello_world;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        // For using ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        // For using XmlBeanFactory
        // XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("Beans.xml"));

        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.setMessage("New message");
        objA.getMessage();

        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
        objB.getMessage();
    }
}
