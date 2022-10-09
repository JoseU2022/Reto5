package com.example.toolproject.services;

import com.example.toolproject.entities.Tool;
import com.example.toolproject.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll() {
        return toolRepository.getAll();
    }

    public Optional<Tool> getTool(int id) {
        return toolRepository.getTool(id);
    }

    public Tool save(Tool tool) {
        if (tool.getId() == null) {
            return toolRepository.save(tool);
        } else {
            Optional<Tool> e = toolRepository.getTool(tool.getId());

            if (!e.isEmpty()) {
                return tool;
            } else {
                return toolRepository.save(tool);
            }
        }
    }

    public Tool update(Tool tool) {
        if (tool.getId() != null) {
            Optional<Tool> e = toolRepository.getTool(tool.getId());

            if (!e.isEmpty()) {

                if (tool.getName() != null) {
                    e.get().setName(tool.getName());
                }

                if (tool.getBrand() != null) {
                    e.get().setBrand(tool.getBrand());
                }

                if (tool.getDescription() != null) {
                    e.get().setDescription(tool.getDescription());
                }

                if (tool.getYear() != null) {
                    e.get().setYear(tool.getYear());
                }
                toolRepository.save(e.get());
                return e.get();
            } else {
                return tool;
            }
        } else {
            return tool;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Tool> e = toolRepository.getTool(id);
        if (!e.isEmpty()) {
            toolRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }

}
