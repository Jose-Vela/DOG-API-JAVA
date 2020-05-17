package Modelo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class Http {
    private HttpClient httpClient;
    private HttpGet get;
    private HttpResponse response;
    private String resource;
    
    public Http(){
        this.httpClient = HttpClients.createDefault();
        this.get = null;
        this.resource =  null;
    }
    
    public String GET(String url){
        this.get = new HttpGet(url);
        
        try {
            this.response = this.httpClient.execute(this.get);
            this.resource = EntityUtils.toString(this.response.getEntity());
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        
        return this.resource;
    }
}
