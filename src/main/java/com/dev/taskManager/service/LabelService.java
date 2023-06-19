package com.dev.taskManager.service;

import com.dev.taskManager.entity.Comment;
import com.dev.taskManager.entity.Label;
import com.dev.taskManager.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {
    @Autowired
    private LabelRepository repository;

    public Label create(Label label) {
        return repository.create(label);
    }

    public Optional<Label> getLabelById(int id) {
        return repository.findLabelById(id);
    }

    public List<Label> getAllLabels() {
        return repository.findAllLabels();
    }

    public Label update(Label label) {
        if (label.getId() != null) {
            Optional<Label> label1 = repository.findLabelById(label.getId());
            if (!label1.isEmpty()) {
                if (label.getId() != null) {
                    label1.get().setId(label.getId());

                }
                if (label.getName() != null) {
                    label1.get().setName(label.getName());
                }

                repository.update(label1.get());
                return label1.get();
            } else {
                return label;
            }
        } else {
            return label;
        }
    }

    public boolean delete(int id) {
        Optional<Label> label = getLabelById(id);
        if (label.isEmpty()) {
            return false;
        } else {
            repository.delete(label.get());
            return true;
        }
    }
}
