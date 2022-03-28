package com.ctrends.employee.controllers;

import com.ctrends.employee.models.ERole;
import com.ctrends.employee.models.Employee;
import com.ctrends.employee.models.Role;
import com.ctrends.employee.payloads.request.LoginRequest;
import com.ctrends.employee.payloads.request.SignupRequest;
import com.ctrends.employee.payloads.response.JwtResponse;
import com.ctrends.employee.payloads.response.MessageResponse;
import com.ctrends.employee.repository.EmployeeRepository;
import com.ctrends.employee.repository.RoleRepository;
import com.ctrends.employee.security.jwt.JwtUtils;
import com.ctrends.employee.security.services.EmployeeDetailsImpl;
import com.ctrends.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {

        if (employeeRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (employeeRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Employee employee = new Employee(signupRequest.getEmpname(),
                signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()),
                signupRequest.getDesignation(),
                signupRequest.getMobileno(),
                signupRequest.getAddress()
        );

        Set<String> strRoles = signupRequest.getRole();

        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        employee.setRoles(roles);
        employeeRepository.save(employee);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        EmployeeDetailsImpl userDetails = (EmployeeDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{empId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Employee updateEmployee(@PathVariable("empId") Long empId, @RequestBody SignupRequest signupRequest){

        // update existing user's account
        Employee employee = new Employee(signupRequest.getEmpname(),
                signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()),
                signupRequest.getDesignation(),
                signupRequest.getMobileno(),
                signupRequest.getAddress()
        );

        Set<String> strRoles = signupRequest.getRole();

        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        employee.setRoles(roles);

        UserDetails userDetails =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        boolean isAdmin = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"));

        if(isAdmin == true){
            return employeeService.updateEmployee(empId, employee);

        }else{
            Employee employee2 = employeeService.getEmployeeById(empId);

            if(userDetails.getUsername().equals(employee.getUsername())){
                return employeeService.updateEmployee(empId, employee);
            }
        }
        return null;

    }

    @DeleteMapping("/{empId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEmployee(@PathVariable("empId") Long empId){
        employeeService.deleteEmployee(empId);
    }

    @GetMapping("/{empId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Employee getEmployeeById(@PathVariable("empId") Long empId){

        UserDetails userDetails =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        boolean isAdmin = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"));

        if(isAdmin == true){
            return employeeService.getEmployeeById(empId);

        }else{
            Employee employee = employeeService.getEmployeeById(empId);

            if(userDetails.getUsername().equals(employee.getUsername())){
                return employeeService.getEmployeeById(empId);
            }
        }
        return null;
    }

    @GetMapping("/email/{email}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Employee getEmployeeByEmail(@PathVariable("email") String email){

        UserDetails userDetails =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        boolean isAdmin = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"));

        if(isAdmin == true){
            return employeeService.getEmployeeByEmail(email);

        }else{
            Employee employee = employeeService.getEmployeeByEmail(email);

            if(userDetails.getUsername().equals(employee.getUsername())){
                return employeeService.getEmployeeByEmail(email);
            }
        }
        return null;
    }
}
