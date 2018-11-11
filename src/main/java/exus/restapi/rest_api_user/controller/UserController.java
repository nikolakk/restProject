package exus.restapi.rest_api_user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exus.restapi.rest_api_user.domain.User;
import exus.restapi.rest_api_user.service.UserService;
@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    
    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByEmail(
                @RequestParam(value = "email", required = false) String email,
                @RequestParam(value = "ip_address", required = false) String ipAddress) {
    	
    			User user = new User();
    			if (email!=null)
    				user = userService.getUserByEmail(email);
    			else if (ipAddress!=null)
    				user = userService.getUserByIpAddress(ipAddress);
    			return new ResponseEntity<User>(user, HttpStatus.OK);
    	}
    
//	@RequestMapping("/students/{id}")
//	public ResponseEntity<Object> updateStudent(@PathVariable long id) {
//
//		User studentOptional = userService.;
//
//		if (!studentOptional.isPresent())
//			return ResponseEntity.notFound().build();
//
//		student.setId(id);
//		
//		studentRepository.save(student);
//
//		return ResponseEntity.noContent().build();
//	}
//}

//	@GetMapping("/users/{id}")
//	public User retrieveStudent(@PathVariable long id) {
//		Optional<User> student = userService.
//
//		if (!student.isPresent())
//			throw new StudentNotFoundException("id-" + id);
//
//		return student.get();
//	}
//
//	@DeleteMapping("/students/{id}")
//	public void deleteStudent(@PathVariable long id) {
//		studentRepository.deleteById(id);
//	}
//
//	@PostMapping("/students")
//	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
//		Student savedStudent = studentRepository.save(student);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedStudent.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
//
//	}
//	
//	@PutMapping("/students/{id}")
//	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
//
//		Optional<Student> studentOptional = studentRepository.findById(id);
//
//		if (!studentOptional.isPresent())
//			return ResponseEntity.notFound().build();
//
//		student.setId(id);
//		
//		studentRepository.save(student);
//
//		return ResponseEntity.noContent().build();
//	}
}
