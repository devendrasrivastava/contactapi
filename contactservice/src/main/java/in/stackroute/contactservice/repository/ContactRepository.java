package in.stackroute.contactservice.repository;

import in.stackroute.contactservice.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends MongoRepository<Contact,String> {

    Optional<Contact> findByEmail(String email);

   Optional <Contact> findByEmailAndUserEmail(String email,String userEmail);
   List<Contact> findByCategory(String category);

  List<Contact> findByUserEmail(String userEmail);

}
