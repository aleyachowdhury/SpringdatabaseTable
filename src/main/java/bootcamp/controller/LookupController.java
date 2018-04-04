package bootcamp.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.dao.PersonDao;
import bootcamp.model.LookUp;
import bootcamp.model.Person;

@RestController
public class LookupController {
	@Autowired
	PersonDao pDao;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
//
//    @RequestMapping("/greeting")
//    public LookUp greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new LookUp(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
//    
   
    @RequestMapping(value="/{aleya}", method=RequestMethod.GET)
    public List<Person> availablePerson(@PathVariable String aleya) {
        return pDao.getPerson();
    }

    
    @RequestMapping(value="/availablePersonById/{personid}", method=RequestMethod.GET)
    public Person availablePersonById(@PathVariable int personid) {
        return pDao.getPersonById(personid);
       
    }
    @RequestMapping(value="/updatePersonbyId/update/{personid}", method=RequestMethod.GET)
    public List<Person> updatePersonbyId(@PathVariable int personid) {
        return pDao.updatePersonbyId();
        
    }
    @RequestMapping(value="/deletePersonbyId/delete/byID/{personid}", method=RequestMethod.GET)
    public List<Person> deletePersonbyId(@PathVariable int personid) {
        return pDao.deletePersonbyId(personid);
    }
    @RequestMapping(value="aleya/createPerson/create/byID/{create}", method=RequestMethod.GET)
    public List<Person> createPersonbyId(@PathVariable String create) {
        return pDao.createPersonById();
    }
}
