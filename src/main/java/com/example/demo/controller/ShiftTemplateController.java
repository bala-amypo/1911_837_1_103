package com.example.demo.controller;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/templates")
public class ShiftTemplateController{
    private final ShiftTemplateService shiftTemplateService;
    public ShiftTemplateController(ShiftTemplateService shiftTemplateService){
        this.shiftTemplateService = shiftTemplateService;
    }
    @PostMapping("/department/{departmentId}")
    public ResponseEntity<ShiftTemplate> create(@PathVariable Long departmentId,@RequestBody ShiftTemplate template){
        template.getDepartment().setId(departmentId);
        ShiftTemplate saved=shiftTemplateService.create(template);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("/")
    public ResponseEntity<List<ShiftTemplate>>getAll(){
        return ResponseEntity.ok(shiftTemplateService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ShiftTemplate>get(@PathVariable Long id) {
        return ResponseEntity.ok(shiftTemplateService.get(id));
    }
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<ShiftTemplate>>getByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(shiftTemplateService.getByDepartment(departmentId));
    }
}
