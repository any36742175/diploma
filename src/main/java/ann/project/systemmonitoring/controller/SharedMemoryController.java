package ann.project.systemmonitoring.controller;

import ann.project.systemmonitoring.entity.SharedMemory;
import ann.project.systemmonitoring.repository.SharedMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class SharedMemoryController {

    @Autowired
    private SharedMemoryRepository sharedMemoryRepository;

    @RequestMapping("/getSharedMemory")
    public String index() {
        return "getSharedMemory";
    }

    /*@ModelAttribute("array")
    public int[] array(*//*@Value("${application.message:Hello World}") String message*//*) {
        return new int[]{1,2,9};
        //return message;
    }*/

    @ModelAttribute("sharedMemoryList")
    public List<SharedMemory> getSharedMemory(/*@Value("${application.message:Hello World}") String message*/) {
        Iterator<SharedMemory> iterator = sharedMemoryRepository.findAll().iterator();
        List<SharedMemory> sharedMemoryList = new ArrayList<>();
        while (iterator.hasNext()){
            sharedMemoryList.add(iterator.next());
        }
        return sharedMemoryList;
        //return message;
    }
}
