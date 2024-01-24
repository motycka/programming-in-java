package lesson11;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final HelloRepository helloRepository;

    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public String sayHello(String name, String locale) {
        String hello = helloRepository.selectHelloInLanguage(locale);
        return String.format("%s %s!", hello, name);
    }

}
