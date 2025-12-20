package com.example.demo.service.impl;
import com.example.demo.exception.ResourceExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService{
    private final ShiftTemplateRepository shiftTemplateRepository;
    public ShiftTemplateServiceImpl(ShiftTemplateRepository shiftTemplateRepository){
        this.shiftTemplateRepository = shiftTemplateRepository;
    }
    @Override
    public ShiftTemplate create(ShiftTemplate template){
        shiftTemplateRepository.findByTemplateNameAndDepartment_Id(
                template.getTemplateName(),
                template.getDepartment().getId()
        ).ifPresent(existing->{
            throw new ResourceExistsException("Shift template unique constraint violation");
        });
        if (!template.getEndTime().isAfter(template.getStartTime())){
            throw new IllegalArgumentException("endTime must be after startTime");
        }
        return shiftTemplateRepository.save(template);
    }
    @Override
    public List<ShiftTemplate> getByDepartment(Long departmentId){
        return shiftTemplateRepository.findByDepartment_Id(departmentId);
    }
    @Override
    public List<ShiftTemplate> getAll(){
        return shiftTemplateRepository.findAll();
    }
    @Override
    public ShiftTemplate get(Long id){
        return shiftTemplateRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Shift template not found"));
    }
}
