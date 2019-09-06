package com.paro.sngiz;

import com.paro.sngiz.AddressData.Address;
import com.paro.sngiz.AddressData.AddressRepository;
import com.paro.sngiz.BirthData.Birth;
import com.paro.sngiz.EducationData.Education;
import com.paro.sngiz.FamilyData.Family;
import com.paro.sngiz.JobData.Job;
import com.paro.sngiz.PersonalData.Employer;
import com.paro.sngiz.PersonalData.EmployerRepository;
import com.paro.sngiz.PersonalData.EmployerService;
import com.paro.sngiz.Validator.PhotoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

//@RestController
@Controller
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @Autowired
    PhotoValidator photoValidator;

    SimpleDateFormat dateFormat=new SimpleDateFormat("dd MM yyyy");
    Calendar cal=Calendar.getInstance();
    //validating only newEmployer form bean object, otherwise if empty it will try to validate employer form bean object which is being returned from service
    @InitBinder("newEmployer")
    public void initialiseBinder(WebDataBinder binder) {
        System.out.println("Validator is being called");
        binder.setValidator(photoValidator);
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("today", dateFormat.format(cal.getTime()));
        return "index";
    }
    @RequestMapping("/registration")
    public String registration(ModelMap model) {
        EmployerWrapper newEmployer=new EmployerWrapper();

        model.addAttribute("today", dateFormat.format(cal.getTime()));

        model.addAttribute("newEmployer", newEmployer);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processRegistration(@Valid @ModelAttribute("newEmployer") EmployerWrapper newEmployer, BindingResult result, HttpServletRequest request) {
        System.out.println("Result has errors? "+result.hasErrors());
        //Spring validation
        if(result.hasErrors()){

            return "registration";
        }
        photoValidator.validate(newEmployer, result);

        //Saving the image to the employer object
        EmployerWrapper createdEmployer=newEmployer;
        try {
            createdEmployer.getEmployer().setPhoto(createdEmployer.getImage().getBytes());
       } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        We want to save photo under the direction resources/static/photos, as this directory structure will be available directly
        under the root directory of our web application at runtime. So, in order to get the root directory of our web application
        we need HttpServletRequest. That's why we added an extra method parameter called request.
         */
        //For saving photo within web application
        /*
        MultipartFile employerPhoto=createdEmployer.getImage();
        String rootDirectory=request.getSession().getServletContext().getRealPath("/");
        String rootDirectory2=request.getSession().getServletContext().getContextPath();
        System.out.println(System.getProperty("user.dir"));
        if(employerPhoto!=null &&!employerPhoto.isEmpty()){
            try {
                //employerPhoto.transferTo(new File("resources/static/img/"+createdEmployer.getEmployer().getId()+".jpg"));
                //The below line should be changed soon. The above line didn't work
                employerPhoto.transferTo(new File(System.getProperty("user.dir")+"/src/main/resources/static/photos/"+createdEmployer.getEmployer().getId()+".jpg"));
            } catch (Exception e) {
                throw new RuntimeException("Employer photo saving failed", e);
            }
        }
         */

        Employer employerToBeAdded=createdEmployer.getEmployer();
        Address addressToBeAdded=createdEmployer.getAddress();

        employerToBeAdded.setAddress(addressToBeAdded);
        addressToBeAdded.setEmployer(employerToBeAdded);

        Birth birthToBeAdded=createdEmployer.getBirth();
        employerToBeAdded.setBirth(birthToBeAdded);
        birthToBeAdded.setEmployer(employerToBeAdded);

        List<Education> educationList=newEmployer.getEducationList();
        for (Education educationToBeAdded:educationList) {
            educationToBeAdded.setEmployer(employerToBeAdded);
        }
        employerToBeAdded.setEducationList(educationList);

        List<Family> relativeList=newEmployer.getFamilyList();
        for (Family familyToBeAdded:relativeList) {
            familyToBeAdded.setEmployer(employerToBeAdded);
        }
        employerToBeAdded.setFamilyList(relativeList);

        List<Job> jobList=newEmployer.getJobList();
        for (Job jobToBeAdded:jobList) {
            jobToBeAdded.setEmployer(employerToBeAdded);
        }
        employerToBeAdded.setJobList(jobList);

        employerService.addEmployer(employerToBeAdded);
        return "redirect:/";
    }



    @RequestMapping("/search")
    public String search(Model model){

        model.addAttribute("today", dateFormat.format(cal.getTime()));
        //model.addAttribute("employers", employerService.getAllEmployers());

        Search query=new Search();

        model.addAttribute("query", query);
        model.addAttribute("criteriaTypes", SearchCriteria.values());

        return "searchPage";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("query") Search query, Model model){
        Search search = query;
        List<Employer> employerList=performSearch(query.getCriteria(), query.getValue());
        model.addAttribute("query", query);
        model.addAttribute("criteriaTypes", SearchCriteria.values());
        model.addAttribute("searchResults", employerList);

        return "searchPage";
    }

    @RequestMapping("/employers/{id}")
    public String getEmployer(@PathVariable("id") int employerId, Model model) {
        model.addAttribute("today", dateFormat.format(cal.getTime()));
        model.addAttribute("employer", employerService.getEmployer(employerId));
        byte[] img=employerService.getEmployer(employerId).getPhoto();
        String image= Base64.getEncoder().encodeToString(img);
        model.addAttribute("image", image);
        return "employer";
    }

    @RequestMapping("/employers/{id}/photo")
    public String getEmployerImage(@PathVariable("id") int employerId, Model model) throws IOException {
        byte[] img=employerService.getEmployer(employerId).getPhoto();
        String image= Base64.getEncoder().encodeToString(img);
        model.addAttribute("image", image);
        return "employerImage";
    }

    public List<Employer> performSearch(SearchCriteria criteria, String value) {
        System.out.println("Criteria is "+criteria+"\t"+criteria.name());
        System.out.println("Value is "+value);
        List<Employer> employerList=new ArrayList<>();
        SearchCriteria criteria1=criteria;

        switch (criteria1)
        {
            case ALL: employerList=employerService.getAllEmployers();
                break;
            case ID:
                int valueToint=Integer.parseInt(value);
                Employer employer=employerService.getEmployer(valueToint);
                employerList.add(employer);
            break;
            case FIRSTNAME: employerList=employerService.getEmployerByFirstname(value);
                break;
            case SURNAME:  employerList=employerService.getEmployerBySurname(value);
                break;
            case FATHERSNAME: employerList=employerService.getEmployerByFathersname(value);
                break;
            case INTPASSPORT: employerList=employerService.getEmployerByIntpassport(value);
                break;
            case DOMPASSPORT: employerList=employerService.getEmployerByDompassport(value);
                break;
            case NATIONALITY: employerList=employerService.getEmployerByNationality(value);
                break;
//            case BIRTHDAY: employerList=employerService.getEmployerByBirthday(value);
//                break;
            case EDUCATION: employerList=employerService.getEmployerByEducation(value);
                break;
            case FAMILYSTATUS: employerList=employerService.getEmployerByFamilystatus(value);
                break;
            case EMAIL: employerList=employerService.getEmployerByEmail(value);
                break;
            case SEX: employerList=employerService.getEmployerBySex(value);
                break;
            default: System.out.println("Not cached");
        }
        for (Employer employer: employerList
        ) {
            System.out.println(employer.getId()+" "+employer.getFirstname()+" "+employer.getSurname()+" "+employer.getIntpassport()+" "+employer.getDompassport());
        }
        return employerList;

    }




    //RestController
/*
    @RequestMapping("/employers")
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }

    @RequestMapping("/employers/{id}")
    public Employer getEmployer(@PathVariable int id) {
        return employerService.getEmployer(id);
    }
    */
    @RequestMapping(method = RequestMethod.POST, value = "/employers")
    public void addEmployer(@RequestBody Employer employer) {
        employerService.addEmployer(employer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employers/{id}")
    public void updateEmployer(@RequestBody Employer employer, @PathVariable int id) {
        employerService.updateEmployer(id, employer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employers/{id}")
    public void deleteEmployer(@RequestBody Employer employer, @PathVariable int id) {
        employerService.deleteEmployer(id);
    }


    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    AddressRepository addressRepository;


    /*
    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public List<Employer> update(Model model) {

    }
    */
}
