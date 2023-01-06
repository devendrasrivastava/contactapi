package in.stackroute.userprofile.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "contacts-service")
public interface ContactServiceClient {

    @GetMapping("/api/v1/contacts/info")
    public String getContactStatus();
}
