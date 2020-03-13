package webService;

@WebSevice
public class ExampleWebService(){
    @WebMethod
    public String helloWorld(String name){
        return "Hello " + name;
    }
}
